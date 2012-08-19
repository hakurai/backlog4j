package backlog4j;

import backlog4j.conf.BacklogConfigure;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

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

        return XmlRpcUtil.toList(Project.class, res);
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

        return XmlRpcUtil.toList(Category.class, res);
    }

    @Override
    public List<Version> getVersions(int projectId) {
        Object[] res = getObjects(BACKLOG_GETVERSIONS, projectId);

        return XmlRpcUtil.toList(Version.class, res);
    }

    @Override
    public List<User> getUsers(int projectId) {
        Object[] res = getObjects(BACKLOG_GETUSERS, projectId);

        return XmlRpcUtil.toList(User.class, res);
    }

    @Override
    public List<IssueType> getIssueTypes(int projectId) {
        Object[] res = getObjects(BACKLOG_GETISSUETYPES, projectId);

        return XmlRpcUtil.toList(IssueType.class, res);
    }

    @Override
    public Issue getIssue(String issueKey) {
        Object[] params = new Object[]{issueKey};

        return getIssue(params);
    }

    @Override
    public Issue getIssue(int issueId) {
        Object[] params = new Object[]{issueId};

        return getIssue(params);
    }

    @Override
    public List<Comment> getComments(int issueId) {
        Object[] res = getObjects(BACKLOG_GETCOMMENTS, issueId);

        return XmlRpcUtil.toList(Comment.class, res);
    }

    private Object[] getObjects(String method, Object... params) {
        try {
            return (Object[]) client.execute(method, params);
        } catch (XmlRpcException e) {
            throw new BacklogException(e);
        }
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

    private Issue getIssue(Object[] params) {
        Object res;
        try {
            res = client.execute(BACKLOG_GETISSUE, params);
        } catch (XmlRpcException e) {
            throw new BacklogException(e);
        }

        return new Issue((Map<String, Object>) res);
    }
}
