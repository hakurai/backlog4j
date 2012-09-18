package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
import backlog4j.BacklogException;
import backlog4j.admin.impl.UserEx;
import backlog4j.util.MD5;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public class AddUser implements BacklogAdminCommand<UserEx> {

    private final BacklogAdminClient client;
    protected final Map<String, Object> map = new HashMap<String, Object>();

    public AddUser(BacklogAdminClient client) {
        this.client = client;
    }

    public AddUser setUserId(String userId) {
        map.put(USER_ID, userId);

        return this;
    }

    public String getUserId() {
        return (String) map.get(USER_ID);
    }

    public AddUser setPassword(String password) {
        try {
            map.put(PASSWORD_MD5, MD5.encode(password));
        } catch (NoSuchAlgorithmException e) {
            throw new BacklogException(e);
        }

        return this;
    }

    public AddUser setName(String name) {
        map.put(NAME, name);

        return this;
    }

    public String getName() {
        return (String) map.get(NAME);
    }

    public AddUser setMailAddress(String mailAddress) {
        map.put(MAIL_ADDRESS, mailAddress);

        return this;
    }

    public String getMailAddress() {
        return (String) map.get(MAIL_ADDRESS);
    }

    public AddUser setRole(String role) {
        map.put(ROLE, role);

        return this;
    }

    public String getRole() {
        return (String) map.get(ROLE);
    }

    public AddUser setMail(Boolean mail) {
        Map<String, Object> mailSetting = (Map<String, Object>) map.get(MAIL_SETTING);
        if (mailSetting == null) {
            mailSetting = new HashMap<String, Object>(5);
            map.put(MAIL_SETTING, mailSetting);
        }

        mailSetting.put(MAIL, mail);

        return this;
    }

    public String getMail() {
        Map<String, Object> mailSetting = (Map<String, Object>) map.get(MAIL_SETTING);
        if (mailSetting == null) {
            return null;
        }

        return (String) mailSetting.get(MAIL);

    }

    public AddUser setComment(Boolean mail) {
        Map<String, Object> mailSetting = (Map<String, Object>) map.get(MAIL_SETTING);
        if (mailSetting == null) {
            mailSetting = new HashMap<String, Object>(5);
            map.put(MAIL_SETTING, mailSetting);
        }

        mailSetting.put(COMMENT, mail);

        return this;
    }

    public String getComment() {
        Map<String, Object> mailSetting = (Map<String, Object>) map.get(MAIL_SETTING);
        if (mailSetting == null) {
            return null;
        }

        return (String) mailSetting.get(COMMENT);
    }

    public AddUser setIconType(String type) {
        Map<String, Object> icon = (Map<String, Object>) map.get(ICON);
        if (icon == null) {
            icon = new HashMap<String, Object>(5);
            map.put(ICON, icon);
        }

        icon.put(TYPE, type);

        return this;
    }

    public String getIconType() {
        Map<String, Object> icon = (Map<String, Object>) map.get(ICON);
        if (icon == null) {
            return null;
        }

        return (String) icon.get(TYPE);
    }

    public AddUser setIconDate(String data) {
        Map<String, Object> icon = (Map<String, Object>) map.get(ICON);
        if (icon == null) {
            icon = new HashMap<String, Object>(5);
            map.put(ICON, icon);
        }

        icon.put(DATA, data);

        return this;
    }

    public String getIconData() {
        Map<String, Object> icon = (Map<String, Object>) map.get(ICON);
        if (icon == null) {
            return null;
        }

        return (String) icon.get(DATA);
    }

    private void checkParameters() {
        if (getUserId() == null) {
            throw new BacklogException("userId is required");
        }
        if (map.get(PASSWORD_MD5) == null) {
            throw new BacklogException("password is required");
        }
        if (getName() == null) {
            throw new BacklogException("name is required");
        }
        if (getMailAddress() == null) {
            throw new BacklogException("mailAddress is required");
        }
        if (getRole() == null) {
            throw new BacklogException("role is required");
        }
    }

    @Override
    public UserEx execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_ADMIN_ADD_USER, map);

        return new UserEx((Map<String, Object>) res);
    }
}