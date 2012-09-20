package backlog4j.xmlrpc;

import backlog4j.BacklogException;
import backlog4j.conf.ImmutableSpaceConfigure;
import org.junit.Test;

/**
 * @author eguchi
 */
public class XmlRpcClientTest {
    @Test
    public void testExecute() throws Exception {

        XmlRpcClient client = new XmlRpcClient(ImmutableSpaceConfigure.getInstance());

        client.execute("backlog.getStatuses");

    }

    @Test(expected = BacklogException.class)
    public void testShouldThrowException() throws Exception {

        XmlRpcClient client = new XmlRpcClient(ImmutableSpaceConfigure.getInstance());

        client.execute("backlog.getHoge");

    }
}
