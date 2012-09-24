package backlog4j;

import backlog4j.admin.api.*;

/**
 * The <code>BacklogAdminClient</code> returns a object to execute Backlog Admin APIs.
 *
 * @author eguchi
 */
public interface BacklogAdminClient extends BacklogClientBase {

    /**
     * Returns a object to execute a backlog.admin.getUsers API
     *
     * @return the new GetUsers object.
     */
    GetUsers getUsers();

    /**
     * Returns a object to execute a backlog.admin.addUser API
     *
     * @return the new AddUser object.
     */
    AddUser addUser();

    /**
     * Returns a object to execute a backlog.admin.updateUser API
     *
     * @return the new UpdateUser object.
     */
    UpdateUser updateUser();

    /**
     * Returns a object to execute a backlog.admin.deleteUser API
     *
     * @return the new DeleteUser object.
     */
    DeleteUser deleteUser();

    /**
     * Returns a object to execute a backlog.admin.getProjects API
     *
     * @return the new GetProjects object.
     */
    GetProjects getProjects();

    /**
     * Returns a object to execute a backlog.admin.addProject API
     *
     * @return the new AddProject object.
     */
    AddProject addProject();

    /**
     * Returns a object to execute a backlog.admin.updateProject API
     *
     * @return the new UpdateProject object.
     */
    UpdateProject updateProject();

    /**
     * Returns a object to execute a backlog.admin.deleteProject API
     *
     * @return the new DeleteProject object.
     */
    DeleteProject deleteProject();

    /**
     * Returns a object to execute a backlog.admin.getProjectUsers API
     *
     * @return the new GetProjectUsers object.
     */
    GetProjectUsers getProjectUsers();

    /**
     * Returns a object to execute a backlog.admin.addProjectUser API
     *
     * @return the new AddProjectUser object.
     */
    AddProjectUser addProjectUser();

    /**
     * Returns a object to execute a backlog.admin.updateProjectUsers API
     *
     * @return the new UpdateProjectUsers object.
     */
    UpdateProjectUsers updateProjectUsers();

    /**
     * Returns a object to execute a backlog.admin.deleteProjectUsers API
     *
     * @return the new DeleteProjectUsers object.
     */
    DeleteProjectUsers deleteProjectUsers();

    /**
     * Returns a object to execute a backlog.admin.addCustomField API
     *
     * @return the new AddCustomField object.
     */
    AddCustomField addCustomField();

    /**
     * Returns a object to execute a backlog.admin.updateCustomField API
     *
     * @return the new UpdateCustomField object.
     */
    UpdateCustomField updateCustomField();

    /**
     * Returns a object to execute a backlog.admin.deleteCustomField API
     *
     * @return the new DeleteCustomField object.
     */
    DeleteCustomField deleteCustomField();
}
