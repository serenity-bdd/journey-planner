package planner.screenplay.interactions;

import com.google.common.base.Splitter;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import planner.screenplay.ui.TripPlanner;

public class SelectDepartureTime {
    public static Interaction to(String timeOfDeparture) {
        return Interaction.where("Set departure time to " + timeOfDeparture,
                SelectFromOptions.byVisibleText(hourOf(timeOfDeparture)).from(TripPlanner.HOUR),
                SelectFromOptions.byVisibleText(minuteOf(timeOfDeparture)).from(TripPlanner.MINUTE)
        );
    }

    private static String hourOf(String timeOfDeparture) {
        return Splitter.on(":").splitToList(timeOfDeparture).get(0);
    }

    private static String minuteOf(String timeOfDeparture) {
        return Splitter.on(":").splitToList(timeOfDeparture).get(1);
    }

}
