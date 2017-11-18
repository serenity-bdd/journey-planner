package planner.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class JourneyPlanner {
    public static final Target ORIGIN = Target.the("Departure station")
            .locatedBy("#InputFrom");

    public static final Target ORIGIN_SUGGESTIONS = Target.the("Origin Suggestions")
            .locatedBy("//*[input[@id='InputFrom']]/*[contains(@class, 'tt-dropdown-menu')]");

    public static final Target DESTINATION = Target.the("Destination station")
            .locatedBy("#InputTo");

    public static final Target DESTINATION_SUGGESTIONS = Target.the("Destination Suggestions")
            .locatedBy("//*[input[@id='InputTo']]/*[contains(@class, 'tt-dropdown-menu')]");

    public static final Target SUGGESTIONS = Target.the("Suggestions")
            .locatedBy(".tt-suggestion");

    public static final Target CHANGE_TIME = Target.the("Change Time")
            .locatedBy(".change-departure-time");

    public static final Target LEAVING_BUTTON = Target.the("Leaving")
            .located(By.cssSelector("label[for=departing]"));

    public static final Target SELECTED_DEPARTURE_DATE = Target.the("Departure Date")
            .located(By.id("Date"));

    public static final Target SELECTED_DEPARTURE_TIME = Target.the("Departure Time")
            .located(By.id("Time"));

    public static final Target SELECTED_DEPARTURE_DROPDOWN = Target.the("Departure Time")
            .located(By.cssSelector(".hours"));

    public static final Target PLAN_MY_JOURNEY = Target.the("Plan my journey")
            .locatedBy("#plan-a-journey .plan-journey-button");
    ;

}
