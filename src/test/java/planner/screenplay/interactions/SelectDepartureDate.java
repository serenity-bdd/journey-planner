package planner.screenplay.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class SelectDepartureDate {
    public static SelectDepartureDateBuilder in(Target departureDate) {
        return new SelectDepartureDateBuilder(departureDate);
    }

    public static class SelectDepartureDateBuilder {
        private Target departureDate;

        public SelectDepartureDateBuilder(Target departureDate) {
            this.departureDate = departureDate;
        }

        public Interaction toNext(DayOfWeek dayOfDeparture) {
            LocalDate today = LocalDate.now();
            LocalDate plannedDay = today.with(TemporalAdjusters.nextOrSame(dayOfDeparture));
            String plannedDate = plannedDay.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

            SelectFromOptions.byValue(plannedDate).from(departureDate);

            return Interaction.where(
                    "Select departure date of next " + dayOfDeparture,
                    SelectFromOptions.byValue(plannedDate).from(departureDate)
            );
        }
    }
}
