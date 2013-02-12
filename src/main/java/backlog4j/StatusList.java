package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface StatusList extends List<Status> {

    Status getById(Integer id);

    Status getByName(String name);
}
