package steps;

import emuns.UsersFilterDropBox;
import grids.UsersGrid;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import pageComponents.FilterUsersModalWindow;

import java.time.Duration;
import java.util.ArrayList;
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
    public FilterUsersModalWindow getFilterUsersWindow() {
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
    public void filterUsers(String filter, String filterTarget) {
        UsersFilterDropBox dropBox = UsersFilterDropBox.getUsersFilterDropBox(filter);
        switch (dropBox) {
            case STATUS:
                FilterUsersModalWindow filterUsersStatusModalWindow = FILTER_USERS_WINDOW.get();
                List<String> statusValues = new ArrayList<String>();
                filterUsersStatusModalWindow.getStatus().click();
                List<WebElementFacade> statusList = filterUsersStatusModalWindow.getStatus().thenFindAll(By.xpath("./..//li"));
                for (WebElementFacade element : statusList) {
                    statusValues.add(element.waitUntilEnabled().waitUntilVisible().getText());
                }
                statusList.get(statusValues.indexOf(filterTarget)).click();
                break;
            case ADMIN_ROLE:
                FilterUsersModalWindow filterUsersRoleModalWindow = FILTER_USERS_WINDOW.get();
                List<String> roleValues = new ArrayList<String>();
                filterUsersRoleModalWindow.getAdminRole().click();
                List<WebElementFacade> roleList = filterUsersRoleModalWindow.getAdminRole().thenFindAll(By.xpath("./..//li"));
                for (WebElementFacade element : roleList) {
                    roleValues.add(element.waitUntilEnabled().waitUntilVisible().getText());
                }
                roleList.get(roleValues.indexOf(filterTarget)).click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dropBox);
        }
    }

    @Step
    public List<UsersGrid> getUsersGrid() {
        log.info("Getting [Users] grid");
        return new UsersGrid().getAllItems(usersPage.getDriver());
    }

    public boolean checkUserPresenceInTable(String userName) {
        List<UsersGrid> allItems = getUsersGrid();
        for (UsersGrid gridElem : allItems) {
            if (gridElem.getEmployeeName().contains(userName)){
                return true;
            }
        }
        return false;
    }

    @Step
    public List<String> checkFilterStatus(){
        FilterUsersModalWindow filterUsersRoleModalWindow = FILTER_USERS_WINDOW.get();
        List<WebElementFacade> allDropBoxes= filterUsersRoleModalWindow.getFormContainer().thenFindAll(By.xpath("./..//input[@class='select-dropdown']"));
        List<String> allStatuses = new ArrayList<>();
        for (WebElementFacade element:allDropBoxes) {
            allStatuses.add(element.getValue());
        }
        return allStatuses;
    }
}
