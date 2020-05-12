package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import pages.CompanyModulePage;


public class CompanyModuleSteps extends PageObject {
    CompanyModulePage companysigninpage;

    @When("^User sign in with valid credential of administrator$")
    public void userSignInWithValidCredentialOfAdministrator() {
        companysigninpage.enterCredentialsForAdministrator("admin","Password@123");


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
    public void userFillTheDetailsForCratingANewCompany(DataTable adddetails) {
        companysigninpage.addDetailsForCreatingNewCompany(adddetails);
    }

    @And("^user clicks on the submit button$")
    public void userClicksOnTheSubmitButton() {
        companysigninpage.userClicksOnSubmitButton();
    }
}
