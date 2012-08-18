package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface BacklogClient {

    static final String BACKLOG_GETPROJECTS = "backlog.getProjects";

    List<Project> getProjects();
}
