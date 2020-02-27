package pageComponents;

import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

@Getter
public class PopUp {

    private WebElementFacade popUp;

    public PopUp(WebElementFacade popUp) {
        this.popUp = popUp;
    }

    public String getPopUpMessage() {
        return popUp.find(By.xpath("//div[@class='toast-message']")).getText();
    }
}
