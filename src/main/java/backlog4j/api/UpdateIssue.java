package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Issue;

import java.util.Map;

/**
 * @author eguchi
 */
public class UpdateIssue extends AbstractUpdateIssue {

    private final BacklogClient client;

    public UpdateIssue(BacklogClient client) {
        this.client = client;
    }

    public String getKey() {
        return (String) map.get(KEY);
    }

    public UpdateIssue setKey(String key) {
        map.put(KEY, key);

        return this;
    }

    private void checkParameters() {
        if (getKey() == null) {
            throw new BacklogException("key is required");
        }
    }

    @Override
    public Issue execute() {
        checkParameters();
        Object res = client.execute(BACKLOG_UPDATE_ISSUE, map);

        return new Issue((Map<String, Object>) res);
    }
}
