package backlog4j.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

/**
 * @author eguchi
 */
public class BacklogConfigureBuilder {

    private String spaceId;
    private String username;
    private String password;
    private String url;
    private int connectTimeout;
    private int readTimeout;

    public BacklogConfigureBuilder() {
    }


    public BacklogConfigureBuilder loadPropertyFIle(String path) throws IOException {
        Properties properties = new Properties();
        properties.loadFromXML(new FileInputStream(path));

        setSpaceId(properties.getProperty("spaceId", null));
        setUsername(properties.getProperty("username", null));
        setPassword(properties.getProperty("password", null));
        setUrl(properties.getProperty("url", null));
        setConnectTimeout(Integer.parseInt(properties.getProperty("connectionTimeout", null)));
        setReadTimeout(Integer.parseInt(properties.getProperty("readTimeout", null)));

        return this;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public BacklogConfigureBuilder setSpaceId(String spaceId) {
        this.spaceId = spaceId;

        return this;
    }

    public String getUsername() {
        return username;
    }

    public BacklogConfigureBuilder setUsername(String username) {
        this.username = username;

        return this;
    }

    public String getPassword() {
        return password;
    }

    public BacklogConfigureBuilder setPassword(String password) {
        this.password = password;

        return this;
    }

    public String getUrl() {
        return url;
    }

    public BacklogConfigureBuilder setUrl(String url) {
        this.url = url;

        return this;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public BacklogConfigureBuilder setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;

        return this;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public BacklogConfigureBuilder setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;

        return this;
    }


    public BacklogConfigure buildBacklogConfigure() throws MalformedURLException {
        return new BacklogConfigureImpl(spaceId, username, password, readTimeout, connectTimeout);
    }

    public BacklogConfigure buildBacklogToolConfigure() throws MalformedURLException {
        return new BacklogToolConfigureImpl(spaceId, username, password, readTimeout, connectTimeout);
    }

    public BacklogConfigure buildBacklogPackageConfigure() throws MalformedURLException {
        return new BacklogPackageConfigureImpl(url, username, password, readTimeout, connectTimeout);
    }
}
