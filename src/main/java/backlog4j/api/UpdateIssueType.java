package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.IssueType;
import backlog4j.impl.IssueTypeImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public class UpdateIssueType implements BacklogCommand<IssueType> {

    protected final BacklogClient client;
    protected final Map<String, Object> map = new HashMap<String, Object>();

    public UpdateIssueType(BacklogClient client) {
        this.client = client;
    }

    public Integer getId() {
        return (Integer) map.get(ID);
    }

    public UpdateIssueType setId(Integer projectId) {
        map.put(ID, projectId);

        return this;
    }

    public String getName() {
        return (String) map.get(NAME);
    }

    public UpdateIssueType setName(String name) {
        map.put(NAME, name);

        return this;
    }

    public String getColor() {
        return (String) map.get(COLOR);
    }

    public UpdateIssueType setColor(String Color) {
        map.put(COLOR, Color);

        return this;
    }

    private void checkParameters() {
        if (getId() == null) {
            throw new BacklogException("id is required");
        }
        if (getName() == null) {
            throw new BacklogException("name is required");
        }
        if (getColor() == null) {
            throw new BacklogException("color is required");
        }
    }

    @Override
    public IssueType execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_UPDATE_ISSUE_TYPE, map);
        return new IssueTypeImpl((Map<String, Object>) res);
    }
}
