package backlog4j;

import backlog4j.conf.BacklogConfigure;
import backlog4j.conf.BacklogConfigureBuilder;

import javax.net.ssl.SSLSocketFactory;
import java.net.MalformedURLException;

/**
 * @author eguchi
 */
public class BacklogClientFactory {

    private final BacklogConfigure configure;

    public BacklogClientFactory(BacklogConfigure configure) {
        this.configure = configure;
    }

    public BacklogClient newBacklogClient() {
        return new BacklogClientImpl(configure);
    }

    @Deprecated
    public BacklogAdminClient newBacklogAdminClient() {
        return new BacklogAdminClientImpl(configure);
    }

    public static BacklogClient createBacklogClient(String spaceId, String username, String password) throws MalformedURLException {
        BacklogConfigure backlogConfigure = new BacklogConfigureBuilder()
                .setSpaceId(spaceId)
                .setUsername(username)
                .setPassword(password)
                .buildBacklogConfigure();

        return new BacklogClientFactory(backlogConfigure).newBacklogClient();
    }

    public static BacklogClient createBacklogToolClient(String spaceId, String username, String password) throws MalformedURLException {
        BacklogConfigure backlogConfigure = new BacklogConfigureBuilder()
                .setSpaceId(spaceId)
                .setUsername(username)
                .setPassword(password)
                .buildBacklogToolConfigure();

        return new BacklogClientFactory(backlogConfigure).newBacklogClient();
    }

    public static BacklogClient createBacklogPackageClient(String url, String username, String password) throws MalformedURLException {
        BacklogConfigure backlogConfigure = new BacklogConfigureBuilder()
                .setUrl(url)
                .setUsername(username)
                .setPassword(password)
                .buildBacklogPackageConfigure();

        return new BacklogClientFactory(backlogConfigure).newBacklogClient();
    }

    public static BacklogClient createBacklogPackageClient(String url, String username, String password, SSLSocketFactory sslSocketFactory) throws MalformedURLException {
        BacklogConfigure backlogConfigure = new BacklogConfigureBuilder()
                .setUrl(url)
                .setUsername(username)
                .setPassword(password)
                .setSslSocketFactory(sslSocketFactory)
                .buildBacklogPackageConfigure();

        return new BacklogClientFactory(backlogConfigure).newBacklogClient();
    }
}
