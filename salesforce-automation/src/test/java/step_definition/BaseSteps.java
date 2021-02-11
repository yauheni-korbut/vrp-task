package step_definition;

import org.picocontainer.annotations.Inject;
import pages.*;
import scenario_context.ScenarioContext;

public class BaseSteps {

    @Inject
    protected ScenarioContext scenarioContext;
    @Inject
    protected LoginPage loginPage;
    @Inject
    protected HomePage homePage;
    @Inject
    protected AccountTabPage accountTab;
    @Inject
    protected CreateNewAccountPage createNewAccountPage;
    @Inject
    protected DetailAccountPage detailAccountPage;

}
