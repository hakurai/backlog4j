package backlog4j.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
abstract class AbstractFindIssueRequest<T,S extends BacklogCommand<T>> implements BacklogCommand<T> {

    protected final Map<String, Object> map = new HashMap<String, Object>();

    public Integer getProjectId() {
        return (Integer) map.get(PROJECT_ID);
    }
    
    protected abstract S getThis();

    public S setProjectId(Integer projectId) {
        map.put(PROJECT_ID, projectId);

        return getThis();
    }

    public List<Integer> getIssueTypeId() {
        return (List<Integer>) map.get(ISSUE_TYPE_ID);
    }

    public S addIssueTypeId(int newIssueTypeId) {
        List<Integer> issueTypeId = getIssueTypeId();
        if (issueTypeId == null) {
            issueTypeId = new ArrayList<Integer>();
            map.put(ISSUE_TYPE_ID, issueTypeId);
        }
        issueTypeId.add(newIssueTypeId);

        return getThis();
    }

    public List<String> getIssueType() {
        return (List<String>) map.get(ISSUE_TYPE);
    }

    public S addIssueType(String newIssueType) {
        List<String> issueType = getIssueType();
        if (issueType == null) {
            issueType = new ArrayList<String>();
            map.put(ISSUE_TYPE, issueType);
        }
        issueType.add(newIssueType);

        return getThis();
    }

    public List<Integer> getComponentId() {
        return (List<Integer>) map.get(COMPONENT_ID);
    }

    public S addComponentId(int newComponentId) {
        List<Integer> componentId = getComponentId();
        if (componentId == null) {
            componentId = new ArrayList<Integer>();
            map.put(COMPONENT_ID, componentId);
        }
        componentId.add(newComponentId);

        return getThis();
    }

    public List<Integer> getVersionId() {
        return (List<Integer>) map.get(VERSION_ID);
    }

    public S addVersionId(int newVersionId) {
        List<Integer> versionId = getVersionId();
        if (versionId == null) {
            versionId = new ArrayList<Integer>();
            map.put(VERSION_ID, versionId);
        }
        versionId.add(newVersionId);

        return getThis();
    }

    public List<Integer> getMilestoneId() {
        return (List<Integer>) map.get(MILESTONE_ID);
    }

    public S addMilestoneId(int newMilestoneId) {
        List<Integer> milestoneId = getMilestoneId();
        if (milestoneId == null) {
            milestoneId = new ArrayList<Integer>();
            map.put(MILESTONE_ID, milestoneId);
        }
        milestoneId.add(newMilestoneId);

        return getThis();
    }

    public List<Integer> getStatusId() {
        return (List<Integer>) map.get(STATUS_ID);
    }

    public S addStatusId(int newStatusId) {
        List<Integer> statusId = getStatusId();
        if (statusId == null) {
            statusId = new ArrayList<Integer>();
            map.put(STATUS_ID, statusId);
        }
        statusId.add(newStatusId);

        return getThis();
    }

    public List<Integer> getPriorityId() {
        return (List<Integer>) map.get(PRIORITY_ID);
    }

    public S addPriorityId(int newPriorityId) {
        List<Integer> priorityId = getPriorityId();
        if (priorityId == null) {
            priorityId = new ArrayList<Integer>();
            map.put(PRIORITY_ID, priorityId);
        }
        priorityId.add(newPriorityId);

        return getThis();
    }

    public List<Integer> getAssignerId() {
        return (List<Integer>) map.get(ASSIGNER_ID);
    }

    public S addAssignerId(int newAssignerId) {
        List<Integer> assignerId = getAssignerId();
        if (assignerId == null) {
            assignerId = new ArrayList<Integer>();
            map.put(ASSIGNER_ID, assignerId);
        }
        assignerId.add(newAssignerId);

        return getThis();
    }

    public List<Integer> getCreatedUserId() {
        return (List<Integer>) map.get(CREATED_USER_ID);
    }

    public S addCreatedUserId(int newCreatedUserId) {
        List<Integer> createdUserId = getCreatedUserId();
        if (createdUserId == null) {
            createdUserId = new ArrayList<Integer>();
            map.put(CREATED_USER_ID, createdUserId);
        }
        createdUserId.add(newCreatedUserId);

        return getThis();
    }

    public List<Integer> getResolutionId() {
        return (List<Integer>) map.get(RESOLUTION_ID);
    }

    public S addResolutionId(int newResolutionId) {
        List<Integer> resolutionId = getResolutionId();
        if (resolutionId == null) {
            resolutionId = new ArrayList<Integer>();
            map.put(RESOLUTION_ID, resolutionId);
        }
        resolutionId.add(newResolutionId);

        return getThis();
    }

    public String getCreatedOnMin() {
        return (String) map.get(CREATED_ON_MIN);
    }

    public S setCreatedOnMin(String createdOnMin) {
        map.put(CREATED_ON_MIN, createdOnMin);

        return getThis();
    }

    public String getCreatedOnMax() {
        return (String) map.get(CREATED_ON_MAX);
    }

    public S setCreatedOnMax(String createdOnMax) {
        map.put(CREATED_ON_MAX, createdOnMax);

        return getThis();
    }

    public String getUpdatedOnMin() {
        return (String) map.get(UPDATED_ON_MIN);
    }

    public S setUpdatedOnMin(String updatedOnMin) {
        map.put(UPDATED_ON_MIN, updatedOnMin);

        return getThis();
    }

    public String getUpdatedOnMax() {
        return (String) map.get(UPDATED_ON_MAX);
    }

    public S setUpdatedOnMax(String updatedOnMax) {
        map.put(UPDATED_ON_MAX, updatedOnMax);

        return getThis();
    }

    public String getStartDateMin() {
        return (String) map.get(START_DATE_MIN);
    }

    public S setStartDateMin(String startDateMin) {
        map.put(START_DATE_MIN, START_DATE_MIN);

        return getThis();
    }

    public String getStartDateMax() {
        return (String) map.get(START_DATE_MAX);
    }

    public S setStartDateMax(String startDateMax) {
        map.put(START_DATE_MAX, startDateMax);

        return getThis();
    }

    public String getDueDateMin() {
        return (String) map.get(DUE_DATE_MIN);
    }

    public S setDueDateMin(String dueDateMin) {
        map.put(DUE_DATE_MIN, dueDateMin);

        return getThis();
    }

    public String getDueDateMax() {
        return (String) map.get(DUE_DATE_MAX);
    }

    public S setDueDateMax(String dueDateMax) {
        map.put(DUE_DATE_MAX, dueDateMax);

        return getThis();
    }

    public String getQuery() {
        return (String) map.get(QUERY);
    }

    public S setQuery(String query) {
        map.put(QUERY, query);

        return getThis();
    }

    public List<BacklogCommand.File> getFile() {
        return (List<BacklogCommand.File>) map.get(FILE);
    }

    public S addFile(BacklogCommand.File file) {
        List<BacklogCommand.File> list = getFile();
        if (list == null) {
            list = new ArrayList<BacklogCommand.File>();
            map.put(FILE, list);
        }
        list.add(file);

        return getThis();
    }
}
