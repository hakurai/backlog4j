package backlog4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public final class ProjectSummary {

    private final Integer id;
    private final String name;
    private final String key;
    private final String url;
    private final List<Status> statuses;
    private final List<Milestone> milestones;
    private final Milestone currentMilestone;

    public ProjectSummary(Map<String, Object> map) {
        id = (Integer) map.get("id");
        name = (String) map.get("name");
        key = (String) map.get("key");
        url = (String) map.get("url");

        statuses = XmlRpcUtil.toList(Status.class, map.get("statuses"));
        milestones = XmlRpcUtil.toList(Milestone.class, map.get("milestones"));

        currentMilestone = Milestone.create((Map<String, Object>) map.get("current_milestone"));

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public String getUrl() {
        return url;
    }

    public List<Status> getStatuses() {
        return new ArrayList<Status>(statuses);
    }

    public List<Milestone> getMilestones() {
        return new ArrayList<Milestone>(milestones);
    }

    public Milestone getCurrentMilestone() {
        return currentMilestone;
    }
}
