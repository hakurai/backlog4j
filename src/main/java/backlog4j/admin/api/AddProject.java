package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
import backlog4j.admin.impl.ProjectEx;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public class AddProject implements BacklogAdminCommand<ProjectEx> {

    private final BacklogAdminClient client;
    protected final Map<String, Object> map = new HashMap<String, Object>();

    public AddProject(BacklogAdminClient client) {
        this.client = client;
    }

    public AddProject setName(String name) {
        map.put(NAME, name);

        return this;
    }

    public String getName() {
        return (String) map.get(NAME);
    }

    public AddProject setKey(String key) {
        map.put(KEY, key);

        return this;
    }

    public String getKey() {
        return (String) map.get(KEY);
    }

    public AddProject setUseChart(String key) {
        map.put(USE_CHART, key);

        return this;
    }

    public Boolean getUseChart() {
        return (Boolean) map.get(USE_CHART);
    }

    @Override
    public ProjectEx execute() {

        Object res = client.execute(BACKLOG_ADMIN_ADD_PROJECT, map);

        return new ProjectEx((Map<String, Object>) res);
    }
}