package backlog4j.conf;

import java.net.MalformedURLException;

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
