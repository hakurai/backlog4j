package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogClientImpl;
import backlog4j.Version;
import backlog4j.conf.MutableSpaceConfigure;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class AddVersionTest {

    @Test
    public void testShouldWorkAddVersion() throws Exception {
        final int projectId = 1073771652;
        BacklogClient client = new BacklogClientImpl(MutableSpaceConfigure.getInstance());

        Version newVersion = client.AddVersion().setProjectId(projectId).setName("newVersion").execute();

        assertThat(newVersion.getName(), is("newVersion"));

    }
}
