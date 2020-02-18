package steps;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class LoginPageSteps extends DefaultStepsData {

    @Step
    public void loginToApplication(String userName, String password) {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
    }

    @Step
    public String getErrorMessageAfterLogin() {
        log.info("Getting error message after unsuccessful login to application");
        return loginPage.getEmptyFieldErrorMessage().waitUntilVisible().getText();
    }

    @Step
    public void clickOnTheLoginAsDifferentRoleButton() {
        loginPage.clickOnTheLoginAsDifferentRoleButton();
    }

    @Step
    public List<String> getAllUsersRolesFromDropDown() {
        return loginPage.getUserRoles().stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }
}
