package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface SelectCustomField {

    Boolean isAllowInput();

    List<Item> getItems();
}
