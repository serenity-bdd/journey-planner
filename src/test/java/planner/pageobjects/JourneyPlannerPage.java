package planner.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@DefaultUrl("https://tfl.gov.uk")
public class JourneyPlannerPage extends PageObject {

    @FindBy(id = "InputFrom")
    private WebElementFacade origin;

    @FindBy(className = "tt-suggestions")
    private WebElementFacade originSuggestions;

    @FindBy(id = "InputTo")
    private WebElementFacade destination;

    @FindBy(className = "tt-suggestions")
    private WebElementFacade destinationSuggestions;

    @FindBy(partialLinkText = "change time")
    private WebElementFacade changeTimeLink;

    @FindBy(css = "label[for=departing]")
    private WebElementFacade leavingButton;

    @FindBy(id = "Time")
    private WebElement timeSelector;

    @FindBy(css = "#plan-a-journey .plan-journey-button")
    private WebElementFacade planMyJourneyButton;

    @FindBy(className = "summary-results")
    private WebElementFacade journeyResults;


    public void chooseOriginOf(String originValue) {
        origin.sendKeys(originValue);

        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(visibilityOf(originSuggestions));

        origin.sendKeys(Keys.ARROW_DOWN);
        origin.sendKeys(Keys.ENTER);
    }

    public void chooseDestinationOf(String destinationValue) {
        destination.sendKeys(destinationValue);

        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(visibilityOf(destinationSuggestions));

        destination.sendKeys(Keys.ARROW_DOWN);
        destination.sendKeys(Keys.ENTER);
    }

    public void chooseTimeOfDeparture(String timeOfDeparture) {
        changeTimeLink.click();
        leavingButton.click();

        selectFromDropdown(timeSelector, timeOfDeparture);
    }


    public void confirmSelection() {

        planMyJourneyButton.click();

        waitFor(visibilityOf(journeyResults));
    }
}
