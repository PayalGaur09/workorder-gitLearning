package steps.web;

import com.jayway.restassured.response.Response;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import models.ContentModel;
import models.ImageModel;
import org.apache.commons.configuration.ConfigurationException;
import pages.SignageApplicationPage;
import services.RegisterKioskService;
import utilities.LoadProperties;

import java.io.IOException;
import java.util.List;

import static utilities.LoadProperties.saveValueInPropertiesFile;

public class SignageApplicationSteps {
    SignageApplicationPage manageKiosk;
    public static Response fetchResponse;

    @Then("^user should redirects to the kiosk page$")
    public void userShouldRedirectsToTheKioskPage() {
        manageKiosk.verifyKioskPage();
    }

    @And("^user clicks on register new kiosk button$")

    public void userClicksOnRegisterNewKioskButton() {
        manageKiosk.verifyRegistration();
    }


    @And("^User clicks on Select dropdown and select a facility$")
    public void userClicksOnSelectDropdownAndSelectAFacility() {
        manageKiosk.selectFacilityFromDropdown();


    }

    @And("^user enters the registration key and tag field$")
    public void userEntersTheRegistrationKeyAndTagField(DataTable values) {
        manageKiosk.enterRegistrationKeyAndTag(values);
    }


    @And("^user clicks on the configure  button$")

    public void userClicksOnTheConfigureButton() {
        manageKiosk.clickingOnConfigureButton();
    }

    @And("^user redirects to the managekioskpage$")
    public void userRedirectsToTheManagekioskpage() {
        manageKiosk.redirectsManageKioskPage();
    }

    @And("^User is on Kiosk Detail page$")
    public void userIsOnKioskDetailPage() {
        manageKiosk.selectTagFromKiosk();
    }



    @And("^user fills all the details$")
    public void userFillsAllTheDetails(DataTable text) {
        manageKiosk.addContentForSignageAppliccation(text);
    }

    @And("^user clicks  on the submit button$")
    public void userClicksOnTheSubmitButton() {
        manageKiosk.submitButton();
    }

    @And("^user upload the image type content in the upload content field$")
    public void userUploadThePngTypeContentInTheUploadContentField(List<ImageModel> imageModelList) {
        manageKiosk.uploadProductImage(imageModelList);
    }

    @And("^user clicks on the addcontent button$")
    public void userClicksOnTheAddcontentButton() {
        manageKiosk.clicksOnAddContentBtn();
    }

    @And("^user clicks on the  Cancel button$")
    public void userClicksOnTheCancelButton() {
        manageKiosk.clicksOnCanceltBtn();
    }

    @Then("^user should redirects to the  Manage Signage page$")
    public void userShouldRedirectsToTheManageSignagePage() {
        manageKiosk.redirectionOnManageSignagepage();
    }

    @And("^user clicks on the Edit button$")
    public void userClicksOnTheEditButton() {
        manageKiosk.clicksOnEditButton();
    }

    @And("^user clicks on the Change file  button$")
    public void userClicksOnTheChangeButton() {
        manageKiosk.editFile();
    }


    @And("^user Edit the content details$")
    public void userEditTheContentDetails(DataTable details) {
        manageKiosk.editAllContentDetails(details);
    }

    @And("^user clicks on the delete button$")
    public void userClicksOnTheDeleteButton() {
        manageKiosk.clicksOnDeleteContent();
    }

    @And("^user clicks on the cancel button of delete popup$")
    public void userClicksOnTheCancelButtonOfDeletePopup() {
        manageKiosk.clickOnCancelButtonOfDeletePopup();
    }


    @And("^User clicks on the delete fileicon$")
    public void userClicksOnTheDeleteFunction() {
        manageKiosk.clicksOndeleteFileIcon();
    }

    @And("^user upload the content in choose file$")
    public void userUploadTheContentInChooseFile(List<ContentModel> contentModelList) {
        manageKiosk.uploadVideoPdf(contentModelList);

    }

    @And("^user clicks on Choose file in thumbnail field$")
    public void userClicksOnChooseFileInThumbnailField() {
        manageKiosk.uploadContentInThumbnail();
    }

    @And("^user clicks on the upload content or manage content button$")
    public void userClicksOnTheUploadContentOrManageContentButton() {
        manageKiosk.userClicksOnUploadContentOrManageContentButton();
    }

    @And("^user clicks on manage button$")
    public void userClicksOnManageButton() {
        manageKiosk.userClicksOnManageButton();
    }

    @And("^user upload the image type content in thumbnail field$")
    public void userUploadTheImageTypeContentInThumbnailField(List<ImageModel> imageModelList) {
            manageKiosk.uploadFileInThumbnail(imageModelList);
    }

    @And("^user check the functionality of toggle button$")
    public void userCheckTheFunctionalityOfToggleButton() {
        manageKiosk.userClicksOnTheToggleButtonOfSignageApplication();
    }


    @Then("^error message should be come \"([^\"]*)\"$")
    public void errorMessageShouldBeCome(String arg0) throws Throwable {
        manageKiosk.registrationKeyAlreadyExist();
    }


    @And("^user delete the tag from the list$")
    public void userDeleteTheTagFromTheList() {
        manageKiosk.userClicksOnDeleteTag();
    }


    @Then("^user enters the title and description$")
    public void userEntersTheTitleAndDescription(DataTable values) throws IOException, ConfigurationException {
        manageKiosk.userEntersTitleThatAlradyExist(values);
    }

    @And("^User enter title in text box$")
    public void userEnterTitleInTextBox() throws Throwable {
        manageKiosk.titleText();
    }

    @Then("^user enters the title and description again$")
    public void userEntersTheTitleAndDescriptionAgain() throws Throwable {
        manageKiosk.enterTitleDescription();
    }

    @Then("^Verify the error message$")
    public void verifyTheErrorMessage() throws Throwable {
      manageKiosk.errorMessagePopup();
    }


    @Then("^verify the functionality of pagination$")
    public void verifyTheFunctionalityOfPagination() {
        manageKiosk.verifyPagination();
    }


    @Given("^User get the registration key list$")
    public void userGetTheRegistrationKeyList() {
        fetchResponse = RegisterKioskService.getRegistrationNo();
    }

    @Then("^User verifies the registration key$")
    public void userVerifiesTheRegistrationKey() throws IOException, ConfigurationException {
        String registrationKey = fetchResponse.prettyPrint().replaceAll("\"", "");
        saveValueInPropertiesFile("RegistrationKey", registrationKey, "testData");

    }

    @And("^user enters the registration key$")
    public void userEntersTheRegistrationKey() {
        String regkey = LoadProperties.getValueFromPropertyFile("testData", "RegistrationKey");
        manageKiosk.enterReistrationKey(regkey);
    }

    @And("^user enters the value in tag field$")
    public void userEntersTheValueInTagField(DataTable data) {
        manageKiosk.enterValueInTagField(data);
    }


    @And("^user clicks  on submit button$")
    public void userClicksOnSubmitButton() {
        manageKiosk.UserTapsOnVideoOrPdfSubmitbutton();
    }

    @And("^user clicks  on the submit button for uploading the the pdf$")
    public void userClicksOnTheSubmitButtonForUploadingTheThePdf() {
        manageKiosk.userClicksOnSubmitButtonForUplaodingThePdfTypefile();
    }
}






