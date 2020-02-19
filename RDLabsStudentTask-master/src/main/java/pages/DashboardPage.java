package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@Getter
@Slf4j
public class DashboardPage extends BasePage {

    public static final String PAGE_TITLE = "OrangeHRM";

    @FindBy(css = "#account-name")
    private WebElementFacade accountNameLabel;

    @FindBy(xpath = "//a[@id='side-menu-hamburger']")
    private WebElementFacade hideMenuButton;

    @FindBy(css = "#dashboard__viewNewsOnDashboard")
    private WebElementFacade newsContainer;

    @FindBy(css = "#dashboard__viewDocumentsOnDashboard")
    private WebElementFacade documentsContainer;

    @FindBy(css = ".card-content .material-icons")
    private WebElementFacade threeDotsButton;

    @FindBy(css = "#panel_draggable_0_5 .material-icons")
    private WebElementFacade threeDotsButtonSecond;

    @FindBy(css = "#task-list-group-panel-menu_holder-legend")
    private WebElementFacade employeeLegend;

    @FindBy(css = "#legend")
    private WebElementFacade leavesLegend;

    @FindBy(xpath = "//div[@id='dashboard__viewDocumentsOnDashboard']//div[@class='document-count-text']/div[@class='right']")
    private WebElementFacade shownDocuments;

    @FindBy(xpath = "//div[@id='dashboard__viewNewsOnDashboard']//div[@class='document-count-text']/div[@class='right']")
    private WebElementFacade shownNews;

    public void clickOnHideMenuButton() {
        log.info("Clicking on the [Hide menu] button");
        hideMenuButton.waitUntilVisible().waitUntilClickable().click();
    }

}
