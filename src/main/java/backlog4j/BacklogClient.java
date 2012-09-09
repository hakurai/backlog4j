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


}
