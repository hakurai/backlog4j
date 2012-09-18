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
public class UpdateUser implements BacklogAdminCommand<UserEx> {

    private final BacklogAdminClient client;
    protected final Map<String, Object> map = new HashMap<String, Object>();

    public UpdateUser(BacklogAdminClient client) {
        this.client = client;
    }

    public UpdateUser setId(Integer id) {
        map.put(ID, id);

        return this;
    }

    public Integer getId() {
        return (Integer) map.get(ID);
    }

    public UpdateUser setPassword(String password) {
        try {
            map.put(PASSWORD_MD5, MD5.encode(password));
        } catch (NoSuchAlgorithmException e) {
            throw new BacklogException(e);
        }

        return this;
    }

    public UpdateUser setName(String name) {
        map.put(NAME, name);

        return this;
    }

    public String getName() {
        return (String) map.get(NAME);
    }

    public UpdateUser setMailAddress(String mailAddress) {
        map.put(MAIL_ADDRESS, mailAddress);

        return this;
    }

    public String getMailAddress() {
        return (String) map.get(MAIL_ADDRESS);
    }

    public UpdateUser setRole(String role) {
        map.put(ROLE, role);

        return this;
    }

    public String getRole() {
        return (String) map.get(ROLE);
    }

    public UpdateUser setMail(Boolean mail) {
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

    public UpdateUser setComment(Boolean mail) {
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

    public UpdateUser setIconType(String type) {
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

    public UpdateUser setIconDate(String data) {
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
        if (getId() == null) {
            throw new BacklogException("id is required");
        }

    }

    @Override
    public UserEx execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_ADMIN_UPDATE_USER, map);

        return new UserEx((Map<String, Object>) res);
    }
}