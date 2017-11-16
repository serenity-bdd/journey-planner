package planner.pageobjects;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class JourneyPlannerWithPageObjectsTest {

    @Managed
    WebDriver driver;

    JourneyPlannerPage journeyPlanner;
    JourneyResultsPage journeyResults;

    @Test
    public void planning_a_journey() {

        journeyPlanner.open();

        journeyPlanner.chooseOriginOf("Waterloo");
        journeyPlanner.chooseDestinationOf("Canary Wharf");
        journeyPlanner.chooseTimeOfDeparture("09:00");
        journeyPlanner.confirmSelection();

        assertThat(journeyResults.getFastestJourneyDepartureTime()).isEqualTo("08:59");
    }
}
