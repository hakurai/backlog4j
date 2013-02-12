package backlog4j;

/**
 * @author eguchi
 */
public interface Milestone extends Identifired, Named {

    String getDate();

    StatusList getStatuses();
}
