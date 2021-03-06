package stepDefs;

import com.google.common.collect.Ordering;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import steps.DefaultStepsData;
import steps.PersonalDetailsSteps;

import java.util.List;

import static utils.DateUtils.DATEPATTERN_FULL;
import static utils.DateUtils.getDateInFutureOrPastFromNow;
import static utils.SessionVariables.DATE_OF_BIRTH;

public class PersonalDatailsStepDef extends DefaultStepsData {

    @Steps
    PersonalDetailsSteps personalDetailsSteps;

    @Then("I save current Date of Birth to session")
    public void saveCurrentDateOfBirthToSession() {
        DATE_OF_BIRTH.put(personalDetailsSteps.getValueFromDateOfBirthField());
    }

    @When("I change Date of Birth added 1 day to old date")
    public void changeDateOfBirth() {
        String currentDate = personalDetailsSteps.getValueFromDateOfBirthField();
        String updatedDate = getDateInFutureOrPastFromNow(DATEPATTERN_FULL, 1, currentDate);
        personalDetailsSteps.enterDateIntoDateBirthField(updatedDate);
    }

    @Then("Date of Birth field contains old date (date from session)")
    public void checkThatDateOfBirthNotChange() {
        String currentDate = personalDetailsSteps.getValueFromDateOfBirthField();
        softly.assertThat(currentDate).as("After refreshing Date of Birth change").isEqualTo(DATE_OF_BIRTH.get());
    }

    @Then("I check that all countries in Nationality select box ordered by name asc")
    public void checkOrderingInNationalitySelectBox() {
        List<String> optionsFromNationalitySelect = personalDetailsSteps.getOptionsFromNationalitySelect();
        boolean isSorted = Ordering.natural().isOrdered(optionsFromNationalitySelect);
        softly.assertThat(isSorted).as("Wrong ordering inside select box").isTrue();
    }

    @Then("I check that current radio button is $genderName")
    @Alias("I check that $genderName radio button selected")
    public void verifyCheckedRadioButtonState(String genderName){
        softly.assertThat(personalDetailsSteps.checkRadioButtonStatus(genderName)).as("Wrong state this").isTrue();
    }

    @Then("$genderName radio button become unchecked")
    public void verifyUncheckedButtonState(String genderName){
        softly.assertThat(personalDetailsSteps.checkRadioButtonStatus(genderName)).as("Wrong state").isFalse();
    }

    @When("I click on $genderName radio button")
    public void radioButtonClick(String genderName){
        personalDetailsSteps.clickOnRadioButton(genderName);
    }

    @When("I change Date of Birth added 1 day to today's day")
    public void changeDateOfBirthToToday(){
       String today = getDateInFutureOrPastFromNow(DATEPATTERN_FULL,1);
        personalDetailsSteps.enterDateIntoDateBirthField(today);
    }

    @Then("'$errorMessage' error message appears")
    public void verifyWrongDateOfBirthAlert(String errorMessage){
        softly.assertThat(personalDetailsPage.getDateOfBirthErrorMessage().getText()).as("Message wasn't shown").isEqualTo(errorMessage);
    }

    @Then("I choose default value from EEO Race and Ethnicity field")
    public void selectOptionFromEEORaceAndEthnicityList(){
        personalDetailsSteps.selectDefaultValueFromEeoRaceAndEthnicitySelect();
    }

    @When("I click on Save button")
    public void clickOnSaveButton(){
        personalDetailsPage.clickSaveButton();
    }

    @Then("error message with text $errorText appears")
    public void verifyRequiredMessage(String errorText){
        softly.assertThat(personalDetailsPage.getEeoRaceAndEthnicityError().getText()).as("Message wasn't shown").isEqualTo(errorText);
    }
}
