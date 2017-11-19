package planner.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import planner.screenplay.interactions.PickFirstSuggestion;
import planner.screenplay.ui.TripPlanner;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ChooseToStation {

    /**
     * Usage: ChooseToStation.of("Town Hall")
     */
    public static Task of(String station) {
        return Task.where("{0} selects destination station of #station",
                Enter.theValue(station).into(TripPlanner.DESTINATION),
                WaitUntil.the(TripPlanner.SUGGESTIONS, isVisible()),
                PickFirstSuggestion.from(TripPlanner.DESTINATION))
                .with("station").of(station);
    }
}
