package pageComponents;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

@Getter
@Slf4j
public class AddWorkShiftModalWindow {

    private WebElementFacade addWorkShiftModal;
    private WebElementFacade saveButton;
    private WebElementFacade cancelButton;
    private WebElementFacade workShiftNameInputField;
    private WebElementFacade fromInputField;
    private WebElementFacade fromClockIcon;
    private WebElementFacade toInputField;
    private WebElementFacade toClockIcon;
    private WebElementFacade hoursPerDayInputField;

    public AddWorkShiftModalWindow(WebElementFacade addWorkShiftModal) {
        this.addWorkShiftModal = addWorkShiftModal;
        this.saveButton = addWorkShiftModal.find(By.xpath(".//a[text()='Save']"));
        this.cancelButton = addWorkShiftModal.find(By.xpath(".//a[text()='Cancel']"));
        this.workShiftNameInputField = addWorkShiftModal.find(By.xpath(".//input[@id='name']"));
        this.fromInputField = addWorkShiftModal.find(By.xpath(".//input[@id='start_time']"));
        this.fromClockIcon = fromInputField.find(By.xpath("./..//i[contains(@class,'time-picker-open-icon')]"));
    }
}
