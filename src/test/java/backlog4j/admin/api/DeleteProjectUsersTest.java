package backlog4j.admin.api;

import backlog4j.admin.impl.ProjectUser;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class DeleteProjectUsersTest extends BacklogAdminCommandTestBase {

    @Test
    public void testShouldAddUser() throws Exception {
        mutableClient
                .addProjectUser()
                .setProjectId(MUTABLE_PROJECT_ID)
                .setUserId(1073804493)
                .execute();


        List<ProjectUser> newList =
                mutableClient
                        .deleteProjectUsers()
                        .setProjectId(MUTABLE_PROJECT_ID)
                        .setUserId(1073804493)
                        .execute();

        assertThat(newList.size(), is(1));

    }
}