package stepDefs;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import steps.CommonSteps;
import steps.DefaultStepsData;

public class CommonStepDefs extends DefaultStepsData {

    @Steps
    private CommonSteps commonSteps;

    @Then("check box $checkBoxName is $condition")
    public void checkThatCheckBoxHaveConditionByDefault(String checkBoxName, String condition) {
        if (condition.contains("not")) {
            softly.assertThat(commonSteps.getCheckBoxStatus(checkBoxName))
                    .as("Wrong checkBox status: must be [" + condition + "]").isFalse();
        } else {
            softly.assertThat(commonSteps.getCheckBoxStatus(checkBoxName))
                    .as("Wrong checkBox status: must be [" + condition + "]").isTrue();
        }
    }

    @When("refresh page")
    public void refreshCurrrentPage() {
        commonSteps.refreshPage();
    }

    @When("I go to $pageName page")
    @Given("I go to $pageName page")
    public void goToThePage(String page) {
        commonSteps.navigateToThePage(page);
    }
}
