package planner.pageobjects;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.time.DayOfWeek;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test uses Serenity Page Objects.
 * The code reads more smoothly than the scripted test in the JourneyPlannerTest class.
 * But the page objects themselves can become bloated and hard to maintain, and it is hard to reuse larger
 * pieces of business logic.
 */
@RunWith(SerenityRunner.class)
public class JourneyPlannerWithPageObjectsTest {

    @Managed
    WebDriver driver;

    JourneyPlannerPage journeyPlanner;
    JourneyResultsPage journeyResults;

    @Test
    public void planning_a_journey_with_page_objects() {

        journeyPlanner.open();

        journeyPlanner.chooseOriginOf("Waterloo");
        journeyPlanner.chooseDestinationOf("Canary Wharf");
        journeyPlanner.chooseDayAndTimeOfDeparture(DayOfWeek.MONDAY,"09:00");
        journeyPlanner.confirmSelection();

        assertThat(journeyResults.getFastestJourneyDepartureTime()).isEqualTo("08:59");
    }
}
