package backlog4j;

import backlog4j.conf.BacklogConfigure;

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

    public BacklogAdminClient newBacklogAdminClient() {
        return new BacklogAdminClientImpl(configure);
    }
}
