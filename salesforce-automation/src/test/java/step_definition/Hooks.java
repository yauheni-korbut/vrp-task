package step_definition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import scenario_context.ScenarioContext;
import webdriver.WebDriverManager;

public class Hooks extends BaseSteps{

    public Hooks(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

    @Before
    public void setUp(){
        WebDriverManager.init();
    }



    @After
    public void tearDown(Scenario scenario){
        try {
            scenarioContext.getSoftAssertions().assertAll();
        }
        finally {
            if(scenario.isFailed() || !scenarioContext.getSoftAssertions().wasSuccess()){
                byte[] screenshotViewPort = ((TakesScreenshot) WebDriverManager.getWebDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshotViewPort, "image/png");
            }
        }
    }

    @After
    public void tearDown(){
        WebDriverManager.stopWebDriver();
    }

}
