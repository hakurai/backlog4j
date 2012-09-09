package backlog4j.api;

/**
 * @author eguchi
 */
public interface BacklogCommand<T> {

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

    public static final String SORT_ISSUE_TYPE = "ISSUE_TYPE";
    public static final String SORT_SUMMARY = "SUMMARY";
    public static final String SORT_STATUS = "STATUS";
    public static final String SORT_PRIORITY = "PRIORITY";
    public static final String SORT_CREATED = "CREATED";
    public static final String SORT_UPDATED = "UPDATED";
    public static final String SORT_DUE_DATE = "DUE_DATE";
    public static final String SORT_CUSTOM_FIELD_ = "CUSTOM_FIELD_";

    public static final String PROJECT_ID = "projectId";
    public static final String SUMMARY = "summary";
    public static final String DESCRIPTION = "description";
    public static final String DUE_DATE = "due_date";
    public static final String START_DATE = "start_date";
    public static final String ESTIMATED_HOURS = "estimated_hours";
    public static final String ACTUAL_HOURS = "actual_hours";
    public static final String ISSUE_TYPE_ID = "issueTypeId";
    public static final String ISSUE_TYPE = "issueType";
    public static final String PRIORITY_ID = "priorityId";
    public static final String COMPONENT_ID = "componentId";
    public static final String VERSION_ID = "versionId";
    public static final String MILESTONE_ID = "milestoneId";
    public static final String ASSIGNER_ID = "assignerId";
    public static final String STATUS_ID = "statusId";
    public static final String CREATED_USER_ID = "createdUserId";
    public static final String RESOLUTION_ID = "resolutionId";
    public static final String CREATED_ON_MIN = "created_on_min";
    public static final String CREATED_ON_MAX = "created_on_max";
    public static final String UPDATED_ON_MIN = "updated_on_min";
    public static final String UPDATED_ON_MAX = "updated_on_max";
    public static final String START_DATE_MIN = "start_date_min";
    public static final String START_DATE_MAX = "start_date_max";
    public static final String DUE_DATE_MIN = "due_date_min";
    public static final String DUE_DATE_MAX = "due_date_max";
    public static final String QUERY = "query";
    public static final String FILE = "file";
    public static final String SORT = "sort";
    public static final String ORDER = "order";
    public static final String OFFSET = "offset";
    public static final String LIMIT = "limit";
    public static final String KEY = "key";
    public static final String COMMENT = "comment";
    public static final String CONTENT = "content";

    public static final int MAX_LIMIT = 100;


    static final String BACKLOG_GETPROJECTS = "backlog.getProjects";
    static final String BACKLOG_GETPROJECT = "backlog.getProject";
    static final String BACKLOG_GETCOMPONENTS = "backlog.getComponents";
    static final String BACKLOG_GETVERSIONS = "backlog.getVersions";
    static final String BACKLOG_GETUSERS = "backlog.getUsers";
    static final String BACKLOG_GETISSUETYPES = "backlog.getIssueTypes";
    static final String BACKLOG_GETISSUE = "backlog.getIssue";
    static final String BACKLOG_GETCOMMENTS = "backlog.getComments";
    static final String BACKLOG_COUNTISSUE = "backlog.countIssue";
    static final String BACKLOG_FINDISSUE = "backlog.findIssue";
    static final String BACKLOG_CREATEISSUE = "backlog.createIssue";
    static final String BACKLOG_UPDATEISSUE = "backlog.updateIssue";
    static final String BACKLOG_SWITCHSTATUS = "backlog.switchStatus";
    static final String BACKLOG_ADDCOMMENT = "backlog.addComment";

    T execute();
}
