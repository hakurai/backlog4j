package backlog4j.api;

import backlog4j.Issue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
abstract class AbstractUpdateIssue<S> implements BacklogCommand<Issue> {

    protected final Map<String, Object> map = new HashMap<String, Object>();
    
    protected abstract S getThis();

    public String getSummary() {
        return (String) map.get(SUMMARY);
    }

    public S setSummary(String summary) {
        map.put(SUMMARY, summary);

        return getThis();
    }

    public String getDescription() {
        return (String) map.get(DESCRIPTION);
    }

    public S setDescription(String description) {
        map.put(DESCRIPTION, description);

        return getThis();
    }

    public String getDueDate() {
        return (String) map.get(DUE_DATE);
    }

    public S setDueDate(String dueDate) {
        map.put(DUE_DATE, dueDate);

        return getThis();
    }

    public String getStartDate() {
        return (String) map.get(START_DATE);
    }

    public S setStartDate(String startDate) {
        map.put(START_DATE, startDate);

        return getThis();
    }

    public Double getEstimatedHours() {
        return (Double) map.get(ESTIMATED_HOURS);
    }

    public S setEstimatedHours(Double estimatedHours) {
        map.put(ESTIMATED_HOURS, estimatedHours);

        return getThis();
    }

    public Double getActualHours() {
        return (Double) map.get(ACTUAL_HOURS);
    }

    public S setActualHours(Double actualHours) {
        map.put(ACTUAL_HOURS, actualHours);

        return getThis();
    }

    public Integer getIssueTypeId() {
        return (Integer) map.get(ISSUE_TYPE_ID);
    }

    public S setIssueTypeId(Integer issueTypeId) {
        map.put(ISSUE_TYPE_ID, issueTypeId);

        return getThis();
    }

    public Integer getPriorityId() {
        return (Integer) map.get(PRIORITY_ID);
    }

    public S setPriorityId(Integer priorityId) {
        map.put(PRIORITY_ID, priorityId);

        return getThis();
    }

    public List<Integer> getComponentId() {
        return (List<Integer>) map.get(COMPONENT_ID);
    }

    public S addComponentId(Integer componentId) {
        List<Integer> components = getComponentId();
        if (components == null) {
            components = new ArrayList<Integer>();
            map.put(COMPONENT_ID, components);
        }
        components.add(componentId);

        return getThis();
    }

    public List<Integer> getVersionId() {
        return (List<Integer>) map.get(VERSION_ID);
    }

    public S addVersion(int versionId) {
        List<Integer> versions = getVersionId();
        if (versions == null) {
            versions = new ArrayList<Integer>();
            map.put(VERSION_ID, versions);
        }
        versions.add(versionId);

        return getThis();
    }

    public List<Integer> getMilestoneId() {
        return (List<Integer>) map.get(MILESTONE_ID);
    }

    public S addMilestonId(int milestone) {
        List<Integer> milestones = getMilestoneId();
        if (milestones == null) {
            milestones = new ArrayList<Integer>();
            map.put(MILESTONE_ID, milestones);
        }
        milestones.add(milestone);

        return getThis();
    }

    public Integer getAssignerId() {
        return (Integer) map.get(ASSIGNER_ID);
    }

    public S setAssignerId(int assignerId) {
        map.put(ASSIGNER_ID, assignerId);

        return getThis();
    }
}
