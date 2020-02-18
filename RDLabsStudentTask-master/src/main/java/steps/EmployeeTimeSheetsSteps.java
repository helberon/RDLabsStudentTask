package steps;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.NoSuchFrameException;

import javax.sound.midi.Soundbank;
import java.time.Duration;

@Getter
@Slf4j
public class EmployeeTimeSheetsSteps extends DefaultStepsData {

    @Step
    public void searchByEmployeeName(String name) {
        try {
            employeeTimeSheetsPage.switchToIFrame();
        } catch (NoSuchFrameException exeption) {
            System.out.println("No such frame");
        }
        employeeTimeSheetsPage.getSearchInputField().waitUntilEnabled().click();
        employeeTimeSheetsPage.getSearchInputField().clear();
        log.info("Searching by name: " + name);
        employeeTimeSheetsPage.getSearchInputField().sendKeys(name);
    }

    @Step
    public String getTextFromAutoCompleteNameField() {
        return employeeTimeSheetsPage.getEmployeeNameAutoCompleteElement().withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible().getText();
    }
}
