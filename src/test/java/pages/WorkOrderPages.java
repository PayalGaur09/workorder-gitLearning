package pages;

import cucumber.api.DataTable;
import models.WorkOrderModel;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.RandomGenerator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WorkOrderPages extends PageObject {

    private WorkOrderModel workOrderModel = new WorkOrderModel();
    private VendorManagementPage vendor;
    private FacilityManagementPage facility;

    //......Static Locators..........
    @FindBy(xpath = "//button[contains(text(),'Add New')]")
    private WebElementFacade addNewFromGrid;
    @FindBy(xpath = "//button[contains(text(),'Closed')]")
    private WebElementFacade closedWOButtonFromGrid;
    @FindBy(xpath = "//label[contains(text(),'Title')]/..//input")
    private WebElementFacade titleInputbox;
    @FindBy(xpath = "//textarea")
    private WebElementFacade descriptionTesxtArea;
    @FindBy(xpath = "//p[text()='Low Priority']/../..//app-work-order-grid-view-item")
    private WebElementFacade gridItem;
    @FindBy(xpath = "//div[@class='col-12']//button")
    private WebElementFacade addWOPhoto;
    @FindBy(xpath = "//i[@class='la la-trash']/..")
    private WebElementFacade detetePhoto;
    @FindBy(xpath = "//div[@class='col-2']//img")
    private WebElementFacade uploadedImg;
    @FindBy(xpath = "//div[@class='col-9 text-right']//button")
    private WebElementFacade statusButton;
    @FindBy(xpath = "//div[@class='col-9 text-right']//a")
    private WebElementFacade changeStatusFromDetailScreen;
    @FindBy(xpath = "//div[@class='btn-group']//button")
    private WebElementFacade priorityButton;
    @FindBy(xpath = "//div[@class='btn-group']//a")
    private WebElementFacade changePriorityFromDetailScreen;
    @FindBy(xpath = "//div[text()='Select All']")
    private WebElementFacade selectAllWatchers;
    @FindBy(xpath = "//label[contains(text(),'Watcher')]/..//span")
    private WebElementFacade watcherDropdown;
    @FindBy(xpath = "//label[contains(text(),'Due')]/..//span")
    private WebElementFacade dueDateIcon;
    @FindBy(xpath = "//label[contains(text(),'Watcher')]")
    private WebElementFacade watcherLabel;
    @FindBy(xpath = "//button[contains(text(),'Add Note')]")
    private WebElementFacade addNoteButton;
    @FindBy(xpath = "//button[contains(text(),'Add Note')]/..//a")
    private WebElementFacade viewAllNotes;
    @FindBy(xpath = "//span[contains(text(),'Re-open')]")
    private WebElementFacade reOpenButton;
    @FindBy(xpath = "//span[contains(text(),'Closed')]")
    private WebElementFacade closedStatusOfWO;
    @FindBy(xpath = "//i[@class='fa fa-list']/..")
    private WebElementFacade listViewIcon;
    @FindBy(xpath = "//span[contains(text(),'Report')]")
    private WebElementFacade reportIssueButton;
    @FindBy(xpath = "//button[contains(text(),'Action')]")
    private WebElementFacade actionButton;
    @FindBy(xpath = "//label[contains(text(),'Content')]/..//textarea")
    private WebElementFacade contentTextarea;
    @FindBy(xpath = "//label[contains(text(),'Facility')]/..//option")
    private List<WebElementFacade> facilityOptions;
    @FindBy(xpath = "//td[text()='No matching records found']")
    private WebElementFacade noRecords;
    @FindBy(xpath = "//a[contains(@class,'breadcrumbs-link')]")
    private WebElementFacade breadcrumbLink;
    //@FindBy(xpath = "//input[@id='sendReadReceiptEmailNotifications']")
    @FindBy(xpath = "//div[13]//div[1]//div[1]//div[1]//div[1]//label[1]//span[1]")
    private WebElementFacade sendReadReceipt;
    @FindBy(xpath = "//h3[contains(text(),'Logs')]/../../..")
    private WebElementFacade logsSection;
    @FindBy(xpath = "//span[text()='Notifications']")
    private WebElementFacade notificationSpan;
    @FindBy(xpath = "//select[@title='Select year']")
    private WebElementFacade selectYear;
    @FindBy(xpath = "//select[@title='Select month']")
    private WebElementFacade selectmonth;
    @FindBy(xpath = "//select[@name='ngModelRecurring']")
    WebElementFacade selectValue;
    @FindBy(xpath = "//h5[contains(text(),'Set Custom Recurrence')]")
    WebElementFacade verifymanagesignagepage;
    @FindBy(xpath = "(//button[text()='Submit'])[2]")
    WebElementFacade submitbutton;
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElementFacade cancelbutton;
    @FindBy(xpath = "//h3[text()=' Add Work Order ']")
    WebElementFacade addworkorderscreen;
    @FindBy(xpath = "//select[@name='repeatEvery']")
    WebElementFacade selectweek;
    @FindBy(xpath = "//button[text()=' W']")
    WebElementFacade selectday;
    @FindBy(xpath = "(//div[@class='multiselect-dropdown'])[2]")
    WebElementFacade clicksonrpeateverymonthdropdown;
    @FindBy(xpath = "//select[@name='repeatEveryNMonthField']")
    WebElementFacade repeateverydropdown;


    //......Dynamic Locators........
    private By selectDropdownField(String field) {
        return By.xpath("//label[contains(text(),'" + field + "')]/..//select");
    }

    private By selectWatcherCheckbox(String checkbox) {
        return By.xpath("//div[text()='" + checkbox + "']");
    }

    private By selectWateherOrDate(String field) {
        return By.xpath("//label[contains(text(),'" + field + "')]/..//span");
    }

    private By workOrderDetail(String detail) {
        return By.xpath("//label[contains(text(),'" + detail + "')]/..//p");
    }

    private By dropdownOption(String name) {
        return By.xpath("//label[contains(text(),'" + name + "')]/..//option");
    }

    private By filterType(String filter) {
        return By.xpath("//select[@name='" + filter + "']");
    }

    private By priorityOnGrid(String priority) {
        return By.xpath("//div[contains(@id,'container-" + priority + "')]");
    }

    private By titleOnGrid(String title) {
        return By.xpath("//p[text()='" + title + "']");
    }

    private By notificationCheckbox(int count) {
        return By.xpath("(//label[contains(text(),'notifications')]/..//span)[" + count + "]");
    }


    public void tapOnAddNewButtonFromGrid() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(addNewFromGrid).click();
    }

    public void tapOnClosedWOButtonFromGrid() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(closedWOButtonFromGrid).click();
    }

    public void enterTitleAndDescription() {
        waitABit(5000);
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(titleInputbox).waitUntilClickable().click();
        titleInputbox.clear();
        workOrderModel.setTitle("Automated Title " + RandomGenerator.randomAlphabetic(7));
        titleInputbox.sendKeys(workOrderModel.getTitle());

        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(descriptionTesxtArea).waitUntilClickable().click();
        descriptionTesxtArea.clear();
        workOrderModel.setDescription("Automated Description " + RandomGenerator.randomAlphabetic(7));
        descriptionTesxtArea.sendKeys(workOrderModel.getDescription());
        waitABit(4000);
    }

    public void selectPriority() {
        WebElementFacade priority = element(selectDropdownField("Priority"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(priority).selectByIndex(1);
    }

    public void selectCategory() {
        WebElementFacade category = element(selectDropdownField("Category"));
        //withTimeoutOf(20, TimeUnit.SECONDS).waitFor(category).click();
        Select option = new Select(category);
        workOrderModel.setCategory("Customer Complaint");
        option.selectByVisibleText(workOrderModel.getCategory());
    }

    public void removeCategory() {
        WebElementFacade category = element(selectDropdownField("Category"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(category).selectByVisibleText("[Select]");
    }

    public void selectFacility() {
        WebElementFacade facility = element(selectDropdownField("Facility"));
        waitFor(facility).withTimeoutOf(80, TimeUnit.SECONDS).click();
        Select option = new Select(facility);
        workOrderModel.setFacility("Zbt Automation");
        option.selectByVisibleText(workOrderModel.getFacility());
    }

    public void updateFacility() {
        WebElementFacade facility = element(selectDropdownField("Facility"));
        waitFor(facility).withTimeoutOf(80, TimeUnit.SECONDS);
        Select option = new Select(facility);
        workOrderModel.setFacility("Update Auto");
        option.selectByVisibleText(workOrderModel.getFacility());
    }

    public void selectUnit() {
        waitABit(7000);
        WebElementFacade unit = element(selectDropdownField("Unit"));
        Select option = new Select(unit);
        workOrderModel.setUnit("Zbt Auto Unit");
        option.selectByVisibleText(workOrderModel.getUnit());
    }

    public void updateUnit() {
        waitABit(7000);
        WebElementFacade unit = element(selectDropdownField("Unit"));
        Select option = new Select(unit);
        workOrderModel.setUnit("Unit A");
        option.selectByVisibleText(workOrderModel.getUnit());
    }

    public void selectAssignee() {
        waitABit(5000);
        WebElementFacade assignee = element(selectDropdownField("Assignee"));
        waitFor(assignee).withTimeoutOf(80, TimeUnit.SECONDS).waitUntilClickable();
        Select option = new Select(assignee);
        workOrderModel.setAssignee("Arpit Tyagi");
        option.selectByVisibleText(workOrderModel.getAssignee());
    }

    public void selectWatchers(String option) {
        waitABit(8000);
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(watcherDropdown).click();
        element(selectWatcherCheckbox(option)).click();
    }

    public void verifyWatcherOnDetailPage(String option) {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(watcherLabel).isPresent();
        WebElementFacade watchersOnDetail = element("//label[contains(text(),'Watcher')]/..//li");
        waitABit(1000);
        if (option.equals("Select All"))
            Assert.assertTrue(watchersOnDetail.isDisplayed());
        else if (option.equals("UnSelect All"))
            Assert.assertFalse(watchersOnDetail.isDisplayed());
    }

    public void verifyDetails() {
        WebElementFacade title = element(workOrderDetail("Title"));
        Assert.assertEquals(workOrderModel.getTitle(),
                withTimeoutOf(20, TimeUnit.SECONDS).waitFor(title).getText());
        Assert.assertEquals(workOrderModel.getFacility(), element(workOrderDetail("Facility")).getText());
        Assert.assertEquals(workOrderModel.getUnit(), element(workOrderDetail("Unit")).getText());
    }

    public void fetchWOId() {
        WebElementFacade id = element(workOrderDetail("ID"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(id).waitUntilVisible();
        workOrderModel.setWorkOrderId(id.getText());
        return;
    }

    public void removeAssignee() {
        WebElementFacade assignee = element(selectDropdownField("Assignee"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(assignee).selectByIndex(0);
    }

    public void updateStatus() {
        workOrderModel.setOldStatus(withTimeoutOf(20, TimeUnit.SECONDS).waitFor(statusButton).getText());
        statusButton.click();
        workOrderModel.setStatus(withTimeoutOf(20, TimeUnit.SECONDS).waitFor(changeStatusFromDetailScreen).getText());
        changeStatusFromDetailScreen.click();
    }

    public void updateStatusToClosed() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(statusButton).click();
        //withTimeoutOf(20,TimeUnit.SECONDS).waitFor(changeStatusFromDetailScreen);
        WebElement closedWOOption = element("//a[contains(text(),'Closed')]");
        closedWOOption.click();
    }

    public void updatePriority() {
        waitABit(1000);
        workOrderModel.setOldPriority(withTimeoutOf(20, TimeUnit.SECONDS).waitFor(priorityButton).getText());
        priorityButton.click();
        workOrderModel.setStatus(withTimeoutOf(20, TimeUnit.SECONDS).waitFor(changePriorityFromDetailScreen).getText());
        changePriorityFromDetailScreen.click();
    }

    public void enterMandatoryFields() {
        enterTitleAndDescription();
        selectPriority();
        selectFacility();
        selectUnit();
    }

    public void userSelectsTheDueDate() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='DueDate']")).click();
        waitABit(1000);
        waitFor(selectYear).withTimeoutOf(50, TimeUnit.SECONDS).click();
        Select year = new Select(selectYear);
        year.selectByVisibleText("2023");
        waitFor(selectmonth).withTimeoutOf(30, TimeUnit.SECONDS).click();
        Select month = new Select(selectmonth);
        Thread.sleep(2000);
        month.selectByValue("8");
        List<WebElement> dates = getDriver().findElements(By.xpath("//div[contains(@class,'btn-light')]"));
        int total_node = dates.size();
        for (int i = 0; i < total_node; i++) {
            String date = dates.get(i).getText();
            if (date.equals("31")) {
                Boolean value = dates.get(i).isEnabled();
                System.out.println("SELECT DATE " + value);
                $("(//div[text()='31'])[2]").click();
                break;
            }
        }

    }

    public void tapOnGridItem() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(gridItem).click();
    }

    public void tapOnAddPhotoIcon() throws IOException {
        String path = new File(".").getCanonicalPath() + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "testData" + File.separator + "profileIcon.png";
        getDriver().findElement(By.xpath("//input[@type='file']")).sendKeys(path);
        waitABit(5000); //Application is too slow right now that is why adding dynamic wait
    }

    public void maxPhotosAdded() throws IOException {
        for (int i = 0; i <= 5; i++) {
            tapOnAddPhotoIcon();
        }
    }

    public void verifyImageIsUploaded() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(uploadedImg).shouldBePresent();
    }

    public void deleteWOImage() {
        waitABit(1000);
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(detetePhoto).click();
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(uploadedImg).waitUntilNotVisible();
    }

    public void clickOnAddNoteButton() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(addNoteButton).click();
    }

    public void clickOnViewAllNotes() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(viewAllNotes).click();
    }

    public void reOpenFromActionButton() {
        waitFor(reOpenButton).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void closedWOShouldNotPresent() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(statusButton).waitUntilPresent();
    }


    public void tapOnListViewIcon() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(listViewIcon).click();
    }

    public void verifyListViewPage() {
        WebElement tHead = element("//thead");
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(tHead).waitUntilPresent();
    }

    public void tapOnSendMailOption() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(actionButton).click();
        if (reportIssueButton.isPresent()) {
            withTimeoutOf(20, TimeUnit.SECONDS).waitFor(reportIssueButton).click();
        } else {
//            Actions actions = new Actions(getDriver());
//            actions.moveToElement().click().build().perform();
            withTimeoutOf(20, TimeUnit.SECONDS).waitFor(actionButton).click();
            updateStatus();
            waitABit(5000);
            withTimeoutOf(20, TimeUnit.SECONDS).waitFor(actionButton).click();
            withTimeoutOf(20, TimeUnit.SECONDS).waitFor(reportIssueButton).click();
        }
    }

    public void enterContentToReport() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(contentTextarea)
                .sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
    }

    public static List<String> facilityList;

    public void fetchFacilityListFromDropdown() {
        //tap on facility dropdown
        waitABit(5000);
        WebElementFacade facility = element(selectDropdownField("Facility"));
        waitFor(facility).withTimeoutOf(80, TimeUnit.SECONDS).click();

        //Fetch the list
        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(facilityOptions.get(1)).waitUntilVisible();
        facilityList = new ArrayList<>();
        for (int i = 1; i < facilityOptions.size(); i++) {
            facilityList.add(facilityOptions.get(i).getText());
        }
    }


    public void fetchDropdownList(String name) {
        waitABit(5000);
        WebElementFacade facility = element(selectDropdownField(name));
        waitFor(facility).withTimeoutOf(80, TimeUnit.SECONDS).click();

        //Fetch the list
        List<WebElementFacade> dropdown = findAll(dropdownOption(name));
        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(dropdown).get(1).waitUntilVisible();
        facilityList = new ArrayList<>();
        for (int i = 1; i < dropdown.size(); i++) {
            facilityList.add(dropdown.get(i).getText());
        }
    }

    public void fetchFacilityDropdown() {
        fetchDropdownList("Facility");
    }

    public void fetchUnitListFromDropdown() {
        selectFacility();
        fetchDropdownList("Unit");
    }

    //.........Filters...........

