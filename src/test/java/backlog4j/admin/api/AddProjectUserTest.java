package backlog4j.admin.api;

import backlog4j.BacklogException;
import backlog4j.admin.impl.ProjectUser;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class AddProjectUserTest extends BacklogAdminCommandTestBase {

    @Test
    public void testShouldAddUser() throws Exception {
        List<ProjectUser> projectUsers =
                mutableClient
                        .addProjectUser()
                        .setProjectId(MUTABLE_PROJECT_ID)
                        .setUserId(1073804493).execute();

        assertThat(projectUsers.size(), is(2));

        mutableClient.deleteProjectUsers().setProjectId(MUTABLE_PROJECT_ID).setUserId(1073804493).execute();

    }

    @Test(expected = BacklogException.class)
    public void testShouldThrowException() throws Exception {
        normalUserClient
                .addProjectUser()
                .setProjectId(MUTABLE_PROJECT_ID)
                .setUserId(1073804493).execute();


    }
}
