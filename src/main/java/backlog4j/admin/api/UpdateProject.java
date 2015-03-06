package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
import backlog4j.BacklogException;
import backlog4j.admin.impl.ProjectEx;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public class UpdateProject implements BacklogAdminCommand<ProjectEx> {

    private final BacklogAdminClient client;
    protected final Map<String, Object> map = new HashMap<String, Object>();

    public UpdateProject(BacklogAdminClient client) {
        this.client = client;
    }

    public UpdateProject setId(Integer id) {
        map.put(ID, id);

        return this;
    }

    public Integer getId() {
        return (Integer) map.get(ID);
    }

    public UpdateProject setName(String name) {
        map.put(NAME, name);

        return this;
    }

    public String getName() {
        return (String) map.get(NAME);
    }

    public UpdateProject setKey(String key) {
        map.put(KEY, key);

        return this;
    }

    public String getKey() {
        return (String) map.get(KEY);
    }


    public UpdateProject setTextFormattingRule(String textFormattingRule) {
        map.put(TEXT_FORMATTING_RULE, textFormattingRule);

        return this;
    }

    public String getTextFormattingRule() {
        return (String) map.get(TEXT_FORMATTING_RULE);
    }

    public UpdateProject setUseChart(Boolean useChart) {
        map.put(USE_CHART, useChart);

        return this;
    }

    public Boolean getUseChart() {
        return (Boolean) map.get(USE_CHART);
    }

    public UpdateProject setUseParentChildIssue(Boolean b) {
        map.put(USE_PARENT_CHILD_ISSUE, b);

        return this;
    }

    public Boolean getUseParentChildIssue() {
        return (Boolean) map.get(USE_PARENT_CHILD_ISSUE);
    }

    public UpdateProject setArchived(Boolean archived) {
        map.put(ARCHIVED, archived);

        return this;
    }

    public Boolean getArchived() {
        return (Boolean) map.get(ARCHIVED);
    }

    private void checkParameters() {
        if (getId() == null) {
            throw new BacklogException("id is required");
        }
    }

    @Override
    public ProjectEx execute() {

        checkParameters();
        Object res = client.execute(BACKLOG_ADMIN_UPDATE_PROJECT, map);

        return new ProjectEx((Map<String, Object>) res);
    }
}