//    private void selectFilterType(String filter) {
//        WebElementFacade filterDropdown = element(filterType(filter));
//        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(filterDropdown).click();
//
//    }

    public void selectFilterOption(String dropdown, DataTable filter) {
        waitABit(2000);
        //     this.selectFilterType(dropdown);
        String value = filter.asMaps(String.class, String.class).get(0).get("value");

        WebElementFacade filterDropdown = element(filterType(dropdown));
        Select option = new Select(filterDropdown);
        option.selectByVisibleText(value);
    }


    public void verifyStatusOfWorkOrder(String value) {
        try {
            //withTimeoutOf(10, TimeUnit.SECONDS).waitFor(statusInList).shouldBeVisible();
            int num = getDriver().findElements(By.xpath("//tbody/tr")).size();
            for (int i = 1; i <= num; i++) {
                WebElementFacade status = element("(//tr//td[5])[1]");
                String vType = withTimeoutOf(20, TimeUnit.SECONDS).waitFor(status).getText();
                Assert.assertEquals(value, vType);
            }
        } catch (Exception e) {
            noRecords.isPresent();
        }
    }

    public void verifyPriorityOfWorkOrder(String value) {
        try {
            //withTimeoutOf(10, TimeUnit.SECONDS).waitFor(statusInList).shouldBeVisible();
            int num = getDriver().findElements(By.xpath("//tbody/tr")).size();
            for (int i = 1; i <= num; i++) {
                WebElementFacade status = element("(//tr//td[6])[1]");
                String vType = withTimeoutOf(20, TimeUnit.SECONDS).waitFor(status).getText();
                Assert.assertEquals(value, vType);
            }
        } catch (Exception e) {
            noRecords.isPresent();
        }
    }

