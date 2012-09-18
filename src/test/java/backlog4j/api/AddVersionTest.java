package backlog4j.api;

import backlog4j.Version;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class AddVersionTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkAddVersion() throws Exception {
        final int projectId = 1073771652;

        Version newVersion = mutableClient.addVersion().setProjectId(projectId).setName("newVersion").execute();

        assertThat(newVersion.getName(), is("newVersion"));

        mutableClient.deleteVersion().setId(newVersion.getId()).execute();

    }
}
