package steps;

import net.thucydides.core.annotations.Step;

public class MyGoalsSteps extends DefaultStepsData {

    @Step
    public void clickAddGoalButton() {
        myGoalsPage.clickOnAddGoalButton();
    }

    @Step
    public void clickAddObjectiveButton() {
        myGoalsPage.clickOnAddObjectiveButton();
    }

    @Step
    public void clickOnUnapprovedGoalsButton() {
        myGoalsPage.clickOnUnapprovedGoalsButton();
    }

    @Step
    public String getUnapprovedGoalsInfoMessageText() {
        return myGoalsPage.getUnapprovedGoalsInfoMessage().getText();
    }

    @Step
    public void hoverMouseOverAddButton() {
        myGoalsPage.moveToElement(myGoalsPage.getAddButton(), getDriver());
    }

    @Step
    public boolean checkThatButtonIsVisible(String buttonName) {
        boolean isButtonVisible;
        switch (buttonName) {
            case "Add Goals":
                isButtonVisible = myGoalsPage.getAddGoalButton().isVisible();
                break;
            case "Add Objective with Key Results (OKR)":
                isButtonVisible = myGoalsPage.getAddObjectiveButton().isVisible();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + buttonName);
        }
        return isButtonVisible;
    }
}
