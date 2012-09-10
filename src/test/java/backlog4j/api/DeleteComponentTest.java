package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogClientImpl;
import backlog4j.Category;
import backlog4j.conf.MutableSpaceConfigure;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class DeleteComponentTest {

    @Test
    public void testShouldWorkDeleteComponent() throws Exception {
        final int projectId = 1073771652;
        BacklogClient client = new BacklogClientImpl(MutableSpaceConfigure.getInstance());

        Category deletedComponent = client.addComponent().setProjectId(projectId).setName("newComponent").execute();

        client.deleteComponent().setId(deletedComponent.getId()).execute();

        List<Category> categoryList = client.getComponents().setProjectId(projectId).execute();

        assertThat(categoryList.contains(deletedComponent), is(false));


    }
}
