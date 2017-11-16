package planner.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import planner.pageobjects.JourneyPlannerPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenApplication implements Task {

    public static Performable onTheJourneyPlannerPage() {
       return instrumented(OpenApplication.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(JourneyPlannerPage.class)
        );
    }
}
