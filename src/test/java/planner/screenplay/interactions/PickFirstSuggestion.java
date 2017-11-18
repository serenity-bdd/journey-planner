package planner.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import planner.screenplay.ui.JourneyPlanner;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

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
        BrowseTheWeb.as(actor).waitFor(500).milliseconds();
    }

    public static PickFirstSuggestion from(Target inputField) {
        return instrumented(PickFirstSuggestion.class, inputField);
    }
}
