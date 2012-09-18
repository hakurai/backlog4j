package backlog4j.impl;

import backlog4j.Milestone;
import backlog4j.Status;
import backlog4j.util.XmlRpcUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public final class MilestoneImpl implements Milestone {

    private final Integer id;
    private final String name;
    private final String date;
    private final List<Status> statuses;

    public MilestoneImpl(Map<String, Object> map) {
        assert (map.size() > 2);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
        date = (String) map.get("date");

        Object statusesSrc = map.get("statuses");
        if (statusesSrc != null) {
            statuses = XmlRpcUtil.<Status>toList(StatusImpl.class, statusesSrc);
        } else {
            statuses = Collections.emptyList();
        }

    }

    public static Milestone create(Map<String, Object> map) {
        return map == null ? null : new MilestoneImpl(map);
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
    public String getDate() {
        return date;
    }

    @Override
    public List<Status> getStatuses() {
        return new ArrayList<Status>(statuses);
    }

    @Override
    public String toString() {
        return "Milestone{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}
