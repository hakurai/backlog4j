package backlog4j.xmlrpc;

import backlog4j.BacklogException;
import backlog4j.conf.BacklogConfigure;
import backlog4j.util.Base64;
import backlog4j.xmlrpc.reader.XmlRpcRequestReader;
import backlog4j.xmlrpc.writer.XmlRpcRequestWriter;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
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

    public Object execute(String methodName) {
        return execute(methodName, null);
    }

    public Object execute(String methodName, Object params) {

        if( params instanceof Object[]){
            Object[] array = ((Object[])params);
            if( array.length == 0 ){
                params = null;
            } else if( array.length == 1 ){
                params = array[0];
            }
        }

        try {
            HttpsURLConnection con = createConnection();

            XmlRpcRequestWriter.write(con.getOutputStream(), methodName, params);

            con.connect();

//            Map<String, List<String>> headerFields = con.getHeaderFields();

            InputStream inputStream = con.getInputStream();

            return XmlRpcRequestReader.read(inputStream);

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
