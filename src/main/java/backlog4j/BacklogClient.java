package backlog4j;

import backlog4j.api.*;

/**
 * @author eguchi
 */
public interface BacklogClient {

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

    UpdateIssue updateIssue();

    SwitchStatus switchStatus();

    AddComment addComment();

    AddIssueType addIssueType();

    UpdateIssueType updateIssueType();

    DeleteIssueType deleteIssueType();

    AddVersion addVersion();

    UpdateVersion updateVersion();

    DeleteVersion deleteVersion();

    AddComponent addComponent();

    UpdateComponent updateComponent();

    DeleteComponent deleteComponent();

    GetTimeline getTimeline();

    GetProjectSummary getProjectSummary();

    GetProjectSummaries getProjectSummaries();

    GetUser getUser();

    GetUserIcon getUserIcon();
}
