package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogClientFactory;
import backlog4j.Project;
import backlog4j.conf.ImmutableSpaceConfigure;
import backlog4j.conf.MutableSpaceConfigure;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class BacklogCommandTestBase {

    public static final int PROJECT_ID = 1073773875;
    protected BacklogClient immutableClient;
    protected BacklogClient mutableClient;


    @Before
    public void setUp() throws Exception {
        immutableClient = new BacklogClientFactory(ImmutableSpaceConfigure.getInstance()).newBacklogClient();
        mutableClient = new BacklogClientFactory(MutableSpaceConfigure.getInstance()).newBacklogClient();
    }


    public void assertProject1(Project project) {
        assertThat(project.getId(), is(PROJECT_ID));
        assertThat(project.getName(), is("project1"));
        assertThat(project.getKey(), is("P_1"));
        assertThat(project.getUrl(), is("https://b4jtest.backlog.jp/projects/P_1"));
    }

}
