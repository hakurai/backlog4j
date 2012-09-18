package backlog4j.admin.api;

import backlog4j.api.BacklogCommand;

/**
 * @author eguchi
 */
public interface BacklogAdminCommand<T> extends BacklogCommand<T> {

    static final String BACKLOG_ADMIN_GET_USERS = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_ADD_USER = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_UPDTE_USERS = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_DELETE_USERS = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_GET_PROJECTS = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_ADD_PROJECT = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_UPDATE_PROJECT = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_DELETE_PROJECT = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_GET_PROJECT_USERS = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_ADD_PROJECT_USER = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_UPDATE_PROJECT_USERS = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_DELETE_PROJECT_USER = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_ADD_CUSTOM_FIELD = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_UPDATE_CUSTOM_FIELD = "backlog.admin.getUsers";
    static final String BACKLOG_ADMIN_DELETE_CUSTOM_FIELD = "backlog.admin.getUsers";

}
