package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
import backlog4j.BacklogClientFactory;
import backlog4j.conf.ImmutableSpaceConfigure;
import backlog4j.conf.MutableSpaceConfigure;
import org.junit.Before;

/**
 * @author eguchi
 */
public class BacklogAdminCommandTestBase {

    public static final int PROJECT_ID = 1073773875;
    protected BacklogAdminClient immutableClient;
    protected BacklogAdminClient mutableClient;


    @Before
    public void setUp() throws Exception {
        immutableClient = new BacklogClientFactory(ImmutableSpaceConfigure.getInstance()).newBacklogAdminClient();
        mutableClient = new BacklogClientFactory(MutableSpaceConfigure.getInstance()).newBacklogAdminClient();
    }
}
