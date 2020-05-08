package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import models.ContentModel;
import models.ImageModel;
import org.apache.commons.configuration.ConfigurationException;
import pages.SignageApplicationPage;

import java.io.IOException;
import java.util.List;

public class SignageApplicationSteps {
    SignageApplicationPage managekioskpage;

    @Then("^user should redirects to the kiosk page$")
    public void userShouldRedirectsToTheKioskPage() {
        managekioskpage.verifyKioskPage();
    }

    @And("^user clicks on register new kiosk button$")

    public void userClicksOnRegisterNewKioskButton() {
        managekioskpage.verifyRegistration();
    }


    @And("^User clicks on Select dropdown and select a facility$")
    public void userClicksOnSelectDropdownAndSelectAFacility() {

        managekioskpage.selectFacilityFromDropdown();


    }

    @And("^user enters the registration key and tag field$")
    public void userEntersTheRegistrationKeyAndTagField(DataTable values) {
        managekioskpage.enterRegistrationKeyAndTag(values);
    }


    @And("^user clicks on the configure  button$")

    public void userClicksOnTheConfigureButton() {
        managekioskpage.clickingOnConfigureButton();
    }

    @And("^user redirects to the managekioskpage$")
    public void userRedirectsToTheManagekioskpage() {
        managekioskpage.redirectsManageKioskPage();
    }






//    @And("^user selects pagination  from show entries dropdown$")
//    public void userClicksSelectsPageEntriesFromShowEntriesDropdown() {
//        managekioskpage.selectPageFromShowEntriesDropdown();
//
//    }


    @And("^user selects the tag kiosk page$")
    public void userSelectsTheTagKioskPage() {
        managekioskpage.selectTagFromKiosk();

    }

//    @And("^user clicks on the upload content button$")
//    public void userClicksOnTheUploadContentButton() {
//        managekioskpage.uploadContent();
//    }

    @And("^user fills all the details$")
    public void userFillsAllTheDetails(DataTable text) {
        managekioskpage.addContentForSignageAppliccation(text);

    }

    @And("^user clicks  on the submit button$")
    public void userClicksOnTheSubmitButton() {
        managekioskpage.submitButton();
    }

    @And("^user upload the image type content in the upload content field$")
    public void userUploadThePngTypeContentInTheUploadContentField(List<ImageModel> imageModelList) {
        managekioskpage.uploadProductImage(imageModelList);

    }

//    @And("^user clicks on the manage button$")
//    public void userClicksNTheManageButton() {
//        managekioskpage.clicksOnManageButton();
//    }

    @And("^user clicks on the addcontent button$")
    public void userClicksOnTheAddcontentButton() {
        managekioskpage.clicksOnAddContentBtn();
    }

    @And("^user clicks on the  Cancel button$")
    public void userClicksOnTheCancelButton() {
        managekioskpage.clicksOnCanceltBtn();
    }

    @Then("^user should redirects to the  Manage Signage page$")
    public void userShouldRedirectsToTheManageSignagePage() {
        managekioskpage.redirectionOnManageSignagepage();
    }

    @And("^user clicks on the Edit button$")
    public void userClicksOnTheEditButton() {
        managekioskpage.clicksOnEditButton();
    }

    @And("^user clicks on the Change file  button$")
    public void userClicksOnTheChangeButton() {
        managekioskpage.editFile();
    }


    @And("^user Edit the content details$")
    public void userEditTheContentDetails(DataTable details) {
        managekioskpage.editAllContentDetails(details);
    }

    @And("^user clicks on the delete button$")
    public void userClicksOnTheDeleteButton() {
        managekioskpage.clicksOnDeleteContent();
    }

    @And("^user clicks on the cancel button of delete popup$")
    public void userClicksOnTheCancelButtonOfDeletePopup() {
        managekioskpage.clickOnCancelButtonOfDeletePopup();
    }


    @And("^User clicks on the delete fileicon$")
    public void userClicksOnTheDeleteFunction() {
        managekioskpage.clicksOndeleteFileIcon();
    }

    @And("^user upload the content in choose file$")
    public void userUploadTheContentInChooseFile(List<ContentModel> contentModelList) {
        managekioskpage.uploadVideoPdf(contentModelList);

    }

    @And("^user clicks on Choose file in thumbnail field$")
    public void userClicksOnChooseFileInThumbnailField() {
        managekioskpage.uploadContentInThumbnail();
    }

//    @And("^user upload the image type content in thumbnail field$")
//    public void userUploadTheImageTypeContentInThumbnailField(List<ThumbnailModel> thumbnailModelList) {
//        managekioskpage.uploadContentInThumbnailField(thumbnailModelList);
//
//    }

//    @And("^user clicks on the \"([^\"]*)\"  button$")
//    public void userClicksOnTheButton(String action) throws Throwable {
//        managekioskpage.uploadContent(action);
//    }
    public void userClicksOnUploadContentOrManageContentButton(){

    }

    @And("^user clicks on the upload content or manage content button$")
    public void userClicksOnTheUploadContentOrManageContentButton() {
        managekioskpage.userClicksOnUploadContentOrManageContentButton();
    }

    @And("^user clicks on manage button$")
    public void userClicksOnManageButton() {
        managekioskpage.userClicksOnManageButton();

    }



    @And("^user upload the image type content in thumbnail field$")
    public void userUploadTheImageTypeContentInThumbnailField(List<ImageModel> imageModelList) {
            managekioskpage.uploadFileInThumbnail(imageModelList);
    }

    @And("^user check the functionality of toggle button$")
    public void userCheckTheFunctionalityOfToggleButton() {
        managekioskpage.userClicksOnTheToggleButtonOfSignageApplication();

    }


    @Then("^error message should be come \"([^\"]*)\"$")
    public void errorMessageShouldBeCome(String arg0) throws Throwable {
        managekioskpage.registrationKeyAlreadyExist();
    }

    @And("^user clicks on the show entries dropdown in list view of manage kiosk page$")
    public void userClicksOnTheShowEntriesDropdownInListViewOfManageKioskPage() {
        managekioskpage.userClicksOnFromShowEntriesDropdownOfListvieOfManageKiosk();
    }

    @And("^user delete the tag from the list$")
    public void userDeleteTheTagFromTheList()
    {
        managekioskpage.userClicksOnDeleteTag();
    }




    @Then("^user enters the title and description$")
    public void userEntersTheTitleAndDescription(DataTable values) throws IOException, ConfigurationException {
        managekioskpage.userEntersTitleThatAlradyExist(values);

    }

    @And("^User enter title in text box$")
    public void userEnterTitleInTextBox() throws Throwable {
        managekioskpage.titleText();
    }

    @Then("^user enters the title and description again$")
    public void userEntersTheTitleAndDescriptionAgain() throws Throwable {
        managekioskpage.enterTitleDescription();
    }

    @Then("^Verify the error message$")
    public void verifyTheErrorMessage() throws Throwable {
      managekioskpage.errorMessagePopup();
    }

    @Given("^there are at least 10 existing tags on landing page$")
    public void thereAreAtLeastExistingTagsOnLandingPage() throws Throwable {
        managekioskpage.countOfPlansOnlistPage();
    }

    @Then("^I will check for presence of pagination on landing page$")
    public void iWillCheckForPresenceOfPaginationOnLandingPage() throws Throwable {
        managekioskpage.verifyPaginationExists();
    }
}






