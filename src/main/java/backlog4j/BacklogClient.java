package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface BacklogClient {

    static final String BACKLOG_GETPROJECTS = "backlog.getProjects";
    static final String BACKLOG_GETPROJECT = "backlog.getProject";

    List<Project> getProjects();

    Project getProject(String key);
}
