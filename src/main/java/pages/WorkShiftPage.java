package pages;

import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@Getter
public class WorkShiftPage extends BasePage {

    @FindBy(xpath = "//div[@data-tooltip='Add Work Shift']//a")
    private WebElementFacade addWorkShiftButton;

    @FindBy(css = "#modal1.open")
    private WebElementFacade addWorkShiftWindow;

    @FindBy(css = ".picker--opened .picker__box")
    WebElementFacade timePickerLocator;

}
