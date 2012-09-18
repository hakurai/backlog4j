package backlog4j.api;

import backlog4j.Version;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class DeleteVersionTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkDeleteVersion() throws Exception {
        final int projectId = 1073771652;

        Version deletedVersion = mutableClient.addVersion().setProjectId(projectId).setName("newVersion").execute();

        mutableClient.deleteVersion().setId(deletedVersion.getId()).execute();


        List<Version> versionList = mutableClient.getVersions().setProjectId(projectId).execute();

        assertThat(versionList.contains(deletedVersion), is(false));

    }
}
