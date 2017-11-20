package planner.screenplay.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.ChronoUnit.DAYS;

public class SelectDepartureDate {

    private final static ZoneId IN_SYDNEY = ZoneId.of("Australia/Sydney");

    public static SelectDepartureDateBuilder in(Target departureDate) {
        return new SelectDepartureDateBuilder(departureDate);
    }

    public static class SelectDepartureDateBuilder {
        private Target departureDate;

        public SelectDepartureDateBuilder(Target departureDate) {
            this.departureDate = departureDate;
        }

        public Interaction toNext(DayOfWeek dayOfDeparture) {

            String plannedDate = formattedPlannedDay(dayOfDeparture);

            SelectFromOptions.byValue(plannedDate).from(departureDate);
            return Interaction.where(
                    "Select departure date of next " + dayOfDeparture,
                    SelectFromOptions.byVisibleText(plannedDate).from(departureDate)
            );
        }

        private String formattedPlannedDay(DayOfWeek dayOfDeparture) {
            LocalDateTime today = LocalDateTime.now(IN_SYDNEY).withHour(0).withMinute(0).withSecond(0).withNano(0);
            LocalDateTime plannedDay = today.with(TemporalAdjusters.nextOrSame(dayOfDeparture));

            if (DAYS.between(today, plannedDay) == 0) {
                return "Today (" + plannedDay.format(DateTimeFormatter.ofPattern("EEE")) + ")";
            } else if (DAYS.between(today, plannedDay) == 1) {
                return "Tomorrow (" + plannedDay.format(DateTimeFormatter.ofPattern("EEE")) + ")";
            } else {
                return plannedDay.format(DateTimeFormatter.ofPattern("dd MMM (EEE)"));
            }
        }
    }
}
