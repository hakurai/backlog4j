package backlog4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public final class FindIssueOrder {

    public static final String SORT_ISSUE_TYPE = "ISSUE_TYPE";
    public static final String SORT_SUMMARY = "SUMMARY";
    public static final String SORT_STATUS = "STATUS";
    public static final String SORT_PRIORITY = "PRIORITY";
    public static final String SORT_CREATED = "CREATED";
    public static final String SORT_UPDATED = "UPDATED";
    public static final String SORT_DUE_DATE = "DUE_DATE";
    public static final String SORT_CUSTOM_FIELD_ = "CUSTOM_FIELD_";

    private final String sort;
    private final boolean order; // true: accending
    private final int offset;
    private final int limit;  //0~100

    public FindIssueOrder(String sort, boolean order, int offset, int limit) {
        this.sort = sort;
        this.order = order;
        this.offset = offset;
        this.limit = limit;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        if (sort != null) {
            map.put("sort", sort);
        }
        map.put("order", order);
        map.put("offset", offset);
        map.put("limit", limit);

        return map;
    }
}
