package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogClientImpl;
import backlog4j.Version;
import backlog4j.conf.MutableSpaceConfigure;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class DeleteVersionTest {

    @Test
    public void testShouldWorkDeleteVersion() throws Exception {
        final int projectId = 1073771652;
        BacklogClient client = new BacklogClientImpl(MutableSpaceConfigure.getInstance());

        Version deletedVersion = client.addVersion().setProjectId(projectId).setName("newVersion").execute();

        client.deleteVersion().setId(deletedVersion.getId()).execute();


        List<Version> versionList = client.getVersions().setProjectId(projectId).execute();

        assertThat(versionList.contains(deletedVersion), is(false));

    }
}
