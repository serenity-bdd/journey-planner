package planner.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import java.time.DayOfWeek;

/**
 * The PlanAJourney task combines a number of more granular tasks into a single larger one.
 */
public class PlanAJourney {

    public static ToDestination from(String origin) {
        return new PlanAJourneyBuilder(origin);
    }

    public interface ToDestination {  DepartingAt to(String destination); }

    public interface DepartingAt {  DepartingNext departingAt(String departureTime); }

    public interface DepartingNext {  Task next(DayOfWeek departureDay); }

    public static class PlanAJourneyBuilder implements ToDestination, DepartingAt, DepartingNext {

        private String destination;
        private String departure;
        private String departureTime;

        PlanAJourneyBuilder(String departure) {
            this.departure = departure;
        }

        @Override
        public DepartingAt to(String destination) {
            this.destination = destination;
            return this;
        }

        @Override
        public DepartingNext departingAt(String departureTime) {
            this.departureTime = departureTime;
            return this;
        }

        @Override
        public Task next(DayOfWeek departureDay) {
            return Task.where("{0} plans a journey between #departure and #destination, leaving around #departureTime next #departureDay",
                    OpenApplication.onTheJourneyPlannerPage(),
                    ChooseOrigin.of(departure),
                    ChooseDestination.of(destination),
                    ChooseTimeOfDeparture.of(departureTime).next(departureDay),
                    Confirm.journeyDetails())
                    .with("departure").of(departure)
                    .with("destination").of(destination)
                    .with("departureTime").of(departureTime)
                    .with("departureDay").of(departureDay);
        }
    }
}
