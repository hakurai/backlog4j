package backlog4j.admin;

import backlog4j.User;
import backlog4j.impl.UserImpl;

import java.util.Map;

/**
 * @author eguchi
 */
public final class UserEx implements User {

    private final User delegate;

    public UserEx(Map<String, Object> map) {
        delegate = UserImpl.create(map);
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


}
