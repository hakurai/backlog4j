package backlog4j;

import backlog4j.api.*;
import backlog4j.conf.BacklogConfigure;

/**
 * @author eguchi
 */
class BacklogClientImpl extends AbstractBacklogClientBase implements BacklogClient {

    public BacklogClientImpl(BacklogConfigure configure) {
        super(configure);
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
}
