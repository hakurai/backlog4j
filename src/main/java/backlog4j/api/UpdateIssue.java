package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Issue;
import backlog4j.impl.IssueImpl;

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

    @Override
    public UpdateIssue setSummary(String summary) {
        super.setSummary(summary);
        return this;
    }

    @Override
    public UpdateIssue setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    @Override
    public UpdateIssue setDueDate(String dueDate) {
        super.setDueDate(dueDate);
        return this;
    }

    @Override
    public UpdateIssue setStartDate(String startDate) {
        super.setStartDate(startDate);
        return this;
    }

    @Override
    public UpdateIssue setEstimatedHours(Double estimatedHours) {
        super.setEstimatedHours(estimatedHours);
        return this;
    }

    @Override
    public UpdateIssue setActualHours(Double actualHours) {
        super.setActualHours(actualHours);
        return this;
    }

    @Override
    public UpdateIssue setIssueTypeId(Integer issueTypeId) {
        super.setIssueTypeId(issueTypeId);
        return this;
    }

    @Override
    public UpdateIssue setPriorityId(Integer priorityId) {
        super.setPriorityId(priorityId);
        return this;
    }

    @Override
    public UpdateIssue addComponentId(Integer componentId) {
        super.addComponentId(componentId);
        return this;
    }

    @Override
    public UpdateIssue addVersion(int versionId) {
        super.addVersion(versionId);
        return this;
    }

    @Override
    public UpdateIssue addMilestonId(int milestone) {
        super.addMilestonId(milestone);
        return this;
    }

    @Override
    public UpdateIssue setAssignerId(int assignerId) {
        super.setAssignerId(assignerId);
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

        return new IssueImpl((Map<String, Object>) res);
    }
}
