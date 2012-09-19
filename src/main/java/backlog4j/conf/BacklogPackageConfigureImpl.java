package backlog4j.conf;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author eguchi
 */
public final class BacklogPackageConfigureImpl implements BacklogConfigure {

    private final String username;
    private final String password;
    private final URL xmlRpcUrl;

    public BacklogPackageConfigureImpl(String url, String username, String password) throws MalformedURLException {
        if (url == null) {
            throw new IllegalArgumentException("url must not be null");
        }
        if (username == null) {
            throw new IllegalArgumentException("username must not be null");
        }
        if (password == null) {
            throw new IllegalArgumentException("password must not be null");
        }

        this.username = username;
        this.password = password;
        if (url.endsWith("/")) {
            this.xmlRpcUrl = new URL(url + "XML-RPC");
        } else {
            this.xmlRpcUrl = new URL(url + "/XML-RPC");
        }
    }

    @Override
    public String getSpaceId() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public URL getXmlRpcUrl() {
        return xmlRpcUrl;
    }
}
