package planner.screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import planner.screenplay.questions.TheBestJourneyOption;
import planner.screenplay.tasks.*;
import planner.screenplay.ui.JourneyPlanner;
import planner.screenplay.ui.JourneyResults;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.questions.targets.TheTarget.selectedValueOf;
import static net.serenitybdd.screenplay.questions.targets.TheTarget.textOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class WhenPlanningAJourney {

    @Managed WebDriver browser;

    @Test
    public void should_show_the_soonest_departure_time_close_to_the_requested_time() {

        Actor connie = Actor.named("Connie");
        connie.can(BrowseTheWeb.with(browser));

        connie.attemptsTo(
                OpenApplication.onTheJourneyPlannerPage(),
                ChooseOrigin.of("Waterloo"),
                ChooseDestination.of("Canary Wharf"),
                ChooseTimeOfDeparture.of("09:00"),
                Confirm.journeyDetails()
        );

        connie.should(
                seeThat("the proposed itinerary", TheBestJourneyOption.tubeLine(), is(equalTo("Jubilee line to Canary Wharf"))),
                seeThat("the departure time", TheBestJourneyOption.departureTime(), is(equalTo("08:59"))),
                seeThat("the arrival time", TheBestJourneyOption.arrivalTime(), is(equalTo("09:09")))
        );
    }


    @Test
    public void should_show_the_best_journey_option() {
        Actor connie = Actor.named("Connie");
        connie.can(BrowseTheWeb.with(browser));

        connie.attemptsTo(
                PlanAJourney.from("Waterloo").to("Canary Wharf").departingAt("09:00")
        );

        connie.should(
                seeThat("the proposed itinerary", TheBestJourneyOption.tubeLine(), is(equalTo("Jubilee line to Canary Wharf"))),
                seeThat("tbe departure time", TheBestJourneyOption.departureTime(), is(equalTo("08:59"))),
                seeThat("tbe arrival time", TheBestJourneyOption.arrivalTime(), is(equalTo("09:09")))
        );
    }
}