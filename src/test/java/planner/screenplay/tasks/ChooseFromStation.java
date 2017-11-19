package planner.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import planner.screenplay.interactions.PickFirstSuggestion;
import planner.screenplay.ui.TripPlanner;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * This class uses the full-form approach to defining a task. Compare with the ChooseToStation to see the shortened form.
 */
public class ChooseFromStation implements Task {

    @Step("{0} selects origin station of #station")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(station).into(TripPlanner.FROM),
                WaitUntil.the(TripPlanner.SUGGESTIONS, isVisible()),
                PickFirstSuggestion.from(TripPlanner.FROM)
        );
    }

    private final String station;

    public ChooseFromStation(String origin) { this.station = origin;}

    /**
     * Usage: ChooseFromStation.of("Chatswood")
     */
    public static Performable of(String station) { return instrumented(ChooseFromStation.class, station); }

}
