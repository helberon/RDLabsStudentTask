package grids;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Grid<T> {

    protected static By gridPath;
    protected static By rowPath;
    protected static By cellPath;

    public Grid() {
        initPaths();
    }

    public abstract void initPaths();

    @SneakyThrows
    protected T initializeClass(WebElement webElement) {
        return (T) this.getClass().getConstructor(webElement.getClass()).newInstance(webElement);
    }

    public List<T> getAllItems(WebDriver driver) {
        List<WebElement> listRows = driver.findElement(gridPath).findElements(rowPath);
        List<T> allItems = listRows.stream().map(this::initializeClass).collect(Collectors.toList());
        return allItems;
    }
}
