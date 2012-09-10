package backlog4j;

import backlog4j.api.*;
import backlog4j.conf.BacklogConfigure;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

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

    public Object execute(String methodName) {
        return execute(methodName, new Object[]{});
    }

    public Object execute(String methodName, Object... params) {
        try {
            return client.execute(methodName, params);
        } catch (XmlRpcException e) {
            throw new BacklogException(e);
        }
    }

    @Override
    public GetProjects getProjects() {
        return new GetProjects(this);
    }

    @Override
    public GetProject getProject() {
        return new GetProject(this);
    }

    @Override
    public GetComponents getComponents() {
        return new GetComponents(this);
    }

    @Override
    public GetVersions getVersions() {
        return new GetVersions(this);
    }

    @Override
    public GetUsers getUsers() {
        return new GetUsers(this);
    }

    @Override
    public GetIssueTypes getIssueTypes() {
        return new GetIssueTypes(this);
    }

    @Override
    public GetIssue getIssue() {
        return new GetIssue(this);
    }

    @Override
    public GetComments getComments() {
        return new GetComments(this);
    }

    @Override
    public CountIssue countIssue() {
        return new CountIssue(this);
    }

    @Override
    public FindIssue findIssue() {
        return new FindIssue(this);
    }

    @Override
    public CreateIssue createIssue() {
        return new CreateIssue(this);
    }

    @Override
    public UpdateIssue updateIssue() {
        return new UpdateIssue(this);
    }

    @Override
    public SwitchStatus switchStatus() {
        return new SwitchStatus(this);
    }

    @Override
    public AddComment addComment() {
        return new AddComment(this);
    }

    @Override
    public AddIssueType addIssueType() {
        return new AddIssueType(this);
    }

    @Override
    public UpdateIssueType updateIssueType() {
        return new UpdateIssueType(this);
    }

    @Override
    public DeleteIssueType deleteIssueType() {
        return new DeleteIssueType(this);
    }

    @Override
    public AddVersion addVersion() {
        return new AddVersion(this);
    }

    @Override
    public UpdateVersion updateVersion() {
        return new UpdateVersion(this);
    }

    @Override
    public DeleteVersion deleteVersion() {
        return new DeleteVersion(this);
    }

    @Override
    public AddComponent addComponent() {
        return new AddComponent(this);
    }

    @Override
    public UpdateComponent updateComponent() {
        return new UpdateComponent(this);
    }

    @Override
    public DeleteComponent deleteComponent() {
        return new DeleteComponent(this);
    }

    @Override
    public GetTimeline getTimeline() {
        return new GetTimeline(this);
    }
}
