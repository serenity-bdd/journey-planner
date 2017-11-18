package planner.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
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

    @FindBy(id = "Date")
    private WebElement dateSelector;

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

    public void chooseDayAndTimeOfDeparture(DayOfWeek day, String timeOfDeparture) {
        changeTimeLink.click();
        leavingButton.click();

        selectFromDropdown(timeSelector, timeOfDeparture);

        LocalDate today = LocalDate.now();
        LocalDate plannedDay = today.with(TemporalAdjusters.nextOrSame(day));
        new Select(dateSelector).selectByValue((plannedDay.format(DateTimeFormatter.ofPattern("yyyyMMdd"))));
    }

    public void confirmSelection() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click();", planMyJourneyButton);

        waitFor(visibilityOf(journeyResults));
    }
}
