package steps.web;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.configuration.ConfigurationException;
import pages.CompanyModulePage;

import java.io.IOException;


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
}
