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

        for (Object o : res) {
            Map<String, Object> map = (Map<String, Object>) o;
            projectList.add(new Project(map));
        }

        return Collections.unmodifiableList(projectList);
    }

    @Override
    public Project getProject(String key) {
        Object[] params = new Object[]{key};
        return getProject(params);
    }

    @Override
    public Project getProject(int id) {
        Object[] params = new Object[]{id};
        return getProject(params);
    }

    @Override
    public List<Category> getComponents(int projectId) {
        Object[] params = new Object[]{projectId};
        Object[] res;
        try {
            res = (Object[]) client.execute(BACKLOG_GETCOMPONENTS, params);
        } catch (XmlRpcException e) {
            throw new BacklogException(e);
        }

        List<Category> categoryList = new ArrayList<Category>(res.length);

        for (Object o : res) {
            Map<String, Object> map = (Map<String, Object>) o;

            categoryList.add(new Category(map));
        }

        return Collections.unmodifiableList(categoryList);
    }

    private Project getProject(Object[] params) {
        Object res;
        try {
            res = client.execute(BACKLOG_GETPROJECT, params);
        } catch (XmlRpcException e) {
            throw new BacklogException(e);
        }

        return new Project((Map<String, Object>) res);
    }
}
