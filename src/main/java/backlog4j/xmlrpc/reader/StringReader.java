package backlog4j.xmlrpc.reader;

import backlog4j.util.XmlRpcUtil;

/**
 * @author eguchi
 */
public class StringReader extends ObjectReader<String> {

    private String value;

    @Override
    public void read(String source) {
        value = XmlRpcUtil.unescape(source);
    }

    @Override
    public String getObject() {
        return value;
    }
}
