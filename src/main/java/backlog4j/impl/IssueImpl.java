package backlog4j.impl;

import backlog4j.*;
import backlog4j.util.XmlRpcUtil;

import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public final class IssueImpl implements Issue {

    private final Integer id;
    private final Integer parentIssueId;
    private final String key;
    private final String summary;
    private final String description;
    private final String url;
    private final String dueDate;
    private final String startDate;
    private final Double estimatedHours;
    private final Double actualHours;
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

    public IssueImpl(Map<String, Object> map) {
        id = (Integer) map.get(ID);
        parentIssueId = (Integer) map.get(PARENT_ISSUE_ID);
        key = (String) map.get(KEY);
        summary = (String) map.get(SUMMARY);
        description = (String) map.get(DESCRIPTION);
        url = (String) map.get(URL);
        dueDate = (String) map.get(DUE_DATE);
        startDate = (String) map.get(START_DATE);
        estimatedHours = (Double) map.get(ESTIMATED_HOURS);
        actualHours = (Double) map.get(ACTUAL_HOURS);
        issueType = IssueTypeImpl.create((Map<String, Object>) map.get(ISSUE_TYPE));
        priority = PriorityImpl.create((Map<String, Object>) map.get(PRIORITY));
        resolution = ResolutionImpl.create((Map<String, Object>) map.get(RESOLUTION));
        status = StatusImpl.create((Map<String, Object>) map.get(STATUS));
        components = XmlRpcUtil.<Category>toList(CategoryImpl.class, map.get(COMPONENTS));
        versions = XmlRpcUtil.<Version>toList(VersionImpl.class, map.get(VERSIONS));
        milestones = XmlRpcUtil.<Milestone>toList(MilestoneImpl.class, map.get(MILESTONES));
        createdUser = UserImpl.create((Map<String, Object>) map.get(CREATED_USER));
        assigner = UserImpl.create((Map<String, Object>) map.get(ASSIGNER));
        createdOn = (String) map.get(CREATED_ON);
        updatedOn = (String) map.get(UPDATED_ON);

    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getParentIssueId() {
        return parentIssueId;
    }
    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getDueDate() {
        return dueDate;
    }

    @Override
    public String getStartDate() {
        return startDate;
    }

    @Override
    public Double getEstimatedHours() {
        return estimatedHours;
    }

    @Override
    public Double getActualHours() {
        return actualHours;
    }

    @Override
    public IssueType getIssueType() {
        return issueType;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public Resolution getResolution() {
        return resolution;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public List<Category> getComponents() {
        return components;
    }

    @Override
    public List<Version> getVersions() {
        return versions;
    }

    @Override
    public List<Milestone> getMilestones() {
        return milestones;
    }

    @Override
    public User getCreatedUser() {
        return createdUser;
    }

    @Override
    public User getAssigner() {
        return assigner;
    }

    @Override
    public String getCreatedOn() {
        return createdOn;
    }

    @Override
    public String getUpdatedOn() {
        return updatedOn;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "key='" + key + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Issue) ) return false;

        IssueImpl issue = (IssueImpl) o;

        if (id != null ? !id.equals(issue.id) : issue.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
