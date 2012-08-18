package backlog4j;

import backlog4j.conf.BacklogConfigureTestImpl;
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
        assertProject1(project);
    }

    @Test
    public void testGetProjectByKey() throws Exception {
        Project project = client.getProject("P_1");

        assertProject1(project);
    }

    @Test
    public void testGetProjectById() throws Exception {
        Project project = client.getProject(1073773875);

        assertProject1(project);
    }


    @Test
    public void testGetComponents() throws Exception {
        List<Category> categoryList = client.getComponents(1073773875);

        assertThat(categoryList.size(), is(3));

        Category category1 = categoryList.get(0);
        assertThat(category1.getId(), is(1073813651));
        assertThat(category1.getName(), is("category1"));

        Category category2 = categoryList.get(1);
        assertThat(category2.getId(), is(1073813652));
        assertThat(category2.getName(), is("mail"));

        Category category3 = categoryList.get(2);
        assertThat(category3.getId(), is(1073813653));
        assertThat(category3.getName(), is("test"));

    }

    @Test
    public void testGetVersions() throws Exception {
        List<Version> versionList = client.getVersions(1073773875);

        assertThat(versionList.size(),is(4));

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

    private void assertProject1(Project project) {
        assertThat(project.getId(), is(1073773875));
        assertThat(project.getName(), is("project1"));
        assertThat(project.getKey(), is("P_1"));
        assertThat(project.getUrl(), is("https://b4jtest.backlog.jp/projects/P_1"));
    }


}
