package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface IssueTypeList extends List<IssueType> {

    IssueType getById(Integer id);

    IssueType getByName(String name);
}
