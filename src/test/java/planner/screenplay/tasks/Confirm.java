package planner.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import planner.screenplay.ui.TripPlanner;
import planner.screenplay.ui.TripResults;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Confirm {

    /**
     * Usage: Confirm.journeyDetails()
     */
    public static Task journeyDetails() {

        return Task.where("{0} confirms the journey details",
                Click.on(TripPlanner.GO),
                WaitUntil.the(TripResults.RESULTS_LIST, isVisible())
                        .forNoMoreThan(15).seconds()
        );
    }
}
