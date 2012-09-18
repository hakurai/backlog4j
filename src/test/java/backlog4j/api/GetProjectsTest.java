package backlog4j.api;

import backlog4j.Project;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetProjectsTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkGetProjects() throws Exception {
        GetProjects getProjects = immutableClient.getProjects();

        List<Project> projects = getProjects.execute();

        assertThat(projects.size(), is(1));

        Project project = projects.get(0);
        assertProject1(project);
    }

}
