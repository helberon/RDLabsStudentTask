package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

@Getter
@Slf4j
public class UsersPage extends BasePage {

    @FindBy(xpath = "//a[@data-tooltip='Filter']")
    private WebElementFacade filterButton;

    public void clickOnFilterButton() {
        log.info("Clicking on the [Filter button]");
        filterButton.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
        waitUntilSpinnerGone(3);
        filterButton.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible().waitUntilEnabled().waitUntilClickable().click();
    }
}
