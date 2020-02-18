package steps;

import grids.UsersGrid;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import pageComponents.FilterUsersModalWindow;

import java.time.Duration;
import java.util.List;

import static utils.SessionVariables.FILTER_USERS_WINDOW;

@Slf4j
public class UsersSteps extends DefaultStepsData {

    @Step
    public void openFilterWindow() {
        log.info("Opens Filter Users window");
        usersPage.clickOnFilterButton();
        FILTER_USERS_WINDOW.put(new FilterUsersModalWindow(usersPage.getFilterUsersModalWindow()));
    }

    @Step
    public FilterUsersModalWindow getFiltetUsersWindow() {
        return new FilterUsersModalWindow(usersPage.getFilterUsersModalWindow());
    }

    @Step
    public void clickOnTheSearchButton() {
        log.info("Clicking on the Search button");
        FilterUsersModalWindow filterUsersModalWindow = FILTER_USERS_WINDOW.get();
        filterUsersModalWindow.clickOnSearchButton();
    }

    @Step
    public void filterUsersByEmployeeName(String employeeName) {
        FilterUsersModalWindow filterUsersModalWindow = FILTER_USERS_WINDOW.get();
        log.info("Filtering by Employee Name: " + employeeName);
        log.info("Typing employee name into [Employee Name] input field");
        filterUsersModalWindow.getEmployeeNameField().waitUntilEnabled().sendKeys(employeeName);
        WebElementFacade employeeDropDown = filterUsersModalWindow.getEmployeeNameField().withTimeoutOf(Duration.ofSeconds(5)).find(By.xpath("./..//div[contains(@class,'angucomplete-row')]"));
        log.info("Clicking on the autocomplete search result");
        employeeDropDown.waitUntilVisible().waitUntilClickable().click();
        employeeDropDown.waitUntilNotVisible();
    }

    @Step
    public List<UsersGrid> getUsersGrid() {
        log.info("Getting [Users] grid");
        return new UsersGrid().getAllItems(usersPage.getDriver());
    }
}
