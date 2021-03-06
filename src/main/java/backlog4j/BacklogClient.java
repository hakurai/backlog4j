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
 * The <code>BacklogClient</code> returns a object to execute Backlog APIs.
 *
 * @author eguchi
 */
public interface BacklogClient extends BacklogClientBase {

    /**
     * Return a BacklogAdminClient instance
     *
     * @return BacklogAdminClient
     */
    BacklogAdminClient getAdmin();

    /**
     * Returns a configure
     *
     * @return configure.
     */
    BacklogConfigure getConfigure();

    /**
     * Returns a object to execute a backlog.getProjects API
     *
     * @return the new GetProjects object.
     */
    GetProjects getProjects();

    /**
     * Returns a object to execute a backlog.getProject API
     *
     * @return the new GetProject object.
     */
    GetProject getProject();

    /**
     * Returns a object to execute a backlog.getComponents API
     *
     * @return the new GetComponents object.
     */
    GetComponents getComponents();

    /**
     * Returns a object to execute a backlog.getVersions API
     *
     * @return the new GetVersions object.
     */
    GetVersions getVersions();

    /**
     * Returns a object to execute a backlog.getUsers API
     *
     * @return the new GetUsers object.
     */
    GetUsers getUsers();

    /**
     * Returns a object to execute a backlog.getIssueTypes API
     *
     * @return the new GetIssueTypes object.
     */
    GetIssueTypes getIssueTypes();

    /**
     * Returns a object to execute a backlog.getIssue API
     *
     * @return the new GetIssue object.
     */
    GetIssue getIssue();

    /**
     * Returns a object to execute a backlog.getComments API
     *
     * @return the new GetComments object.
     */
    GetComments getComments();

    /**
     * Returns a object to execute a backlog.countIssue API
     *
     * @return the new CountIssue object.
     */
    CountIssue countIssue();

    /**
     * Returns a object to execute a backlog.findIssue API
     *
     * @return the new FindIssue object.
     */
    FindIssue findIssue();

    /**
     * Returns a object to execute a backlog.createIssue API
     *
     * @return the new CreateIssue object.
     */
    CreateIssue createIssue();

    /**
     * Returns a object to execute a backlog.updateIssue API
     *
     * @return the new UpdateIssue object.
     */
    UpdateIssue updateIssue();

    /**
     * Returns a object to execute a backlog.switchStatus API
     *
     * @return the new SwitchStatus object.
     */
    SwitchStatus switchStatus();

    /**
     * Returns a object to execute a backlog.addComment API
     *
     * @return the new AddComment object.
     */
    AddComment addComment();

    /**
     * Returns a object to execute a backlog.addIssueType API
     *
     * @return the new AddIssueType object.
     */
    AddIssueType addIssueType();

    /**
     * Returns a object to execute a backlog.updateIssueType API
     *
     * @return the new UpdateIssueType object.
     */
    UpdateIssueType updateIssueType();

    /**
     * Returns a object to execute a backlog.deleteIssueType API
     *
     * @return the new DeleteIssueType object.
     */
    DeleteIssueType deleteIssueType();

    /**
     * Returns a object to execute a backlog.addVersion API
     *
     * @return the new AddVersion object.
     */
    AddVersion addVersion();

    /**
     * Returns a object to execute a backlog.updateVersion API
     *
     * @return the new UpdateVersion object.
     */
    UpdateVersion updateVersion();

    /**
     * Returns a object to execute a backlog.deleteVersion API
     *
     * @return the new DeleteVersion object.
     */
    DeleteVersion deleteVersion();

    /**
     * Returns a object to execute a backlog.addComponent API
     *
     * @return the new AddComponent object.
     */
    AddComponent addComponent();

    /**
     * Returns a object to execute a backlog.updateComponent API
     *
     * @return the new UpdateComponent object.
     */
    UpdateComponent updateComponent();

    /**
     * Returns a object to execute a backlog.deleteComponent API
     *
     * @return the new DeleteComponent object.
     */
    DeleteComponent deleteComponent();

    /**
     * Returns a object to execute a backlog.getTimeline API
     *
     * @return the new GetTimeline object.
     */
    GetTimeline getTimeline();

    /**
     * Returns a object to execute a backlog.getProjectSummary API
     *
     * @return the new GetProjectSummary object.
     */
    GetProjectSummary getProjectSummary();

    /**
     * Returns a object to execute a backlog.getProjectSummaries API
     *
     * @return the new GetProjectSummaries object.
     */
    GetProjectSummaries getProjectSummaries();

    /**
     * Returns a object to execute a backlog.getUser API
     *
     * @return the new GetUser object.
     */
    GetUser getUser();

    /**
     * Returns a object to execute a backlog.getUserIcon API
     *
     * @return the new GetUserIcon object.
     */
    GetUserIcon getUserIcon();

    /**
     * Returns a object to execute a backlog.getActivityTypes API
     *
     * @return the new GetActivityTypes object.
     */
    GetActivityTypes getActivityTypes();

    /**
     * Returns a object to execute a backlog.getStatuses API
     *
     * @return the new GetStatuses object.
     */
    GetStatuses getStatuses();

    /**
     * Returns a object to execute a backlog.getResolutions API
     *
     * @return the new GetResolutions object.
     */
    GetResolutions getResolutions();

    /**
     * Returns a object to execute a backlog.getPriorities API
     *
     * @return the new GetPriorities object.
     */
    GetPriorities getPriorities();

    /**
     * Returns a object to execute a backlog.getCustomFields API
     *
     * @return the new GetCustomFields object.
     */
    GetCustomFields getCustomFields();

    /**
     * Returns a object to execute a backlog.getChildIssues API
     *
     * @return the new GetChildIssues object.
     */
    GetChildIssues getChildIssues();
}
