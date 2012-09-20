package backlog4j.conf;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author eguchi
 */
public final class BacklogPackageConfigureImpl extends AbstractBacklogConfigure {


    private final URL xmlRpcUrl;

    public BacklogPackageConfigureImpl(
            String url,
            String username,
            String password,
            int readTimeout,
            int connectTimeout) throws MalformedURLException {
        super(username, password, readTimeout, connectTimeout);

        if (url == null) {
            throw new IllegalArgumentException("url must not be null");
        }

        if (url.endsWith("/")) {
            this.xmlRpcUrl = new URL(url + "XML-RPC");
        } else {
            this.xmlRpcUrl = new URL(url + "/XML-RPC");
        }
    }

    @Override
    public URL getXmlRpcUrl() {
        return xmlRpcUrl;
    }
}
