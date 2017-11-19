package planner.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import planner.screenplay.interactions.SelectDepartureDate;
import planner.screenplay.interactions.SelectDepartureTime;
import planner.screenplay.ui.TripPlanner;

import java.time.DayOfWeek;

public class ChooseTimeOfDeparture {

    /**
     * Usage: ChooseTimeOfDeparture.of("09:00").next(MONDAY)
     */
    public static TimeOfDepartureBuilder of(String timeOfDeparture) {
        return new TimeOfDepartureBuilder(timeOfDeparture);
    }

    public static class TimeOfDepartureBuilder {

        private final String timeOfDeparture;

        TimeOfDepartureBuilder(String timeOfDeparture) {
            this.timeOfDeparture = timeOfDeparture;
        }

        public Task next(DayOfWeek dayOfDeparture) {
            return Task.where("{0} selects time of departure of #timeOfDeparture next #dayOfDeparture",

                    Click.on(TripPlanner.CHANGE_TIME),
                    Click.on(TripPlanner.LEAVING_BUTTON),

                    SelectDepartureDate.in(TripPlanner.SELECTED_DEPARTURE_DATE).toNext(dayOfDeparture),
                    SelectDepartureTime.to(timeOfDeparture)


            ).with("timeOfDeparture").of(timeOfDeparture)
             .with("dayOfDeparture").of(dayOfDeparture);
        }
    }
}
