package backlog4j;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class BacklogClientImplTest {

    private BacklogClient client;


    @Before
    public void setUp() throws Exception {
        client = new BacklogClientImpl(BacklogConfigureTestImpl.getInstance());
    }

    @Test
    public void testGetProjects() throws Exception {
        List<Project> projects = client.getProjects();

        assertThat(projects.size(), is(1));

        Project project = projects.get(0);
        assertThat(project.getId(), is(1073773875));
        assertThat(project.getName(), is("project1"));
        assertThat(project.getKey(), is("P_1"));
        assertThat(project.getUrl(), is("https://b4jtest.backlog.jp/projects/P_1"));
        assertThat(project.isArchived(), is(false));


    }

}
