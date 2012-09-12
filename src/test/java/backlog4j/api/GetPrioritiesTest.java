package backlog4j.api;

import backlog4j.Priority;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetPrioritiesTest extends BacklogCommandTestBase {

    @Test
    public void testShouldReturnPriorityList() throws Exception {
        List<Priority> priorityList = client.getPriorities().execute();

        assertThat(priorityList.size(), is(3));

    }
}
