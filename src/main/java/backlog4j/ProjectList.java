package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface ProjectList extends List<Project> {

    Project getById(Integer id);

    Project getByName(String name);
}
