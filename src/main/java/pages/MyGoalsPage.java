package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@Getter
@Slf4j
public class MyGoalsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'fixed-action-btn ')]//i[text()='add']/..")
    private WebElementFacade addButton;

    @FindBy(xpath = "//a[contains(@class, 'red')]")
    private WebElementFacade addGoalButton;

    @FindBy(xpath = "//a[contains(@class, 'blue')]")
    private WebElementFacade addObjectiveButton;

    @FindBy(xpath = "//a[@data-tooltip='Unapproved Goals']")
    private WebElementFacade unupprovedGoalsButton;

    @FindBy(xpath = "//a[@data-tooltip='Filter']")
    private WebElementFacade filterButton;

    @FindBy(xpath = "//a[@data-tooltip='Unapproved Goals']")
    private WebElementFacade unapprovedGoalsButton;

    @FindBy(css = ".toast-message")
    private WebElementFacade unapprovedGoalsInfoMessage;

    public void clickOnAddGoalButton() {
        moveToElement(addButton, getDriver());
        log.info("Clicking on the [Add goal] button");
        addGoalButton.waitUntilVisible().click();
    }

    public void clickOnAddObjectiveButton() {
        moveToElement(addButton, getDriver());
        log.info("Clicking on the [Add goal] button");
        addObjectiveButton.waitUntilVisible().click();
    }

    public void clickOnUnapprovedGoalsButton() {
        log.info("Clicking on the [Unapproved Goals] button");
        unapprovedGoalsButton.waitUntilEnabled().click();
    }
}
