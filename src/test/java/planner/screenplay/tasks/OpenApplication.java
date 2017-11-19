package planner.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import planner.screenplay.ui.TripPlannerPage;

public class OpenApplication {

    public static Task onTheJourneyPlannerPage() {
        return Task.where(
                "{0} opens the trip planner application",
                Open.browserOn().the(TripPlannerPage.class)
        );
    }
}
