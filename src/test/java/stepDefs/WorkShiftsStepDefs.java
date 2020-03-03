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

    @Then("I check Work Shift field is empty")
    public void checkWorkShiftFieldEmpty(){
        softly.assertThat(workShiftsSteps.checkWorkShiftFieldEmpty()).as("Field doesn't empty").isTrue();
    }

    @Then("I click on Save button")
    public void clickOnSaveButton(){
        workShiftsSteps.clickOnSaveButton();
    }

    @Then("check that '$textMessage' message appears under Work Shift field")
    public void checkMessageAppears(String textMessage){
        softly.assertThat(workShiftsSteps.checkInputFieldErrorText()).as("Wrong message").isEqualTo(textMessage);
    }


    @When("pick up $hours:$minutes on From field")
    public void getFromTime(String hours,String minutes){
        workShiftsSteps.fillFromField(hours, minutes);
    }

    @When("pick up $hours:$minutes on To field")
    public void getToTime(String hours,String minutes){
        workShiftsSteps.fillToField(hours, minutes);
    }

    @When("pick up $hours:$minutes on $timeBorder field")
    public void getFromTime(String hours,String minutes, String timeBorder){
        workShiftsSteps.fillTimeField(hours, minutes, timeBorder);
    }

//    @When("pick up $hours:$minutes on $timeBorder field")
//    public void getToTime(String hours,String minutes, String timeBorder){
//        workShiftsSteps.fillTimeField(hours, minutes, timeBorder);
//    }


    @Then("Check that $time value calculated in Hours Per Day field")
    public void checkHoursPerDayCalculatedCorrectness(String time) {
        softly.assertThat(workShiftsSteps.getHoursPerShift()).isEqualTo(time);
    }
}
