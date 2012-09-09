package backlog4j.api;

import backlog4j.Version;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetVersionsTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkGetVersions() throws Exception {
        GetVersions getVersions = client.getVersions().setProjectId(PROJECT_ID);


        List<Version> versionList = getVersions.execute();

        assertThat(versionList.size(), is(4));

        Version version1 = versionList.get(0);
        assertThat(version1.getId(), is(1073787619));
        assertThat(version1.getName(), is("milestone1"));
        assertThat(version1.getDate(), is("20130818"));

        Version version2 = versionList.get(1);
        assertThat(version2.getId(), is(1073787620));
        assertThat(version2.getName(), is("version1.0"));
        assertThat(version2.getDate(), is(""));

        Version version3 = versionList.get(2);
        assertThat(version3.getId(), is(1073787621));
        assertThat(version3.getName(), is("test1"));
        assertThat(version3.getDate(), is("20120920"));

        Version version4 = versionList.get(3);
        assertThat(version4.getId(), is(1073787622));
        assertThat(version4.getName(), is("jenkins"));
        assertThat(version4.getDate(), is(""));

    }
}
