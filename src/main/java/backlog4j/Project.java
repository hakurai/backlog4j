package backlog4j;

/**
 * @author eguchi
 */
public interface Project extends Identifired, Named {

    String getKey();

    String getUrl();

    Boolean isArchived();
}
