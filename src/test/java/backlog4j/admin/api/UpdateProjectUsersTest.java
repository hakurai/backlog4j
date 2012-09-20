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
public class UpdateProjectUsersTest extends BacklogAdminCommandTestBase {

    @Test
    public void testShouldAddUser() throws Exception {
        List<ProjectUser> oldList = mutableClient
                .getProjectUsers()
                .setProjectId(MUTABLE_PROJECT_ID)
                .execute();


        List<ProjectUser> newList =
                mutableClient
                        .updateProjectUsers()
                        .setProjectId(MUTABLE_PROJECT_ID)
                        .addUserId(1073804493)
                        .execute();

        assertThat(newList.size(), is(1));

        ProjectUser user = newList.get(0);
        assertThat(user.getId(), is(1073804493));


        mutableClient
                .updateProjectUsers()
                .setProjectId(MUTABLE_PROJECT_ID)
                .addUserList(oldList)
                .execute();

    }

    @Test(expected = BacklogException.class)
    public void testShouldThrowException() throws Exception {
        normalUserClient
                .updateProjectUsers()
                .setProjectId(MUTABLE_PROJECT_ID)
                .addUserId(1073804493)
                .execute();
    }
}