package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogClientFactory;
import backlog4j.CustomField;
import backlog4j.conf.CustomConfigure;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetCustomFieldsTest {

    protected BacklogClient customClient;


    @Before
    public void setUp() throws Exception {
        customClient = new BacklogClientFactory(CustomConfigure.getInstance()).newBacklogClient();
    }

    @Test
    public void testExecute() throws Exception {
        List<CustomField> customFieldList = customClient.getCustomFields().setProjectId(151).execute();

        assertThat(customFieldList.size(),is(5));

    }
}
