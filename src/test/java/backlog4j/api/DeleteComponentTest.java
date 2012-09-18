package backlog4j.api;

import backlog4j.Category;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class DeleteComponentTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkDeleteComponent() throws Exception {
        final int projectId = 1073771652;

        Category deletedComponent = mutableClient.addComponent().setProjectId(projectId).setName("newComponent").execute();

        mutableClient.deleteComponent().setId(deletedComponent.getId()).execute();

        List<Category> categoryList = mutableClient.getComponents().setProjectId(projectId).execute();

        assertThat(categoryList.contains(deletedComponent), is(false));


    }
}
