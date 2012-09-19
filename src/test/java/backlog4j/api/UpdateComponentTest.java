package backlog4j.api;

import backlog4j.Category;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class UpdateComponentTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkUpdateComponent() throws Exception {
        final int projectId = 1073771652;

        Category newComponent =
                mutableClient.addComponent().setProjectId(projectId).setName("newComponent").execute();

        Category updatedComponent = mutableClient.updateComponent()
                .setId(newComponent.getId())
                .setName("updatedComponent")
                .execute();


        assertThat(updatedComponent.getName(), is("updatedComponent"));

        mutableClient.deleteComponent().setId(newComponent.getId()).execute();

    }
}
