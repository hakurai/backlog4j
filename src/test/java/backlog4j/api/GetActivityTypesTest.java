package backlog4j.api;

import backlog4j.ActivityType;
import org.junit.Test;

import java.util.List;

/**
 * @author eguchi
 */
public class GetActivityTypesTest extends BacklogCommandTestBase {

    @Test
    public void testShouldReturnActivityTypeList() throws Exception {
        List<ActivityType> activityTypeList = immutableClient.getActivityTypes().execute();


    }
}
