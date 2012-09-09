package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.IssueType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public class DeleteIssueType implements BacklogCommand<IssueType> {

    private final BacklogClient client;
    protected final Map<String, Object> map = new HashMap<String, Object>();

    public DeleteIssueType(BacklogClient client) {
        this.client = client;
    }

    public Integer getId() {
        return (Integer) map.get(ID);
    }

    public DeleteIssueType setId(Integer id) {
        map.put(ID, id);

        return this;
    }

    public Integer getSubstituteId() {
        return (Integer) map.get(SUBSTITUTE_ID);
    }

    public DeleteIssueType setSubstituteId(Integer substituteId) {
        map.put(SUBSTITUTE_ID, substituteId);

        return this;
    }

    private void checkParameters() {
        if (getId() == null) {
            throw new BacklogException("id is required");
        }
    }

    @Override
    public IssueType execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_DELETEISSUETYPE, map);
        return new IssueType((Map<String, Object>) res);
    }
}