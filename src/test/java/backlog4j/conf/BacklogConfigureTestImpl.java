package backlog4j.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * @author eguchi
 */
public class BacklogConfigureTestImpl implements BacklogConfigure {

    private static final BacklogConfigure BACKLOG_CONFIGURE = new BacklogConfigureTestImpl();
    private final BacklogConfigure delegate;


    private BacklogConfigureTestImpl(){
        Properties properties = new Properties();
        try {
            properties.loadFromXML(new FileInputStream("test.properties"));
        } catch (IOException e) {
        }

        String spaceId = properties.getProperty("spaceId","");
        String username = properties.getProperty("username","");
        String password = properties.getProperty("password","");

        try {
            delegate = new BacklogConfigureImpl(spaceId,username,password);
        } catch (MalformedURLException e) {
            throw new IllegalStateException("failed to create BacklogConfigureTestImpl");
        }

    }



    public static BacklogConfigure getInstance() {
        return BACKLOG_CONFIGURE;
    }

    @Override
    public String getSpaceId() {
        return delegate.getSpaceId();
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
}
