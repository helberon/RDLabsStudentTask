package grids;

import lombok.Getter;
import net.serenitybdd.core.pages.AnyPage;
import net.thucydides.core.webelements.Checkbox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.Objects;

@Getter
public class UsersGrid extends Grid {

    private Checkbox checkbox;
    private String userName;
    private String userRole;
    private String employeeName;
    private String status;
    private String regions;
    private WebElement editIcon;
    private WebElement rowElement;

    @Override
    public void initPaths() {
        gridPath = By.xpath("//tbody[@ng-if='!listData.staticBody']");
        rowPath = By.xpath(".//tr");
        cellPath = By.xpath(".//td");
    }

    public UsersGrid() {
        super();
    }

    public UsersGrid(RemoteWebElement webElement) {
        this.rowElement = webElement;
        List<WebElement> cells = rowElement.findElements(cellPath);
        this.checkbox = new Checkbox(cells.get(0).findElement(By.xpath(".//label")));
        this.userName = cells.get(1).findElement(By.xpath(".//span")).getText();
        this.userRole = cells.get(2).findElement(By.xpath(".//span")).getText();
        this.employeeName = cells.get(3).findElement(By.xpath(".//span")).getText();
        this.status = cells.get(4).findElement(By.xpath(".//span")).getText();
        this.regions = cells.get(5).findElement(By.xpath(".//span")).getText();
        this.editIcon = cells.get(6).findElement(By.xpath("//i"));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UsersGrid> getAllItems(WebDriver driver) {
        new AnyPage(driver).waitForAngularRequestsToFinish();
        return super.getAllItems(driver);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersGrid usersGrid = (UsersGrid) o;
        return Objects.equals(getUserName(), usersGrid.getUserName()) &&
                Objects.equals(getUserRole(), usersGrid.getUserRole()) &&
                Objects.equals(getEmployeeName(), usersGrid.getEmployeeName()) &&
                Objects.equals(getStatus(), usersGrid.getStatus()) &&
                Objects.equals(getRegions(), usersGrid.getRegions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getUserRole(), getEmployeeName(), getStatus(), getRegions());
    }

    @Override
    public String toString() {
        return "UsersGrid{" +
                "userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", status='" + status + '\'' +
                ", regions='" + regions + '\'' +
                '}';
    }
}
