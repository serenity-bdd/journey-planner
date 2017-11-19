package planner.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import planner.screenplay.ui.TripResults;

public class TheFirstTrain {
    public static Question<String> departureTime() {
        return actor -> Text.of(TripResults.FISRT_DEPARTURE_TIME).viewedBy(actor).asString();
    }

    public static Question<String> arrivalTime() {
        return actor -> Text.of(TripResults.FISRT_ARRIVAL_TIME).viewedBy(actor).asString();
    }

    public static Question<String> tripDuration() {
        return actor -> Text.of(TripResults.FISRT_TRIP_DURATION).viewedBy(actor).asString();
    }
}
