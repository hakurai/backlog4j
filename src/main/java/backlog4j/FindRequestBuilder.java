package backlog4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eguchi
 */
public class FindRequestBuilder {

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
    private List<FindRequest.File> file;


    public FindRequestBuilder(int projectId) {
        this.projectId = projectId;
    }

    public int getProjectId() {
        return projectId;
    }

    public FindRequestBuilder setProjectId(int projectId) {
        this.projectId = projectId;

        return this;
    }

    public List<Integer> getIssueTypeId() {
        return issueTypeId;
    }

    public FindRequestBuilder addIssueTypeId(int newIssueTypeId) {
        if (this.issueTypeId == null) {
            this.issueTypeId = new ArrayList<Integer>();
        }
        this.issueTypeId.add(newIssueTypeId);

        return this;
    }

    public List<String> getIssueType() {
        return issueType;
    }

    public FindRequestBuilder addIssueType(String newIssueType) {
        if (this.issueType == null) {
            this.issueType = new ArrayList<String>();
        }
        this.issueType.add(newIssueType);

        return this;
    }

    public List<Integer> getComponentId() {
        return componentId;
    }

    public FindRequestBuilder addComponentId(int newComponentId) {
        if (this.componentId == null) {
            this.componentId = new ArrayList<Integer>();
        }
        this.componentId.add(newComponentId);

        return this;
    }

    public List<Integer> getVersionId() {
        return versionId;
    }

    public FindRequestBuilder addVersionId(int newVersionId) {
        if (this.versionId == null) {
            this.versionId = new ArrayList<Integer>();
        }
        this.versionId.add(newVersionId);

        return this;
    }

    public List<Integer> getMilestoneId() {
        return milestoneId;
    }

    public FindRequestBuilder addMilestoneId(int newMilestoneId) {
        if (this.milestoneId == null) {
            this.milestoneId = new ArrayList<Integer>();
        }
        this.milestoneId.add(newMilestoneId);

        return this;
    }

    public List<Integer> getStatusId() {
        return statusId;
    }

    public FindRequestBuilder addStatusId(int newStatusId) {
        if (this.statusId == null) {
            this.statusId = new ArrayList<Integer>();
        }
        this.statusId.add(newStatusId);

        return this;
    }

    public List<Integer> getPriorityId() {
        return priorityId;
    }

    public FindRequestBuilder addPriorityId(int newPriorityId) {
        if (this.priorityId == null) {
            this.priorityId = new ArrayList<Integer>();
        }
        this.priorityId.add(newPriorityId);

        return this;
    }

    public List<Integer> getAssignerId() {
        return assignerId;
    }

    public FindRequestBuilder addAssignerId(int newAssignerId) {
        if (this.assignerId == null) {
            this.assignerId = new ArrayList<Integer>();
        }
        this.assignerId.add(newAssignerId);

        return this;
    }

    public List<Integer> getCreatedUserId() {
        return createdUserId;
    }

    public FindRequestBuilder addCreatedUserId(int newCreatedUserId) {
        if (this.createdUserId == null) {
            this.createdUserId = new ArrayList<Integer>();
        }
        this.createdUserId.add(newCreatedUserId);

        return this;
    }

    public List<Integer> getResolutionId() {
        return resolutionId;
    }

    public FindRequestBuilder addResolutionId(int newResolutionId) {
        if (this.resolutionId == null) {
            this.resolutionId = new ArrayList<Integer>();
        }
        this.resolutionId.add(newResolutionId);

        return this;
    }

    public String getCreatedOnMin() {
        return createdOnMin;
    }

    public FindRequestBuilder setCreatedOnMin(String createdOnMin) {
        this.createdOnMin = createdOnMin;

        return this;
    }

    public String getCreatedOnMax() {
        return createdOnMax;
    }

    public FindRequestBuilder setCreatedOnMax(String createdOnMax) {
        this.createdOnMax = createdOnMax;

        return this;
    }

    public String getUpdatedOnMin() {
        return updatedOnMin;
    }

    public FindRequestBuilder setUpdatedOnMin(String updatedOnMin) {
        this.updatedOnMin = updatedOnMin;

        return this;
    }

    public String getUpdatedOnMax() {
        return updatedOnMax;
    }

    public FindRequestBuilder setUpdatedOnMax(String updatedOnMax) {
        this.updatedOnMax = updatedOnMax;

        return this;
    }

    public String getStartDateMin() {
        return startDateMin;
    }

    public FindRequestBuilder setStartDateMin(String startDateMin) {
        this.startDateMin = startDateMin;

        return this;
    }

    public String getStartDateMax() {
        return startDateMax;
    }

    public FindRequestBuilder setStartDateMax(String startDateMax) {
        this.startDateMax = startDateMax;

        return this;
    }

    public String getDueDateMin() {
        return dueDateMin;
    }

    public FindRequestBuilder setDueDateMin(String dueDateMin) {
        this.dueDateMin = dueDateMin;

        return this;
    }

    public String getDueDateMax() {
        return dueDateMax;
    }

    public FindRequestBuilder setDueDateMax(String dueDateMax) {
        this.dueDateMax = dueDateMax;

        return this;
    }

    public String getQuery() {
        return query;
    }

    public FindRequestBuilder setQuery(String query) {
        this.query = query;

        return this;
    }

    public List<FindRequest.File> getFile() {
        return file;
    }

    public FindRequestBuilder setFile(List<FindRequest.File> file) {
        this.file = file;

        return this;
    }

    public FindRequest build() {
        return new FindRequest(getProjectId(),
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
