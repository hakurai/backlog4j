package backlog4j.xmlrpc.reader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author eguchi
 */
public class XmlRpcHandler extends DefaultHandler {

    private Deque<ObjectReader<?>> stack = new LinkedList<ObjectReader<?>>();
    private StringBuilder characters = new StringBuilder();
    private boolean nameTag;
    private boolean valueTag;
    private String name;


    public XmlRpcHandler() {
        stack.push(new Params());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (uri.isEmpty()) {
            if (qName.equals("methodResponse")) {

            } else if (qName.equals("params")) {

            } else if (qName.equals("param")) {

            } else if (qName.equals("value")) {
                valueTag = true;
            } else if (qName.equals("name")) {
                nameTag = true;
            } else if (qName.equals("data")) {

            } else if (qName.equals("member")) {

            } else if (qName.equals("fault")) {

            } else {
                ObjectReader<?> reader = ObjectReader.getObjectReader(qName);
                reader.setName(name);
                stack.push(reader);

            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (uri.isEmpty()) {
            if (qName.equals("methodResponse")) {

            } else if (qName.equals("params")) {

            } else if (qName.equals("param")) {

            } else if (qName.equals("value")) {
                if (name != null) {
                    stack.peek().addObject(name, characters.toString());
                    characters.setLength(0);
                    name = null;
                    valueTag = false;
                }
            } else if (qName.equals("name")) {
                name = characters.toString();
                characters.setLength(0);
                nameTag = false;
            } else if (qName.equals("data")) {

            } else if (qName.equals("member")) {

            } else if (qName.equals("fault")) {

            } else {
                ObjectReader<?> reader = stack.pop();
                reader.read(characters.toString());

                stack.peek().addObject(reader.getName(),reader.getObject());

                characters.setLength(0);
                name = null;

            }
        }
    }

    public Object getObject() {
        return stack.peek().getObject();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        characters.append(ch, start, length);
    }

    private class Params extends ObjectReader<Object> {

        private Object object;

        @Override
        public void read(String source) {

        }

        @Override
        public Object getObject() {
            return object;
        }

        @Override
        public void addObject(String name, Object obj) {
            object = obj;
        }
    }

}
