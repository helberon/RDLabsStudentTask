package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

@Getter
@Slf4j
public abstract class BasePage extends PageObject {

    @FindBy(xpath = "//title")
    protected WebElementFacade pageTitle;

    @FindBy(css = "#left-menu")
    protected WebElementFacade leftMenuBlock;

    @FindBy(css = "#preloader")
    protected WebElementFacade spinner;

    @FindBy(css = "#systemUser_list_search_modal")
    protected WebElementFacade filterUsersModalWindow;

    @FindBy(css = ".toast")
    private WebElementFacade popUpElement;

    public void openLoginPage() {
        LoginPage loginPage = new LoginPage().setDriver(this.getDriver());
        loginPage.open();
    }

    public boolean isPageTitleCorrect(String expectedPageTitle) {
        return this.pageTitle.getText().equals(expectedPageTitle);
    }

    public WebElementFacade getCheckBoxByName(final String checkBoxName) {
        return find(By.xpath("//label[text()='" + checkBoxName + "']/../input"));
    }

//    public void waitUntilSpinnerGone() {
//        waitUntilSpinnerGone(5);
//    }

    public void waitUntilSpinnerGone(int seconds) {
        log.info("Waiting until spinner gone for: " + seconds + " seconds");
        spinner.withTimeoutOf(Duration.ofSeconds(seconds)).waitUntilNotVisible();
    }

    public void refreshPage() {
        log.info("Refreshing page...");
        getDriver().navigate().refresh();
        waitUntilSpinnerGone(10);
    }

    public void moveToElement(WebElement element, WebDriver driver) {
        log.info("Moving to element " + element);
        new Actions(driver).moveToElement(element).build().perform();
    }

    private JavascriptExecutor getJavaScriptExecutor(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public void clickOnElementWithJSExecutor(WebDriver driver, WebElementFacade webElement) {
        log.info("Clicking with java script executor");
        getJavaScriptExecutor(driver).executeScript("arguments[0].click();", webElement);
    }

    public WebElementFacade getPopUpElement() {
        return withTimeoutOf(Duration.ofSeconds(10)).waitFor(popUpElement);
    }

    public void switchToIFrame(){
        getDriver().switchTo().frame("noncoreIframe");
    }

}
