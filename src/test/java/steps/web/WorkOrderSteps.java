package steps.web;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

import java.io.IOException;

public class WorkOrderSteps {
    private WorkOrderPages workOrder;
    private VendorManagementPage vendor;
    private UserSigninPage userSigninPage;
    private FacilityManagementPage facility;
    private UserManagementPage users;

    @Given("^User is on add work order screen$")
    public void userIsOnAddWorkOrderScreen() {
        workOrder.tapOnAddNewButtonFromGrid();
    }

    @When("^User enters the mandatory fields in work order screen$")
    public void userEntersTheMandatoryFieldsInWorkOrderScreen() {
        workOrder.enterMandatoryFields();
    }

    @Given("^User is on the work order detail screen$")
    public void userIsOnTheWorkOrderDetailScreen() {
        workOrder.tapOnGridItem();
        workOrder.fetchWOId();
    }

    @And("^User verify work order detail screen$")
    public void userVerifyWorkOrderDetailScreen() {
        workOrder.verifyDetails();
        workOrder.fetchWOId();
    }

    @When("^User uploads more than five images to a work order$")
    public void userUploadsMoreThanFiveImagesToAWorkOrder() throws IOException {
        workOrder.maxPhotosAdded();
    }

    @When("^User uploads an image to a work order$")
    public void userUploadsAnImageToAWorkOrder() throws IOException {
        workOrder.tapOnAddPhotoIcon();
    }

    @Then("^Uploaded image is getting displayed on the screen$")
    public void uploadedImageIsGettingDisplayedOnTheScreen() {
        workOrder.verifyImageIsUploaded();
    }

    @And("^User removes the uploaded image$")
    public void userRemovesTheUploadedImage() {
        workOrder.deleteWOImage();
    }

    @And("^User selects an assignee and category to the work order$")
    public void userSelectsAnAssigneeAndCategoryToTheWorkOrder() {
        workOrder.selectCategory();
        workOrder.selectAssignee();
        vendor.tapOnSubmitButton();
    }/////////////////////////////////////////////////////////////////////////////////////////////////////

    @And("^User removes the assignee$")
    public void userRemovesTheAssignee() {
        workOrder.removeCategory();
        workOrder.removeAssignee();
        vendor.tapOnSubmitButton();
    }

    @When("^User updates the work order status and priority$")
    public void userUpdatesTheWorkOrderStatusAndPriority() {
        workOrder.updateStatus();
        workOrder.updatePriority();
    }

    @Then("^Activity log for status update is displayed$")
    public void activityLogForStatusUpdateIsDisplayed() {
        workOrder.verifyLogForStatusUpdate();
    }

    @Then("^Activity log for priority update is displayed$")
    public void activityLogForPriorityUpdateIsDisplayed() {
        workOrder.verifyLogForPriorityUpdate();
    }

    @Then("^Activity log for work order added is displayed$")
    public void activityLogForWorkOrderAddedIsDisplayed() {
        workOrder.verifyLogForAddWO();
    }

    @And("^User select checkbox \"([^\"]*)\"  in watchers dropdown$")
    public void userSelectCheckboxInWatchersDropdown(String option) throws Throwable {
        workOrder.selectWatchers(option);
        vendor.tapOnSubmitButton();
    }

    @Then("^User verify watchers according to selected \"([^\"]*)\"$")
    public void userVerifyWatchersAccordingToSelected(String option) throws Throwable {
        workOrder.verifyWatcherOnDetailPage(option);
    }

    @Then("^Notification for work order added is displayed$")
    public void notificationForWorkOrderAddedIsDisplayed() {
        workOrder.verifyAddWONotification();
        userSigninPage.signout();
    }

    @When("^User clicks on add note button$")
    public void userClicksOnAddNoteButton() {
        workOrder.clickOnAddNoteButton();
    }

    @When("^User reached to notes screen of the work order$")
    public void userReachedToNotesScreenOfTheWorkOrder() {
        workOrder.clickOnViewAllNotes();
    }

    @Given("^User is on the Closed work order list screen$")
    public void userIsOnTheClosedWorkOrderListScreen() {
        workOrder.tapOnClosedWOButtonFromGrid();
    }

    @Then("^User is not able to edit the work order$")
    public void userIsNotAbleToEditTheWorkOrder() {
        vendor.tapOnActionButton();
        vendor.editOptionIsNotPresent();
    }

    @When("^User changes the work order status to closed$")
    public void userChangesTheWorkOrderStatusToClosed() {
        workOrder.updateStatusToClosed();
    }

    @And("^User clicks on re-open option from action dropdown$")
    public void userClicksOnReOpenOptionFromActionDropdown() {
        vendor.tapOnActionButton();
        workOrder.reOpenFromActionButton();
    }

    @Then("^Work order status is in open state$")
    public void workOrderStatusIsInOpenState() {
        workOrder.closedWOShouldNotPresent();
    }

    @Given("^User taps on the list view icon$")
    public void userTapsOnTheListViewIcon() {
        workOrder.tapOnListViewIcon();
    }

