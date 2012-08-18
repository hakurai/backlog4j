package backlog4j;

import backlog4j.conf.BacklogConfigure;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public class BacklogClientImpl implements BacklogClient {

    private final XmlRpcClient client;


    public BacklogClientImpl(BacklogConfigure configure) {
        if (configure == null) {
            throw new IllegalArgumentException("configure must not be null");
        }

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(configure.getXmlRpcUrl());

        config.setBasicUserName(configure.getUsername());
        config.setBasicPassword(configure.getPassword());

        client = new XmlRpcClient();
        client.setConfig(config);
    }

    @Override
    public List<Project> getProjects() {
        Object[] params = new Object[]{};
        Object[] res;
        try {
            res = (Object[]) client.execute(BACKLOG_GETPROJECTS, params);
        } catch (XmlRpcException e) {
            throw new BacklogException(e);
        }

        ArrayList<Project> projectList = new ArrayList<Project>(res.length);

        for (Object src : res) {

            Map<String, Object> map = (Map<String, Object>) src;

            projectList.add(new Project(map));
        }

        return Collections.unmodifiableList(projectList);
    }
}
