package steps.web;

import com.typesafe.config.Config;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.UserSigninPage;
import utilities.ConfigLoader;
import utilities.LoadProperties;

import java.util.List;
import java.util.Map;

public class UserSigninSteps {
    private Config conf = ConfigLoader.load();
    private UserSigninPage userSigninPage;

    @Given("^User is on work order sign in page$")
    public void userIsOnWorkOrderSignInPage() {
        userSigninPage.getDriver().get(conf.getString("test_url"));
    }


    @When("^User enter credentials and tap on the sign in button$")
    public void userEnterCredentialsAndTapOnTheSignInButton(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String userEmail = list.get(0).get("userEmail");
        String pwd = list.get(0).get("password");
        userSigninPage.enterCredentials(userEmail, pwd);

    }


    @Then("^User successfully logged in and Dashboard page displayed$")
    public void userSuccessfullyLoggedInAndDashboardPageDisplayed() {
        userSigninPage.verifyHomepage();
    }

    @And("^User logout from work order platform$")
    public void userLogoutFromWorkOrderPlatform() {
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
        String id = LoadProperties.getValueFromPropertyFile("testData", "accountOwnerId");
        String pwd = LoadProperties.getValueFromPropertyFile("testData", "accountOwnerPassword");
        userSigninPage.enterCredentials(id, pwd);
    }

    @And("^User sign in with valid credential of Client Personnel$")
    public void userSignInWithValidCredentialOfClientPersonnel() {
        String id = LoadProperties.getValueFromPropertyFile("testData", "clientPersonnelId");
        String pwd = LoadProperties.getValueFromPropertyFile("testData", "clientPersonnelPassword");
        userSigninPage.enterCredentials(id, pwd);
    }

    @When("^User sign in with valid credential of Client Admin$")
    public void userSignInWithValidCredentialOfClientAdmin() {
        String id = LoadProperties.getValueFromPropertyFile("testData", "clientAdminId");
        String pwd = LoadProperties.getValueFromPropertyFile("testData", "clientAdminPassword");
        userSigninPage.enterCredentials(id, pwd);
    }

    @When("^User sign in with valid credential of Ten Fed Admin$")
    public void userSignInWithValidCredentialOfTenFedAdmin() {
        String id = LoadProperties.getValueFromPropertyFile("testData", "tenFedAdminId");
        String pwd = LoadProperties.getValueFromPropertyFile("testData", "tenFedAdminPassword");
        userSigninPage.enterCredentials(id, pwd);

    }

    @When("^User sign in with valid credential of Super Admin$")
    public void userSignInWithValidCredentialOfSuperAdmin() {
        String id = LoadProperties.getValueFromPropertyFile("testData", "superAdminId");
        String pwd = LoadProperties.getValueFromPropertyFile("testData", "superAdminPassword");
        userSigninPage.enterCredentials(id, pwd);
    }

    @When("^user clicks on the forgot password link$")
    public void userClicksOnTheForgotPasswordLink() {
        userSigninPage.userClicksOnForgotPasswordLink();

    }

    @Then("^user should redirects to the resetpassword page$")
    public void userShouldRedirectsToTheResetpasswordPage() {
        userSigninPage.switchToNextTab();
        userSigninPage.redirectsOnResetPasswordPage();
    }

    @Then("^Reset Password page is displayed$")
    public void resetPasswordPageIsDisplayed() {
    }

    @And("^I enter Email Address as \"([^\"]*)\"$")
    public void iEnterEmailAddressAs(String arg0) throws Throwable {
        userSigninPage.enterEmailForForgotPaasword();
    }

    @And("^user clicks on the submitbutton$")
    public void userClicksOnTheSubmitbutton() {
        userSigninPage.userClicksOnSubmitBtn();
    }

    @And("^log into yopmail with \"([^\"]*)\" email id$")
    public void logIntoYopmailWithEmailId(String arg0) throws Throwable {
        userSigninPage.getDriver().get(conf.getString("mail_url"));
        userSigninPage.userEnttersEmailInMailnator();
    }

    @And("^user clicks on the mail tab and clicks on the link reset password$")
    public void userClicksOnTheMailTabAndClicksOnTheLinkResetPassword() {
        userSigninPage.userCliksOnTheLinkResetPassword();
    }

    @And("^I enter new password and confirm new password same$")
    public void iEnterNewPasswordAndConfirmNewPasswordSame() {
        userSigninPage.userEnterNewAndConfirmPwd();

    }

    @And("^I enter username and password$")
    public void iEnterUsernameAndPassword() {
        String id = LoadProperties.getValueFromPropertyFile("testData", "UserEmailForgotPwd");
        String pwd = LoadProperties.getValueFromPropertyFile("testData", "forpwd");
        userSigninPage.enterCredentials(id, pwd);
    }
}


