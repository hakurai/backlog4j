package backlog4j.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
abstract class AbstractFindIssueRequest<T, S extends BacklogCommand<T>> implements BacklogCommand<T> {

    public enum ParentChildCondition {
        NOT_CHILD_ISSUE(1),
        CHILD_ISSUE(2),
        LONELY_ISSUE(3),
        PARENT_ISSUE(4);

        private final int value;
        public int getValue() {
            return value;
        }

        public static ParentChildCondition of(int value) {
            switch (value) {
                case 1:
                    return NOT_CHILD_ISSUE;
                case 2:
                    return CHILD_ISSUE;
                case 3:
                    return LONELY_ISSUE;
                case 4:
                    return PARENT_ISSUE;
                default:
                    throw new IllegalArgumentException("Illegal ParentChildCondition value: " + value);
            }
        }

        private ParentChildCondition(int value) {
            this.value = value;
        }
    }

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

    public S setIssueTypeId(Integer issueTypeId) {
        return setValue(ISSUE_TYPE_ID, issueTypeId);
    }

    public S addIssueTypeId(Integer newIssueTypeId) {
        return addValue(ISSUE_TYPE_ID, newIssueTypeId);
    }

    public List<String> getIssueType() {
        return (List<String>) map.get(ISSUE_TYPE);
    }

    public S setIssueType(String issueType) {
        return setValue(ISSUE_TYPE, issueType);

    }

    public S addIssueType(String newIssueType) {
        return addValue(ISSUE_TYPE, newIssueType);
    }

    public List<Integer> getComponentId() {
        return (List<Integer>) map.get(COMPONENT_ID);
    }

    public S setComponentId(Integer componentId) {
        return setValue(COMPONENT_ID, componentId);

    }

    public S addComponentId(int newComponentId) {
        return addValue(COMPONENT_ID, newComponentId);
    }

    public List<Integer> getVersionId() {
        return (List<Integer>) map.get(VERSION_ID);
    }

    public S setVersionId(Integer versionId) {
        return setValue(VERSION_ID, versionId);
    }

    public S addVersionId(int newVersionId) {
        return addValue(VERSION_ID, newVersionId);
    }

    public List<Integer> getMilestoneId() {
        return (List<Integer>) map.get(MILESTONE_ID);
    }

    public S setMilestoneId(Integer milestoneId) {
        return setValue(MILESTONE_ID, milestoneId);
    }

    public S addMilestoneId(int newMilestoneId) {
        return addValue(MILESTONE_ID, newMilestoneId);
    }

    public List<Integer> getStatusId() {
        return (List<Integer>) map.get(STATUS_ID);
    }

    public S setStatusId(Integer statusId) {
        return setValue(STATUS_ID, statusId);
    }

    public S addStatusId(int newStatusId) {
        return addValue(STATUS_ID, newStatusId);
    }

    public List<Integer> getPriorityId() {
        return (List<Integer>) map.get(PRIORITY_ID);
    }

    public S addPriorityId(int newPriorityId) {
        return addValue(PRIORITY_ID, newPriorityId);
    }

    public List<Integer> getAssignerId() {
        return (List<Integer>) map.get(ASSIGNER_ID);
    }

    public S setAssignerId(Integer assignerId) {
        return setValue(ASSIGNER_ID, assignerId);
    }

    public S addAssignerId(int newAssignerId) {
        return addValue(ASSIGNER_ID, newAssignerId);
    }

    public List<Integer> getCreatedUserId() {
        return (List<Integer>) map.get(CREATED_USER_ID);
    }

    public S setCreatedUserId(Integer createdUserId) {
        return setValue(CREATED_USER_ID, createdUserId);
    }

    public S addCreatedUserId(int newCreatedUserId) {
        return addValue(CREATED_USER_ID, newCreatedUserId);
    }

    public List<Integer> getResolutionId() {
        return (List<Integer>) map.get(RESOLUTION_ID);
    }

    public S setResolutionId(Integer resolutionId) {
        return setValue(RESOLUTION_ID, resolutionId);
    }

    public S addResolutionId(int newResolutionId) {
        return addValue(RESOLUTION_ID, newResolutionId);
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

    public ParentChildCondition getParentChildIssue() {
        Integer value = (Integer) map.get(PARENT_CHILD_ISSUE);

        return value == null ? null : ParentChildCondition.of(value);
    }

    public S setParentChildIssue(ParentChildCondition parentChildCondition) {
        map.put(PARENT_CHILD_ISSUE, parentChildCondition.getValue());

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

    public S setFile(BacklogCommand.File file) {
        return setValue(FILE, file);
    }

    public S addFile(BacklogCommand.File file) {
        return addValue(FILE, file);
    }

    protected <V> S setValue(String name, V value) {
        List<V> list = (List<V>) map.get(name);
        if (list != null && !list.isEmpty()) {
            list.clear();
        }
        addValue(name, value);

        return getThis();
    }

    protected <V> S addValue(String name, V value) {
        List<V> list = (List<V>) map.get(name);
        if (list == null) {
            list = new ArrayList<V>();
            map.put(name, list);
        }
        list.add(value);

        return getThis();
    }
}