//    public void verifyCategoryOfWorkOrder(String value) {
////        waitABit(2000);
//        WebElementFacade valueOnDetail = element(workOrderDetail("Category"));
//        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(valueOnDetail).waitUntilPresent();
//        Assert.assertEquals(value, valueOnDetail.getText());
//    }


    public void breadcrumbWorkOrder() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(breadcrumbLink).click();
        waitABit(2000);
    }

    public void selectFacilityFilter() {
        waitABit(2000);
        WebElementFacade filterDropdown = element(filterType("facilityId"));
        Select option = new Select(filterDropdown);
        option.selectByVisibleText(" Zbt Automation");
        waitABit(5000);
    }

    public void verifyFilterValueOnWODetail(String dropdown, String value) {
        WebElementFacade valueOnDetail = null;
        if (dropdown.equals("facilityId")) {
            valueOnDetail = element(workOrderDetail("Facility"));
        } else if (dropdown.equals("workOrderCategoryId")) {
            valueOnDetail = element(workOrderDetail("Category"));
        } else if (dropdown.equals("unitId")) {
            valueOnDetail = element(workOrderDetail("Unit"));
        } else if (dropdown.equals("assigneeId")) {
            valueOnDetail = element(workOrderDetail("Assignee"));
        }
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(valueOnDetail).waitUntilPresent();
        Assert.assertEquals(value, valueOnDetail.getText());
    }

    public void dragAndDropWO() {
        WebElementFacade from = element("(//div[contains(@id,'container-low')]//p)[2]");
        WebElementFacade to = element(priorityOnGrid("medium"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(from).waitUntilClickable();
        workOrderModel.setWorkOrderId(from.getText());
        Actions act = new Actions(getDriver());
        act.dragAndDrop(from, to).build().perform();
    }

    public void clickOnDraggedWorkOrder() {
        waitABit(5000);
        WebElementFacade id = element(titleOnGrid(workOrderModel.getWorkOrderId()));
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(id).waitUntilClickable().click();
        WebElementFacade priority = element("//span[text()='Medium']");
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(priority).waitUntilPresent();
    }

    //........Activity Log.............
    public void verifyLogForStatusUpdate() {
        String statusUpdate = "Work Order " + workOrderModel.getWorkOrderId() + " status changed from " +
                workOrderModel.getOldStatus() + " to " + workOrderModel.getStatus();
        vendor.searchContentForActivity(statusUpdate);
    }

    public void verifyLogForPriorityUpdate() {
        String priorityUpdate = "Work Order " + workOrderModel.getWorkOrderId() + " priority changed from " +
                workOrderModel.getOldPriority() + " to " + workOrderModel.getPriority();
        vendor.searchContentForActivity(priorityUpdate);
    }

    public void verifyLogForAddWO() {
        String activity = "Work Order " + workOrderModel.getWorkOrderId() + " has been created";
        vendor.searchContentForActivity(activity);
    }

    public void verifyLogForEditTitleDescription() {
        String activity1 = "Work Order " + workOrderModel.getWorkOrderId() + " renamed";
        String activity2 = "Work Order " + workOrderModel.getWorkOrderId() + " description has been changed";
        vendor.searchContentForActivity(activity1);
        vendor.searchContentForActivity(activity2);
    }

    public void verifyLogForAssignedWO() {
        String addAssignee = "Work Order " + workOrderModel.getWorkOrderId() + " has been assigned to"
                + workOrderModel.getAssignee();
        vendor.searchContentForActivity(addAssignee);
    }

    public void verifyLogForRemovedWO() {
        String removeAssignee = "Assignee has been removed from the workorder " + workOrderModel.getWorkOrderId()
                + " . Tap to view details.";
        vendor.searchContentForActivity(removeAssignee);
    }

    public void verifyLogForCategoryAdded() {
        String addCategory = "Category has been added to " + workOrderModel.getWorkOrderId();
        vendor.searchContentForActivity(addCategory);

    }

    public void verifyLogForCategoryRemoved() {
        String removeCategory = "Category has been removed from " + workOrderModel.getWorkOrderId();
        vendor.searchContentForActivity(removeCategory);
    }

    //..........Notification............
    public void verifyAddWONotification() {
        String notification = "Work Order " + workOrderModel.getWorkOrderId() + " has been created. Tap to view details.";
        facility.searchNotificationContent(notification);
    }

    public void verifyUpdatedTitleDescriptionNotification() {
        String notification1 = workOrderModel.getWorkOrderId() + " renamed to " +
                workOrderModel.getTitle() + ". Tap to view details.";
        String notification2 = workOrderModel.getWorkOrderId() + " description has been changed. Tap to view details.";
        facility.searchNotificationContent(notification1);
        facility.searchNotificationContent(notification2);
    }

    public void verifyAssignedWONotification() {
        String notification = workOrderModel.getWorkOrderId() + " has been assigned to you. Tap to view details.";
        facility.searchNotificationContent(notification);
    }

    public void verifyRemovedWONotification() {
        String notification = "Assignee has been removed from the workorder " + workOrderModel.getWorkOrderId()
                + ". Tap to view details.";
        facility.searchNotificationContent(notification);
    }

    public void verifyNotificationForCategoryAdded() {
        String addCategory = "Category has been added to " + workOrderModel.getWorkOrderId() + ". Tap to view details.";
        facility.searchNotificationContent(addCategory);

    }

    public void verifyNotificationForCategoryRemoved() {
        String removeCategory = "Category has been removed from " + workOrderModel.getWorkOrderId() + ". Tap to view details.";
        vendor.searchContentForActivity(removeCategory);
    }

    public void checkboxIsSelected() {
//        for (int i = 1; i <= 4; i++) {
//            WebElementFacade notificationType = element(notificationCheckbox(i));
//            Assert.assertTrue(notificationType.isSelected());}
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(notificationSpan).click();
        waitFor(5000);
        sendReadReceipt.isSelected();
        //Assert.assertTrue(sendReadReceipt.isSelected());
    }

    public void woLogsForTitleDescription() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(logsSection).containsText("Title changed");
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(logsSection).containsText("Description changed");
    }

    public void selectValueFromSetAsRecurringDropdown() {
        waitFor(selectValue).withTimeoutOf(90, TimeUnit.SECONDS).click();
        Select selectValueFromDropdown = new Select(selectValue);
        selectValueFromDropdown.selectByIndex(1);
    }

    public void userRedirectsToSetCustomRecurrencePopup() {
        Assert.assertTrue(verifymanagesignagepage.isDisplayed());
    }

    public void userClicksOnSubmit() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(submitbutton).click();
    }

    public void userClicksOnCancelButton() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(cancelbutton).click();
    }

    public void verifyRedirection() {
        Assert.assertTrue(addworkorderscreen.isDisplayed());
    }

    public void userSelectsTheWeekFromRepeatOnDropdown() {
        selectweek.click();
        Select selectWeekFromRepeatDropdown = new Select(selectweek);
        selectWeekFromRepeatDropdown.selectByIndex(1);
    }

    public void userSelectsTheDays() {
        selectday.click();
    }

    public void userSelectsTheDateFromTermateOnField() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='terminateOn']")).click();
        waitFor(selectYear).withTimeoutOf(30, TimeUnit.SECONDS).click();
        Select year = new Select(selectYear);
        year.selectByVisibleText("2023");
        waitFor(selectmonth).withTimeoutOf(30, TimeUnit.SECONDS).click();
        Select month = new Select(selectmonth);
        Thread.sleep(2000);
        month.selectByValue("8");
        List<WebElement> dates = getDriver().findElements(By.xpath("//div[contains(@class,'btn-light')]"));
        int total_node = dates.size();
        for (int i = 0; i < total_node; i++) {
            String date = dates.get(i).getText();
            if (date.equals("31")) {
                Boolean value = dates.get(i).isEnabled();
                System.out.println("SELECT DATE " + value);
                $("(//div[text()='31'])[2]").click();
                break;
            }
        }
    }

    public void userClicksOnRepeatEveryMonthDropdown() {
        waitABit(5000);
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(clicksonrpeateverymonthdropdown).click();
    }

    public void userSelectsTheDaysFromRepeatEveryMonthOnField() {
        List<WebElement> dates = getDriver().findElements(By.xpath("(//ul[@class='item2'])[2]/li"));
        dates.get(3).click();
        dates.get(4).click();
        clicksonrpeateverymonthdropdown.click();
    }

    public void userSelectsTheDayFromRepeatEveryDayField() {
        repeateverydropdown.click();
        Select selectWeekFromRepeatDropdown = new Select(repeateverydropdown);
        selectWeekFromRepeatDropdown.selectByIndex(2);
    }

    public void useEditTheRecurringField() {
        waitFor(selectValue).withTimeoutOf(90, TimeUnit.SECONDS).click();
        Select selectValueFromDropdown = new Select(selectValue);
        selectValueFromDropdown.selectByIndex(0);

    }

}