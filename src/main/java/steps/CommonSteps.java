package steps;

import emuns.SortingOrder;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webelements.Checkbox;
import org.openqa.selenium.By;
import pageComponents.LeftMenu;

import static emuns.SortingOrder.getSortingOrder;

@Slf4j
public class CommonSteps extends DefaultStepsData {

    @Step
    public boolean isMenuAvatarVisibleNow() {
        return new LeftMenu(dashboardPage.getLeftMenuBlock()).getAvatar().isCurrentlyVisible();
    }

    @Step
    public boolean getCheckBoxStatus(String checkBoxName) {
        WebElementFacade checkBox = dashboardPage.getCheckBoxByName(checkBoxName);
        Checkbox checkbox = new Checkbox(checkBox);
        return checkbox.isChecked();
    }

    @Step
    public void refreshPage() {
        dashboardPage.refreshPage();
    }

    @Step
    public void navigateToThePage(String pageName) {
        LeftMenu leftMenuElement = new LeftMenu(dashboardPage.getLeftMenuBlock());
        log.info("Navigating to: " + pageName + " page");
        leftMenuElement.goToPage(pageName);
        dashboardPage.waitUntilSpinnerGone(15);
    }

    @Step
    public void sortColumn(final String columnName, String sortingOrder) {
        SortingOrder order = getSortingOrder(sortingOrder);
        log.info(String.format("Sorting column %s by %s", columnName, sortingOrder));
        WebElementFacade columnHeader = dashboardPage.find(By.xpath("//th[contains(@class,'sortable') and text()[normalize-space() = '" + columnName + "']]"));
        switch (order) {
            case ASC:
                columnHeader.click();
                dashboardPage.waitUntilSpinnerGone(10);
                if (columnHeader.findElement(By.xpath(".//i")).getAttribute("innerText").equals("arrow_upward")) {
                    break;
                } else {
                    columnHeader.findElement(By.xpath(".//i")).click();
                }
            case DESC:
                columnHeader.click();
                dashboardPage.waitUntilSpinnerGone(10);
                if (columnHeader.findElement(By.xpath(".//i")).getAttribute("innerText").equals("arrow_downward")) {
                    break;
                } else {
                    columnHeader.findElement(By.xpath(".//i")).click();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sortingOrder);
        }
    }
}
