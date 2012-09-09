package backlog4j.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public abstract class AbstractFindIssueRequest<T> implements BacklogCommand<T> {

    protected final Map<String, Object> map = new HashMap<String, Object>();

    public Integer getProjectId() {
        return (Integer) map.get(PROJECT_ID);
    }

    public AbstractFindIssueRequest<T> setProjectId(Integer projectId) {
        map.put(PROJECT_ID, projectId);

        return this;
    }

    public List<Integer> getIssueTypeId() {
        return (List<Integer>) map.get(ISSUE_TYPE_ID);
    }

    public AbstractFindIssueRequest<T> addIssueTypeId(int newIssueTypeId) {
        List<Integer> issueTypeId = getIssueTypeId();
        if (issueTypeId == null) {
            issueTypeId = new ArrayList<Integer>();
            map.put(ISSUE_TYPE_ID, issueTypeId);
        }
        issueTypeId.add(newIssueTypeId);

        return this;
    }

    public List<String> getIssueType() {
        return (List<String>) map.get(ISSUE_TYPE);
    }

    public AbstractFindIssueRequest<T> addIssueType(String newIssueType) {
        List<String> issueType = getIssueType();
        if (issueType == null) {
            issueType = new ArrayList<String>();
            map.put(ISSUE_TYPE, issueType);
        }
        issueType.add(newIssueType);

        return this;
    }

    public List<Integer> getComponentId() {
        return (List<Integer>) map.get(COMPONENT_ID);
    }

    public AbstractFindIssueRequest<T> addComponentId(int newComponentId) {
        List<Integer> componentId = getComponentId();
        if (componentId == null) {
            componentId = new ArrayList<Integer>();
            map.put(COMPONENT_ID, componentId);
        }
        componentId.add(newComponentId);

        return this;
    }

    public List<Integer> getVersionId() {
        return (List<Integer>) map.get(VERSION_ID);
    }

    public AbstractFindIssueRequest<T> addVersionId(int newVersionId) {
        List<Integer> versionId = getVersionId();
        if (versionId == null) {
            versionId = new ArrayList<Integer>();
            map.put(VERSION_ID, versionId);
        }
        versionId.add(newVersionId);

        return this;
    }

    public List<Integer> getMilestoneId() {
        return (List<Integer>) map.get(MILESTONE_ID);
    }

    public AbstractFindIssueRequest<T> addMilestoneId(int newMilestoneId) {
        List<Integer> milestoneId = getMilestoneId();
        if (milestoneId == null) {
            milestoneId = new ArrayList<Integer>();
            map.put(MILESTONE_ID, milestoneId);
        }
        milestoneId.add(newMilestoneId);

        return this;
    }

    public List<Integer> getStatusId() {
        return (List<Integer>) map.get(STATUS_ID);
    }

    public AbstractFindIssueRequest<T> addStatusId(int newStatusId) {
        List<Integer> statusId = getStatusId();
        if (statusId == null) {
            statusId = new ArrayList<Integer>();
            map.put(STATUS_ID, statusId);
        }
        statusId.add(newStatusId);

        return this;
    }

    public List<Integer> getPriorityId() {
        return (List<Integer>) map.get(PRIORITY_ID);
    }

    public AbstractFindIssueRequest<T> addPriorityId(int newPriorityId) {
        List<Integer> priorityId = getPriorityId();
        if (priorityId == null) {
            priorityId = new ArrayList<Integer>();
            map.put(PRIORITY_ID, priorityId);
        }
        priorityId.add(newPriorityId);

        return this;
    }

    public List<Integer> getAssignerId() {
        return (List<Integer>) map.get(ASSIGNER_ID);
    }

    public AbstractFindIssueRequest<T> addAssignerId(int newAssignerId) {
        List<Integer> assignerId = getAssignerId();
        if (assignerId == null) {
            assignerId = new ArrayList<Integer>();
            map.put(ASSIGNER_ID, assignerId);
        }
        assignerId.add(newAssignerId);

        return this;
    }

    public List<Integer> getCreatedUserId() {
        return (List<Integer>) map.get(CREATED_USER_ID);
    }

    public AbstractFindIssueRequest<T> addCreatedUserId(int newCreatedUserId) {
        List<Integer> createdUserId = getCreatedUserId();
        if (createdUserId == null) {
            createdUserId = new ArrayList<Integer>();
            map.put(CREATED_USER_ID, createdUserId);
        }
        createdUserId.add(newCreatedUserId);

        return this;
    }

    public List<Integer> getResolutionId() {
        return (List<Integer>) map.get(RESOLUTION_ID);
    }

    public AbstractFindIssueRequest<T> addResolutionId(int newResolutionId) {
        List<Integer> resolutionId = getResolutionId();
        if (resolutionId == null) {
            resolutionId = new ArrayList<Integer>();
            map.put(RESOLUTION_ID, resolutionId);
        }
        resolutionId.add(newResolutionId);

        return this;
    }

    public String getCreatedOnMin() {
        return (String) map.get(CREATED_ON_MIN);
    }

    public AbstractFindIssueRequest<T> setCreatedOnMin(String createdOnMin) {
        map.put(CREATED_ON_MIN, createdOnMin);

        return this;
    }

    public String getCreatedOnMax() {
        return (String) map.get(CREATED_ON_MAX);
    }

    public AbstractFindIssueRequest<T> setCreatedOnMax(String createdOnMax) {
        map.put(CREATED_ON_MAX, createdOnMax);

        return this;
    }

    public String getUpdatedOnMin() {
        return (String) map.get(UPDATED_ON_MIN);
    }

    public AbstractFindIssueRequest<T> setUpdatedOnMin(String updatedOnMin) {
        map.put(UPDATED_ON_MIN, updatedOnMin);

        return this;
    }

    public String getUpdatedOnMax() {
        return (String) map.get(UPDATED_ON_MAX);
    }

    public AbstractFindIssueRequest<T> setUpdatedOnMax(String updatedOnMax) {
        map.put(UPDATED_ON_MAX, updatedOnMax);

        return this;
    }

    public String getStartDateMin() {
        return (String) map.get(START_DATE_MIN);
    }

    public AbstractFindIssueRequest<T> setStartDateMin(String startDateMin) {
        map.put(START_DATE_MIN, START_DATE_MIN);

        return this;
    }

    public String getStartDateMax() {
        return (String) map.get(START_DATE_MAX);
    }

    public AbstractFindIssueRequest<T> setStartDateMax(String startDateMax) {
        map.put(START_DATE_MAX, startDateMax);

        return this;
    }

    public String getDueDateMin() {
        return (String) map.get(DUE_DATE_MIN);
    }

    public AbstractFindIssueRequest<T> setDueDateMin(String dueDateMin) {
        map.put(DUE_DATE_MIN, dueDateMin);

        return this;
    }

    public String getDueDateMax() {
        return (String) map.get(DUE_DATE_MAX);
    }

    public AbstractFindIssueRequest<T> setDueDateMax(String dueDateMax) {
        map.put(DUE_DATE_MAX, dueDateMax);

        return this;
    }

    public String getQuery() {
        return (String) map.get(QUERY);
    }

    public AbstractFindIssueRequest<T> setQuery(String query) {
        map.put(QUERY, query);

        return this;
    }

    public List<BacklogCommand.File> getFile() {
        return (List<BacklogCommand.File>) map.get(FILE);
    }

    public AbstractFindIssueRequest<T> addFile(BacklogCommand.File file) {
        List<BacklogCommand.File> list = getFile();
        if (list == null) {
            list = new ArrayList<BacklogCommand.File>();
            map.put(FILE, list);
        }
        list.add(file);

        return this;
    }
}