    @Then("^User reaches to the work order list screen$")
    public void userReachesToTheWorkOrderListScreen() {
        workOrder.verifyListViewPage();
    }

    @When("^User clicks on the report option from action dropdown$")
    public void userClicksOnTheReportOptionFromActionDropdown() {
        workOrder.tapOnSendMailOption();
    }

    @When("^User enter the content to report an issue$")
    public void userEnterTheContentToReportAnIssue() {
        workOrder.enterContentToReport();
    }

    @When("^User click on facility dropdown and fetches the facility list$")
    public void userClickOnFacilityDropdownAndFetchesTheFacilityList() {
        // workOrder.fetchFacilityListFromDropdown();
        workOrder.fetchFacilityDropdown();
    }

    @Then("^User verifies the facilities with the facility list page$")
    public void userVerifiesTheFacilitiesWithTheFacilityListPage() {
        facility.selectPageLimit100();
        facility.verifyFacilityList(WorkOrderPages.facilityList);
    }

    @When("^User fetches the list from unit dropdown$")
    public void userFetchesTheListFromUnitDropdown() {
        workOrder.fetchUnitListFromDropdown();
    }

    @When("^User clicks on the dropdown \"([^\"]*)\"$")
    public void userClicksOnTheDropdown(String dropdown, DataTable value) throws Throwable {
        if (dropdown.equals("unitId")||dropdown.equals("assigneeId")) {
            workOrder.selectFacilityFilter();
        }
//        else if (dropdown.equals("assigneeId")) {
//            workOrder.selectFacilityFilter();
//        }
        workOrder.selectFilterOption(dropdown, value);
        users.tapOnFilterButton();
    }

    @Then("^User verifies the selected \"([^\"]*)\" filter for \"([^\"]*)\"$")
    public void userVerifiesTheSelectedFilterFor(String dropdown, String value) throws Throwable {
        if (dropdown.equals("status")) {
            workOrder.verifyStatusOfWorkOrder(value);
        } else if (dropdown.equals("priority")) {
            workOrder.verifyPriorityOfWorkOrder(value);
        }
    }

    @When("^User reaches back to the list view$")
    public void userReachesBackToTheListView() {
        workOrder.breadcrumbWorkOrder();
    }

    @When("^User selects facility dropdown filter$")
    public void userSelectsFacilityDropdownFilter() throws Throwable {
        workOrder.selectFacilityFilter();
    }


    @Then("^User verifies the selected \"([^\"]*)\" filter for \"([^\"]*)\" on the detail screen$")
    public void userVerifiesTheSelectedFilterForOnTheDetailScreen(String dropdown, String value) throws Throwable {
        workOrder.verifyFilterValueOnWODetail(dropdown, value);
    }

    @When("^User drag a work order to change the the priority$")
    public void userDragAWorkOrderToChangeTheThePriority() {
        workOrder.dragAndDropWO();
    }

    @Then("^The priority of a work order should be changed$")
    public void thePriorityOfAWorkOrderShouldBeChanged() {
        workOrder.clickOnDraggedWorkOrder();
    }

    @Then("^Activity log for work order update is displayed$")
    public void activityLogForWorkOrderUpdateIsDisplayed() {
        workOrder.verifyLogForEditTitleDescription();
    }

    @Then("^Notification for work order update is displayed$")
    public void notificationForWorkOrderUpdateIsDisplayed() {
        workOrder.verifyUpdatedTitleDescriptionNotification();
        userSigninPage.signout();
    }


    @And("^User Removes the category from a work order$")
    public void userRemovesTheCategoryFromAWorkOrder() {
        workOrder.removeCategory();
        vendor.tapOnSubmitButton();
    }

    @Then("^Activity log for assignee/category removed and added is displayed$")
    public void activityLogForAssigneeCategoryRemovedAndAddedIsDisplayed() {
        workOrder.verifyLogForAssignedWO();
        workOrder.verifyLogForCategoryAdded();
        workOrder.verifyLogForRemovedWO();
        workOrder.verifyLogForCategoryRemoved();
    }

    @Then("^Notification for assignee/category removed and added is displayed$")
    public void notificationForAssigneeCategoryRemovedAndAddedIsDisplayed() {
        workOrder.verifyAssignedWONotification();
        workOrder.verifyRemovedWONotification();
        workOrder.verifyNotificationForCategoryAdded();
        workOrder.verifyNotificationForCategoryRemoved();

    }

    @When("^User verifies the the checkbox selection$")
    public void userVerifiesTheTheCheckboxSelection() {
        workOrder.checkboxIsSelected();
    }

    @When("^User updates all the field of work order screen$")
    public void userUpdatesAllTheFieldOfWorkOrderScreen() {
        workOrder.enterTitleAndDescription();
    }

    @Then("^User verifies the work order logs$")
    public void userVerifiesTheWorkOrderLogs() {
        workOrder.woLogsForTitleDescription();
    }
}
