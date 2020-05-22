package steps;

import com.typesafe.config.Config;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.UserManagementPage;
import pages.VendorManagementPage;
import utilities.ConfigLoader;

import java.io.IOException;
import java.util.List;

public class VendorManagementSteps {

    Config conf = ConfigLoader.load();
    VendorManagementPage vendor;
    UserManagementPage users;


    @Given("^User is on add vendor screen$")
    public void userIsOnAddVendorScreen() {
        vendor.tapOnAddVendorButton();
    }

    @When("^User enters all the field$")
    public void userEntersAllTheField() throws IOException {
        users.uploadProfilePicture();
        vendor.addInputFieldsOfVendorForm();
        vendor.selectTypeFromDropdown();
    }

    @When("^User updates all the field of vendor form$")
    public void userUpdatesAllTheFieldOfVendorForm() {
        vendor.addInputFieldsOfVendorForm();
        vendor.selectTypeFromDropdown();
    }

    @And("^User taps on the Submit button$")
    public void userTapsOnTheSubmitButton() {
        vendor.tapOnSubmitButton();
    }


    @And("^User verify vendor detail screen$")
    public void userVerifyVendorDetailPage() {
        vendor.vendorDetailsVerify();
    }


    @And("^User clicks on Cancel button$")
    public void userClicksOnCancelButton() {
        vendor.tapOnCancelButton();
    }


    @Then("^Error message should be displayed$")
    public void errorMessageShouldBeDisplayed(List<String> options) {
        for (String option : options) {
            vendor.verifyValidationMessage(option);
        }

    }

    @When("^User enters invalid contact number$")
    public void userEntersInvalidContactNumber() {
        vendor.enterInvalidContactNo();
    }

    @Given("^User navigates to edit page from list screen$")
    public void userNavigatesToEditPageFromListScreen() {
        vendor.tapOnEditIcon();

    }

    @Then("^Success message \"([^\"]*)\" should be displayed$")
    public void successMessageShouldBeDisplayed(String arg0) throws Throwable {
        vendor.verifyValidationMessage(arg0);
    }

    @Given("^User is on detail screen$")
    public void userIsOnDetailScreen() {
        vendor.tapOnNameLink();
    }

    @When("^User clicks on the action button$")
    public void userClicksOnTheActionButton() {
        vendor.tapOnActionButton();
    }

    @When("^User clicks on edit option from action dropdown$")
    public void userClicksOnEditOptionFromActionDropdown() {
        vendor.tapOnActionButton();
        vendor.editFromActionButton();
    }

    @When("^User clicks on Notes option from action dropdown$")
    public void userClicksOnNotesOptionFromActionDropdown() {
        vendor.tapOnActionButton();
        vendor.noteOptionFromActionButton();
        vendor.tapOnAddButton();

    }

    @And("^User enter a note$")
    public void userEnterANote() {
        vendor.enterNote();
    }

    @Then("^Notes added successfully and user cross verify the added note$")
    public void notesAddedSuccessfullyAndUserCrossVerifyTheAddedNote() {

    }

    @When("^User clicks on edit note icon$")
    public void userClicksOnEditNoteIcon() {
        vendor.tapOnEditNoteIcon();
    }

    @When("^User reaches to notes screen$")
    public void userReachesToNotesScreen() {
        vendor.tapOnActionButton();
        vendor.noteOptionFromActionButton();
    }

    @Then("^Notes count is same as the number of notes listed below$")
    public void notesCountIsSameAsTheNumberOfNotesListedBelow() {vendor.countNotesForVendor();
    }


    @When("^User clicks on Select dropdown and select a vendor type$")
    public void userClicksOnSelectDropdownAndSelectAVendorType() {
        vendor.selectVendorTypeToFilterList();
        vendor.tapOnFilterButton();
    }

    @Then("^Vendor list is filtered out$")
    public void vendorListIsFilteredOut() {
        vendor.verifyVendorType();
    }


    @When("^User clicks on Reset button$")
    public void userClicksOnRestButton() {
        vendor.tapOnResetButton();
    }

    @When("^User enters a keyword$")
    public void userEntersAKeyword() {
        vendor.enterKeywordInSearchField();
    }

    @And("^User clicks on Filter button$")
    public void userClicksOnFilterButton() {
        vendor.tapOnFilterButton();
    }

    @Then("^Vendor list displayed is according to the entered keyword$")
    public void vendorListDisplayedIsAccordingToTheEnteredKeyword() {
        vendor.verifyVendorName();
    }

    @And("^User hits 'Enter' button on keyboard$")
    public void userHitsEnterButtonOnKeyboard() {
        vendor.pressEnterKey();
    }

    @Then("^Vendor list displayed is according to the searched keyword and vendor type$")
    public void vendorListDisplayedIsAccordingToTheSearchedKeywordAndVendorType() {
        vendor.verifyIntergrationOfSearchFilter();
    }

    @When("^User clicks on delete icon$")
    public void userClicksOnDeleteIcon() {
        vendor.clickOnDeleteIcon();
    }

    @And("^User clicks on 'OK' option in the confirmation popup$")
    public void userClicksOnOKOptionInTheConfirmationPopup() {
        vendor.acceptOptionInJSPopup();
    }

    @When("^User clicks on delete button$")
    public void userClicksOnDeleteButton() {
        vendor.clickOnDeleteButton();
    }

}
