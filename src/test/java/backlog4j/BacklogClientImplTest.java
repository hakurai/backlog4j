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

    public static final int PROJECT_ID = 1073773875;
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
        Project project = client.getProject(PROJECT_ID);

        assertProject1(project);
    }


    @Test
    public void testGetComponents() throws Exception {
        List<Category> categoryList = client.getComponents(PROJECT_ID);

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
        List<Version> versionList = client.getVersions(PROJECT_ID);

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

    @Test
    public void testGetUsers() throws Exception {
        List<User> userList = client.getUsers(PROJECT_ID);

        assertThat(userList.size(),is(4));

        User user1 = userList.get(0);
        assertThat(user1.getId(), is(1073806664));
        assertThat(user1.getName(), is("hakurai"));

        User user2 = userList.get(1);
        assertThat(user2.getId(), is(1073806659));
        assertThat(user2.getName(), is("owner"));

        User user3 = userList.get(2);
        assertThat(user3.getId(), is(1073806665));
        assertThat(user3.getName(), is("tom"));

        User user4 = userList.get(3);
        assertThat(user4.getId(), is(1073806666));
        assertThat(user4.getName(), is("uochan"));

    }

    @Test
    public void testGetIssueTypes() throws Exception {
        List<IssueType> issueTypeList = client.getIssueTypes(PROJECT_ID);

        assertThat(issueTypeList.size(),is(4));

        IssueType issueType1 = issueTypeList.get(0);
        assertThat(issueType1.getId(),is(1073884674));
        assertThat(issueType1.getName(),is("バグ"));
        assertThat(issueType1.getColor(),is("#990000"));

        IssueType issueType2 = issueTypeList.get(1);
        assertThat(issueType2.getId(),is(1073884675));
        assertThat(issueType2.getName(),is("タスク"));
        assertThat(issueType2.getColor(),is("#7ea800"));

        IssueType issueType3 = issueTypeList.get(2);
        assertThat(issueType3.getId(),is(1073884676));
        assertThat(issueType3.getName(),is("要望"));
        assertThat(issueType3.getColor(),is("#ff9200"));

        IssueType issueType4 = issueTypeList.get(3);
        assertThat(issueType4.getId(),is(1073884677));
        assertThat(issueType4.getName(),is("その他"));
        assertThat(issueType4.getColor(),is("#2779ca"));

    }

    private void assertProject1(Project project) {
        assertThat(project.getId(), is(PROJECT_ID));
        assertThat(project.getName(), is("project1"));
        assertThat(project.getKey(), is("P_1"));
        assertThat(project.getUrl(), is("https://b4jtest.backlog.jp/projects/P_1"));
    }


}
