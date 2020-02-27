package steps;

import grids.UsersGrid;
import grids.WorkShiftGrid;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import pageComponents.AddWorkShiftModalWindow;
import pageComponents.TimePicker;

import java.util.List;

import static utils.SessionVariables.FILTER_USERS_WINDOW;
import static utils.SessionVariables.WORK_SHIFT_ADD_WINDOW;

@Getter
@Slf4j
public class WorkShiftsSteps extends DefaultStepsData {

    @Step
    public List<WorkShiftGrid> getWorkShiftGrid() {
        log.info("Getting Work Shift table from Work Shifts page");
        return new WorkShiftGrid().getAllItems(getDriver());
    }

    @Step
    public void clickOnAddWorkShiftButton() {
        log.info("Clicking on the [Add work shift] button");
        workShiftPage.getAddWorkShiftButton().waitUntilClickable().click();
        WORK_SHIFT_ADD_WINDOW.put(new AddWorkShiftModalWindow(workShiftPage.getAddWorkShiftWindow()));
    }

    @Step
    private AddWorkShiftModalWindow getAddWorkShiftModalWindow() {
        return new AddWorkShiftModalWindow(workShiftPage.getAddWorkShiftWindow());
    }

    @Step
    private TimePicker getTimePickerElement() {
        return new TimePicker(workShiftPage.getTimePickerLocator());
    }

    public boolean checkShiftPresenceInTable(String shiftName) {
        List<WorkShiftGrid> allItems = getWorkShiftGrid();
        for (WorkShiftGrid gridElem : allItems) {
            if (gridElem.getWorkShift().contains(shiftName)){
                return true;
            }
        }
        return false;
    }

    public boolean checkWorkShiftFieldEmpty(){
        AddWorkShiftModalWindow addWorkShift = WORK_SHIFT_ADD_WINDOW.get();
        if (addWorkShift.getWorkShiftNameInputField().getTextContent().isEmpty()){
            return true;
        }
        else return false;
    }

    public void clickOnSaveButton(){
        AddWorkShiftModalWindow addWorkShift = WORK_SHIFT_ADD_WINDOW.get();
        addWorkShift.getSaveButton().waitUntilEnabled().click();
    }

    public String checkInputFieldErrorText(){
        AddWorkShiftModalWindow addWorkShift = WORK_SHIFT_ADD_WINDOW.get();
        return addWorkShift.getWorkShiftNameInputField().findBy(By.xpath("../span[@class='help-block']")).getText();
    }
}
