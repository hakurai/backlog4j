package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface CategoryList extends List<Category> {

    Category getById(Integer id);

    Category getByName(String name);
}
