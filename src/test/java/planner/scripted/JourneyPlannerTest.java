package planner.scripted;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.Keys.*;
import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Some WebDriver tests look like this one.
 * Tests like this are hard to follow and very hard to maintain. And they hide the business intent in a lot of noisy code.
 *
 */
public class JourneyPlannerTest {

    private final By origin                 = By.id("InputFrom");
    private final By originSuggestions      = By.cssSelector(".tt-suggestions");
    private final By destination            = By.id("InputTo");
    private final By destinationSuggestions = By.cssSelector(".tt-suggestions");
    private final By changeTimeLink         = By.partialLinkText("change time");
    private final By leavingButton          = By.cssSelector("label[for=departing]");
    private final By timeSelector           = By.id("Time");
    private final By planMyJourneyButton    = By.cssSelector("#plan-a-journey .plan-journey-button");
    private final By journeyResults         = By.cssSelector(".summary-results");
    private final By fastestJourney         = By.cssSelector(".publictransport-box span.time");

    private WebDriver browser;

    @Before
    public void openBrowser() {
        browser = new FirefoxDriver();
    }

    @After
    public void closeBrowser() {
        browser.quit();
    }

    @Test
    public void planning_a_journey_using_a_test_script() {

        browser.get("https://tfl.gov.uk/");
        browser.findElement(origin).sendKeys("Waterloo");

        WebDriverWait wait = new WebDriverWait(browser, 10);

        wait.until(visibilityOfElementLocated(originSuggestions));

        browser.findElement(originSuggestions).sendKeys(ARROW_DOWN);
        browser.findElement(originSuggestions).sendKeys(ENTER);

        browser.findElement(destination).sendKeys("Canary Wharf");

        wait.until(visibilityOfElementLocated(destinationSuggestions));

        browser.findElement(destinationSuggestions).sendKeys(ARROW_DOWN);
        browser.findElement(destinationSuggestions).sendKeys(ENTER);

        browser.findElement(changeTimeLink).click();
        browser.findElement(leavingButton).click();

        new Select(browser.findElement(timeSelector)).selectByVisibleText("09:00");

        JavascriptExecutor js = (JavascriptExecutor) browser;
        WebElement planMyJourney = browser.findElement(planMyJourneyButton);

        js.executeScript("arguments[0].click();", planMyJourney);

        wait.withTimeout(30, TimeUnit.SECONDS).until(visibilityOfElementLocated(journeyResults));

        String fastestDepartureTime = startTimeOf(browser.findElement(fastestJourney).getText());

        assertThat(fastestDepartureTime).isEqualTo("08:59");
    }

    private String startTimeOf(String text) {
        return text.split(" - ")[0].replace("Depart at:","").trim();
    }
}
