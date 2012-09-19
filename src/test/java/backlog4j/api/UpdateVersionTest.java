package backlog4j.api;

import backlog4j.Version;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class UpdateVersionTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkUpdateVersion() throws Exception {
        final int projectId = 1073771652;

        Version newVersion = mutableClient.addVersion().setProjectId(projectId).setName("newVersion").execute();

        Version updatedVersion = mutableClient.updateVersion().setId(newVersion.getId()).setName("updatedVersion").execute();


        assertThat(updatedVersion.getName(), is("updatedVersion"));

        mutableClient.deleteVersion().setId(newVersion.getId()).execute();

    }
}
