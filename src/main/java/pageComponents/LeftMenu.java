package pageComponents;

import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class LeftMenu {

    private WebElementFacade menu;
    private WebElementFacade avatar;
    private List<WebElementFacade> levelOneMenuOptions;

    public LeftMenu(WebElementFacade menu) {
        this.menu = menu;
        this.levelOneMenuOptions = menu.thenFindAll(By.xpath("//li[contains(@class,'level1')]"));
        this.avatar = menu.find(By.xpath("//div[@id='menu-profile']"));
    }

    public void goToPage(String page) {
        final String level1MenuItemSelector = "./ancestor::li[contains(@class,'level1')]";
        final String level2MenuItemSelector = "./ancestor::li[contains(@class,'level2')]";
        WebElement searchedMenuItem = menu.findElement(By.xpath("//span[contains(text(),'" + page + "')]/../.."));
        String menuItemClassName = searchedMenuItem.getAttribute("class");

        if (menuItemClassName.contains("level3")) {
            WebElement levelOneMenuItem = searchedMenuItem.findElement(By.xpath(level1MenuItemSelector));
            levelOneMenuItem.click();
            WebElement levelTwoMenuItem = searchedMenuItem.findElement(By.xpath(level2MenuItemSelector));
            levelTwoMenuItem.click();
            WebElement levelThreeMenuItem = levelTwoMenuItem.findElement(By.xpath("//li[contains(@class,'level3')]//span[contains(text(),'" + page + "')]/.."));
            levelThreeMenuItem.click();
        } else if (menuItemClassName.contains("level2")) {
            WebElement levelOneMenuItem = searchedMenuItem.findElement(By.xpath(level1MenuItemSelector));
            levelOneMenuItem.click();
            WebElement levelTwoMenuItem = levelOneMenuItem.findElement(By.xpath("//li[contains(@class,'level2')]//span[contains(text(),'" + page + "')]/.."));
            levelTwoMenuItem.click();
        } else if (menuItemClassName.contains("level1")) {
            WebElement levelOneMenuItem = menu.findElement(By.xpath("//li[contains(@class,'level1')]//span[contains(text(),'" + page + "')]/.."));
            levelOneMenuItem.click();
        }
    }

}
