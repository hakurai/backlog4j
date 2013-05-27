package backlog4j.impl;

import backlog4j.Category;
import backlog4j.CategoryList;

import java.util.List;

/**
 * @author eguchi
 */
public final class CategoryListImpl extends BacklogResponse<Category> implements CategoryList {

    private final List<Category> delegate;

    public CategoryListImpl(List<Category> delegate) {
        this.delegate = delegate;
    }
    @Override
    public List<Category> getDelegate() {
        return delegate;
    }

    @Override
    public Category getById(Integer id) {
        return super.getById(delegate, id);
    }

    @Override
    public Category getByName(String name) {
        return super.getByName(delegate, name);
    }
}
