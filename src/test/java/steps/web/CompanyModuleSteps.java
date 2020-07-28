package steps.web;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import pages.CompanyModulePage;
import pages.UserSigninPage;
import utilities.LoadProperties;

import java.io.IOException;


public class CompanyModuleSteps extends PageObject {
    CompanyModulePage companySigninPage;
    private UserSigninPage userSigninPage;

    @When("^User sign in with valid credential of administrator$")
    public void userSignInWithValidCredentialOfAdministrator() {
        companySigninPage.enterCredentialsForAdministrator("admin", "Password@123");
    }

    @When("^user clicks on the newcompany button$")
    public void userClicksOnTheNewcompanyButton() {
        companySigninPage.crateNewCompany();
    }

    @Then("^user should redirects to the add company page$")
    public void userShouldRedirectsToTheAddCompanyPage() {
        companySigninPage.verifyRedirection();
    }

    @And("^user fill the details for creating a new company$")
    public void userFillTheDetailsForCreatingANewCompany(DataTable dataTable) throws IOException, ConfigurationException {
        companySigninPage.addDetailsForCreatingNewCompany(dataTable);
    }

    @And("^user clicks on the submit$")
    public void userClicksOnTheSubmit() {
        companySigninPage.userClicksOnSubmitButton();

    }

    @And("^user delete the company$")
    public void userDeleteTheCompany() {
        companySigninPage.userDeleteTheCompany();
    }


    @And("^user clicks on the OK button for deleting the company$")
    public void userClicksOnTheOKButtonForDeletingTheCompany() {
        companySigninPage.userCliksOnOkButtonForDeletingTheCompany();

    }


    @And("^user clicks on the edit button of the company$")
    public void userClicksOnTheEditButtonOfTheCompany() {
        companySigninPage.userclicksOnTheEditButton();
    }

    @And("^user check the validation on  add company page$")
    public void userCheckTheValidationOnAddCompanyPage(DataTable validation) {
        companySigninPage.checkValidationsOnAddCompany(validation);

    }


    @And("^user clicks on the cancel button$")
    public void userClicksOnTheCancelButton() {
        companySigninPage.userCliksOnCancelButtonOfAddCompanyPage();

    }

    @Then("^user Should redirects to the companypage$")
    public void userShouldRedirectsToTheCompanypage() {
        companySigninPage.verifyTheRedirection();
    }

    @And("^user edit the Company details details$")
    public void userEditTheCompanyDetailsDetails() {
        companySigninPage.userEditTheCompanyDetails();
    }
    @Then("^verify data on company table$")
    public void verifyDataOnCompanyTable() {
        companySigninPage.dataVerify();
    }
    @And("^user clicks on the edit button for account owner details$")
    public void userClicksOnTheEditButtonForAccountOwnerDetails() {
        companySigninPage.userCliksOnTheEditButtonForAccountOwnerDetails();
    }
    @And("^user edit  the details$")
    public void userEditTheDetails(DataTable editownerdetails) {
        companySigninPage.userEditTheOwnerDetails(editownerdetails);
    }
    @And("^user clicks on the company$")
    public void userClicksOnTheCompany() {
        companySigninPage.verifyTheDetailsOfTheEditCompany();
    }

    @Then("^user cross verify the Account owner details$")
    public void userCrossVerifyTheAccountOwnerDetails() {
        companySigninPage.crossVeriyTheOwnerDetails();
    }


    @And("^user click on the deactivate button for the company$")
    public void userClickOnTheDeactivateButtonForTheCompany() {
        companySigninPage.userCheckTheCompanyStatus();
    }
    @When("^search filter by company$")
    public void searchFilterByCompany() throws Throwable {
        companySigninPage.searchText().sendKeys(LoadProperties.getProp("name", "testData"));
    }
    @And("^Verify Company on list$")
    public void verifyCompanyOnList() throws Throwable {
        companySigninPage.verifyCompanyOnList();
    }

    @When("^search filter by inValid companyName$")
    public void searchFilterByInValidCompanyName() throws Throwable {
        companySigninPage.searchText().sendKeys(LoadProperties.getProp("inValidCompany", "testData"));
    }

    @Then("^Verify data on list$")
    public void verifyDataOnList() throws Throwable {
        companySigninPage.noData();
    }
    @And("^user click on the activate button for the company$")
    public void userClickOnTheActivateButtonForTheCompany() {
        companySigninPage.verifyCompanyProfileStatusActive();
    }

    @When("^user select the status active from the dropdown$")
    public void userSelectTheStatusActiveFromTheDropdown() {
        companySigninPage.VerifyTheActiveStatus();
    }

    @Then("^All the status active should be displayed to the user$")
    public void allTheStatusActiveShouldBeDisplayedToTheUser() {
        companySigninPage.verifyAllTheActiveStatusVisibleToTheuser();
    }

    @When("^user select the status inactive from the dropdown$")
    public void userSelectTheStatusInactiveFromTheDropdown() {
        companySigninPage.VerifyTheInActiveStatus();
    }

    @And("^User Clicks on the each tab showing on company detail page$")
    public void userClicksOnTheEachTabShowingOnCompanyDetailPage() {
        companySigninPage.navigationPage();
    }

    @Then("^All the status inactive should be displayed to the user$")
    public void allTheStatusInactiveShouldBeDisplayedToTheUser() {
        companySigninPage.verifyAllTheInActiveStatusVisibleToTheuser();

    }

    @And("^cross verify the create details$")
    public void crossVerifyTheCreateDetails() {
        companySigninPage.userVerifyTheCompanyDetails();
    }


    @Then("^Notification for company creation is displayed$")
    public void notificationForCompanyCreationIsDisplayed() {
        companySigninPage.verifyAddCompanyNotification();
        userSigninPage.signout();
    }

    @Then("^Notification for Existing Company is  Deactivated is displayed$")
    public void notificationForExistingCompanyIsDeactivatedIsDisplayed() {
        companySigninPage.verifyDeactivatedCompanyNotification();
        userSigninPage.signout();
    }

    @Then("^Notification for Existing Company Deleted is displayed$")
    public void notificationForExistingCompanyDeletedIsDisplayed() {
        companySigninPage.verifyDeleteCompanyNotification();
        userSigninPage.signout();
    }

    @Then("^Edit button should not  visible to the  client personel$")
    public void editButtonShouldVisibleToTheClientPersonel() {
        companySigninPage.checkEditButtonForClientPersoneel();
    }

    @Then("^Edit button should visible to the  client admin$")
    public void editButtonShouldVisibleToTheClientAdmin() {
        companySigninPage.checkEditButtonForClientAdmin();

    }

    @Then("^Notification for Existing Company is deleted is displayed$")
    public void notificationForExistingCompanyIsDeletedIsDisplayed() {
       companySigninPage.verifyDeleteNotification();
        userSigninPage.signout();

    }


}

















