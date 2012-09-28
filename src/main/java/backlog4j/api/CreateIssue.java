package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Issue;
import backlog4j.impl.IssueImpl;

import java.util.Map;

/**
 * @author eguchi
 */
public class CreateIssue extends AbstractUpdateIssue {

    private final BacklogClient client;

    public CreateIssue(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return (Integer) map.get(PROJECT_ID);
    }

    public CreateIssue setProjectId(Integer projectId) {
        map.put(PROJECT_ID, projectId);

        return this;
    }

    @Override
    public CreateIssue setSummary(String summary) {
        super.setSummary(summary);
        return this;
    }

    @Override
    public CreateIssue setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    @Override
    public CreateIssue setDueDate(String dueDate) {
        super.setDueDate(dueDate);
        return this;
    }

    @Override
    public CreateIssue setStartDate(String startDate) {
        super.setStartDate(startDate);
        return this;
    }

    @Override
    public CreateIssue setEstimatedHours(Double estimatedHours) {
        super.setEstimatedHours(estimatedHours);
        return this;
    }

    @Override
    public CreateIssue setActualHours(Double actualHours) {
        super.setActualHours(actualHours);
        return this;
    }

    @Override
    public CreateIssue setIssueTypeId(Integer issueTypeId) {
        super.setIssueTypeId(issueTypeId);
        return this;
    }

    @Override
    public CreateIssue setPriorityId(Integer priorityId) {
        super.setPriorityId(priorityId);
        return this;
    }

    @Override
    public CreateIssue addComponentId(Integer componentId) {
        super.addComponentId(componentId);
        return this;
    }

    @Override
    public CreateIssue addVersion(int versionId) {
        super.addVersion(versionId);
        return this;
    }

    @Override
    public CreateIssue addMilestonId(int milestone) {
        super.addMilestonId(milestone);
        return this;
    }

    @Override
    public CreateIssue setAssignerId(int assignerId) {
        super.setAssignerId(assignerId);
        return this;
    }

    public Issue execute() {
        Object res = client.execute(BACKLOG_CREATE_ISSUE, map);

        return new IssueImpl((Map<String, Object>) res);
    }


}
