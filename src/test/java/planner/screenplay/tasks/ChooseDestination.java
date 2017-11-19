package planner.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import planner.screenplay.interactions.PickFirstSuggestion;
import planner.screenplay.interactions.TypeKeysInto;
import planner.screenplay.ui.JourneyPlanner;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ChooseDestination {

    /**
     * Usage: ChooseDestination.of("Canary Wharf")
     */
    public static Task of(String station) {
        return Task.where("{0} selects destination station of #station",
                Enter.theValue(station).into(JourneyPlanner.DESTINATION),

                WaitUntil.the(JourneyPlanner.DESTINATION_SUGGESTIONS, isVisible()).forNoMoreThan(15).seconds(),
                PickFirstSuggestion.from(JourneyPlanner.DESTINATION))
                .with("station").of(station);
    }
}
