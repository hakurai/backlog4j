package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Category;
import backlog4j.CategoryList;
import backlog4j.impl.CategoryImpl;
import backlog4j.impl.CategoryListImpl;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetComponents implements BacklogCommand<CategoryList> {

    private final BacklogClient client;
    private       Integer       projectId;

    public GetComponents(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public GetComponents setProjectId(Integer projectId) {
        this.projectId = projectId;

        return this;
    }

    public CategoryList execute() {
        if (getProjectId() == null) {
            throw new BacklogException();
        }

        Object res = client.execute(BACKLOG_GET_COMPONENTS, getProjectId());

        List<Category> categoryList = XmlRpcUtil.<Category>toList(CategoryImpl.class, res);
        return new CategoryListImpl(categoryList);
    }
}
