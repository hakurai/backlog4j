package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface BacklogClient {

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

    List<Project> getProjects();

    Project getProject(String key);

    Project getProject(int id);

    List<Category> getComponents(int projectId);

    List<Version> getVersions(int projectId);

    List<User> getUsers(int projectId);

    List<IssueType> getIssueTypes(int projectId);

    Issue getIssue(String issueKey);

    Issue getIssue(int issueId);

    List<Comment> getComments(int issueId);

    int countIssue(FindIssueRequest findIssueRequest);

    List<Issue> findIssue(FindIssueRequest findIssueRequest, FindIssueOrder findIssueOrder);

    Issue createIssue(CreateIssueRequest createIssueRequest);
}
