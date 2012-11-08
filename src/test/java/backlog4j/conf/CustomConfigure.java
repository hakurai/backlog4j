package backlog4j.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * @author eguchi
 */
public class CustomConfigure implements BacklogConfigure {

    private static final BacklogConfigure BACKLOG_CONFIGURE = new CustomConfigure();
    private final BacklogConfigure delegate;


    private CustomConfigure() {
        Properties properties = new Properties();
        try {
            properties.loadFromXML(new FileInputStream("custom.properties"));
        } catch (IOException e) {
        }

        String spaceId = properties.getProperty("spaceId", "");
        String username = properties.getProperty("username", "");
        String password = properties.getProperty("password", "");

        try {
            delegate = new BacklogConfigureImpl(spaceId, username, password, 10000, 10000);
        } catch (MalformedURLException e) {
            throw new IllegalStateException("failed to write TestuserConfigure");
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
