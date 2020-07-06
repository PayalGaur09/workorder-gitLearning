package steps.web;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.configuration.ConfigurationException;
import pages.UsergroupModulePage;

import java.io.IOException;

public class UsergroupModuleSteps extends PageObject {
    UsergroupModulePage usergroup;

    @And("^user redirects to the usergroup page$")
    public void userRedirectsToTheUsergroupPage() {
        usergroup.verifyRedirection();
    }


    @And("^user clicks on create new usergroup button$")
    public void userClicksOnCreateNewUsergroupButton() {
        usergroup.userClicksOnNewUserGroupButton();
    }

    @And("^user enters the value in the group name field$")
    public void userEntersTheValueInTheGroupNameField(DataTable table) throws IOException, ConfigurationException {
        usergroup.userEntersTheValueInGroupNameField(table);

    }

    @And("^user clicks on the member assigned dropdown$")
    public void userClicksOnTheMemberAssignedDropdown() {
        usergroup.selectMemberDropdown();
    }

    @And("^cross verify the details$")
    public void crossVerifyUsergroupEnteredDetails() {
        usergroup.verifyUserGroupDetails();
    }


    @And("^user delete the  usergroup$")
    public void userDeleteTheUsergroup() {
        usergroup.userDeleteUsergroup();
    }


    @And("^user clicks on the deativating button for usergroup$")
    public void userClicksOnTheDeativatingButtonForUsergroup() {
        usergroup.userClicksOnDeactivatiingButton();
    }

    @And("^user clicks on the activating for usergroup$")
    public void userClicksOnTheActivatingForUsergroup() {
        usergroup.userClicksOnActivatingButton();
    }

    @Then("^user clicks on the edit button for edit the usergroup details$")
    public void userClicksOnTheEditButtonForEditTheUsergroupDetails() {
        usergroup.userCkicksOnEditButton();
    }

    @And("^user edit the usergroup details$")
    public void userEditTheUsergroupDetails(DataTable data) {
        usergroup.UserEditUserGroupDetails(data);
    }

    @And("^user check the validation on create usergroup page$")
    public void userCheckTheValidationOnCreateUsergroupPage(DataTable value) {
        usergroup.userCheckValidationMessage(value);
    }

    @And("^user enters  the details$")
    public void userEntersTheDetails(DataTable value) throws IOException, ConfigurationException {
        usergroup.userEntersTheDetails(value);
    }

    @And("^user enter the value in usergroup again$")
    public void userEnterTheValueInUsergroupAgain() {
        usergroup.userCheckSameNameUsergroupIsNotExist();
    }

    @And("^user clicks on the confirm buttom for delete the usergroup$")
    public void userClicksOnTheConfirmButtomForDeleteTheUsergroup() {
        usergroup.userClicksOnDeleteButton();
    }

    @And("^User clicks on any company$")
    public void userClicksOnAnyCompany() {
        usergroup.userClicksOnAnyCompany();
    }

    @And("^user Clicks on usergroup tab$")
    public void userClicksOnUsergroupTab() {
        usergroup.userClicksOnUserGroupTab();
    }
}

