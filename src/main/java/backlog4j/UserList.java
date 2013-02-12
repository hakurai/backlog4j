package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface UserList extends List<User> {

    User getById(Integer id);

    User getByName(String name);
}
