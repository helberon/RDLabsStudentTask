package emuns;

import lombok.Getter;

@Getter
public enum UsersFilterDropBox {
    STATUS("Status"),
    ADMIN_ROLE("Admin Role");

    public String var;

    UsersFilterDropBox(String var) {
        this.var = var;
    }

    public static UsersFilterDropBox getUsersFilterDropBox(String dropBoxName) {
        for (UsersFilterDropBox dropBox : UsersFilterDropBox.values()) {
            if (dropBox.getVar().equalsIgnoreCase(dropBoxName)) {
                return dropBox;
            }
        }
        throw new IllegalStateException("Wrong parameter passed");
    }
}
