package planner.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PickFirstSuggestion implements Interaction {

    private final Target inputField;

    public PickFirstSuggestion(Target inputField) {
        this.inputField = inputField;
    }

    @Override
    @Step("{0} selects the first suggestion")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Hit.the(Keys.ARROW_DOWN).into(inputField),
                Hit.the(Keys.ENTER).into(inputField)
        );
    }

    public static PickFirstSuggestion from(Target inputField) {
        return instrumented(PickFirstSuggestion.class, inputField);
    }
}
