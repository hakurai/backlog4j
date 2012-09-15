package backlog4j.xmlrpc.reader;

import backlog4j.util.Base64;

/**
 * @author eguchi
 */
public class Base64Reader extends ObjectReader<byte[]> {

    private byte[] value;

    @Override
    public void read(String source) {
        value = Base64.decode(source);
    }

    @Override
    public byte[] getObject() {
        return value;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
