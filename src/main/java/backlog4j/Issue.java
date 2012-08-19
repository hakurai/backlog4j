package backlog4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public final class Issue {

    private final int id;
    private final String key;
    private final String summary;
    private final String description;
    private final String url;
    private final String dueDate;
    private final String startDate;
    private final String estimatedHours;
    private final String actualHours;
    private final IssueType issueType;
    private final Priority priority;
    private final Resolution resolution;
    private final Status status;
    private final List<Category> components;
    private final List<Version> versions;
    private final List<Milestone> milestones;
    private final User createdUser;
    private final User assigner;
    private final String createdOn;
    private final String updatedOn;

    public Issue(Map<String, Object> map) {
        id = (Integer) map.get("id");
        key = (String) map.get("key");
        summary = (String) map.get("summary");
        description = (String) map.get("description");
        url = (String) map.get("url");
        dueDate = (String) map.get("due_date");
        startDate = XmlRpcUtil.castToString(map.get("start_date"));
        estimatedHours = XmlRpcUtil.castToString(map.get("estimated_hours"));
        actualHours = XmlRpcUtil.castToString(map.get("actual_hours"));
        issueType = new IssueType((Map<String, Object>) map.get("issueType"));
        priority = new Priority((Map<String, Object>) map.get("priority"));
        Object resolutionSrc = map.get("resolution");
        resolution = resolutionSrc == null ? null : new Resolution((Map<String, Object>) resolutionSrc);
        status = new Status((Map<String, Object>) map.get("status"));
        components = XmlRpcUtil.toList(Category.class, map.get("components"));
        versions = XmlRpcUtil.toList(Version.class, map.get("versions"));
        milestones = XmlRpcUtil.toList(Milestone.class, map.get("milestones"));
        createdUser = new User((Map<String, Object>) map.get("created_user"));
        Object assignerSrc = map.get("assigner");
        assigner = assignerSrc == null ? null : new User((Map<String, Object>) assignerSrc);
        createdOn = (String) map.get("created_on");
        updatedOn = (String) map.get("updated_on");

    }

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
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

    public IssueType getIssueType() {
        return issueType;
    }

    public Priority getPriority() {
        return priority;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public Status getStatus() {
        return status;
    }

    public List<Category> getComponents() {
        return components;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public List<Milestone> getMilestones() {
        return milestones;
    }

    public User getCreatedUser() {
        return createdUser;
    }

    public User getAssigner() {
        return assigner;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }
}
