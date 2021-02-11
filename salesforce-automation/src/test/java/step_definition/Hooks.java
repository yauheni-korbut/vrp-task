package step_definition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import webdriver.WebDriverManager;

public class Hooks extends BaseSteps {

    @Before
    public void setUp() {
        WebDriverManager.init();
    }

    @After(order = 1)
    public void verifyScenario(Scenario scenario) {
        try {
            scenarioContext.getSoftAssertions().assertAll();
        } finally {
            if (scenario.isFailed() || !scenarioContext.getSoftAssertions().errorsCollected().isEmpty()) {
                byte[] screenshotViewPort = ((TakesScreenshot) WebDriverManager.getWebDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshotViewPort, "image/png");
            }
        }
    }

    @After(order = 0)
    public void closeBrowser() {
        WebDriverManager.stopWebDriver();
    }

}
