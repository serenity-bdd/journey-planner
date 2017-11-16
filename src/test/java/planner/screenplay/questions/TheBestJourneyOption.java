package planner.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import planner.screenplay.ui.JourneyResults;

public class TheBestJourneyOption {

    public static Question<String> tubeLine() {
        return actor -> Text.of(JourneyResults.ITINERARY).viewedBy(actor).asString();
    }


    public static Question<String> departureTime() {
        return actor -> {
            String departureTime = journeyOptionElements(actor, JourneyResults.BEST_JOURNEY_OPTION)[2];
            return stripExtraCharsFrom(departureTime);
        };
    }

    public static Question<String> arrivalTime() {
        return actor -> {
            String arrivalTime = journeyOptionElements(actor, JourneyResults.BEST_JOURNEY_OPTION)[4];
            return stripExtraCharsFrom(arrivalTime);
        };
    }

    private static String[] journeyOptionElements(Actor actor, Target journeyOption) {
        return Text.of(JourneyResults.BEST_JOURNEY_OPTION)
                    .viewedBy(actor)
                    .asString()
                    .split("\n");
    }

    private static String stripExtraCharsFrom(String value) {
        return value.replace("-", "").trim();
    }

}
