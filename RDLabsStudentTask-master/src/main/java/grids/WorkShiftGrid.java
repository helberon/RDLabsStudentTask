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
public class WorkShiftGrid extends Grid {

    private Checkbox checkbox;
    private String workShift;
    private String from;
    private String to;
    private String hoursPerDay;
    private WebElement editIcon;
    private WebElement rowElement;

    @Override
    public void initPaths() {
        gridPath = By.xpath("//tbody[@ng-if='!listData.staticBody']");
        rowPath = By.xpath(".//tr");
        cellPath = By.xpath(".//td");
    }

    public WorkShiftGrid() {
        super();
    }

    public WorkShiftGrid(RemoteWebElement webElement) {
        this.rowElement = webElement;
        List<WebElement> cells = rowElement.findElements(cellPath);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<WorkShiftGrid> getAllItems(WebDriver driver) {
        new AnyPage(driver).waitForAngularRequestsToFinish();
        return super.getAllItems(driver);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkShiftGrid that = (WorkShiftGrid) o;
        return Objects.equals(getWorkShift(), that.getWorkShift()) &&
                Objects.equals(getFrom(), that.getFrom()) &&
                Objects.equals(getTo(), that.getTo()) &&
                Objects.equals(getHoursPerDay(), that.getHoursPerDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWorkShift(), getFrom(), getTo(), getHoursPerDay());
    }

    @Override
    public String toString() {
        return "WorkShiftGrid{" +
                "workShift='" + workShift + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", hoursPerDay='" + hoursPerDay + '\'' +
                '}';
    }
}
