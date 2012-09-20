package backlog4j.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * @author eguchi
 */
public class ImmutableSpaceConfigure implements BacklogConfigure {

    private static final BacklogConfigure BACKLOG_CONFIGURE = new ImmutableSpaceConfigure();
    private final BacklogConfigure delegate;


    private ImmutableSpaceConfigure() {
        Properties properties = new Properties();
        try {
            properties.loadFromXML(new FileInputStream("immutable.properties"));
        } catch (IOException e) {
        }

        String spaceId = properties.getProperty("spaceId", "");
        String username = properties.getProperty("username", "");
        String password = properties.getProperty("password", "");

        try {
            delegate = new BacklogConfigureImpl(spaceId, username, password, 10000, 10000);
        } catch (MalformedURLException e) {
            throw new IllegalStateException("failed to write ImmutableSpaceConfigure");
        }

    }


    public static BacklogConfigure getInstance() {
        return BACKLOG_CONFIGURE;
    }

    @Override
    public String getUsername() {
        return delegate.getUsername();
    }

    @Override
    public String getPassword() {
        return delegate.getPassword();
    }

    @Override
    public URL getXmlRpcUrl() {
        return delegate.getXmlRpcUrl();
    }

    @Override
    public int getReadTimeout() {
        return delegate.getReadTimeout();
    }

    @Override
    public int getConnectTimeout() {
        return delegate.getConnectTimeout();
    }
}
