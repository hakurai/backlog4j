package backlog4j;

import backlog4j.admin.api.AddCustomField;
import backlog4j.admin.api.AddProject;
import backlog4j.admin.api.AddProjectUser;
import backlog4j.admin.api.AddUser;
import backlog4j.admin.api.DeleteCustomField;
import backlog4j.admin.api.DeleteProject;
import backlog4j.admin.api.DeleteProjectUsers;
import backlog4j.admin.api.DeleteUser;
import backlog4j.admin.api.GetProjectUsers;
import backlog4j.admin.api.GetProjects;
import backlog4j.admin.api.GetUsers;
import backlog4j.admin.api.UpdateCustomField;
import backlog4j.admin.api.UpdateProject;
import backlog4j.admin.api.UpdateProjectUsers;
import backlog4j.admin.api.UpdateUser;
import backlog4j.conf.BacklogConfigure;

/**
 * @author eguchi
 */
class BacklogAdminClientImpl extends AbstractBacklogClientBase implements BacklogAdminClient {

    public BacklogAdminClientImpl(BacklogConfigure configure) {
        super(configure);
    }

    @Override
    public GetUsers getUsers() {
        return new GetUsers(this);
    }

    @Override
    public AddUser addUser() {
        return new AddUser(this);
    }

    @Override
    public UpdateUser updateUser() {
        return new UpdateUser(this);
    }

    @Override
    public DeleteUser deleteUser() {
        return new DeleteUser(this);
    }

    @Override
    public GetProjects getProjects() {
        return new GetProjects(this);
    }

    @Override
    public AddProject addProject() {
        return new AddProject(this);
    }

    @Override
    public UpdateProject updateProject() {
        return new UpdateProject(this);
    }

    @Override
    public DeleteProject deleteProject() {
        return new DeleteProject(this);
    }

    @Override
    public GetProjectUsers getProjectUsers() {
        return new GetProjectUsers(this);
    }

    @Override
    public AddProjectUser addProjectUser() {
        return new AddProjectUser(this);
    }

    @Override
    public UpdateProjectUsers updateProjectUsers() {
        return new UpdateProjectUsers(this);
    }

    @Override
    public DeleteProjectUsers deleteProjectUsers() {
        return new DeleteProjectUsers(this);
    }

    @Override
    public AddCustomField addCustomField() {
        return new AddCustomField(this);
    }

    @Override
    public UpdateCustomField updateCustomField() {
        return new UpdateCustomField(this);
    }

    @Override
    public DeleteCustomField deleteCustomField() {
        return new DeleteCustomField(this);
    }
}
