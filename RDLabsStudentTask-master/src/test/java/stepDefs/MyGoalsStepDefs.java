package stepDefs;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import steps.DefaultStepsData;
import steps.MyGoalsSteps;

public class MyGoalsStepDefs extends DefaultStepsData {

    @Steps
    private MyGoalsSteps myGoalsSteps;

    @When("I click on Unapproved Goals button")
    public void clickOnUnapprovedGoalsButton() {
        myGoalsSteps.clickOnUnapprovedGoalsButton();
    }

    @Then("$message message is shown on the page")
    public void checkErrorMessageText(String message) {
        softly.assertThat(myGoalsSteps.getUnapprovedGoalsInfoMessageText())
                .as("Wrong text is shown").isEqualTo(message);
    }

    @When("I hover mouse over Add button")
    public void hoverMouseOverButton() {
        myGoalsSteps.hoverMouseOverAddButton();
    }

    @Then("$buttonName button become visible")
    public void checkThatButtonVisible(String buttonName) {
        myGoalsSteps.checkThatButtonIsVisible(buttonName);
    }
}
