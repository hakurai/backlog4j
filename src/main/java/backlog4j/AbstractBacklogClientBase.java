package backlog4j;

import backlog4j.conf.BacklogConfigure;
import backlog4j.xmlrpc.XmlRpcClient;

/**
 * @author eguchi
 */
public abstract class AbstractBacklogClientBase implements BacklogClientBase {

    protected final XmlRpcClient client;

    public AbstractBacklogClientBase(BacklogConfigure configure) {
        if (configure == null) {
            throw new IllegalArgumentException("configure must not be null");
        }

        client = new XmlRpcClient(configure);
    }

    public Object execute(String methodName) {
        return execute(methodName, new Object[]{});
    }

    public Object execute(String methodName, Object... params) {

        return client.execute(methodName, params);

    }
}
