package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface Milestone {
    Integer getId();

    String getName();

    String getDate();

    List<Status> getStatuses();
}
