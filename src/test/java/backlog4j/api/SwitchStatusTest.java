package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogClientImpl;
import backlog4j.Issue;
import backlog4j.conf.MutableSpaceConfigure;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class SwitchStatusTest {

    @Test
    public void testShouldSwitchStatus() throws Exception {
        final int projectId = 1073771652;
        BacklogClient client = new BacklogClientImpl(MutableSpaceConfigure.getInstance());

        Issue issue = client.createIssue().setProjectId(projectId).setSummary("test").execute();

        assertThat(issue.getStatus().getName(), is("未対応"));

        Issue switched = client.switchStatus().setKey(issue.getKey()).setStatusId(2).execute();

        assertThat(switched.getStatus().getName(), is("処理中"));


    }
}
