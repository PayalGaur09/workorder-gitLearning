package steps;

import com.typesafe.config.Config;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.UserManagementPage;
import pages.UserManagementPage;
import utilities.ConfigLoader;

public class UserManagementSteps {
    Config conf = ConfigLoader.load();
    UserManagementPage users;


    @Given("^User is on add user screen$")
    public void userIsOnAddUserScreen() {
        users.tapOnAddUserButton();
    }


    @When("^User enters all the field in user screen$")
    public void userEntersAllTheFieldInUserScreen() {
        users.addInputFiledsOfUserForm();
    }


    @And("^User select Client Admin as the user role$")
    public void userSelectClientAdminAsTheUserRole() {
        users.selectRole("Administrator");
    }


    @And("^User select Client Personnel as the user role$")
    public void userSelectClientPersonnelAsTheUserRole() {
        users.selectRole("Personnel");
    }

    @And("^Verify user detail screen$")
    public void verifyUserDetailScreen() {
        users.userDetailsVerify();
    }


    @When("^User clicks on Select role dropdown$")
    public void userClicksOnSelectRoleDropdown() {
        users.selectRoleDropdown();

    }

    @And("^User select \"([^\"]*)\" role$")
    public void userSelectRole(String userRoles)  {
        users.selectFilterDropdown(userRoles);
        users.tapOnFilterButton();
        users.verifyUserRole(userRoles);
    }

    @When("^User clicks on Select status dropdown$")
    public void userClicksOnSelectStatusDropdown() {
        users.selectStatusDropdown();
    }

    @And("^User select \"([^\"]*)\" status$")
    public void userSelectStatus(String userStatus)  {
        users.selectFilterDropdown(userStatus);
        users.tapOnFilterButton();
        users.verifyUserStatus(userStatus);
    }


    @When("^User enters a user name$")
    public void userEntersAUserName() {
        users.enterKeyInSearchField();
    }

    @Then("^User list displayed is according to the entered keyword$")
    public void userListDisplayedIsAccordingToTheEnteredKeyword() {
        users.verifyUserName();
    }

    @When("^User clicks on \"([^\"]*)\" icon on list page$")
    public void userClicksOnIconOnListPage(String title) {
        users.tapOnStatusIcon(title);
    }

    @And("^User verify status and takes necessary actions to change the status$")
    public void userVerifyStatusAndTakesNecessaryActionsToChangeTheStatus() {
        users.changeUserStatus();
    }

    @Then("^User verified the changed status$")
    public void userVerifiedTheChangedStatus() {
        users.verifyChangedStatus();
    }


//    @And("^Status of user changes to \"([^\"]*)\"$")
//    public void statusOfUserChangesTo(String arg0) throws Throwable {
//        users.statusChanged(arg0);
//    }
}
