package backlog4j.api;

import backlog4j.Resolution;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetResolutionsTest extends BacklogCommandTestBase {

    @Test
    public void testShouldReturnResolutionList() throws Exception {
        List<Resolution> resolutionList = client.getResolutions().execute();

        assertThat(resolutionList.size(), is(5));

    }
}
