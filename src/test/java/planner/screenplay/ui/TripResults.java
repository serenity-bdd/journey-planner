package planner.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class TripResults {

    public static final Target RESULTS_LIST = Target.the("Results list").locatedBy(".tp-result-list");;

    public static final Target FISRT_DEPARTURE_TIME
            = Target.the("departure time").locatedBy(".tp-result-item:first-child .departure-time");

    public static final Target FISRT_ARRIVAL_TIME
            = Target.the("arrival time").locatedBy(".tp-result-item:first-child .arrival-time");

    public static final Target FISRT_TRIP_DURATION
            = Target.the("arrival time").locatedBy(".tp-result-item:first-child .tp-result-item-timing-duration");
}
