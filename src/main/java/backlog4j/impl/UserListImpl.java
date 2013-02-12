package backlog4j.impl;

import backlog4j.User;
import backlog4j.UserList;

import java.util.List;

/**
 * @author eguchi
 */
public final class UserListImpl extends BacklogResponse<User> implements UserList {

    private final List<User> delegate;

    public UserListImpl(List<User> delegate) {
        this.delegate = delegate;
    }
    @Override
    public List<User> getDelegate() {
        return delegate;
    }

    @Override
    public User getById(Integer id) {
        return super.getById(delegate, id);
    }

    @Override
    public User getByName(String name) {
        return super.getByName(delegate, name);
    }
}
