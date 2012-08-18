package backlog4j.conf;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author eguchi
 */
public class BacklogConfigureImpl implements BacklogConfigure {

    private final String spaceId;
    private final String username;
    private final String password;
    private final URL xmlRpcUrl;

    public BacklogConfigureImpl(String spaceId, String username, String password) throws MalformedURLException {
        if (spaceId == null) {
            throw new IllegalArgumentException("spaceId must not be null");
        }
        if (username == null) {
            throw new IllegalArgumentException("username must not be null");
        }
        if (password == null) {
            throw new IllegalArgumentException("password must not be null");
        }
        this.spaceId = spaceId;
        this.username = username;
        this.password = password;
        this.xmlRpcUrl = new URL("https://" + spaceId + ".backlog.jp/XML-RPC");
    }

    @Override
    public String getSpaceId() {
        return spaceId;
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
