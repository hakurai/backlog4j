package backlog4j.admin.api;

import backlog4j.BacklogException;
import backlog4j.admin.impl.ProjectEx;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetProjectsTest extends BacklogAdminCommandTestBase {
    @Test
    public void testShouldReturnProject() throws Exception {

        List<ProjectEx> projectExList = immutableClient.getProjects().execute();

        assertThat(projectExList.size(), is(1));

        ProjectEx project = projectExList.get(0);

        assertThat(project.getCreatedOn(), is("20120818212051"));
        assertThat(project.getUpdatedOn(), is("20120919023230"));
    }

    @Test(expected = BacklogException.class)
    public void testShouldThrowException() throws Exception {

        normalUserClient.getProjects().execute();

    }
}
