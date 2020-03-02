package steps;

import emuns.ItemsContainer;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

@Slf4j
public class DashboardPageSteps extends DefaultStepsData {

    @Step
    public String getDashBoardPageTitle() {
        return dashboardPage.getTitle();
    }

    @Step
    public String getAccountNameFromDashboard() {
        return dashboardPage.getAccountNameLabel().getText();
    }

    @Step
    public void clickOnHideMenuButton() {
        dashboardPage.clickOnHideMenuButton();
    }

    @Step
    public void expandContainerClickingOnThreeDots(String sectionName) {
        ItemsContainer itemsContainer = ItemsContainer.getItemsContainerName(sectionName);
        switch (itemsContainer) {
            case EMPLOYEE_DISTRIBUTION:
                dashboardPage.getThreeDotsButton().waitUntilEnabled().click();
                break;
            case LEAVE_TAKEN:
                dashboardPage.getThreeDotsButtonSecond().waitUntilEnabled().click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + itemsContainer);
        }
    }

    public boolean checkThatLegendAppearsIn(String sectionName) {
        ItemsContainer itemsContainer = ItemsContainer.getItemsContainerName(sectionName);
        switch (itemsContainer) {
            case EMPLOYEE_DISTRIBUTION:
                return dashboardPage.getEmployeeLegend().isVisible();
            case LEAVE_TAKEN:
                return dashboardPage.getLeavesLegend().isVisible();
            default:
                throw new IllegalStateException("Unexpected value: " + itemsContainer);
        }
    }

    public int getRealCounter(String sectionName){
        ItemsContainer itemsContainer = ItemsContainer.getItemsContainerName(sectionName);
        switch (itemsContainer){
            case DOCUMENTS:
                return dashboardPage.getDocumentsContainer().thenFindAll(By.xpath("//li[contains(@id,'docTitle_.')]")).size();
            case NEWS:
                return dashboardPage.getNewsContainer().thenFindAll(By.xpath("//div[@id='dashboard__viewNewsOnDashboard']//li[@class='collection-item avatar']")).size();
            default:
                throw new IllegalStateException("Unexpected value: " + itemsContainer);

        }

    }

    public int getExpectedCounter(String sectionName){
        ItemsContainer itemsContainer = ItemsContainer.getItemsContainerName(sectionName);
        String rawWithExpectedCounter;
        switch(itemsContainer) {
            case DOCUMENTS:
                rawWithExpectedCounter = dashboardPage.getShownDocuments().getText().split("/")[1].trim();
                return Integer.parseInt(rawWithExpectedCounter);
            case NEWS:
                 rawWithExpectedCounter = dashboardPage.getShownNews().getText().split("/")[1].trim();
                return Integer.parseInt(rawWithExpectedCounter);
            default:
                throw new IllegalStateException("Unexpected value: " + itemsContainer);
        }
    }
}
