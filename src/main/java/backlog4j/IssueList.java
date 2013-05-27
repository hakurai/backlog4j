package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface IssueList extends List<Issue> {

    Issue getById(Integer id);

    Issue getByKey(String key);

}
