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
public class UpdateVersionTest {

    @Test
    public void testShouldWorkUpdateVersion() throws Exception {
        final int projectId = 1073771652;
        BacklogClient client = new BacklogClientImpl(MutableSpaceConfigure.getInstance());

        Version newVersion = client.addVersion().setProjectId(projectId).setName("newVersion").execute();

        Version updatedVersion = client.updateVersion().setId(newVersion.getId()).setName("updatedVersion").execute();


        assertThat(updatedVersion.getName(), is("updatedVersion"));

        client.deleteVersion().setId(newVersion.getId()).execute();

    }
}
