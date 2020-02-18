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

    public int countDocuments(){
        return dashboardPage.getDocumentsContainer().thenFindAll(By.xpath("//li[contains(@id,'docTitle_.')]")).size();
    }

    public int getDocumentsounter(){
        int counter=0;
        String docs= dashboardPage.getDocumentsContainer().findElement(By.xpath("//div[@class='document-count-text']/div[@class='right']")).getText().split("/")[1].trim();
        return Integer.parseInt(docs);
    }
}
