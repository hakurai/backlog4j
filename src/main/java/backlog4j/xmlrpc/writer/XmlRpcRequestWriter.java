package backlog4j.xmlrpc.writer;

import backlog4j.BacklogException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

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

        ObjectWriter writer = ObjectWriter.getObjectWriter(obj);
        writeTagStart("value");
        writer.write(this, obj);
        writeTagEnd("value");

    }

    public void write(String name, String text) throws IOException {

        writeTagStart(name);
        out.write(text.getBytes(CHARSET));
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
            if (o != null) {
                requestWriter.startParam();
                requestWriter.writeObject(o);
                requestWriter.endParam();
            }
            requestWriter.endParams();

            requestWriter.endRequest();

        } catch (IOException e) {
            throw new BacklogException(e);
        }
    }
}
