package emuns;

import lombok.Getter;

@Getter
public enum SortingOrder {

    ASC("asc"),
    DESC("desc");

    public final String var;

    SortingOrder(String var) {
        this.var = var;
    }

    public static SortingOrder getSortingOrder(String order) {
        for (SortingOrder sortingOrder : SortingOrder.values()) {
            if (sortingOrder.getVar().equalsIgnoreCase(order)) {
                return sortingOrder;
            }
        }
        throw new IllegalStateException("Wrong parameter passed");
    }
}
