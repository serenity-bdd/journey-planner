package planner.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class JavaScriptClick implements Interaction {

    private final Target target;

    public JavaScriptClick(Target target) {
        this.target = target;
    }

    public static Interaction on(Target target) {
        return instrumented(JavaScriptClick.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor)
                    .evaluateJavascript("arguments[0].click();",
                                        target.resolveFor(actor));
    }
}
