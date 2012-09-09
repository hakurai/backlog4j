package backlog4j.api;

import backlog4j.Category;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetComponentsTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkGetComponents() throws Exception {
        GetComponents getComponents = client.getComponents().setProjectId(PROJECT_ID);


        List<Category> categoryList = getComponents.execute();

        assertThat(categoryList.size(), is(3));

        Category category1 = categoryList.get(0);
        assertThat(category1.getId(), is(1073813651));
        assertThat(category1.getName(), is("category1"));

        Category category2 = categoryList.get(1);
        assertThat(category2.getId(), is(1073813652));
        assertThat(category2.getName(), is("mail"));

        Category category3 = categoryList.get(2);
        assertThat(category3.getId(), is(1073813653));
        assertThat(category3.getName(), is("test"));

    }

}
