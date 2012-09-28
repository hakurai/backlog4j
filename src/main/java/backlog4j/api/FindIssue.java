package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Issue;
import backlog4j.impl.IssueImpl;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class FindIssue extends AbstractFindIssueRequest<List<Issue>> {


    private final BacklogClient client;

    public FindIssue(BacklogClient client) {
        this.client = client;
    }

    @Override
    public FindIssue setProjectId(Integer projectId) {
        super.setProjectId(projectId);

        return this;
    }

    @Override
    public FindIssue addIssueTypeId(int newIssueTypeId) {
        super.addIssueTypeId(newIssueTypeId);

        return this;
    }

    @Override
    public FindIssue addIssueType(String newIssueType) {
        super.addIssueType(newIssueType);

        return this;
    }

    @Override
    public FindIssue addComponentId(int newComponentId) {
        super.addComponentId(newComponentId);

        return this;
    }

    @Override
    public FindIssue addVersionId(int newVersionId) {
        super.addVersionId(newVersionId);

        return this;
    }

    @Override
    public FindIssue addMilestoneId(int newMilestoneId) {
        super.addMilestoneId(newMilestoneId);

        return this;
    }

    @Override
    public FindIssue addStatusId(int newStatusId) {
        super.addStatusId(newStatusId);

        return this;
    }

    @Override
    public FindIssue addPriorityId(int newPriorityId) {
        super.addPriorityId(newPriorityId);

        return this;
    }

    @Override
    public FindIssue addAssignerId(int newAssignerId) {
        super.addAssignerId(newAssignerId);

        return this;
    }

    @Override
    public FindIssue addCreatedUserId(int newCreatedUserId) {
        super.addCreatedUserId(newCreatedUserId);

        return this;
    }

    @Override
    public FindIssue addResolutionId(int newResolutionId) {
        super.addResolutionId(newResolutionId);

        return this;
    }

    @Override
    public FindIssue setCreatedOnMin(String createdOnMin) {
        super.setCreatedOnMin(createdOnMin);

        return this;
    }

    @Override
    public FindIssue setCreatedOnMax(String createdOnMax) {
        super.setCreatedOnMax(createdOnMax);

        return this;
    }

    @Override
    public FindIssue setUpdatedOnMin(String updatedOnMin) {
        super.setUpdatedOnMin(updatedOnMin);

        return this;
    }

    @Override
    public FindIssue setUpdatedOnMax(String updatedOnMax) {
        super.setUpdatedOnMax(updatedOnMax);

        return this;
    }

    @Override
    public FindIssue setStartDateMin(String startDateMin) {
        super.setStartDateMin(startDateMin);

        return this;
    }

    @Override
    public FindIssue setStartDateMax(String startDateMax) {
        super.setStartDateMax(startDateMax);

        return this;
    }

    @Override
    public FindIssue setDueDateMin(String dueDateMin) {
        super.setDueDateMin(dueDateMin);

        return this;
    }

    @Override
    public FindIssue setDueDateMax(String dueDateMax) {
        super.setDueDateMax(dueDateMax);

        return this;
    }

    @Override
    public FindIssue setQuery(String query) {
        super.setQuery(query);

        return this;
    }

    @Override
    public FindIssue addFile(File file) {
        super.addFile(file);

        return this;
    }

    public String getSort() {
        return (String) map.get(SORT);
    }

    public FindIssue setSort(String sort) {
        map.put(SORT, sort);

        return this;
    }


    public Boolean getOrder() {
        return (Boolean) map.get(ORDER);
    }

    public FindIssue setOrder(boolean order) {
        map.put(ORDER, order);

        return this;
    }

    public Integer getOffset() {
        return (Integer) map.get(OFFSET);
    }

    public FindIssue setOffset(int offset) {
        map.put(OFFSET, offset);

        return this;
    }

    public Integer getLimit() {
        return (Integer) map.get(LIMIT);
    }

    public FindIssue setLimit(int limit) {
        if (limit > MAX_LIMIT || limit < 0) {
            throw new IllegalArgumentException();
        }
        map.put(LIMIT, limit);

        return this;
    }

    private void checkParameters() {
        if (getProjectId() == null) {
            throw new BacklogException("projectId is required");
        }
    }

    public List<Issue> execute() {
        checkParameters();
        Object res = client.execute(BACKLOG_FIND_ISSUE, map);

        return XmlRpcUtil.<Issue>toList(IssueImpl.class, res);
    }

}
