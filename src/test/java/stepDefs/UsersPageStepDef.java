package stepDefs;

import grids.UsersGrid;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import steps.DefaultStepsData;
import steps.UsersSteps;

import java.util.List;
import java.util.Map;

import static utils.SessionVariables.*;

public class UsersPageStepDef extends DefaultStepsData {

    @Steps
    private UsersSteps usersSteps;

    @When("filter users by Employee Name $userName")
    public void filterUsersByEmployeeName(String employeeName) {
        usersSteps.filterUsersByEmployeeName(employeeName);
    }

    @When("filter users by '$filter' '$filterTarget'")
    public void filterUsers(String filter, String filterTarget){
        usersSteps.filterUsers(filter, filterTarget);
    }

    @Then("record is shown with following parameters:$table")
    public void checkResultOfFiltering(ExamplesTable examplesTable) {
        Map<String, String> row = examplesTable.getRow(0);
        List<UsersGrid> allItems = usersSteps.getUsersGrid();
        softly.assertThat(allItems).as("Wrong search result size is shown").hasSize(1);
        softly.assertThat(allItems.get(0).getUserName()).as("Wrong [Username] is shown").isEqualTo(row.get("Username"));
        softly.assertThat(allItems.get(0).getUserRole()).as("Wrong [User Role(s)] is shown").isEqualTo(row.get("User Role(s)"));
        softly.assertThat(allItems.get(0).getEmployeeName()).as("Wrong [Employee Name] is shown").isEqualTo(row.get("Employee Name"));
        softly.assertThat(allItems.get(0).getStatus()).as("Wrong [Status] is shown").isEqualTo(row.get("Status"));
        softly.assertThat(allItems.get(0).getRegions()).as("Region field is not empty").isEqualTo(row.get("Region"));
    }

    @When("I open filter users window")
    @Then("I open filter users window")
    public void openFilterUsersWindow() {
        usersSteps.openFilterWindow();
    }

    @When("I click on the Search button in Filter Users window")
    public void clickOnTheSearchButtonInFilterUsersWindow() {
        usersSteps.clickOnTheSearchButton();
    }

    @Then("I check that Employee with name $userName is NOT shown in the search result")
    public void checkEmployeeAbsentInSearchResult(String userName){
        softly.assertThat(usersSteps.checkUserPresenceInTable(userName)).as("Wasn't found any raw").isFalse();
    }

    @Then("I check that Employee with name $userName is shown in the search result")
    public void checkEmployeePresentInSearchResult(String userName){
        softly.assertThat(usersSteps.checkUserPresenceInTable(userName)).as("Wasn't found any raw").isTrue();
    }

    @When("I check current state of filters")
    public void checkFilterState(){
        FILTER_USERS_DROP_BOX.put(usersSteps.checkFilterStatus());

    }

    @Then("check filters stay same")
    public void checkFiltersStaySame(){
        softly.assertThat(usersSteps.checkFilterStatus()).as("Filer was changed").isEqualTo(FILTER_USERS_DROP_BOX.get());
    }
}
