package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
import backlog4j.BacklogException;
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

    public AddProject setTextFormattingRule(String textFormattingRule) {
        map.put(TEXT_FORMATTING_RULE, textFormattingRule);

        return this;
    }

    public String getTextFormattingRule() {
        return (String) map.get(TEXT_FORMATTING_RULE);
    }
    
    public AddProject setUseChart(Boolean useChart) {
        map.put(USE_CHART, useChart);

        return this;
    }

    public Boolean getUseChart() {
        return (Boolean) map.get(USE_CHART);
    }

    public AddProject setUseParentChildIssue(Boolean b) {
        map.put(USE_PARENT_CHILD_ISSUE, b);

        return this;
    }

    public Boolean getUseParentChildIssue() {
        return (Boolean) map.get(USE_PARENT_CHILD_ISSUE);
    }

    private void checkParameters() {
        if (getName() == null) {
            throw new BacklogException("id is required");
        }
        if (getKey() == null) {
            throw new BacklogException("key is required");
        }
    }

    @Override
    public ProjectEx execute() {

        checkParameters();
        Object res = client.execute(BACKLOG_ADMIN_ADD_PROJECT, map);

        return new ProjectEx((Map<String, Object>) res);
    }
}