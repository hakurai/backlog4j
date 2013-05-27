package backlog4j;

/**
 * @author eguchi
 */
public interface Project extends identified, Named {

    String getKey();

    String getUrl();

    Boolean isArchived();
    
    Boolean isUseParentChildIssue();
}
