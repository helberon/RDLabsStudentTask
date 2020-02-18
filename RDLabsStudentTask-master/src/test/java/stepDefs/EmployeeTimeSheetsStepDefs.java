package stepDefs;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import steps.DefaultStepsData;
import steps.EmployeeTimeSheetsSteps;

public class EmployeeTimeSheetsStepDefs extends DefaultStepsData {

    @Steps
    private EmployeeTimeSheetsSteps employeeTimeSheetsSteps;

    @When("I search by part of employee name $name")
    public void searchEmployeeByPartName(String partName) {
        employeeTimeSheetsSteps.searchByEmployeeName(partName);
    }

    @Then("$fullName is shown in auto fill result")
    public void checkThatFullNameInAutoFillResult(String fullName) {
        String autoCompleteName = employeeTimeSheetsSteps.getTextFromAutoCompleteNameField();
        softly.assertThat(autoCompleteName).as("Wrong autocomplete text is shown").contains(fullName);
    }
}
