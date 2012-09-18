package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Version;
import backlog4j.impl.VersionImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public class AddVersion implements BacklogCommand<Version> {

    protected final BacklogClient client;
    protected final Map<String, Object> map = new HashMap<String, Object>();

    public AddVersion(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return (Integer) map.get(PROJECT_ID);
    }

    public AddVersion setProjectId(Integer projectId) {
        map.put(PROJECT_ID, projectId);

        return this;
    }

    public String getName() {
        return (String) map.get(NAME);
    }

    public AddVersion setName(String name) {
        map.put(NAME, name);

        return this;
    }

    public String getStartDate() {
        return (String) map.get(START_DATE);
    }

    public AddVersion setStartDate(String startDate) {
        map.put(START_DATE, startDate);

        return this;
    }

    public String getDueDate() {
        return (String) map.get(DUE_DATE);
    }

    public AddVersion setDueDate(String dueDate) {
        map.put(DUE_DATE, dueDate);

        return this;
    }

    private void checkParameters() {
        if (getProjectId() == null) {
            throw new BacklogException("projectId is required");
        }
        if (getName() == null) {
            throw new BacklogException("name is required");
        }

    }

    @Override
    public Version execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_ADD_VERSION, map);
        return new VersionImpl((Map<String, Object>) res);
    }
}
