package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface PriorityList extends List<Priority> {

    Priority getById(Integer id);

    Priority getByName(String name);
}
