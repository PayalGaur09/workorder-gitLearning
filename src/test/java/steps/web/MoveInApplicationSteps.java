package steps.web;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.AmenityIconModel;
import models.ImageModel;
import net.serenitybdd.core.pages.PageObject;
import pages.MoveInApplicationPage;
import pages.ProfilePage;
import net.serenitybdd.core.pages.PageObject;
import pages.ProfilePage;
import utilities.ConfigLoader;

import java.io.IOException;
import java.util.List;


public class MoveInApplicationSteps extends PageObject {
    MoveInApplicationPage moveinapplication;


    @Then("^user should redirects to the  Manage Kiosk  page$")
    public void userShouldRedirectsToTheManageKioskPage() {
        moveinapplication.verifyMangeKioskDetailViewPage();
    }

    @When("^user clicks on configure and manage button$")
    public void userClicksOnConfigureAndManageButton() {
        moveinapplication.uploadAmentiesAndIcons();
    }


    @And("^user selects the amenties from select amenties dropdpwn$")
    public void userSelectsTheAmentiesFromSelectAmentiesDropdpwn() {
        moveinapplication.selectAmenity();
    }

    @And("^user uploads the icons in the upload icon fields$")
    public void userUploadsTheIconsInTheUploadIconFields(List<AmenityIconModel> amenityiconModelList) {
        moveinapplication.uploadAmenityAndIcon(amenityiconModelList);
    }

    @And("^user selects the parking checkbox$")
    public void userSelectsTheParkingCheckbox() {
        moveinapplication.selectCheckBox();
    }

    @And("^use clicks on the Add button$")
    public void useClicksOnTheAddButton() {
        moveinapplication.clicksOnAddButton();
    }


    @And("^user Select Amenities$")
    public void userSelectAmenities() {
        moveinapplication.SelectAmenityType();
    }

    @And("^user clicks on the  pagination  from show entries dropdown$")
    public void userClicksOnThePaginationFromShowEntriesDropdown() {
        moveinapplication.userClicksOnFromShowEntriesDropdown();
    }

    @And("^user clicks on the delete button  of amenity$")
    public void userClicksOnTheDeleteButtonOfAmenity() {
        moveinapplication.clicksOnDeleteAmenityIcon();
    }

    @Then("^user click on the cancel button of delete amenity popup$")
    public void userClickOnTheCancelButtonOfDeleteAmenityPopup() {
        moveinapplication.clicksOnCancelButtonOfDeleteAmityPopup();
    }

    @When("^user cliks on the checkbox od driving license number$")
    public void userCliksOnTheCheckboxOdDrivingLicenseNumber() {
        moveinapplication.userClicksOnCheckboxOfDrivingLicenseNumber();
    }

    @And("^user clicks on filed and criteria tab$")
    public void userClicksOnFiledAndCriteriaTab() {
        moveinapplication.clicksOnFieldAndCriteriaTab();
    }

//    @When("^user clicks on the radio button of Dropview$")
//    public void userClicksOnTheRadioButtonOfDropview() {
//
//    }

    @Then("^User Select \"([^\"]*)\" Type$")
    public void userSelectType(String arg0) throws Throwable {
        moveinapplication.selectDropOrPopUp(arg0, 1);
    }


    @And("^user clicks on the toggle button$")
    public void userClicksOnTheToggleButton() {
        moveinapplication.userClicksOnToggleButton();

    }


    @And("^user clicks on apply changes button$")
    public void userClicksOnApplyChangesButton() {
        moveinapplication.userClicksOnApplyChangesButton();
    }

    @And("^user upload the Document file$")
    public void userUploadTheDocumentFile() throws IOException {
        moveinapplication.userUploadTheDoculentFile();
    }
}




