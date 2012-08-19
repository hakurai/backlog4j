package backlog4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public final class CreateIssueRequest {

    private final int projectId;
    private final String summary;
    private final String description;
    private final String dueDate;
    private final String startDate;
    private final String estimatedHours;
    private final String actualHours;
    private final Integer issueTypeId;
    private final Integer priority;
    private final List<Integer> components;
    private final List<Integer> versions;
    private final List<Integer> milestones;
    private final Integer assignerId;

    public CreateIssueRequest(int projectId,
                              String summary,
                              String description,
                              String dueDate,
                              String startDate,
                              String estimatedHours,
                              String actualHours,
                              Integer issueTypeId,
                              Integer priority,
                              List<Integer> components,
                              List<Integer> versions,
                              List<Integer> milestones,
                              Integer assignerId) {
        this.projectId = projectId;
        this.summary = summary;
        this.description = description;
        this.dueDate = dueDate;
        this.startDate = startDate;
        this.estimatedHours = estimatedHours;
        this.actualHours = actualHours;
        this.issueTypeId = issueTypeId;
        this.priority = priority;
        this.components = components;
        this.versions = versions;
        this.milestones = milestones;
        this.assignerId = assignerId;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEstimatedHours() {
        return estimatedHours;
    }

    public String getActualHours() {
        return actualHours;
    }

    public Integer getIssueTypeId() {
        return issueTypeId;
    }

    public Integer getPriority() {
        return priority;
    }

    public List<Integer> getComponents() {
        return components;
    }

    public List<Integer> getVersions() {
        return versions;
    }

    public List<Integer> getMilestones() {
        return milestones;
    }

    public Integer getAssignerId() {
        return assignerId;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("projectId", getProjectId());
        map.put("summary", getSummary());
        XmlRpcUtil.putNonNullObject(map, "description", getDescription());
        XmlRpcUtil.putNonNullObject(map, "start_date", getStartDate());
        XmlRpcUtil.putNonNullObject(map, "due_date", getDueDate());
        XmlRpcUtil.putNonNullObject(map, "estimated_hours", getEstimatedHours());
        XmlRpcUtil.putNonNullObject(map, "actual_hours", getActualHours());
        XmlRpcUtil.putNonNullObject(map, "issueTypeId", getIssueTypeId());
        XmlRpcUtil.putNonNullObject(map, "componentId", getComponents());
        XmlRpcUtil.putNonNullObject(map, "versionId", getVersions());
        XmlRpcUtil.putNonNullObject(map, "milestoneId", getMilestones());
        XmlRpcUtil.putNonNullObject(map, "priorityId", getPriority());
        XmlRpcUtil.putNonNullObject(map, "assignerId", getAssignerId());
        XmlRpcUtil.putNonNullObject(map, "versionId", getVersions());

        return map;

    }
}
