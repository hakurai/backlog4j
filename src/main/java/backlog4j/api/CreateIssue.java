package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Issue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public class CreateIssue {

    private final BacklogClient client;
    private final Map<String, Object> map = new HashMap<String, Object>();

    public CreateIssue(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return (Integer) map.get("projectId");
    }

    public CreateIssue setProjectId(Integer projectId) {
        map.put("projectId", projectId);

        return this;
    }

    public String getSummary() {
        return (String) map.get("summary");
    }

    public CreateIssue setSummary(String summary) {
        map.put("summary", summary);

        return this;
    }

    public String getDescription() {
        return (String) map.get("description");
    }

    public CreateIssue setDescription(String description) {
        map.put("description", description);

        return this;
    }

    public String getDueDate() {
        return (String) map.get("due_date");
    }

    public CreateIssue setDueDate(String dueDate) {
        map.put("due_date", dueDate);

        return this;
    }

    public String getStartDate() {
        return (String) map.get("start_date");
    }

    public CreateIssue setStartDate(String startDate) {
        map.put("start_date", startDate);

        return this;
    }

    public String getEstimatedHours() {
        return (String) map.get("estimated_hours");
    }

    public CreateIssue setEstimatedHours(String estimatedHours) {
        map.put("estimated_hours", estimatedHours);

        return this;
    }

    public String getActualHours() {
        return (String) map.get("actual_hours");
    }

    public CreateIssue setActualHours(String actualHours) {
        map.put("actual_hours", actualHours);

        return this;
    }

    public Integer getIssueTypeId() {
        return (Integer) map.get("issueTypeId");
    }

    public CreateIssue setIssueTypeId(Integer issueTypeId) {
        map.put("issueTypeId", issueTypeId);

        return this;
    }

    public Integer getPriorityId() {
        return (Integer) map.get("priorityId");
    }

    public CreateIssue setPriorityId(Integer priorityId) {
        map.put("priorityId", priorityId);

        return this;
    }

    public List<Integer> getComponentId() {
        return (List<Integer>) map.get("componentId");
    }

    public CreateIssue addComponentId(Integer componentId) {
        List<Integer> components = getComponentId();
        if (components == null) {
            components = new ArrayList<Integer>();
            map.put("componentId", components);
        }
        components.add(componentId);

        return this;
    }

    public List<Integer> getVersionId() {
        return (List<Integer>) map.get("versionId");
    }

    public CreateIssue addVersion(int versionId) {
        List<Integer> versions = getVersionId();
        if (versions == null) {
            versions = new ArrayList<Integer>();
            map.put("versionId", versions);
        }
        versions.add(versionId);

        return this;
    }

    public List<Integer> getMilestoneId() {
        return (List<Integer>) map.get("milestoneId");
    }

    public CreateIssue addMilestonId(int milestone) {
        List<Integer> milestones = getMilestoneId();
        if (milestones == null) {
            milestones = new ArrayList<Integer>();
            map.put("milestoneId", milestones);
        }
        milestones.add(milestone);

        return this;
    }

    public Integer getAssignerId() {
        return (Integer) map.get("assignerId");
    }

    public CreateIssue setAssignerId(int assignerId) {
        map.put("assignerId", assignerId);

        return this;
    }

    public Issue execute() {
        Object res = client.execute(BacklogClient.BACKLOG_CREATEISSUE, map);

        return new Issue((Map<String, Object>) res);
    }


}
