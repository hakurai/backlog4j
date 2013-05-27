package backlog4j.xmlrpc;

import backlog4j.BacklogException;
import backlog4j.conf.BacklogConfigure;
import backlog4j.util.Base64;
import backlog4j.xmlrpc.reader.XmlRpcRequestReader;
import backlog4j.xmlrpc.writer.XmlRpcRequestWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author eguchi
 */
public class XmlRpcClient {

    private final BacklogConfigure configure;

    public XmlRpcClient(BacklogConfigure configure) {
        this.configure = configure;
    }

    public BacklogConfigure getConfigure() {
        return configure;
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
            HttpURLConnection con = createConnection();

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
                        "Backlog returned response code : " + code +
                                " " + con.getResponseMessage());
            }

            InputStream in = null;
            try {
                in = con.getInputStream();

                return XmlRpcRequestReader.read(in);
            } catch (Exception e) {

                StringBuilder sb = new StringBuilder("Failed to execute: ");
                sb.append(methodName).append(" ");
                
                String paramsText = params == null ? "{}" : params.toString();
                sb.append(paramsText);

                throw new BacklogException(sb.toString(), e);//TODO detail message

            } finally {
                if (in != null) {
                    in.close();
                }
            }

        } catch (IOException e) {
            throw new BacklogException(e);
        }
    }

    private HttpURLConnection createConnection() throws IOException {
        return configure.createConnection();
    }
}
