package pageComponents;

import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;

@Getter
public class NewsContainer extends ItemsContainer {

    public NewsContainer(WebElementFacade container) {
        super(container);
    }
}
