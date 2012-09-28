package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;

/**
 * @author eguchi
 */
public class CountIssue extends AbstractFindIssueRequest<Integer> {

    private final BacklogClient client;


    public CountIssue(BacklogClient client) {
        this.client = client;
    }

    @Override
    public CountIssue setProjectId(Integer projectId) {
        super.setProjectId(projectId);

        return this;
    }

    @Override
    public CountIssue addIssueTypeId(int newIssueTypeId) {
        super.addIssueTypeId(newIssueTypeId);

        return this;
    }

    @Override
    public CountIssue addIssueType(String newIssueType) {
        super.addIssueType(newIssueType);

        return this;
    }

    @Override
    public CountIssue addComponentId(int newComponentId) {
        super.addComponentId(newComponentId);

        return this;
    }

    @Override
    public CountIssue addVersionId(int newVersionId) {
        super.addVersionId(newVersionId);

        return this;
    }

    @Override
    public CountIssue addMilestoneId(int newMilestoneId) {
        super.addMilestoneId(newMilestoneId);

        return this;
    }

    @Override
    public CountIssue addStatusId(int newStatusId) {
        super.addStatusId(newStatusId);

        return this;
    }

    @Override
    public CountIssue addPriorityId(int newPriorityId) {
        super.addPriorityId(newPriorityId);

        return this;
    }

    @Override
    public CountIssue addAssignerId(int newAssignerId) {
        super.addAssignerId(newAssignerId);

        return this;
    }

    @Override
    public CountIssue addCreatedUserId(int newCreatedUserId) {
        super.addCreatedUserId(newCreatedUserId);

        return this;
    }

    @Override
    public CountIssue addResolutionId(int newResolutionId) {
        super.addResolutionId(newResolutionId);

        return this;
    }

    @Override
    public CountIssue setCreatedOnMin(String createdOnMin) {
        super.setCreatedOnMin(createdOnMin);

        return this;
    }

    @Override
    public CountIssue setCreatedOnMax(String createdOnMax) {
        super.setCreatedOnMax(createdOnMax);

        return this;
    }

    @Override
    public CountIssue setUpdatedOnMin(String updatedOnMin) {
        super.setUpdatedOnMin(updatedOnMin);

        return this;
    }

    @Override
    public CountIssue setUpdatedOnMax(String updatedOnMax) {
        super.setUpdatedOnMax(updatedOnMax);

        return this;
    }

    @Override
    public CountIssue setStartDateMin(String startDateMin) {
        super.setStartDateMin(startDateMin);

        return this;
    }

    @Override
    public CountIssue setStartDateMax(String startDateMax) {
        super.setStartDateMax(startDateMax);

        return this;
    }

    @Override
    public CountIssue setDueDateMin(String dueDateMin) {
        super.setDueDateMin(dueDateMin);

        return this;
    }

    @Override
    public CountIssue setDueDateMax(String dueDateMax) {
        super.setDueDateMax(dueDateMax);

        return this;
    }

    @Override
    public CountIssue setQuery(String query) {
        super.setQuery(query);

        return this;
    }

    @Override
    public CountIssue addFile(File file) {
        super.addFile(file);

        return this;
    }

    private void checkParameters() {
        if (getProjectId() == null) {
            throw new BacklogException("projectId is required");
        }
    }

    public Integer execute() {
        checkParameters();
        Integer res = (Integer) client.execute(BACKLOG_COUNT_ISSUE, map);

        return res;
    }
}
