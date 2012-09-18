package backlog4j.api;

import backlog4j.Category;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class AddComponentTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkAddComponent() throws Exception {
        final int projectId = 1073771652;

        Category newComponent = mutableClient.addComponent().setProjectId(projectId).setName("newComponent").execute();

        assertThat(newComponent.getName(), is("newComponent"));

        mutableClient.deleteComponent().setId(newComponent.getId()).execute();

    }
}
