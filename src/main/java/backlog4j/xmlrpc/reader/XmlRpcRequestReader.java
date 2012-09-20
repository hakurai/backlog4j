package backlog4j.xmlrpc.reader;

import backlog4j.BacklogException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.Map;

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

            if (handler.isFault()) {
                Map<String, Object> map = (Map<String, Object>) handler.getObject();

                Integer faultCode = (Integer) map.get("faultCode");
                String faultString = (String) map.get("faultString");

                throw new BacklogException("Request faild faultCode : " + faultCode + " faultString : " + faultString);
            }


            return handler.getObject();

        } catch (Exception e) {
            throw new BacklogException(e);
        }
    }


}
