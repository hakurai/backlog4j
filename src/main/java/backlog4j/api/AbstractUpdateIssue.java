package backlog4j.api;

import backlog4j.Issue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
abstract class AbstractUpdateIssue implements BacklogCommand<Issue> {

    protected final Map<String, Object> map = new HashMap<String, Object>();

    public String getSummary() {
        return (String) map.get(SUMMARY);
    }

    public AbstractUpdateIssue setSummary(String summary) {
        map.put(SUMMARY, summary);

        return this;
    }

    public String getDescription() {
        return (String) map.get(DESCRIPTION);
    }

    public AbstractUpdateIssue setDescription(String description) {
        map.put(DESCRIPTION, description);

        return this;
    }

    public String getDueDate() {
        return (String) map.get(DUE_DATE);
    }

    public AbstractUpdateIssue setDueDate(String dueDate) {
        map.put(DUE_DATE, dueDate);

        return this;
    }

    public String getStartDate() {
        return (String) map.get(START_DATE);
    }

    public AbstractUpdateIssue setStartDate(String startDate) {
        map.put(START_DATE, startDate);

        return this;
    }

    public String getEstimatedHours() {
        return (String) map.get(ESTIMATED_HOURS);
    }

    public AbstractUpdateIssue setEstimatedHours(String estimatedHours) {
        map.put(ESTIMATED_HOURS, estimatedHours);

        return this;
    }

    public String getActualHours() {
        return (String) map.get(ACTUAL_HOURS);
    }

    public AbstractUpdateIssue setActualHours(String actualHours) {
        map.put(ACTUAL_HOURS, actualHours);

        return this;
    }

    public Integer getIssueTypeId() {
        return (Integer) map.get(ISSUE_TYPE_ID);
    }

    public AbstractUpdateIssue setIssueTypeId(Integer issueTypeId) {
        map.put(ISSUE_TYPE_ID, issueTypeId);

        return this;
    }

    public Integer getPriorityId() {
        return (Integer) map.get(PRIORITY_ID);
    }

    public AbstractUpdateIssue setPriorityId(Integer priorityId) {
        map.put(PRIORITY_ID, priorityId);

        return this;
    }

    public List<Integer> getComponentId() {
        return (List<Integer>) map.get(COMPONENT_ID);
    }

    public AbstractUpdateIssue addComponentId(Integer componentId) {
        List<Integer> components = getComponentId();
        if (components == null) {
            components = new ArrayList<Integer>();
            map.put(COMPONENT_ID, components);
        }
        components.add(componentId);

        return this;
    }

    public List<Integer> getVersionId() {
        return (List<Integer>) map.get(VERSION_ID);
    }

    public AbstractUpdateIssue addVersion(int versionId) {
        List<Integer> versions = getVersionId();
        if (versions == null) {
            versions = new ArrayList<Integer>();
            map.put(VERSION_ID, versions);
        }
        versions.add(versionId);

        return this;
    }

    public List<Integer> getMilestoneId() {
        return (List<Integer>) map.get(MILESTONE_ID);
    }

    public AbstractUpdateIssue addMilestonId(int milestone) {
        List<Integer> milestones = getMilestoneId();
        if (milestones == null) {
            milestones = new ArrayList<Integer>();
            map.put(MILESTONE_ID, milestones);
        }
        milestones.add(milestone);

        return this;
    }

    public Integer getAssignerId() {
        return (Integer) map.get(ASSIGNER_ID);
    }

    public AbstractUpdateIssue setAssignerId(int assignerId) {
        map.put(ASSIGNER_ID, assignerId);

        return this;
    }
}
