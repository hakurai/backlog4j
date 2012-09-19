package backlog4j.api;

import backlog4j.Status;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetStatusesTest extends BacklogCommandTestBase {

    @Test
    public void testShouldReturnStatusList() throws Exception {
        List<Status> statusList = immutableClient.getStatuses().execute();

        assertThat(statusList.size(), is(4));

    }
}
