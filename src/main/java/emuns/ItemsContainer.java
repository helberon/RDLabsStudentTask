package emuns;

import lombok.Getter;

@Getter
public enum ItemsContainer {

    NEWS("News"),
    DOCUMENTS("Documents"),
    EMPLOYEE_DISTRIBUTION("Employee Distribution by Subunit"),
    LEAVE_TAKEN("Leave Taken from January by Subunit");

    public String var;

    ItemsContainer(String var) {
        this.var = var;
    }

    public static ItemsContainer getItemsContainerName(String containerName) {
        for (ItemsContainer container : ItemsContainer.values()) {
            if (container.getVar().equalsIgnoreCase(containerName)) {
                return container;
            }
        }
        throw new IllegalStateException("Wrong parameter passed");
    }
}
