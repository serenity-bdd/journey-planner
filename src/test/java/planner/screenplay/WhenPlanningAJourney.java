package planner.screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import planner.screenplay.questions.TheFastest;
import planner.screenplay.tasks.*;

import java.time.DayOfWeek;

import static java.time.DayOfWeek.MONDAY;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class WhenPlanningAJourney {

    @Managed WebDriver browser;

    @Test
    @WithTagValuesOf({"screenplay"})
    public void should_show_the_best_journey_option() {
        Actor connie = Actor.named("Connie");
        connie.can(BrowseTheWeb.with(browser));

        connie.attemptsTo(
                PlanAJourney.from("Waterloo").to("Canary Wharf").departingAt("09:00").next(MONDAY)
        );

        connie.should(
                seeThat("the fastest tube line", TheFastest.tubeLine(), is(equalTo("Jubilee line to Canary Wharf"))),
                seeThat("tbe departure time", TheFastest.departureTime(), is(equalTo("08:59"))),
                seeThat("tbe arrival time", TheFastest.arrivalTime(), is(equalTo("09:09")))
        );
    }
}