package backlog4j.admin.impl;

import backlog4j.User;
import backlog4j.admin.MailSetting;
import backlog4j.impl.UserImpl;

import java.util.Map;

/**
 * @author eguchi
 */
public final class UserEx implements User {

    private final User delegate;
    private final String userId;
    private final String mailAddress;
    private final String role;
    private final MailSetting mailSetting;
    private final String createdOn;

    public UserEx(Map<String, Object> map) {
        delegate = UserImpl.create(map);

        userId = (String) map.get("user_id");
        mailAddress = (String) map.get("mail_address");
        role = (String) map.get("role");
        mailSetting = MailSettingImpl.create(map);
        createdOn = (String) map.get("created_on");

    }

    @Override
    public Integer getId() {
        return delegate.getId();
    }

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public String getLang() {
        return delegate.getLang();
    }

    @Override
    public String getUpdatedOn() {
        return delegate.getUpdatedOn();
    }

    public User getDelegate() {
        return delegate;
    }

    public String getUserId() {
        return userId;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getRole() {
        return role;
    }

    public MailSetting getMailSetting() {
        return mailSetting;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEx userEx = (UserEx) o;

        if (delegate != null ? !delegate.equals(userEx.delegate) : userEx.delegate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return delegate != null ? delegate.hashCode() : 0;
    }
}
