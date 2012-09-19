package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Version;
import backlog4j.impl.VersionImpl;

import java.util.Map;

/**
 * @author eguchi
 */
public class DeleteVersion implements BacklogCommand<Version> {

    protected final BacklogClient client;
    protected Integer id;

    public DeleteVersion(BacklogClient client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public DeleteVersion setId(Integer id) {
        this.id = id;

        return this;
    }

    private void checkParameters() {
        if (getId() == null) {
            throw new BacklogException("id is required");
        }

    }

    @Override
    public Version execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_DELETE_VERSION, id);
        return new VersionImpl((Map<String, Object>) res);
    }
}
