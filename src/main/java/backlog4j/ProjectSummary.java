package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface ProjectSummary {
    Integer getId();

    String getName();

    String getKey();

    String getUrl();

    List<Status> getStatuses();

    List<Milestone> getMilestones();

    Milestone getCurrentMilestone();
}
