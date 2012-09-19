package backlog4j;

import backlog4j.admin.api.*;

/**
 * @author eguchi
 */
public interface BacklogAdminClient extends BacklogClientBase {

    GetUsers getUsers();

    AddUser addUser();

    UpdateUser updateUser();

    DeleteUser deleteUser();

    GetProjects getProjects();

    AddProject addProject();

    UpdateProject updateProject();

    DeleteProject deleteProject();

    GetProjectUsers getProjectUsers();

    AddProjectUser addProjectUser();

    UpdateProjectUsers updateProjectUsers();

    DeleteProjectUsers deleteProjectUsers();

    AddCustomField addCustomField();

    UpdateCustomField updateCustomField();

    DeleteCustomField deleteCustomField();
}
