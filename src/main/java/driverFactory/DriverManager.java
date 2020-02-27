package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//https://github.com/serenity-bdd/serenity-documentation/blob/master/src/asciidoc/advanced-webdriver.adoc

public class DriverManager implements DriverSource {

    private WebDriver driver;

    public WebDriver newDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public boolean takesScreenshots() {
        return true;
    }
}
