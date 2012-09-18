package backlog4j;

import backlog4j.admin.api.*;
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
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UpdateUser updateUser() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DeleteUser deleteUser() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GetProjects getProjects() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AddProject addProject() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UpdateProject updateProject() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DeleteProject deleteProject() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GetProjectUsers getProjectUsers() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AddProjectUser addProjectUser() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UpdateProjectUsers updateProjectUsers() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DeleteProjectUsers deleteProjectUsers() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AddCustomField addCustomField() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UpdateCustomField updateCustomField() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DeleteCustomField deleteCustomField() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}