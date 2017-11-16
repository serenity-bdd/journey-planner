package planner.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class JourneyResultsPage extends PageObject {

    @FindBy(css = ".publictransport-box span.time")
    private WebElementFacade fastestJourney;


    public String getFastestJourneyDepartureTime() {
        return fastestJourney.getText().split(" - ")[0].replace("Depart at:","").trim();
    }
}
