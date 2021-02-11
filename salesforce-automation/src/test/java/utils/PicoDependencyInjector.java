package utils;

import cucumber.runtime.java.picocontainer.PicoFactory;
import pages.*;
import scenario_context.ScenarioContext;

public class PicoDependencyInjector extends PicoFactory {

    public PicoDependencyInjector() {
        addClass(ScenarioContext.class);
        addClass(LoginPage.class);
        addClass(HomePage.class);
        addClass(AccountTabPage.class);
        addClass(CreateNewAccountPage.class);
        addClass(DetailAccountPage.class);
    }

}