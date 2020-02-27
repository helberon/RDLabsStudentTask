package pageComponents;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public abstract class ItemsContainer {

    private WebElementFacade container;

    public ItemsContainer(WebElementFacade container) {
        this.container = container;
    }

    public String getContainerHeaderText() {
        return container.find(By.xpath("//div[@id='newsOnDashboard']/../../div[@class='dashboardCard-title-for-card']")).getAttribute("innerText");
    }

    public String getContainerItemsCounter() {
        return container.find(By.xpath(".//div[@class='document-count-text']//div[@class='right']")).getAttribute("innerText");
    }

    public List<WebElementFacade> getContainerItems() {
        return container.thenFindAll(By.xpath(".//ul//li"));
    }

}
