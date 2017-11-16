package planner.screenplay.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromBy;
import net.serenitybdd.screenplay.questions.SelectedValue;
import net.thucydides.core.annotations.Step;
import planner.screenplay.ui.JourneyPlanner;

public class ChooseTimeOfDeparture implements Task {

    private final String timeOfDeparture;

    public ChooseTimeOfDeparture(String timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    /**
     * Usage: ChooseTimeOfDeparture.of("09:00")
     */
    public static ChooseTimeOfDeparture of(String timeOfDeparture) {
        return Instrumented.instanceOf(ChooseTimeOfDeparture.class).withProperties(timeOfDeparture);
    }

    @Step("{0} selects time of departure of of #timeOfDeparture")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(JourneyPlanner.CHANGE_TIME),
                Click.on(JourneyPlanner.LEAVING_BUTTON)
        );
        actor.attemptsTo(
                Click.on(JourneyPlanner.SELECTED_DEPARTURE_DROPDOWN),
                SelectFromOptions.byVisibleText(timeOfDeparture).from(JourneyPlanner.SELECTED_DEPARTURE_TIME)
        );
    }


}
