package stepDefs;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import steps.DefaultStepsData;
import steps.WorkShiftsSteps;

public class WorkShiftsStepDefs extends DefaultStepsData {

    @Steps
    private WorkShiftsSteps workShiftsSteps;

    @When("I click on Add Work Shift button")
    public void clickOnAddWorkShiftButton() {
        workShiftsSteps.clickOnAddWorkShiftButton();
    }

    @Then("I check that $shiftName work shift are shown on work shifts page")
    public void checkWorkShiftPresent(String shiftName){
        softly.assertThat(workShiftsSteps.checkShiftPresenceInTable(shiftName)).as("Such work shift absent").isTrue();
    }
}
