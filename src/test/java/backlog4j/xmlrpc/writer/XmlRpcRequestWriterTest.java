package backlog4j.xmlrpc.writer;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

/**
 * @author eguchi
 */
public class XmlRpcRequestWriterTest {

    ByteArrayOutputStream out;


    @Before
    public void setUp() throws Exception {
        out = new ByteArrayOutputStream();
    }

    @Test
    public void testNoArgument() throws Exception {

        XmlRpcRequestWriter.write(out, "backlog.getProjects");

        assertThat(
                out.toString(),
                is("<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                        "<methodCall>" +
                        "<methodName>backlog.getProjects</methodName>" +
                        "<params></params>" +
                        "</methodCall>"));
    }

    @Test
    public void testNullArgument() throws Exception {

        XmlRpcRequestWriter.write(out, "backlog.getProjects", null);

        assertThat(out.toString(), containsString("<params></params>"));
    }

    @Test
    public void testEmptyArray() throws Exception {

        XmlRpcRequestWriter.write(out, "backlog.getProjects", new Object[0]);

        assertThat(out.toString(), containsString("<params></params>"));
    }

    @Test
    public void testEmptyList() throws Exception {

        XmlRpcRequestWriter.write(out, "backlog.getProjects", Collections.emptyList());

        assertThat(out.toString(), containsString("<params></params>"));
    }

    @Test
    public void testEmptyMap() throws Exception {

        XmlRpcRequestWriter.write(out, "backlog.getProjects", Collections.emptyMap());

        assertThat(out.toString(), containsString("<params></params>"));
    }

    @Test
    public void testInteger() throws Exception {

        XmlRpcRequestWriter.write(out, "backlog.getProjects", 100);

        assertThat(out.toString(), containsString("<params><param><value><int>100</int></value></param></params>"));
    }

    @Test
    public void testTrue() throws Exception {

        XmlRpcRequestWriter.write(out, "backlog.getProjects", true);

        assertThat(out.toString(), containsString("<params><param><value><boolean>1</boolean></value></param></params>"));
    }

    @Test
    public void testFalse() throws Exception {

        XmlRpcRequestWriter.write(out, "backlog.getProjects", false);

        assertThat(out.toString(), containsString("<params><param><value><boolean>0</boolean></value></param></params>"));
    }

    @Test
    public void testString() throws Exception {

        XmlRpcRequestWriter.write(out, "backlog.getProjects", "hello world!");

        assertThat(out.toString(), containsString("<params><param><value><string>hello world!</string></value></param></params>"));
    }

    @Test
    public void testIntegerArray() throws Exception {

        Integer[] array = {1, 2, 3};

        XmlRpcRequestWriter.write(out, "backlog.getProjects", array);

        assertThat(out.toString(),
                containsString("<params><param><value><array><data>" +
                        "<value><int>1</int></value>" +
                        "<value><int>2</int></value>" +
                        "<value><int>3</int></value>" +
                        "</data></array></value></param></params></methodCall>"));
    }

    @Test
    public void testIntegerList() throws Exception {

        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3});

        XmlRpcRequestWriter.write(out, "backlog.getProjects", list);

        assertThat(out.toString(),
                containsString("<params><param><value><array><data>" +
                        "<value><int>1</int></value>" +
                        "<value><int>2</int></value>" +
                        "<value><int>3</int></value>" +
                        "</data></array></value></param></params></methodCall>"));
    }

    @Test
    public void testNestingList() throws Exception {

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        list.add(Arrays.asList(new Integer[]{1, 2, 3}));
        list.add(Arrays.asList(new Integer[]{4, 5, 6}));


        XmlRpcRequestWriter.write(out, "backlog.getProjects", list);

        assertThat(out.toString(),
                containsString("<params><param><value><array><data>" +
                        "<value><array><data>" +
                        "<value><int>1</int></value><value><int>2</int></value><value><int>3</int></value>" +
                        "</data></array></value>" +
                        "<value><array><data>" +
                        "<value><int>4</int></value><value><int>5</int></value><value><int>6</int></value>" +
                        "</data></array></value>" +
                        "</data></array></value></param></params>"));
    }

    @Test
    public void testMap() throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "backlog");
        map.put("age", 25);
        map.put("male", true);
        map.put("hobby", new String[]{"reading", "football"});

        XmlRpcRequestWriter.write(out, "backlog.getProjects", map);

        assertThat(out.toString(),
                containsString("<params><param><value><struct>" +
                        "<member><name>male</name><value><boolean>1</boolean></value></member>" +
                        "<member><name>age</name><value><int>25</int></value></member>" +
                        "<member><name>name</name><value><string>backlog</string></value></member><member>" +
                        "<name>hobby</name><value>" +
                        "<array><data><value><string>reading</string></value><value><string>football</string></value></data></array>" +
                        "</value></member></struct></value></param></params>"));
    }

    @Test
    public void testNestingMap() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();

        map2.put("name", "backlog");
        map.put("map", map2);

        XmlRpcRequestWriter.write(out, "backlog.getProjects", map);

        assertThat(out.toString(),
                containsString("<params><param><value>" +
                        "<struct><member>" +
                        "<name>map</name>" +
                        "<value><struct>" +
                        "<member><name>name</name><value><string>backlog</string></value></member>" +
                        "</struct></value>" +
                        "</member></struct>" +
                        "</value></param></params>"));

    }
}
