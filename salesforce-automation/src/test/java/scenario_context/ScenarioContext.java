package scenario_context;

import business_objects.Account;
import org.assertj.core.api.SoftAssertions;

public class ScenarioContext {

    private SoftAssertions softAssertions;
    private Account account;

    public ScenarioContext() {
        softAssertions = new SoftAssertions();
    }

    public SoftAssertions getSoftAssertions() {
        return softAssertions;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
