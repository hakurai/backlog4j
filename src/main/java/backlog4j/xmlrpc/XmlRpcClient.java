package backlog4j.xmlrpc;

import backlog4j.BacklogException;
import backlog4j.conf.BacklogConfigure;
import backlog4j.util.Base64;
import backlog4j.xmlrpc.reader.XmlRpcRequestReader;
import backlog4j.xmlrpc.writer.XmlRpcRequestWriter;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * @author eguchi
 */
public class XmlRpcClient {

    private final BacklogConfigure configure;

    public XmlRpcClient(BacklogConfigure configure) {
        this.configure = configure;
    }

    public Object execute(String methodName) {
        return execute(methodName, null);
    }

    public Object execute(String methodName, Object params) {

        if (params instanceof Object[]) {
            Object[] array = ((Object[]) params);
            if (array.length == 0) {
                params = null;
            } else if (array.length == 1) {
                params = array[0];
            }
        }

        try {
            HttpsURLConnection con = createConnection();

            OutputStream out = null;
            try {
                out = con.getOutputStream();
                XmlRpcRequestWriter.write(out, methodName, params);
                out.flush();
                out.close();
            } finally {
                if (out != null) {
                    out.close();
                }
            }

            con.connect();

            int code = con.getResponseCode();
            if (code != 200) {
                throw new BacklogException(
                        "Backlog is returned response code : " + code +
                                " " + con.getResponseMessage());
            }

            InputStream in = null;
            try {
                in = con.getInputStream();

                return XmlRpcRequestReader.read(in);
            } finally {
                if (in != null) {
                    in.close();
                }
            }

        } catch (IOException e) {
            throw new BacklogException(e);
        }
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
