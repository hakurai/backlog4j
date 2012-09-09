package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.IssueType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public abstract class AbstractUpdateIssueType implements BacklogCommand<IssueType> {

    protected final BacklogClient client;
    protected final Map<String, Object> map = new HashMap<String, Object>();

    public AbstractUpdateIssueType(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return (Integer) map.get(PROJECT_ID);
    }

    public AbstractUpdateIssueType setProjectId(Integer projectId) {
        map.put(PROJECT_ID, projectId);

        return this;
    }

    public String getName() {
        return (String) map.get(NAME);
    }

    public AbstractUpdateIssueType setName(String name) {
        map.put(NAME, name);

        return this;
    }

    public String getColor() {
        return (String) map.get(COLOR);
    }

    public AbstractUpdateIssueType setColor(String Color) {
        map.put(COLOR, Color);

        return this;
    }

    protected void checkParameters() {
        if (getProjectId() == null) {
            throw new BacklogException("projectId is required");
        }
        if (getName() == null) {
            throw new BacklogException("name is required");
        }
        if (getColor() == null) {
            throw new BacklogException("color is required");
        }
    }

}
