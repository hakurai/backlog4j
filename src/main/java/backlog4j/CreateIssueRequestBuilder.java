package backlog4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eguchi
 */
public class CreateIssueRequestBuilder {

    private int projectId;
    private String summary;
    private String description;
    private String dueDate;
    private String startDate;
    private String estimatedHours;
    private String actualHours;
    private Integer issueTypeId;
    private Integer priority;
    private List<Integer> components;
    private List<Integer> versions;
    private List<Integer> milestones;
    private Integer assignerId;

    public CreateIssueRequestBuilder() {
    }

    public int getProjectId() {
        return projectId;
    }

    public CreateIssueRequestBuilder setProjectId(int projectId) {
        this.projectId = projectId;

        return this;
    }

    public String getSummary() {
        return summary;
    }

    public CreateIssueRequestBuilder setSummary(String summary) {
        this.summary = summary;

        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateIssueRequestBuilder setDescription(String description) {
        this.description = description;

        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public CreateIssueRequestBuilder setDueDate(String dueDate) {
        this.dueDate = dueDate;

        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public CreateIssueRequestBuilder setStartDate(String startDate) {
        this.startDate = startDate;

        return this;
    }

    public String getEstimatedHours() {
        return estimatedHours;
    }

    public CreateIssueRequestBuilder setEstimatedHours(String estimatedHours) {
        this.estimatedHours = estimatedHours;

        return this;
    }

    public String getActualHours() {
        return actualHours;
    }

    public CreateIssueRequestBuilder setActualHours(String actualHours) {
        this.actualHours = actualHours;

        return this;
    }

    public Integer getIssueTypeId() {
        return issueTypeId;
    }

    public CreateIssueRequestBuilder setIssueTypeId(int issueTypeId) {
        this.issueTypeId = issueTypeId;

        return this;
    }

    public Integer getPriority() {
        return priority;
    }

    public CreateIssueRequestBuilder setPriority(int priority) {
        this.priority = priority;

        return this;
    }

    public List<Integer> getComponents() {
        return components;
    }

    public CreateIssueRequestBuilder addComponent(int component) {
        if (components == null) {
            components = new ArrayList<Integer>();
        }
        components.add(component);

        return this;
    }

    public List<Integer> getVersions() {
        return versions;
    }

    public CreateIssueRequestBuilder addVersion(int version) {
        if (versions == null) {
            versions = new ArrayList<Integer>();
        }
        versions.add(version);

        return this;
    }

    public List<Integer> getMilestones() {
        return milestones;
    }

    public CreateIssueRequestBuilder addMilestone(int milestone) {
        if (milestones == null) {
            milestones = new ArrayList<Integer>();
        }
        milestones.add(milestone);

        return this;
    }

    public Integer getAssignerId() {
        return assignerId;
    }

    public CreateIssueRequestBuilder setAssignerId(int assignerId) {
        this.assignerId = assignerId;

        return this;
    }

    public CreateIssueRequest build() {
        return new CreateIssueRequest(getProjectId(),
                getSummary(),
                getDescription(),
                getDueDate(),
                getStartDate(),
                getEstimatedHours(),
                getActualHours(),
                getIssueTypeId(),
                getPriority(),
                getComponents(),
                getVersions(),
                getMilestones(),
                getAssignerId());
    }
}
