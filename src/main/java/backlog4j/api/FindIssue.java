package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Issue;
import backlog4j.XmlRpcUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public class FindIssue {

    public static final String SORT_ISSUE_TYPE = "ISSUE_TYPE";
    public static final String SORT_SUMMARY = "SUMMARY";
    public static final String SORT_STATUS = "STATUS";
    public static final String SORT_PRIORITY = "PRIORITY";
    public static final String SORT_CREATED = "CREATED";
    public static final String SORT_UPDATED = "UPDATED";
    public static final String SORT_DUE_DATE = "DUE_DATE";
    public static final String SORT_CUSTOM_FIELD_ = "CUSTOM_FIELD_";

    private final BacklogClient client;
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
    private List<CountIssue.File> file;

    private String sort;
    private boolean order; // true: accending
    private int offset;
    private int limit = 100;  //0~100


    public FindIssue(BacklogClient client) {
        this.client = client;
    }

    public int getProjectId() {
        return projectId;
    }

    public FindIssue setProjectId(int projectId) {
        this.projectId = projectId;

        return this;
    }

    public List<Integer> getIssueTypeId() {
        return issueTypeId;
    }

    public FindIssue addIssueTypeId(int newIssueTypeId) {
        if (this.issueTypeId == null) {
            this.issueTypeId = new ArrayList<Integer>();
        }
        this.issueTypeId.add(newIssueTypeId);

        return this;
    }

    public List<String> getIssueType() {
        return issueType;
    }

    public FindIssue addIssueType(String newIssueType) {
        if (this.issueType == null) {
            this.issueType = new ArrayList<String>();
        }
        this.issueType.add(newIssueType);

        return this;
    }

    public List<Integer> getComponentId() {
        return componentId;
    }

    public FindIssue addComponentId(int newComponentId) {
        if (this.componentId == null) {
            this.componentId = new ArrayList<Integer>();
        }
        this.componentId.add(newComponentId);

        return this;
    }

    public List<Integer> getVersionId() {
        return versionId;
    }

    public FindIssue addVersionId(int newVersionId) {
        if (this.versionId == null) {
            this.versionId = new ArrayList<Integer>();
        }
        this.versionId.add(newVersionId);

        return this;
    }

    public List<Integer> getMilestoneId() {
        return milestoneId;
    }

    public FindIssue addMilestoneId(int newMilestoneId) {
        if (this.milestoneId == null) {
            this.milestoneId = new ArrayList<Integer>();
        }
        this.milestoneId.add(newMilestoneId);

        return this;
    }

    public List<Integer> getStatusId() {
        return statusId;
    }

    public FindIssue addStatusId(int newStatusId) {
        if (this.statusId == null) {
            this.statusId = new ArrayList<Integer>();
        }
        this.statusId.add(newStatusId);

        return this;
    }

    public List<Integer> getPriorityId() {
        return priorityId;
    }

    public FindIssue addPriorityId(int newPriorityId) {
        if (this.priorityId == null) {
            this.priorityId = new ArrayList<Integer>();
        }
        this.priorityId.add(newPriorityId);

        return this;
    }

    public List<Integer> getAssignerId() {
        return assignerId;
    }

    public FindIssue addAssignerId(int newAssignerId) {
        if (this.assignerId == null) {
            this.assignerId = new ArrayList<Integer>();
        }
        this.assignerId.add(newAssignerId);

        return this;
    }

    public List<Integer> getCreatedUserId() {
        return createdUserId;
    }

    public FindIssue addCreatedUserId(int newCreatedUserId) {
        if (this.createdUserId == null) {
            this.createdUserId = new ArrayList<Integer>();
        }
        this.createdUserId.add(newCreatedUserId);

        return this;
    }

    public List<Integer> getResolutionId() {
        return resolutionId;
    }

    public FindIssue addResolutionId(int newResolutionId) {
        if (this.resolutionId == null) {
            this.resolutionId = new ArrayList<Integer>();
        }
        this.resolutionId.add(newResolutionId);

        return this;
    }

    public String getCreatedOnMin() {
        return createdOnMin;
    }

    public FindIssue setCreatedOnMin(String createdOnMin) {
        this.createdOnMin = createdOnMin;

        return this;
    }

    public String getCreatedOnMax() {
        return createdOnMax;
    }

    public FindIssue setCreatedOnMax(String createdOnMax) {
        this.createdOnMax = createdOnMax;

        return this;
    }

    public String getUpdatedOnMin() {
        return updatedOnMin;
    }

    public FindIssue setUpdatedOnMin(String updatedOnMin) {
        this.updatedOnMin = updatedOnMin;

        return this;
    }

    public String getUpdatedOnMax() {
        return updatedOnMax;
    }

    public FindIssue setUpdatedOnMax(String updatedOnMax) {
        this.updatedOnMax = updatedOnMax;

        return this;
    }

    public String getStartDateMin() {
        return startDateMin;
    }

    public FindIssue setStartDateMin(String startDateMin) {
        this.startDateMin = startDateMin;

        return this;
    }

    public String getStartDateMax() {
        return startDateMax;
    }

    public FindIssue setStartDateMax(String startDateMax) {
        this.startDateMax = startDateMax;

        return this;
    }

    public String getDueDateMin() {
        return dueDateMin;
    }

    public FindIssue setDueDateMin(String dueDateMin) {
        this.dueDateMin = dueDateMin;

        return this;
    }

    public String getDueDateMax() {
        return dueDateMax;
    }

    public FindIssue setDueDateMax(String dueDateMax) {
        this.dueDateMax = dueDateMax;

        return this;
    }

    public String getQuery() {
        return query;
    }

    public FindIssue setQuery(String query) {
        this.query = query;

        return this;
    }

    public List<CountIssue.File> getFile() {
        return file;
    }

    public FindIssue setFile(List<CountIssue.File> file) {
        this.file = file;

        return this;
    }

    public String getSort() {
        return sort;
    }

    public FindIssue setSort(String sort) {
        this.sort = sort;

        return this;
    }

    public boolean isOrder() {
        return order;
    }

    public FindIssue setOrder(boolean order) {
        this.order = order;

        return this;
    }

    public int getOffset() {
        return offset;
    }

    public FindIssue setOffset(int offset) {
        this.offset = offset;

        return this;
    }

    public int getLimit() {
        return limit;
    }

    public FindIssue setLimit(int limit) {
        this.limit = limit;

        return this;
    }

    public List<Issue> execute() {
        Object res = client.execute(BacklogClient.BACKLOG_FINDISSUE, toMap());

        return XmlRpcUtil.toList(Issue.class, res);
    }

    private Map<String, Object> toMap() {
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
            for (CountIssue.File f : file) {
                fileList.add(f.getId());
            }
            map.put("file", fileList);
        }

        if (sort != null) {
            map.put("sort", sort);
        }
        map.put("order", order);
        map.put("offset", offset);
        map.put("limit", limit);

        return map;
    }
}
