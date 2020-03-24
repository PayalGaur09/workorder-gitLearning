package steps;

import com.typesafe.config.Config;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.UserSigninPage;
import utilities.ConfigLoader;

import java.util.List;
import java.util.Map;

public class UserSigninSteps {
    private static boolean loginStatus = false;
    private Config conf = ConfigLoader.load();
    private UserSigninPage userSigninPage;

    @Given("^User is on workorder signin page$")
    public void userIsOnWorkorderSigninPage() {
        userSigninPage.getDriver().get(conf.getString("test_url"));
    }


    @When("^User enter credentials and tap on the signin button$")
    public void userEnterCredentialsAndTapOnTheSigninButton(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String userEmail = list.get(0).get("userEmail");
        String pwd = list.get(0).get("password");
        userSigninPage.enterCredentials(userEmail, pwd);

    }


    @Then("^User successfully logged in and Dashboard page displayed$")
    public void userSuccessfullyLoggedInAndDashboardPageDisplayed() {
        userSigninPage.verifyHomepage();
    }

    @And("^User logout from workorder platform$")
    public void userLogoutFromWorkorderPlatform() {
        userSigninPage.signout();
    }

    @Then("^Error message \"([^\"]*)\" is displayed$")
    public void errorMessageIsDisplayed(String arg0) {
        userSigninPage.errorForInvalidCredentials();
    }

    @Then("^the error message is displayed \"([^\"]*)\"$")
    public void theErrorMessageIsDisplayed(String str) {
        System.out.print(str);
        userSigninPage.validationMessage(str);
    }


    @Given("^User sign in with valid credential of Account Owner$")
    public void userSignInWithValidCredentialOfAccountOwner() {
        userSigninPage.enterCredentials("shashank.g@mailinator.com", "1234567890");
    }
}
