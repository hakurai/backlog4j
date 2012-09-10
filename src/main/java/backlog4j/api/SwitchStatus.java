package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Issue;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public class SwitchStatus implements BacklogCommand<Issue> {

    private final BacklogClient client;
    protected final Map<String, Object> map = new HashMap<String, Object>();

    public SwitchStatus(BacklogClient client) {
        this.client = client;
    }

    public String getKey() {
        return (String) map.get(KEY);
    }

    public SwitchStatus setKey(String key) {
        map.put(KEY, key);

        return this;
    }

    public Integer getStatusId() {
        return (Integer) map.get(STATUS_ID);
    }

    public SwitchStatus setStatusId(Integer statusId) {
        map.put(STATUS_ID, statusId);

        return this;
    }

    public Integer getAssignerId() {
        return (Integer) map.get(ASSIGNER_ID);
    }

    public SwitchStatus setAssignerId(Integer assignerId) {
        map.put(ASSIGNER_ID, assignerId);

        return this;
    }

    public Integer getResolutionId() {
        return (Integer) map.get(RESOLUTION_ID);
    }

    public SwitchStatus setResolutionId(Integer resolutionId) {
        map.put(RESOLUTION_ID, resolutionId);

        return this;
    }

    public String getComment() {
        return (String) map.get(COMMENT);
    }

    public SwitchStatus setComment(String comment) {
        map.put(COMMENT, comment);

        return this;
    }

    private void checkParameters() {
        if (getKey() == null) {
            throw new BacklogException("key is required");
        }

        if (getStatusId() == null) {
            throw new BacklogException("statusId is required");
        }
    }

    @Override
    public Issue execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_SWITCH_STATUS, map);

        return new Issue((Map<String, Object>) res);
    }
}
