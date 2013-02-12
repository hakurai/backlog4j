package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface VersionList extends List<Version> {

    Version getById(Integer id);

    Version getByName(String name);
}
