package planner.cucumber;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import planner.screenplay.model.TripDetails;
import planner.screenplay.questions.TheBestJourneyOption;
import planner.screenplay.tasks.PlanAJourney;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class PlanAJourneyStepDefinitions {
    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) is a London commuter$")
    public void a_london_commuter_named(String commuterName) throws Throwable {
        theActorCalled(commuterName);
    }

    @When("^(.*) plans a journey from (.*) to (.*) departing at (.*)$")
    public void plan_a_journeys(String name, String departure, String destination, String departureTime) throws Throwable {
        theActorCalled(name).attemptsTo(
                PlanAJourney.from(departure).to(destination).departingAt(departureTime)

        );
    }

    @Then("^(.*) should see that the fastest train departs at (.*)$")
    public void should_see_departure_time(String name,
                                          String expectedDepartureTime) throws Throwable {
        theActorCalled(name).should(
                seeThat("the departure time", TheBestJourneyOption.departureTime(), is(expectedDepartureTime))
        );
    }

    @Then("^(.*) should see a trip on the (.*) line departing at (.*)")
    public void should_see_trip(String name, String line, String departureTime) {
        theActorCalled(name).should(
                seeThat("the proposed itinerary", TheBestJourneyOption.tubeLine(), is(line)),
                seeThat("the departure time", TheBestJourneyOption.departureTime(), is(departureTime))
        );
    }


}
