package pageComponents;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Objects;

@Getter
@Slf4j
public class TimePicker {

    private WebElementFacade timePickerComponent;
    private WebElementFacade topHours;
    private WebElementFacade topMinutes;
    private List<WebElementFacade> hoursBoard;
    private List<WebElementFacade> minutesBoard;
    private WebElementFacade okButton;

    public TimePicker(WebElementFacade timePickerComponent) {
        this.timePickerComponent = timePickerComponent;
        this.topHours = timePickerComponent.find(By.cssSelector(".clockpicker-span-hours"));
        this.topMinutes = timePickerComponent.find(By.cssSelector(".clockpicker-span-minutes"));
        this.hoursBoard = timePickerComponent.thenFindAll(By.cssSelector(".clockpicker-hours .clockpicker-tick"));
        this.minutesBoard = timePickerComponent.thenFindAll(By.cssSelector(".clockpicker-minutes .clockpicker-tick"));
        this.okButton = timePickerComponent.find(By.cssSelector(".clockpicker-button"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimePicker that = (TimePicker) o;
        return Objects.equals(getTimePickerComponent(), that.getTimePickerComponent()) &&
                Objects.equals(getTopHours(), that.getTopHours()) &&
                Objects.equals(getTopMinutes(), that.getTopMinutes()) &&
                Objects.equals(getHoursBoard(), that.getHoursBoard()) &&
                Objects.equals(getMinutesBoard(), that.getMinutesBoard()) &&
                Objects.equals(getOkButton(), that.getOkButton());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTimePickerComponent(), getTopHours(), getTopMinutes(), getHoursBoard(), getMinutesBoard(), getOkButton());
    }
}
