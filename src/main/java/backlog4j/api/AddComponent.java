package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Category;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public class AddComponent implements BacklogCommand<Category> {

    protected final BacklogClient client;
    protected final Map<String, Object> map = new HashMap<String, Object>();

    public AddComponent(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return (Integer) map.get(PROJECT_ID);
    }

    public AddComponent setProjectId(Integer projectId) {
        map.put(PROJECT_ID, projectId);

        return this;
    }

    public String getName() {
        return (String) map.get(NAME);
    }

    public AddComponent setName(String name) {
        map.put(NAME, name);

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
    public Category execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_ADD_COMPONENT, map);
        return new Category((Map<String, Object>) res);
    }
}
