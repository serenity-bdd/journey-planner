package planner.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class JourneyResults {

    public static final Target RESULTS_LIST = Target.the("Results summary").locatedBy(".journey-results");;

    public static final Target BEST_JOURNEY_OPTION = Target.the("best journey option")
                                                           .locatedBy(".journey-option:first-child");
    public static final Target ITINERARY = Target.the("Itinerary").locatedBy(".stop-location-description");;

    public static final Target HEADER = Target.the("Results heaer").locatedBy(".jp-results-headline");


}
