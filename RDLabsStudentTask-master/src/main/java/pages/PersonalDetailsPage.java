package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@Getter
@Slf4j
public class PersonalDetailsPage extends BasePage {

    @FindBy(css = "#personal_details_tab h4")
    private WebElementFacade personalDetailsHeader;

    @FindBy(css = "#emp_birthday")
    private WebElementFacade dateOfBirthInputField;

    @FindBy(xpath = "//input[@id='emp_birthday']/following-sibling::span[@class='help-block-message']")
    private WebElementFacade dateOfBirthErrorMessage;

    @FindBy(xpath = "//div[@id='nation_code_inputfileddiv']//input")
    private WebElementFacade nationalitySelect;

    @FindBy(xpath = "//div[@id='eeo_race_ent_inputfileddiv']//input")
    private WebElementFacade eeoRaceAndEthnicitySelect;

    @FindBy(xpath = "//div[@id='eeo_race_ent_inputfileddiv']//span[@class='help-block']")
    private WebElementFacade eeoRaceAndEthnicityError;

    @FindBy(xpath = "//label[@for='emp_gender_1']")
    private WebElementFacade maleRadioButtonFrame;

    @FindBy(xpath = "//label[@for='emp_gender_2']")
    private WebElementFacade femaleRadioButtonFrame;

    @FindBy(xpath = "//form[@id='pimPersonalDetailsForm']//button[@type='submit']")
    private WebElementFacade saveButtonPersonalDetails;


    public void enterDateOfBirth(String date) {
        log.info(String.format("Putting %s date into [Date of birth] field", date));
        dateOfBirthInputField.clear();
        dateOfBirthInputField.waitUntilEnabled().sendKeys(date);
        dateOfBirthInputField.submit();
    }

    public void clickOnMaleRadioButton() {
        log.info("set Male radio button checked");
        maleRadioButtonFrame.waitUntilVisible().waitUntilClickable().click();
    }

    public void clickSaveButton(){
        saveButtonPersonalDetails.submit();
    }
}
