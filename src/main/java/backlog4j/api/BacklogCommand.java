package backlog4j.api;

/**
 * @author eguchi
 */
interface BacklogCommand<T> {

    enum File {
        ATTACHED(1),
        SHARED(2);

        private final int id;

        private File(int id) {
            this.id = id;
        }

        int getId() {
            return id;
        }
    }

    static final String SORT_ISSUE_TYPE = "ISSUE_TYPE";
    static final String SORT_SUMMARY = "SUMMARY";
    static final String SORT_STATUS = "STATUS";
    static final String SORT_PRIORITY = "PRIORITY";
    static final String SORT_CREATED = "CREATED";
    static final String SORT_UPDATED = "UPDATED";
    static final String SORT_DUE_DATE = "DUE_DATE";
    static final String SORT_CUSTOM_FIELD_ = "CUSTOM_FIELD_";

    static final String PROJECT_ID = "projectId";
    static final String SUMMARY = "summary";
    static final String DESCRIPTION = "description";
    static final String DUE_DATE = "due_date";
    static final String START_DATE = "start_date";
    static final String ESTIMATED_HOURS = "estimated_hours";
    static final String ACTUAL_HOURS = "actual_hours";
    static final String ISSUE_TYPE_ID = "issueTypeId";
    static final String ISSUE_TYPE = "issueType";
    static final String PRIORITY_ID = "priorityId";
    static final String COMPONENT_ID = "componentId";
    static final String VERSION_ID = "versionId";
    static final String MILESTONE_ID = "milestoneId";
    static final String ASSIGNER_ID = "assignerId";
    static final String STATUS_ID = "statusId";
    static final String CREATED_USER_ID = "createdUserId";
    static final String RESOLUTION_ID = "resolutionId";
    static final String CREATED_ON_MIN = "created_on_min";
    static final String CREATED_ON_MAX = "created_on_max";
    static final String UPDATED_ON_MIN = "updated_on_min";
    static final String UPDATED_ON_MAX = "updated_on_max";
    static final String START_DATE_MIN = "start_date_min";
    static final String START_DATE_MAX = "start_date_max";
    static final String DUE_DATE_MIN = "due_date_min";
    static final String DUE_DATE_MAX = "due_date_max";
    static final String QUERY = "query";
    static final String FILE = "file";
    static final String SORT = "sort";
    static final String ORDER = "order";
    static final String OFFSET = "offset";
    static final String LIMIT = "limit";
    static final String KEY = "key";
    static final String COMMENT = "comment";
    static final String CONTENT = "content";
    static final String NAME = "name";
    static final String COLOR = "color";
    static final String ID = "id";
    static final String SUBSTITUTE_ID = "substitute_id";
    static final String ARCHIVED = "archived";


    static final int MAX_LIMIT = 100;


    static final String BACKLOG_GET_PROJECTS = "backlog.getProjects";
    static final String BACKLOG_GET_PROJECT = "backlog.getProject";
    static final String BACKLOG_GET_COMPONENTS = "backlog.getComponents";
    static final String BACKLOG_GET_VERSIONS = "backlog.getVersions";
    static final String BACKLOG_GET_USERS = "backlog.getUsers";
    static final String BACKLOG_GET_ISSUE_TYPES = "backlog.getIssueTypes";
    static final String BACKLOG_GET_ISSUE = "backlog.getIssue";
    static final String BACKLOG_GET_COMMENTS = "backlog.getComments";
    static final String BACKLOG_COUNT_ISSUE = "backlog.countIssue";
    static final String BACKLOG_FIND_ISSUE = "backlog.findIssue";
    static final String BACKLOG_CREATE_ISSUE = "backlog.createIssue";
    static final String BACKLOG_UPDATE_ISSUE = "backlog.updateIssue";
    static final String BACKLOG_SWITCH_STATUS = "backlog.switchStatus";
    static final String BACKLOG_ADD_COMMENT = "backlog.addComment";
    static final String BACKLOG_ADD_ISSUE_TYPE = "backlog.addIssueType";
    static final String BACKLOG_UPDATE_ISSUE_TYPE = "backlog.updateIssueType";
    static final String BACKLOG_DELETE_ISSUE_TYPE = "backlog.deleteIssueType";
    static final String BACKLOG_ADD_VERSION = "backlog.addVersion";
    static final String BACKLOG_UPDATE_VERSION = "backlog.updateVersion";
    static final String BACKLOG_DELETE_VERSION = "backlog.deleteVersion";
    static final String BACKLOG_ADD_COMPONENT = "backlog.addComponent";
    static final String BACKLOG_UPDATE_COMPONENT = "backlog.updateComponent";
    static final String BACKLOG_DELETE_COMPONENT = "backlog.deleteComponent";
    static final String BACKLOG_GET_TIMELINE = "backlog.getTimeline";
    static final String BACKLOG_GET_PROJECT_SUMMARY = "backlog.getProjectSummary";
    static final String BACKLOG_GET_PROJECT_SUMMARIES = "backlog.getProjectSummaries";
    static final String BACKLOG_GET_USER = "backlog.getUser";
    static final String BACKLOG_GET_USER_ICON = "backlog.getUserIcon";
    static final String BACKLOG_GET_ACTIVITY_TYPES = "backlog.getActivityTypes";


    T execute();
}
