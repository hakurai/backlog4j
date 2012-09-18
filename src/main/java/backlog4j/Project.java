package backlog4j;

/**
 * @author eguchi
 */
public interface Project {
    Integer getId();

    String getName();

    String getKey();

    String getUrl();

    Boolean isArchived();
}
