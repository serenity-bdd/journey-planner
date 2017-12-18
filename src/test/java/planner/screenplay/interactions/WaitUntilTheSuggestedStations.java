package planner.screenplay.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import planner.screenplay.ui.TripPlanner;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class WaitUntilTheSuggestedStations {
    public static Performable areVisible() {
        return Interaction.where("{0} waits until the suggested stations are visible",

                WaitUntil.angularRequestsHaveFinished(),

                Check.whether(the(TripPlanner.SEARCHING_MESSAGE), isCurrentlyVisible())
                     .andIfSo(WaitUntil.the(TripPlanner.SEARCHING_MESSAGE, isNotCurrentlyVisible()))

        );
    }
}
