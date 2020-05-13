package steps.web;

import com.typesafe.config.Config;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.UserManagementPage;
import pages.UserManagementPage;
import utilities.ConfigLoader;

import java.io.IOException;

public class UserManagementSteps {
    Config conf = ConfigLoader.load();
    UserManagementPage users;


    @Given("^User is on add user screen$")
    public void userIsOnAddUserScreen() {
        users.tapOnAddUserButton();
    }


    @When("^User enters all the field in user screen$")
    public void userEntersAllTheFieldInUserScreen() throws IOException {
        users.uploadProfilePicture();
        users.addInputFieldsOfUserForm();
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
       // users.verifyUserRole(userRoles);
    }

    @Then("^List displayed is according to the selected \"([^\"]*)\" role$")
    public void listDisplayedIsAccordingToTheSelectedRole(String userRoles) throws Throwable {
        users.verifyUserRole(userRoles);
    }

    @When("^User clicks on Select status dropdown$")
    public void userClicksOnSelectStatusDropdown() {
        users.selectStatusDropdown();
    }

    @And("^User select \"([^\"]*)\" status$")
    public void userSelectStatus(String status)  {
        users.selectFilterDropdown(status);
        users.tapOnFilterButton();
        users.verifyStatus(status);
    }

    @Then("^List displayed is according to the selected \"([^\"]*)\" status$")
    public void listDisplayedIsAccordingToTheSelectedStatus(String status) throws Throwable {
        users.verifyStatus(status);
    }

    @When("^User enters a keyword \"([^\"]*)\" in the search field$")
    public void userEntersAKeywordInTheSearchField(String searchKey) throws Throwable {
        users.enterKeyInSearchField(searchKey);
    }


    @Then("^List displayed is according to the entered keyword$")
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

}
