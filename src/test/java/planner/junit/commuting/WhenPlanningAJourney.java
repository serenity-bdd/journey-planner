package planner.junit.commuting;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import planner.screenplay.questions.TheFirstTrain;
import planner.screenplay.tasks.*;

import static java.time.DayOfWeek.MONDAY;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class WhenPlanningAJourney {

    @Managed WebDriver browser;

    Actor sarah = Actor.named("Sarah");

    @Before
    public void setTheStage() {
        sarah.can(BrowseTheWeb.with(browser));
    }

  @Test
    @WithTagValuesOf({"screenplay"})
    public void should_show_the_best_journey_option() {

        sarah.attemptsTo(
                PlanATrip.from("Chatswood").to("Town Hall").departingAt("09:00").next(MONDAY)
        );

        sarah.should(
                seeThat("the first train leaves at", TheFirstTrain.departureTime(), is("09:04")),
                seeThat("the first train arrives at", TheFirstTrain.arrivalTime(), is("09:26")),
                seeThat("the trip lasts", TheFirstTrain.tripDuration(), containsString("22min"))
        );
    }
}
