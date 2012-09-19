package backlog4j.admin.api;

import backlog4j.admin.impl.UserEx;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetProjectUsersTest extends BacklogAdminCommandTestBase {

    @Test
    public void testShouldReturnUser() throws Exception {

        List<UserEx> userExList = immutableClient.getProjectUsers().setProjectId(PROJECT_ID).execute();

        assertThat(userExList.size(), is(4));

        UserEx user = userExList.get(0);

        assertThat(user.getId(), is(1073806664));
        assertThat(user.getUserId(), is("eguchi"));
        assertThat(user.getName(), is("hakurai"));


    }
}
