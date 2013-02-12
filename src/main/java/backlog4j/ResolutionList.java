package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface ResolutionList extends List<Resolution> {

    Resolution getById(Integer id);

    Resolution getByName(String name);
}
