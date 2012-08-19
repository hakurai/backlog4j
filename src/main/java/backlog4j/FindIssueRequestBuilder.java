package backlog4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eguchi
 */
public class FindIssueRequestBuilder {

    private int projectId;
    private List<Integer> issueTypeId;
    private List<String> issueType;
    private List<Integer> componentId;
    private List<Integer> versionId;
    private List<Integer> milestoneId;
    private List<Integer> statusId;
    private List<Integer> priorityId;
    private List<Integer> assignerId;
    private List<Integer> createdUserId;
    private List<Integer> resolutionId;
    private String createdOnMin;
    private String createdOnMax;
    private String updatedOnMin;
    private String updatedOnMax;
    private String startDateMin;
    private String startDateMax;
    private String dueDateMin;
    private String dueDateMax;
    private String query;
    private List<FindIssueRequest.File> file;


    public FindIssueRequestBuilder(int projectId) {
        this.projectId = projectId;
    }

    public int getProjectId() {
        return projectId;
    }

    public FindIssueRequestBuilder setProjectId(int projectId) {
        this.projectId = projectId;

        return this;
    }

    public List<Integer> getIssueTypeId() {
        return issueTypeId;
    }

    public FindIssueRequestBuilder addIssueTypeId(int newIssueTypeId) {
        if (this.issueTypeId == null) {
            this.issueTypeId = new ArrayList<Integer>();
        }
        this.issueTypeId.add(newIssueTypeId);

        return this;
    }

    public List<String> getIssueType() {
        return issueType;
    }

    public FindIssueRequestBuilder addIssueType(String newIssueType) {
        if (this.issueType == null) {
            this.issueType = new ArrayList<String>();
        }
        this.issueType.add(newIssueType);

        return this;
    }

    public List<Integer> getComponentId() {
        return componentId;
    }

    public FindIssueRequestBuilder addComponentId(int newComponentId) {
        if (this.componentId == null) {
            this.componentId = new ArrayList<Integer>();
        }
        this.componentId.add(newComponentId);

        return this;
    }

    public List<Integer> getVersionId() {
        return versionId;
    }

    public FindIssueRequestBuilder addVersionId(int newVersionId) {
        if (this.versionId == null) {
            this.versionId = new ArrayList<Integer>();
        }
        this.versionId.add(newVersionId);

        return this;
    }

    public List<Integer> getMilestoneId() {
        return milestoneId;
    }

    public FindIssueRequestBuilder addMilestoneId(int newMilestoneId) {
        if (this.milestoneId == null) {
            this.milestoneId = new ArrayList<Integer>();
        }
        this.milestoneId.add(newMilestoneId);

        return this;
    }

    public List<Integer> getStatusId() {
        return statusId;
    }

    public FindIssueRequestBuilder addStatusId(int newStatusId) {
        if (this.statusId == null) {
            this.statusId = new ArrayList<Integer>();
        }
        this.statusId.add(newStatusId);

        return this;
    }

    public List<Integer> getPriorityId() {
        return priorityId;
    }

    public FindIssueRequestBuilder addPriorityId(int newPriorityId) {
        if (this.priorityId == null) {
            this.priorityId = new ArrayList<Integer>();
        }
        this.priorityId.add(newPriorityId);

        return this;
    }

    public List<Integer> getAssignerId() {
        return assignerId;
    }

    public FindIssueRequestBuilder addAssignerId(int newAssignerId) {
        if (this.assignerId == null) {
            this.assignerId = new ArrayList<Integer>();
        }
        this.assignerId.add(newAssignerId);

        return this;
    }

    public List<Integer> getCreatedUserId() {
        return createdUserId;
    }

    public FindIssueRequestBuilder addCreatedUserId(int newCreatedUserId) {
        if (this.createdUserId == null) {
            this.createdUserId = new ArrayList<Integer>();
        }
        this.createdUserId.add(newCreatedUserId);

        return this;
    }

    public List<Integer> getResolutionId() {
        return resolutionId;
    }

    public FindIssueRequestBuilder addResolutionId(int newResolutionId) {
        if (this.resolutionId == null) {
            this.resolutionId = new ArrayList<Integer>();
        }
        this.resolutionId.add(newResolutionId);

        return this;
    }

    public String getCreatedOnMin() {
        return createdOnMin;
    }

    public FindIssueRequestBuilder setCreatedOnMin(String createdOnMin) {
        this.createdOnMin = createdOnMin;

        return this;
    }

    public String getCreatedOnMax() {
        return createdOnMax;
    }

    public FindIssueRequestBuilder setCreatedOnMax(String createdOnMax) {
        this.createdOnMax = createdOnMax;

        return this;
    }

    public String getUpdatedOnMin() {
        return updatedOnMin;
    }

    public FindIssueRequestBuilder setUpdatedOnMin(String updatedOnMin) {
        this.updatedOnMin = updatedOnMin;

        return this;
    }

    public String getUpdatedOnMax() {
        return updatedOnMax;
    }

    public FindIssueRequestBuilder setUpdatedOnMax(String updatedOnMax) {
        this.updatedOnMax = updatedOnMax;

        return this;
    }

    public String getStartDateMin() {
        return startDateMin;
    }

    public FindIssueRequestBuilder setStartDateMin(String startDateMin) {
        this.startDateMin = startDateMin;

        return this;
    }

    public String getStartDateMax() {
        return startDateMax;
    }

    public FindIssueRequestBuilder setStartDateMax(String startDateMax) {
        this.startDateMax = startDateMax;

        return this;
    }

    public String getDueDateMin() {
        return dueDateMin;
    }

    public FindIssueRequestBuilder setDueDateMin(String dueDateMin) {
        this.dueDateMin = dueDateMin;

        return this;
    }

    public String getDueDateMax() {
        return dueDateMax;
    }

    public FindIssueRequestBuilder setDueDateMax(String dueDateMax) {
        this.dueDateMax = dueDateMax;

        return this;
    }

    public String getQuery() {
        return query;
    }

    public FindIssueRequestBuilder setQuery(String query) {
        this.query = query;

        return this;
    }

    public List<FindIssueRequest.File> getFile() {
        return file;
    }

    public FindIssueRequestBuilder setFile(List<FindIssueRequest.File> file) {
        this.file = file;

        return this;
    }

    public FindIssueRequest build() {
        return new FindIssueRequest(getProjectId(),
                getIssueTypeId(),
                getIssueType(),
                getComponentId(),
                getVersionId(),
                getMilestoneId(),
                getStatusId(),
                getPriorityId(),
                getAssignerId(),
                getCreatedUserId(),
                getResolutionId(),
                getCreatedOnMin(),
                getCreatedOnMax(),
                getUpdatedOnMin(),
                getUpdatedOnMax(),
                getStartDateMin(),
                getStartDateMax(),
                getDueDateMin(),
                getDueDateMax(),
                getQuery(),
                getFile());
    }
}
