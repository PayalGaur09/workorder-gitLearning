package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.FacilityManagementPage;

public class FacilityManagementSteps {

    FacilityManagementPage facility;

    @Given("^User is on add facility screen$")
    public void userIsOnAddFacilityScreen() {
        facility.clickAddFacility();
    }

    @When("^User enters all the field in Facility screen$")
    public void userEntersAllTheFieldInFacilityScreen() {
        facility.enterAllFields();
        facility.selectDropdown();
    }

    @And("^User verify facility detail screen$")
    public void userVerifyFacilityDetailScreen() {
        facility.verifyDetails();
    }
}
