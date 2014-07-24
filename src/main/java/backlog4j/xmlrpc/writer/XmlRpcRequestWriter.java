package backlog4j.xmlrpc.writer;

import backlog4j.BacklogException;
import backlog4j.util.XmlRpcUtil;
import backlog4j.xmlrpc.XmlRpcException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public class XmlRpcRequestWriter {

    private static final Charset CHARSET = Charset.forName("UTF-8");
    private final OutputStream out;


    public XmlRpcRequestWriter(OutputStream out) {
        this.out = out;
    }

    public void startRequest() throws IOException {
        out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?><methodCall>".getBytes(CHARSET));
    }

    public void endRequest() throws IOException {
        out.write("</methodCall>".getBytes(CHARSET));
    }

    private void startParams() throws IOException {
        out.write("<params>".getBytes(CHARSET));
    }

    private void endParams() throws IOException {
        out.write("</params>".getBytes(CHARSET));
    }

    private void startParam() throws IOException {
        out.write("<param>".getBytes(CHARSET));
    }

    private void endParam() throws IOException {
        out.write("</param>".getBytes(CHARSET));
    }

    private void setMethodName(String methodName) throws IOException {

        out.write("<methodName>".getBytes(CHARSET));
        out.write(methodName.getBytes(CHARSET));
        out.write("</methodName>".getBytes(CHARSET));

    }

    public void writeObject(Object obj) throws IOException {

        writeTagStart("value");
        if (obj != null) {
            ObjectWriter writer = ObjectWriter.getObjectWriter(obj);
            writer.write(this, obj);
        }
        writeTagEnd("value");

    }

    public void write(String name, String text) throws IOException {

        writeTagStart(name);
        out.write(XmlRpcUtil.escape(text).getBytes(CHARSET));
        writeTagEnd(name);
    }

    public void writeTagStart(String name) throws IOException {
        out.write("<".getBytes(CHARSET));
        out.write(name.getBytes(CHARSET));
        out.write(">".getBytes(CHARSET));
    }

    public void writeTagEnd(String name) throws IOException {
        out.write("</".getBytes(CHARSET));
        out.write(name.getBytes(CHARSET));
        out.write(">".getBytes(CHARSET));
    }

    public static void write(OutputStream out, String methodName) throws IOException {
        write(out, methodName, null);
    }

    public static void write(OutputStream out, String methodName, Object o) {

        XmlRpcRequestWriter requestWriter = new XmlRpcRequestWriter(out);

        try {
            requestWriter.startRequest();
            requestWriter.setMethodName(methodName);
            requestWriter.startParams();
            if (hasArgument(o)) {
                requestWriter.startParam();
                requestWriter.writeObject(o);
                requestWriter.endParam();
            }
            requestWriter.endParams();

            requestWriter.endRequest();

        } catch (IOException e) {
            throw new XmlRpcException(e);
        }
    }

    private static boolean hasArgument(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Object[]) {
            Object[] array = (Object[]) o;
            if (array.length == 0) {
                return false;
            }
        }

        if (o instanceof List) {
            List<?> list = (List<?>) o;
            if (list.isEmpty()) {
                return false;
            }
        }

        if (o instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) o;
            if (map.isEmpty()) {
                return false;
            }
        }

        return true;
    }
}
