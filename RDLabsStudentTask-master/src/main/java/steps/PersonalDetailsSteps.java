package steps;

import emuns.GenderRadioButton;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class PersonalDetailsSteps extends DefaultStepsData {

    @Step
    public String getValueFromDateOfBirthField() {
        return personalDetailsPage.getDateOfBirthInputField().getAttribute("value");
    }

    @Step
    public void enterDateIntoDateBirthField(String date) {
        personalDetailsPage.getDateOfBirthInputField().clear();
        personalDetailsPage.enterDateOfBirth(date);
    }

    @Step
    public List<String> getOptionsFromNationalitySelect() {
        List<String> nationalityOptions = personalDetailsPage.getNationalitySelect().thenFindAll(By.xpath("./..//li//span"))
                .stream().map(we -> we.getAttribute("innerText")).collect(Collectors.toList());
        return nationalityOptions;
    }

    @Step
    public boolean checkRadioButtonStatus(String genderName){
        GenderRadioButton genderRadioButton = GenderRadioButton.getGenderRadioButtonName(genderName);
        switch (genderRadioButton){
            case FEMALE:
                return Boolean.parseBoolean(personalDetailsPage.getFemaleRadioButtonFrame().find(By.xpath("./../input")).waitUntilEnabled().getAttribute("checked"));
            case MALE:
                return Boolean.parseBoolean(personalDetailsPage.getMaleRadioButtonFrame().find(By.xpath("./../input")).waitUntilEnabled().getAttribute("checked"));
            default:
                throw new IllegalStateException("Unexpected value: " + genderName);
        }
    }

    @Step
    public void clickOnRadioButton(String genderName){
        GenderRadioButton genderRadioButton = GenderRadioButton.getGenderRadioButtonName(genderName);
        switch (genderRadioButton){
            case FEMALE:
                personalDetailsPage.getFemaleRadioButtonFrame().click();
                break;
            case MALE:
                personalDetailsPage.getMaleRadioButtonFrame().click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + genderName);
        }
    }
}
