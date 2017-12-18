package planner.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TripPlanner {
    public static final Target FROM = Target.the("From field")
            .locatedBy("#search-input-From");

    public static final Target SEARCHING_MESSAGE = Target.the("'Searching...' message")
            .locatedBy(".suggestion-message");


    public static final Target SUGGESTIONS = Target.the("Matching stations")
            .locatedBy(".list-group-item-title");

    public static final Target DESTINATION = Target.the("To field")
            .locatedBy("#search-input-To");

    public static final Target CHANGE_TIME = Target.the("Change Time")
            .locatedBy(".time-options-wrapper a[role=button]");

    public static final Target LEAVING_BUTTON = Target.the("Leaving")
            .located(By.cssSelector("label.leaving"));

    public static final Target HOUR = Target.the("Hour")
            .located(By.cssSelector("#search-select-hour"));

    public static final Target MINUTE = Target.the("Minute")
            .located(By.cssSelector("#search-select-minute"));

    public static final Target SELECTED_DEPARTURE_DATE = Target.the("Departure Date")
            .located(By.id("search-select-date"));

    public static final Target GO = Target.the("Go button")
            .locatedBy("#search-button");
}
