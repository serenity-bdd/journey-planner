package planner.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PlanAJourney implements Performable {

    private final String departure;
    private final String destination;
    private final String departureTime;

    public PlanAJourney(String departure, String destination, String departureTime) {
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OpenApplication.onTheJourneyPlannerPage(),
                ChooseOrigin.of(departure),
                ChooseDestination.of(destination),
                ChooseTimeOfDeparture.of(departureTime),
                Confirm.journeyDetails()
        );
    }


    //
    // Builder methods
    //

    public static ToDestination from(String waterloo) {
        return new PlanAJourneyBuilder(waterloo);
    }

    public interface ToDestination {
        DepartingAt to(String canary_wharf);
    }
    
    public interface DepartingAt {
        Performable departingAt(String departureTime);
    }

    public static class PlanAJourneyBuilder implements ToDestination, DepartingAt {

        private String destination;
        private String departure;

        PlanAJourneyBuilder(String departure) {
            this.departure = departure;
        }

        @Override
        public DepartingAt to(String destination) {
            this.destination = destination;
            return this;
        }

        @Override
        public Performable departingAt(String departureTime) {
            return instrumented(PlanAJourney.class, departure, destination, departureTime);
        }
    }
}
