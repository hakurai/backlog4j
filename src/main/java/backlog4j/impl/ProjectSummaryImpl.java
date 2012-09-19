package backlog4j.impl;

import backlog4j.Milestone;
import backlog4j.ProjectSummary;
import backlog4j.Status;
import backlog4j.util.XmlRpcUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public final class ProjectSummaryImpl implements ProjectSummary {

    private final Integer id;
    private final String name;
    private final String key;
    private final String url;
    private final List<Status> statuses;
    private final List<Milestone> milestones;
    private final Milestone currentMilestone;

    public ProjectSummaryImpl(Map<String, Object> map) {
        id = (Integer) map.get("id");
        name = (String) map.get("name");
        key = (String) map.get("key");
        url = (String) map.get("url");

        statuses = XmlRpcUtil.<Status>toList(StatusImpl.class, map.get("statuses"));
        milestones = XmlRpcUtil.<Milestone>toList(MilestoneImpl.class, map.get("milestones"));

        currentMilestone = MilestoneImpl.create((Map<String, Object>) map.get("current_milestone"));

    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public List<Status> getStatuses() {
        return new ArrayList<Status>(statuses);
    }

    @Override
    public List<Milestone> getMilestones() {
        return new ArrayList<Milestone>(milestones);
    }

    @Override
    public Milestone getCurrentMilestone() {
        return currentMilestone;
    }
}
