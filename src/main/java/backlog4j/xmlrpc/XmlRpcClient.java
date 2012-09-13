package backlog4j.xmlrpc;

import backlog4j.conf.BacklogConfigure;
import backlog4j.util.Base64;
import sun.misc.BASE64Encoder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public class XmlRpcClient {

    private final BacklogConfigure configure;

    public XmlRpcClient(BacklogConfigure configure) {
        this.configure = configure;
    }

    public void execute() throws Exception {

        HttpsURLConnection con = createConnection();

        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<methodCall>\n" +
                "  <methodName>backlog.getStatuses</methodName>\n" +
                "  <params />\n" +
                "</methodCall>";

        con.getOutputStream().write(body.getBytes());

        con.connect();

        Map<String, List<String>> headerFields = con.getHeaderFields();

        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {

            for (String value : entry.getValue()) {

                System.out.println(entry.getKey() + ":" + value);
            }

        }

        System.out.println(con.getResponseCode());
        System.out.println(con.getResponseMessage());

        BufferedInputStream bis = new BufferedInputStream(con.getInputStream());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        byte[] buf = new byte[256];
        int len;
        while ((len = bis.read(buf)) > 0) {
            byteArrayOutputStream.write(buf, 0, len);
        }

        System.out.println(new String(byteArrayOutputStream.toByteArray()));


    }

    private HttpsURLConnection createConnection() throws IOException {
        URL url = configure.getXmlRpcUrl();

        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        String encode = Base64.encode((configure.getUsername() + ":" + configure.getPassword()).getBytes());

        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", "Basic " + encode);
        con.setRequestProperty("Content-Type", "text/xml");

        con.setDoOutput(true);

        return con;
    }
}
