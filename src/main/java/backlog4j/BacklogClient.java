package backlog4j;

import backlog4j.api.*;

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

    Object execute(String methodName);

    Object execute(String methodName, Object... params);

    GetProjects getProjects();

    GetProject getProject();

    GetComponents getComponents();

    GetVersions getVersions();

    GetUsers getUsers();

    GetIssueTypes getIssueTypes();

    GetIssue getIssue();

    GetComments getComments();

    CountIssue countIssue();

    FindIssue findIssue();

    CreateIssue createIssue();


}
