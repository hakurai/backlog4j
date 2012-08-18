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

    List<Project> getProjects();

    Project getProject(String key);

    Project getProject(int id);

    List<Category> getComponents(int projectId);

    List<Version> getVersions(int projectId);

    List<User> getUsers(int projectId);

    List<IssueType> getIssueTypes(int projectId);
}
