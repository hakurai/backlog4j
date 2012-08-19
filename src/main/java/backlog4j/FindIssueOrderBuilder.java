package backlog4j;

/**
 * @author eguchi
 */
public class FindIssueOrderBuilder {
    private String sort;
    private boolean order; // true: accending
    private int offset;
    private int limit;  //0~100

    public FindIssueOrderBuilder() {
    }

    public FindIssueOrderBuilder(String sort, boolean order, int offset, int limit) {
        this.sort = sort;
        this.order = order = true;
        this.offset = offset;
        this.limit = limit = 100;
    }

    public String getSort() {
        return sort;
    }

    public FindIssueOrderBuilder setSort(String sort) {
        this.sort = sort;

        return this;
    }

    public boolean isOrder() {
        return order;
    }

    public FindIssueOrderBuilder setOrder(boolean order) {
        this.order = order;

        return this;
    }

    public int getOffset() {
        return offset;
    }

    public FindIssueOrderBuilder setOffset(int offset) {
        this.offset = offset;

        return this;
    }

    public int getLimit() {
        return limit;
    }

    public FindIssueOrderBuilder setLimit(int limit) {
        this.limit = limit;

        return this;
    }

    public FindIssueOrder build() {
        return new FindIssueOrder(getSort(), isOrder(), getOffset(), getLimit());
    }
}
