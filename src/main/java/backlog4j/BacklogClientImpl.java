package backlog4j;

import backlog4j.conf.BacklogConfigure;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

        return toList(Project.class, res);
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
        Object[] res = getObjects(BACKLOG_GETCOMPONENTS, projectId);

        return toList(Category.class, res);
    }

    @Override
    public List<Version> getVersions(int projectId) {
        Object[] res = getObjects(BACKLOG_GETVERSIONS, projectId);

        return toList(Version.class, res);
    }

    @Override
    public List<User> getUsers(int projectId) {
        Object[] res = getObjects(BACKLOG_GETUSERS, projectId);

        return toList(User.class, res);
    }

    @Override
    public List<IssueType> getIssueTypes(int projectId) {
        Object[] res = getObjects(BACKLOG_GETISSUETYPES, projectId);

        return toList(IssueType.class, res);
    }

    private Object[] getObjects(String method, Object... params) {
        try {
            return (Object[]) client.execute(method, params);
        } catch (XmlRpcException e) {
            throw new BacklogException(e);
        }
    }

    private <T> List<T> toList(Class<T> clazz, Object[] objects) {
        List<T> list = new ArrayList<T>(objects.length);

        Constructor<T> constructor;
        try {
            constructor = clazz.getConstructor(Map.class);
        } catch (NoSuchMethodException e) {
            throw new BacklogException(e);
        }

        for (Object o : objects) {
            Map<String, Object> map = (Map<String, Object>) o;

            T t;
            try {
                t = constructor.newInstance(map);
            } catch (InstantiationException e) {
                throw new BacklogException(e);
            } catch (IllegalAccessException e) {
                throw new BacklogException(e);
            } catch (InvocationTargetException e) {
                throw new BacklogException(e);
            }

            list.add(t);
        }

        return Collections.unmodifiableList(list);
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
