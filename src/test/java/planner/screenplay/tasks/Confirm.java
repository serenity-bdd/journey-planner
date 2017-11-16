package planner.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import planner.screenplay.ui.JourneyPlanner;
import planner.screenplay.ui.JourneyResults;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Confirm implements Task {

    /**
     * Usage: Confirm.journeyDetails()
     */
    public static Confirm journeyDetails() {
        return instrumented(Confirm.class);
    }

    @Step("{0} confirms the journey details")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(JourneyPlanner.PLAN_MY_JOURNEY),
                WaitUntil.the(JourneyResults.RESULTS_LIST, isVisible())
                         .forNoMoreThan(30).seconds()
        );
    }


}
