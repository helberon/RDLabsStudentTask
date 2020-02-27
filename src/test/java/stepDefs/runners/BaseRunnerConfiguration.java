package stepDefs.runners;

import net.serenitybdd.core.environment.WebDriverConfiguredEnvironment;
import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;
import resources.Constants;

import static net.thucydides.core.ThucydidesSystemProperty.SERENITY_LOGGING;
import static net.thucydides.core.ThucydidesSystemProperty.WEBDRIVER_BASE_URL;
import static net.thucydides.core.ThucydidesSystemProperty.WEBDRIVER_DRIVER;
import static net.thucydides.core.ThucydidesSystemProperty.WEBDRIVER_PROVIDED_TYPE;

//https://johnfergusonsmart.com/running-individual-scenarios-jbehave-cucumber-serenity-bdd/
//https://github.com/serenity-bdd/serenity-documentation/blob/master/src/asciidoc/advanced-webdriver.adoc

public class BaseRunnerConfiguration extends SerenityStories {

    private Configuration configuration;
    private EnvironmentVariables environmentVariables;

    public BaseRunnerConfiguration() {
        environmentVariables = WebDriverConfiguredEnvironment.getEnvironmentVariables();
        configuration = this.getSystemConfiguration();
        configuration.setIfUndefined(WEBDRIVER_DRIVER.getPropertyName(), "provided");
        configuration.setIfUndefined(WEBDRIVER_PROVIDED_TYPE.getPropertyName(), "mydriver");
        configuration.setIfUndefined("webdriver.provided.mydriver", "driverFactory.DriverManager");
        environmentVariables.setProperty(WEBDRIVER_BASE_URL.getPropertyName(), Constants.BASE_URL);
        configuration.setIfUndefined(SERENITY_LOGGING.getPropertyName(), "QUIET");
    }
}
