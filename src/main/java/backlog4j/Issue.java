package backlog4j;

import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public final class Issue {

    public static final String ID = "id";
    public static final String KEY = "key";
    public static final String SUMMARY = "summary";
    public static final String DESCRIPTION = "description";
    public static final String URL = "url";
    public static final String DUE_DATE = "due_date";
    public static final String START_DATE = "start_date";
    public static final String ESTIMATED_HOURS = "estimated_hours";
    public static final String ACTUAL_HOURS = "actual_hours";
    public static final String ISSUE_TYPE = "issueType";
    public static final String PRIORITY = "priority";
    public static final String RESOLUTION = "resolution";
    public static final String STATUS = "status";
    public static final String COMPONENTS = "components";
    public static final String VERSIONS = "versions";
    public static final String MILESTONES = "milestones";
    public static final String CREATED_USER = "created_user";
    public static final String ASSIGNER = "assigner";
    public static final String CREATED_ON = "created_on";
    public static final String UPDATED_ON = "updated_on";

    private final Integer id;
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
        id = (Integer) map.get(ID);
        key = (String) map.get(KEY);
        summary = (String) map.get(SUMMARY);
        description = (String) map.get(DESCRIPTION);
        url = (String) map.get(URL);
        dueDate = (String) map.get(DUE_DATE);
        startDate = (String) map.get(START_DATE);
        estimatedHours = (String) map.get(ESTIMATED_HOURS);
        actualHours = (String) map.get(ACTUAL_HOURS);
        issueType = IssueType.create((Map<String, Object>) map.get(ISSUE_TYPE));
        priority = Priority.create((Map<String, Object>) map.get(PRIORITY));
        resolution = Resolution.create((Map<String, Object>) map.get(RESOLUTION));
        status = Status.create((Map<String, Object>) map.get(STATUS));
        components = XmlRpcUtil.toList(Category.class, map.get(COMPONENTS));
        versions = XmlRpcUtil.toList(Version.class, map.get(VERSIONS));
        milestones = XmlRpcUtil.toList(Milestone.class, map.get(MILESTONES));
        createdUser = User.create((Map<String, Object>) map.get(CREATED_USER));
        assigner = User.create((Map<String, Object>) map.get(ASSIGNER));
        createdOn = (String) map.get(CREATED_ON);
        updatedOn = (String) map.get(UPDATED_ON);

    }

    public Integer getId() {
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

    @Override
    public String toString() {
        return "Issue{" +
                "key='" + key + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
