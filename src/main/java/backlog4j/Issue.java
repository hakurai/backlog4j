package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface Issue extends Identifired {

    static final String ID = "id";
    static final String KEY = "key";
    static final String SUMMARY = "summary";
    static final String DESCRIPTION = "description";
    static final String URL = "url";
    static final String DUE_DATE = "due_date";
    static final String START_DATE = "start_date";
    static final String ESTIMATED_HOURS = "estimated_hours";
    static final String ACTUAL_HOURS = "actual_hours";
    static final String ISSUE_TYPE = "issueType";
    static final String PRIORITY = "priority";
    static final String RESOLUTION = "resolution";
    static final String STATUS = "status";
    static final String COMPONENTS = "components";
    static final String VERSIONS = "versions";
    static final String MILESTONES = "milestones";
    static final String CREATED_USER = "created_user";
    static final String ASSIGNER = "assigner";
    static final String CREATED_ON = "created_on";
    static final String UPDATED_ON = "updated_on";

    String getKey();

    String getSummary();

    String getDescription();

    String getUrl();

    String getDueDate();

    String getStartDate();

    Double getEstimatedHours();

    Double getActualHours();

    IssueType getIssueType();

    Priority getPriority();

    Resolution getResolution();

    Status getStatus();

    List<Category> getComponents();

    List<Version> getVersions();

    List<Milestone> getMilestones();

    User getCreatedUser();

    User getAssigner();

    String getCreatedOn();

    String getUpdatedOn();
}
