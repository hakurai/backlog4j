package backlog4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public final class FindRequest {

    public enum File {
        ATTACHED(1),
        SHARED(2);

        private final int id;

        private File(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    private final int projectId;
    private final List<Integer> issueTypeId;
    private final List<String> issueType;
    private final List<Integer> componentId;
    private final List<Integer> versionId;
    private final List<Integer> milestoneId;
    private final List<Integer> statusId;
    private final List<Integer> priorityId;
    private final List<Integer> assignerId;
    private final List<Integer> createdUserId;
    private final List<Integer> resolutionId;
    private final String createdOnMin;
    private final String createdOnMax;
    private final String updatedOnMin;
    private final String updatedOnMax;
    private final String startDateMin;
    private final String startDateMax;
    private final String dueDateMin;
    private final String dueDateMax;
    private final String query;
    private final List<File> file;


    public FindRequest(int projectId) {
        this(projectId,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    public FindRequest(int projectId,
                       List<Integer> issueTypeId,
                       List<String> issueType,
                       List<Integer> componentId,
                       List<Integer> versionId,
                       List<Integer> milestoneId,
                       List<Integer> statusId,
                       List<Integer> priorityId,
                       List<Integer> assignerId,
                       List<Integer> createdUserId,
                       List<Integer> resolutionId,
                       String createdOnMin,
                       String createdOnMax,
                       String updatedOnMin,
                       String updatedOnMax,
                       String startDateMin,
                       String startDateMax,
                       String dueDateMin,
                       String dueDateMax,
                       String query,
                       List<File> file) {
        this.projectId = projectId;
        this.issueTypeId = issueTypeId;
        this.issueType = issueType;
        this.componentId = componentId;
        this.versionId = versionId;
        this.milestoneId = milestoneId;
        this.statusId = statusId;
        this.priorityId = priorityId;
        this.assignerId = assignerId;
        this.createdUserId = createdUserId;
        this.resolutionId = resolutionId;
        this.createdOnMin = createdOnMin;
        this.createdOnMax = createdOnMax;
        this.updatedOnMin = updatedOnMin;
        this.updatedOnMax = updatedOnMax;
        this.startDateMin = startDateMin;
        this.startDateMax = startDateMax;
        this.dueDateMin = dueDateMin;
        this.dueDateMax = dueDateMax;
        this.query = query;
        this.file = file;
    }

    public int getProjectId() {
        return projectId;
    }

    public List<Integer> getIssueTypeId() {
        return issueTypeId;
    }

    public List<String> getIssueType() {
        return issueType;
    }

    public List<Integer> getComponentId() {
        return componentId;
    }

    public List<Integer> getVersionId() {
        return versionId;
    }

    public List<Integer> getMilestoneId() {
        return milestoneId;
    }

    public List<Integer> getStatusId() {
        return statusId;
    }

    public List<Integer> getPriorityId() {
        return priorityId;
    }

    public List<Integer> getAssignerId() {
        return assignerId;
    }

    public List<Integer> getCreatedUserId() {
        return createdUserId;
    }

    public List<Integer> getResolutionId() {
        return resolutionId;
    }

    public String getCreatedOnMin() {
        return createdOnMin;
    }

    public String getCreatedOnMax() {
        return createdOnMax;
    }

    public String getUpdatedOnMin() {
        return updatedOnMin;
    }

    public String getUpdatedOnMax() {
        return updatedOnMax;
    }

    public String getStartDateMin() {
        return startDateMin;
    }

    public String getStartDateMax() {
        return startDateMax;
    }

    public String getDueDateMin() {
        return dueDateMin;
    }

    public String getDueDateMax() {
        return dueDateMax;
    }

    public String getQuery() {
        return query;
    }

    public List<File> getFile() {
        return file;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("projectId", projectId);
        if (issueTypeId != null && issueTypeId.size() > 0) {
            map.put("issueTypeId", issueTypeId);
        }
        if (issueType != null && issueType.size() > 0) {
            map.put("issueType", issueType);
        }
        if (componentId != null && componentId.size() > 0) {
            map.put("componentId", componentId);
        }

        if (versionId != null && versionId.size() > 0) {
            map.put("versionId", versionId);
        }

        if (milestoneId != null && milestoneId.size() > 0) {
            map.put("milestoneId", milestoneId);
        }

        if (statusId != null && statusId.size() > 0) {
            map.put("statusId", statusId);
        }

        if (priorityId != null && priorityId.size() > 0) {
            map.put("priorityId", priorityId);
        }

        if (assignerId != null && assignerId.size() > 0) {
            map.put("assignerId", assignerId);
        }

        if (createdUserId != null && createdUserId.size() > 0) {
            map.put("createdUserId", createdUserId);
        }

        if (resolutionId != null && resolutionId.size() > 0) {
            map.put("resolutionId", resolutionId);
        }

        if (createdOnMin != null) {
            map.put("created_on_min", createdOnMin);
        }

        if (createdOnMax != null) {
            map.put("created_on_max", createdOnMax);
        }

        if (updatedOnMin != null) {
            map.put("updated_on_min", updatedOnMin);
        }

        if (updatedOnMax != null) {
            map.put("updated_on_max", updatedOnMax);
        }

        if (startDateMin != null) {
            map.put("start_date_min", startDateMin);
        }

        if (startDateMax != null) {
            map.put("start_date_max", startDateMax);
        }

        if (dueDateMin != null) {
            map.put("due_date_min", dueDateMin);
        }

        if (dueDateMax != null) {
            map.put("due_date_max", dueDateMax);
        }

        if (query != null) {
            map.put("query", query);
        }

        if (file != null && file.size() > 0) {
            List<Integer> fileList = new ArrayList<Integer>(file.size());
            for (File f : file) {
                fileList.add(f.getId());
            }
            map.put("file", fileList);
        }

        return map;

    }
}
