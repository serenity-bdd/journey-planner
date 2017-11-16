package planner.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import planner.screenplay.interactions.PickFirstSuggestion;
import planner.screenplay.ui.JourneyPlanner;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ChooseOrigin implements Task {

    @Step("{0} selects origin station of #station")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(station).into(JourneyPlanner.ORIGIN),
                WaitUntil.the(JourneyPlanner.ORIGIN_SUGGESTIONS, isVisible()).forNoMoreThan(15).seconds(),
                PickFirstSuggestion.from(JourneyPlanner.ORIGIN)
        );
    }

    private final String station;

    public ChooseOrigin(String origin) { this.station = origin;}

    /**
     * Usage: ChooseOrigin.of("Waterloo")
     */
    public static Performable of(String station) { return instrumented(ChooseOrigin.class, station); }

}
