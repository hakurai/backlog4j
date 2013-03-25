package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface ProjectSummary extends identified, Named {

    String getKey();

    String getUrl();

    List<Status> getStatuses();

    List<Milestone> getMilestones();

    Milestone getCurrentMilestone();
}
