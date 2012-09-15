package backlog4j.xmlrpc.reader;

import backlog4j.BacklogException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

/**
 * @author eguchi
 */
public class XmlRpcRequestReader {

    public static Object read(InputStream input) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            XmlRpcHandler handler = new XmlRpcHandler();
            parser.parse(input, handler);

            return handler.getObject();

        } catch (Exception e) {
            throw new BacklogException(e);
        }
    }


}
