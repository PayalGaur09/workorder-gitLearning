package steps.web;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.configuration.ConfigurationException;
import pages.CompanyModulePage;
import utilities.LoadProperties;

import java.io.IOException;



public class CompanyModuleSteps extends PageObject {
    CompanyModulePage companysigninpage;

    @When("^User sign in with valid credential of administrator$")
    public void userSignInWithValidCredentialOfAdministrator() {
        companysigninpage.enterCredentialsForAdministrator("admin", "Password@123");


    }

    @When("^user clicks on the newcompany button$")
    public void userClicksOnTheNewcompanyButton() {
        companysigninpage.crateNewCompany();
    }

    @Then("^user should redirects to the add company page$")
    public void userShouldRedirectsToTheAddCompanyPage() {
        companysigninpage.verifyRedirection();
    }

    @And("^user fill the details for crating a new company$")
    public void userFillTheDetailsForCratingANewCompany(DataTable dataTable) throws IOException, ConfigurationException {
        companysigninpage.addDetailsForCreatingNewCompany(dataTable);
    }

    @And("^user clicks on the submit$")
    public void userClicksOnTheSubmit() {
        companysigninpage.userClicksOnSubmitButton();

    }

    @And("^user delete the company$")
    public void userDeleteTheCompany() {
        companysigninpage.userDeleteTheCompany();
    }


    @And("^user clicks on the OK button for deleting the company$")
    public void userClicksOnTheOKButtonForDeletingTheCompany() {
        companysigninpage.userCliksOnOkButtonForDeletingTheCompany();

    }


    @And("^user clicks on the edit button of the company$")
    public void userClicksOnTheEditButtonOfTheCompany() {
        companysigninpage.userclicksOnTheEditButton();
    }

    @And("^user check the validation on  add company page$")
    public void userCheckTheValidationOnAddCompanyPage(DataTable validation) {
        companysigninpage.checkValidationsOnAddCompany(validation);

    }


    @And("^user clicks on the cancel button$")
    public void userClicksOnTheCancelButton() {
        companysigninpage.userCliksOnCancelButtonOfAddCompanyPage();

    }

    @Then("^user Should redirects to the companypage$")
    public void userShouldRedirectsToTheCompanypage() {
        companysigninpage.verifyTheRedirection();

    }

    @And("^user edit the Company details details$")
    public void userEditTheCompanyDetailsDetails() {
        companysigninpage.userEditTheCompanyDetails();

    }

    @Then("^verify data on company table$")
    public void verifyDataOnCompanyTable() {
        companysigninpage.dataVerify();
    }

    @And("^user clicks on the edit button for account owner details$")
    public void userClicksOnTheEditButtonForAccountOwnerDetails() {
        companysigninpage.userCliksOnTheEditButtonForAccountOwnerDetails();
    }

    @And("^user edit  the details$")
    public void userEditTheDetails(DataTable editownerdetails) {
        companysigninpage.userEditTheOwnerDetails(editownerdetails);
    }

    @Given("^User is on work order Login in page$")
    public void userIsOnWorkOrderLoginInPage() {
        companysigninpage.openLoginPage();
    }

    @And("^I login with '(.*)'$")
    public void iLoginWithAdmin(String username) throws Throwable {
        companysigninpage.loginAs(username);
    }

    @When("^user enter username and password$")
    public void iEnterUsernameAndPassword(DataTable inputs) throws Throwable {
        if (inputs.asMaps(String.class, String.class).get(0).get("userEmail").equalsIgnoreCase("admin")) {
            companysigninpage.enterLogindetails(LoadProperties.getProp("admin", "testData"), inputs.asMaps(String.class, String.class).get(0).get("password"));
        } else if (inputs.asMaps(String.class, String.class).get(0).get("userEmail").equalsIgnoreCase("clientpersonal")) {
            companysigninpage.enterLogindetails(LoadProperties.getProp("clientpersonal", "testData"), inputs.asMaps(String.class, String.class).get(0).get("password"));

        } else if (inputs.asMaps(String.class, String.class).get(0).get("userEmail").equalsIgnoreCase("accountowner")) {
            companysigninpage.enterLogindetails(LoadProperties.getProp("accountowner", "testData"), inputs.asMaps(String.class, String.class).get(0).get("password"));
        }
    }

    @And("^user clicks on the edit company$")
    public void userClicksOnTheEditCompany() {
        companysigninpage.verifyTheDetailsOfTheEditCompany();
    }

    @Then("^user cross verify the Account owner details$")
    public void userCrossVerifyTheAccountOwnerDetails() {
        companysigninpage.crossVeriyTheOwnerDetails();
    }

    @Given("^user is on the company page of work order application$")
    public void userIsOnTheCompanyPageOfWorkOrderApplication() {
    }


    @And("^user click on the deactivate button for the company$")
    public void userClickOnTheDeactivateButtonForTheCompany() {
        companysigninpage.userCheckTheCompanyStatus();
    }


    @When("^search filter by company$")
    public void searchFilterByCompany() throws Throwable {
        companysigninpage.searchText().sendKeys(LoadProperties.getProp("name", "testData"));

    }

    @And("^Verify Company on list$")
    public void verifyCompanyOnList() throws Throwable {
        companysigninpage.verifyCompanyOnList();
    }

    @When("^search filter by inValid companyName$")
    public void searchFilterByInValidCompanyName() throws Throwable {
        companysigninpage.searchText().sendKeys(LoadProperties.getProp("inValidCompany", "testData"));
    }

    @Then("^Verify data on list$")
    public void verifyDataOnList() throws Throwable {
        companysigninpage.noData();
    }


    @And("^user click on the activate button for the company$")
    public void userClickOnTheActivateButtonForTheCompany() {
        companysigninpage.verifyCompanyProfileStatusActive();
    }


    @When("^User click on company$")
    public void userClickOnCompany() throws Throwable {
        companysigninpage.clickOnCompany();
    }

    @When("^user select the status active from the dropdown$")
    public void userSelectTheStatusActiveFromTheDropdown() {
        companysigninpage.VerifyTheActiveStatus();
    }

    @Then("^All the staus active should be displayed to the user$")
    public void allTheStausActiveShouldBeDisplayedToTheUser() {
        companysigninpage.verifyAllTheActiveStatusVisibleToTheuser();
    }

    @When("^user select the status inactive from the dropdown$")
    public void userSelectTheStatusInactiveFromTheDropdown() {
        companysigninpage.VerifyTheInActiveStatus();
    }

    @And("^User Clicks on the each tab showing on company detail page$")
    public void userClicksOnTheEachTabShowingOnCompanyDetailPage() {
        companysigninpage.navigationPage();
    }

    @Then("^All the staus inctive should be displayed to the user$")
    public void allTheStausInctiveShouldBeDisplayedToTheUser() {
        companysigninpage.verifyAllTheInActiveStatusVisibleToTheuser();

    }



    @And("^cross verify the create details$")
    public void crossVerifyTheCreateDetails() {
        companysigninpage.userVerifyTheCompanyDetails();
    }

    @And("^User Clicks On the Company$")
    public void userClicksOnTheCompany() {
        companysigninpage.UserClicksOnTheCompany();
    }
}













