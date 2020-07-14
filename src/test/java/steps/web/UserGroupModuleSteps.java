package steps.web;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.configuration.ConfigurationException;
import pages.UserGroupModulePage;

import java.io.IOException;

public class UserGroupModuleSteps extends PageObject {
    UserGroupModulePage userGroup;

    @And("^user redirects to the usergroup page$")
    public void userRedirectsToTheUsergroupPage() {
        userGroup.verifyRedirection();
    }


    @And("^user clicks on create new usergroup button$")
    public void userClicksOnCreateNewUsergroupButton() {
        userGroup.userClicksOnNewUserGroupButton();
    }

    @And("^user enters the value in the group name field$")
    public void userEntersTheValueInTheGroupNameField(DataTable table) throws IOException, ConfigurationException {
        userGroup.userEntersTheValueInGroupNameField(table);

    }

    @And("^user clicks on the member assigned dropdown$")
    public void userClicksOnTheMemberAssignedDropdown() {
        userGroup.selectMemberDropdown();
    }

    @And("^cross verify the details$")
    public void crossVerifyUsergroupEnteredDetails() {
        userGroup.verifyUserGroupDetails();
    }


    @And("^user delete the  usergroup$")
    public void userDeleteTheUsergroup() {
        userGroup.userDeleteUsergroup();
    }


    @And("^user clicks on the deativating button for usergroup$")
    public void userClicksOnTheDeativatingButtonForUsergroup() {
        userGroup.userClicksOnDeactivatiingButton();
    }

    @And("^user clicks on the activating for usergroup$")
    public void userClicksOnTheActivatingForUsergroup() {
        userGroup.userClicksOnActivatingButton();
    }

    @Then("^user clicks on the edit button for edit the usergroup details$")
    public void userClicksOnTheEditButtonForEditTheUsergroupDetails() {
        userGroup.userCkicksOnEditButton();
    }

    @And("^user edit the usergroup details$")
    public void userEditTheUsergroupDetails(DataTable editusergroupname) {
        userGroup.UserEditUserGroupDetails(editusergroupname);
    }

    @And("^user check the validation on create usergroup page$")
    public void userCheckTheValidationOnCreateUsergroupPage(DataTable value) {
        userGroup.userCheckValidationMessage(value);
    }

    @And("^user enters  the details$")
    public void userEntersTheDetails(DataTable value) throws IOException, ConfigurationException {
        userGroup.userEntersTheDetails(value);
    }

    @And("^user enter the value in usergroup again$")
    public void userEnterTheValueInUsergroupAgain() {
        userGroup.userCheckSameNameUsergroupIsNotExist();
    }

    @And("^user clicks on the confirm buttom for delete the usergroup$")
    public void userClicksOnTheConfirmButtomForDeleteTheUsergroup() {
        userGroup.userClicksOnDeleteButton();
    }

    @And("^User clicks on any company$")
    public void userClicksOnAnyCompany() {
        userGroup.userClicksOnAnyCompany();
    }

    @And("^user Clicks on usergroup tab$")
    public void userClicksOnUsergroupTab() {
        userGroup.userClicksOnUserGroupTab();
    }

    @And("^User adds a user to the usergroup$")
    public void userAddsAUserToTheUsergroup() {
        userGroup.userTapOnUserAssignedDropdown();
        userGroup.selectUserGroupCheckbox();
    }

    @And("^User adds a multiple user to usergroup$")
    public void userAddsAMultipleUserToUsergroup() {
        userGroup.userTapOnUserAssignedDropdown();
        userGroup.selectMultipleUserGroupCheckbox();


    }

    @And("^Select all user to the usergroup$")
    public void selectAllUserToTheUsergroup() {
        userGroup.userTapOnUserAssignedDropdown();
        userGroup.selectAllUserGroupCheckbox();

    }

    @And("^user removes the usergroup$")
    public void userRemovesTheUsergroup() {
        userGroup.userTapOnUserAssignedDropdown();
        userGroup.userRemovesTheUseGroup();
    }


    @And("^cross verify the edit  details$")
    public void crossVerifyTheEditDetails() {
        userGroup.userCrossVerifyTheEditDetails();
    }


    @And("^User clicks on the deactivate button$")
    public void userClicksOnTheDeactivateButton() {
        userGroup.UserClicksOnDeactivateButton();
    }
}

