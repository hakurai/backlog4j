package backlog4j;

import backlog4j.api.AddComment;
import backlog4j.api.AddComponent;
import backlog4j.api.AddIssueType;
import backlog4j.api.AddVersion;
import backlog4j.api.CountIssue;
import backlog4j.api.CreateIssue;
import backlog4j.api.DeleteComponent;
import backlog4j.api.DeleteIssueType;
import backlog4j.api.DeleteVersion;
import backlog4j.api.FindIssue;
import backlog4j.api.GetActivityTypes;
import backlog4j.api.GetChildIssues;
import backlog4j.api.GetComments;
import backlog4j.api.GetComponents;
import backlog4j.api.GetCustomFields;
import backlog4j.api.GetIssue;
import backlog4j.api.GetIssueTypes;
import backlog4j.api.GetPriorities;
import backlog4j.api.GetProject;
import backlog4j.api.GetProjectSummaries;
import backlog4j.api.GetProjectSummary;
import backlog4j.api.GetProjects;
import backlog4j.api.GetResolutions;
import backlog4j.api.GetStatuses;
import backlog4j.api.GetTimeline;
import backlog4j.api.GetUser;
import backlog4j.api.GetUserIcon;
import backlog4j.api.GetUsers;
import backlog4j.api.GetVersions;
import backlog4j.api.SwitchStatus;
import backlog4j.api.UpdateComponent;
import backlog4j.api.UpdateIssue;
import backlog4j.api.UpdateIssueType;
import backlog4j.api.UpdateVersion;
import backlog4j.conf.BacklogConfigure;

/**
 * @author eguchi
 */
class BacklogClientImpl extends AbstractBacklogClientBase implements BacklogClient {

    private BacklogAdminClient adminClient;

    public BacklogClientImpl(BacklogConfigure configure) {
        super(configure);

        adminClient = new BacklogAdminClientImpl(configure);
    }

    @Override
    public BacklogAdminClient getAdmin() {
        return adminClient;
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

    @Override
    public GetProjectSummary getProjectSummary() {
        return new GetProjectSummary(this);
    }

    @Override
    public GetProjectSummaries getProjectSummaries() {
        return new GetProjectSummaries(this);
    }

    @Override
    public GetUser getUser() {
        return new GetUser(this);
    }

    @Override
    public GetUserIcon getUserIcon() {
        return new GetUserIcon(this);
    }

    @Override
    public GetActivityTypes getActivityTypes() {
        return new GetActivityTypes(this);
    }

    @Override
    public GetStatuses getStatuses() {
        return new GetStatuses(this);
    }

    @Override
    public GetResolutions getResolutions() {
        return new GetResolutions(this);
    }

    @Override
    public GetPriorities getPriorities() {
        return new GetPriorities(this);
    }

    @Override
    public GetCustomFields getCustomFields() {
        return new GetCustomFields(this);
    }
    @Override
    public GetChildIssues getChildIssues() {
        return new GetChildIssues(this);
    }
}
