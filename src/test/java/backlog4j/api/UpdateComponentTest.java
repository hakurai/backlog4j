package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogClientImpl;
import backlog4j.Category;
import backlog4j.conf.MutableSpaceConfigure;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class UpdateComponentTest {

    @Test
    public void testShouldWorkUpdateComponent() throws Exception {
        final int projectId = 1073771652;
        BacklogClient client = new BacklogClientImpl(MutableSpaceConfigure.getInstance());

        Category newComponent =
                client.addComponent().setProjectId(projectId).setName("newComponent").execute();

        Category updatedComponent = client.updateComponent()
                        .setId(newComponent.getId())
                        .setName("updatedComponent")
                        .execute();


        assertThat(updatedComponent.getName(), is("updatedComponent"));

        client.deleteComponent().setId(newComponent.getId()).execute();

    }
}
