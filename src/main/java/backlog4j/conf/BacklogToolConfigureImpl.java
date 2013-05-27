package backlog4j.conf;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author eguchi
 */
public final class BacklogToolConfigureImpl extends AbstractBacklogConfigure {

    private final String spaceId;
    private final URL    xmlRpcUrl;

    public BacklogToolConfigureImpl(
            String spaceId,
            String username,
            String password,
            int readTimeout,
            int connectTimeout) throws MalformedURLException {

        super(username, password, readTimeout, connectTimeout);

        if (spaceId == null) {
            throw new IllegalArgumentException("spaceId must not be null");
        }

        this.spaceId = spaceId;
        this.xmlRpcUrl = new URL("https://" + spaceId + ".backlogtool.com/XML-RPC");
    }

    public String getSpaceId() {
        return spaceId;
    }

    @Override
    public URL getXmlRpcUrl() {
        return xmlRpcUrl;
    }
}
