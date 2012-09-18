package backlog4j.admin.api;

import backlog4j.api.BacklogCommand;

/**
 * @author eguchi
 */
public interface BacklogAdminCommand<T> extends BacklogCommand<T> {

    static final String USER_ID = "user_id";
    static final String PASSWORD_MD5 = "password_md5";
    static final String MAIL_ADDRESS = "mail_address";
    static final String ROLE = "role";
    static final String MAIL_SETTING = "mail_setting";
    static final String ICON = "icon";
    static final String TYPE = "type";
    static final String DATA = "data";

    static final String MAIL = "mail";


    static final String BACKLOG_ADMIN_GET_USERS = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_ADD_USER = "backlog.admin.addUser";
    static final String BACKLOG_ADMIN_UPDATE_USER = "backlog.admin.updateUser";
    static final String BACKLOG_ADMIN_DELETE_USERS = "backlog.admin.deleteUser";
    static final String BACKLOG_ADMIN_GET_PROJECTS = "backlog.admin.getProjects";
    static final String BACKLOG_ADMIN_ADD_PROJECT = "backlog.admin.addProject";
    static final String BACKLOG_ADMIN_UPDATE_PROJECT = "backlog.admin.updateProject";
    static final String BACKLOG_ADMIN_DELETE_PROJECT = "backlog.admin.deleteProject";
    static final String BACKLOG_ADMIN_GET_PROJECT_USERS = "backlog.admin.getProjectUsers";
    static final String BACKLOG_ADMIN_ADD_PROJECT_USER = "backlog.admin.addProjectUser";
    static final String BACKLOG_ADMIN_UPDATE_PROJECT_USERS = "backlog.admin.updateProjectUsers";
    static final String BACKLOG_ADMIN_DELETE_PROJECT_USER = "backlog.admin.deleteProjectUser";
    static final String BACKLOG_ADMIN_ADD_CUSTOM_FIELD = "backlog.admin.addCustomField";
    static final String BACKLOG_ADMIN_UPDATE_CUSTOM_FIELD = "backlog.admin.updateCustomField";
    static final String BACKLOG_ADMIN_DELETE_CUSTOM_FIELD = "backlog.admin.deleteCustomField";

}
