package backlog4j.xmlrpc.reader;

import backlog4j.BacklogException;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

/**
 * @author eguchi
 */
public class XmlRpcRequestReaderTest {

    @Test
    public void testReadInt() throws Exception {

        InputStream in = toInputStream("<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<methodResponse>" +
                "<params>" +
                "<param>" +
                "<value><int>100</int></value>" +
                "</param>" +
                "</params>" +
                "</methodResponse>");

        Object o = XmlRpcRequestReader.read(in);

        assertThat((Integer) o, is(100));
    }

    @Test
    public void testReadI4() throws Exception {

        InputStream in = toInputStream("<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<methodResponse>" +
                "<params>" +
                "<param>" +
                "<value><i4>200</i4></value>" +
                "</param>" +
                "</params>" +
                "</methodResponse>");

        Object o = XmlRpcRequestReader.read(in);

        assertThat((Integer) o, is(200));
    }

    @Test
    public void testReadTrue() throws Exception {

        InputStream in = toInputStream("<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<methodResponse>" +
                "<params>" +
                "<param>" +
                "<value><boolean>1</boolean></value>" +
                "</param>" +
                "</params>" +
                "</methodResponse>");

        Object o = XmlRpcRequestReader.read(in);

        assertThat((Boolean) o, is(true));
    }

    @Test
    public void testReadFalse() throws Exception {

        InputStream in = toInputStream("<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<methodResponse>" +
                "<params>" +
                "<param>" +
                "<value><boolean>0</boolean></value>" +
                "</param>" +
                "</params>" +
                "</methodResponse>");

        Object o = XmlRpcRequestReader.read(in);

        assertThat((Boolean) o, is(false));
    }

    @Test
    public void testReadString() throws Exception {

        InputStream in = toInputStream("<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<methodResponse>" +
                "<params>" +
                "<param>" +
                "<value><string>hello world!</string></value>" +
                "</param>" +
                "</params>" +
                "</methodResponse>");

        Object o = XmlRpcRequestReader.read(in);

        assertThat((String) o, is("hello world!"));
    }

    @Test
    public void testReadArray() throws Exception {

        InputStream in = toInputStream("<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<methodResponse>" +
                "<params>" +
                "<param>" +
                "<value>" +
                "<array>" +
                "<data>" +
                "<value><string>java!</string></value>" +
                "<value><string>scala!</string></value>" +
                "<value><string>groovy!</string></value>" +
                "</data>" +
                "</array>" +
                "</value>" +
                "</param>" +
                "</params>" +
                "</methodResponse>");

        Object[] obj = (Object[]) XmlRpcRequestReader.read(in);

        assertThat(Arrays.asList(obj), hasItems((Object) "java!", "scala!", "groovy!"));
    }

    @Test
    public void testReadStruct() throws Exception {

        InputStream in = toInputStream("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<methodResponse>\n" +
                "  <params>\n" +
                "    <param>\n" +
                "      <value>\n" +
                "        <struct>\n" +
                "          <member>\n" +
                "            <name>id</name>\n" +
                "            <value>\n" +
                "              <i4>123</i4>\n" +
                "            </value>\n" +
                "          </member>\n" +
                "          <member>\n" +
                "            <name>name</name>\n" +
                "            <value>えぐち</value>\n" +
                "          </member>\n" +
                "          <member>\n" +
                "            <name>lang</name>\n" +
                "            <value>ja</value>\n" +
                "          </member>\n" +
                "          <member>\n" +
                "            <name>updated_on</name>\n" +
                "            <value>20101020144113</value>\n" +
                "          </member>\n" +
                "        </struct>\n" +
                "      </value>\n" +
                "    </param>\n" +
                "  </params>\n" +
                "</methodResponse>");

        Map<String, Object> map = (Map<String, Object>) XmlRpcRequestReader.read(in);

        assertThat(map.get("id"), is((Object) 123));
        assertThat(map.get("name"), is((Object) "えぐち"));
        assertThat(map.get("lang"), is((Object) "ja"));
        assertThat(map.get("updated_on"), is((Object) "20101020144113"));
    }

    @Test(expected = BacklogException.class)
    public void testReadFault() throws Exception {

        InputStream in = toInputStream("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<methodResponse>\n" +
                "  <fault>\n" +
                "    <value>\n" +
                "      <struct>\n" +
                "        <member>\n" +
                "          <name>faultCode</name>\n" +
                "          <value><int>0</int></value>\n" +
                "        </member>\n" +
                "        <member>\n" +
                "          <name>faultString</name>\n" +
                "          <value><string>No such handler: backlog.getStatus</string></value>\n" +
                "        </member>\n" +
                "      </struct>\n" +
                "    </value>\n" +
                "  </fault>\n" +
                "</methodResponse>");

        XmlRpcRequestReader.read(in);

    }

    private InputStream toInputStream(String text) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(out);
        writer.write(text);
        writer.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
