package backlog4j;

/**
 * @author eguchi
 */
public interface Milestone extends identified, Named {

    String getDate();

    StatusList getStatuses();
}
