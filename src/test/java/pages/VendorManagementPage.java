package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.RandomGenerator;
import models.DetailsModel;

import java.util.concurrent.TimeUnit;

public class VendorManagementPage extends PageObject {

    private DetailsModel detailsModel = new DetailsModel();

    @FindBy(xpath = "//span[contains(text(),'Vendors')]")
    WebElementFacade vendorLink;
    @FindBy(xpath = "//a[contains(text(),'New Vendor')]")
    WebElementFacade addVendorButton;

    @FindBy(xpath = "//label[contains(text(),'Name')]/..//input")
    WebElementFacade vendorName;
    @FindBy(xpath = "//select")
    WebElementFacade vendorTypeDropdown;
    @FindBy(xpath = "//label[contains(text(),'Contact')]/..//input")
    WebElementFacade vendorContactNumber;
    @FindBy(xpath = "//label[contains(text(),'Email')]/..//input")
    WebElementFacade vendorEmailId;
    @FindBy(xpath = "//label[contains(text(),'Location')]/..//input")
    WebElementFacade vendorLocation;
    @FindBy(xpath = "//label[contains(text(),'Account Number')]/..//input")
    WebElementFacade vendorAccountNumber;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElementFacade submitButton;
    @FindBy(xpath = "//a[text()='Cancel']")
    WebElementFacade cancelButton;
    @FindBy(xpath = "//span[@class='link']")
    WebElementFacade nameLink;


    //detail screen
    @FindBy(xpath = "//label[contains(text(),'Name')]/..//p")
    WebElementFacade vendorNameDetail;
    @FindBy(xpath = "//label[contains(text(),'Type')]/..//p")
    WebElementFacade vendorTypeDetail;
    @FindBy(xpath = "//label[contains(text(),'Phone')]/..//p")
    WebElementFacade vendorContactNumberDetail;
    @FindBy(xpath = "//label[contains(text(),'Email')]/..//p")
    WebElementFacade vendorEmailIdDetail;
    @FindBy(xpath = "//label[contains(text(),'Location')]/..//p")
    WebElementFacade vendorLocationDetail;
    @FindBy(xpath = "//label[contains(text(),'Account Number')]/..//p")
    WebElementFacade vendorAccountNumberDetail;

    @FindBy(xpath = "//em[contains(@class,'fa-edit')]")
    WebElementFacade editIcon;
    @FindBy(xpath = "//em[contains(@class,'fa-trash')]")
    WebElementFacade deleteIcon;


    @FindBy(xpath = "//button[contains(text(),'Action')]")
    WebElementFacade actionButton;
    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    WebElementFacade deleteButton;
    @FindBy(xpath = "//span[contains(text(),'Edit')]")
    WebElementFacade editButton;
    @FindBy(xpath = "//span[contains(text(),'Notes')]")
    WebElementFacade notesButton;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElementFacade addNoteButton;
    @FindBy(xpath = "//i/../../button")
    WebElementFacade editNoteIcon;

    @FindBy(xpath = "//label[contains(text(),'Note')]/..//textarea")
    WebElementFacade noteTestArea;
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElementFacade submitNoteButton;
    @FindBy(xpath = "//h3[contains(text(),'Note')]/span")
    WebElementFacade notesCount;
    @FindBy(xpath = "//div[@class='col-md-3']//select")
    WebElementFacade selectFilterDropdown;
    @FindBy(xpath = "//button[contains(text(),'Filter')]")
    WebElementFacade filterButton;
    @FindBy(xpath = "//button[contains(text(),'Reset')]")
    WebElementFacade resetButton;
    @FindBy(xpath = "//input[contains(@placeholder,'Filter')]")
    WebElementFacade searchVendor;

    private By validationMessage(String text) {
        return By.xpath("//*[contains(text(),'" + text + "')]");
    }

    public void verifyValidationMessage(String text) {
        WebElementFacade a = element(validationMessage(text));
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(a).shouldBeVisible();
    }

    private By msg(String text) {
        return By.xpath("//div[contains(text(),'" + text + "')]");
    }

    public void SuccessMsg(String text) {
        element(msg(text)).waitUntilVisible();
    }


    public void scrollTo(String element){
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void tapOnAddVendorButton() {
        waitFor(addVendorButton).withTimeoutOf(20, TimeUnit.SECONDS).click();
    }

    public void addInputFiledsOfVendorForm() { 
        withTimeoutOf(10,TimeUnit.SECONDS).waitFor(vendorName).waitUntilVisible();
        detailsModel.setName("Vendor" + RandomGenerator.randomAlphabetic(3));
        vendorName.type(detailsModel.getName());
        System.out.println(RandomGenerator.randomInteger(10));
        detailsModel.setContact(RandomGenerator.randomInteger(10));
        vendorContactNumber.type(detailsModel.getContact());
        detailsModel.setEmail("vendormail" + RandomGenerator.randomInteger(2) + "@mailinator.com");
        vendorEmailId.type(detailsModel.getEmail());
        detailsModel.setLocation("Location" + RandomGenerator.randomAlphabetic(6));
        vendorLocation.type(detailsModel.getLocation());
        detailsModel.setAccountNo(Integer.parseInt(RandomGenerator.randomInteger(5)));
        vendorAccountNumber.type(detailsModel.getAccountNo().toString());
    }

    public void selectTypeFromDropdown() {
        vendorTypeDropdown.withTimeoutOf(10, TimeUnit.SECONDS).click();
        Select type = new Select(vendorTypeDropdown);
        detailsModel.setType("Electricity Provider ");
        type.selectByVisibleText(detailsModel.getType());
    }

    public void enterInvalidContactNo() {
        waitFor(submitButton).withTimeoutOf(10, TimeUnit.SECONDS).sendKeys("1234");
        waitFor(2000);
    }

    public void tapOnSubmitButton() {
        withTimeoutOf(10,TimeUnit.SECONDS).waitFor(submitButton).click();
    }

    public void vendorDetailsVerify() {
        Assert.assertEquals(detailsModel.getName(), vendorNameDetail.getText());
        Assert.assertTrue(detailsModel.getType().contains(vendorTypeDetail.getText()));
        Assert.assertEquals(detailsModel.getContact(), vendorContactNumberDetail.getText());
        Assert.assertEquals(detailsModel.getEmail(), vendorEmailIdDetail.getText());
        Assert.assertEquals(detailsModel.getLocation(), vendorLocationDetail.getText());
        Assert.assertEquals(detailsModel.getAccountNo().toString(), vendorAccountNumberDetail.getText());
        waitFor(2000);
    }

    public void cancelAddVendorForm() {
        waitFor(cancelButton).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void tapOnEditIcon() {
        waitFor(editIcon).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void tapOnNameLink() {
        nameLink.withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void tapOnActionButton() {
        waitFor(actionButton).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void editFromActionButton() {
        waitFor(editButton).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void noteOptionFromActionButton() {
        waitFor(notesButton).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void tapOnAddButton() {
        waitFor(addNoteButton).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void enterNote() {
        waitFor(noteTestArea).withTimeoutOf(10, TimeUnit.SECONDS).sendKeys("Automation note is added.");
        waitFor(submitNoteButton).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void tapOnEditNoteIcon() {
        waitFor(editNoteIcon).withTimeoutOf(10, TimeUnit.SECONDS).click();

    }

    public void countNotesForVendor() {
        String value = notesCount.getText();
        int intValue = Integer.parseInt(value.replaceAll("[^0-9]", ""));
        System.out.println(intValue);

        int countIcon = getDriver().findElements(By.xpath("//i/../../button")).size();
        Assert.assertEquals(countIcon, intValue);
        waitABit(10000);
    }

    public void selectVendorTypeToFilterList() {
        waitFor(selectFilterDropdown).withTimeoutOf(10, TimeUnit.SECONDS).click();
        Select vendorFilter = new Select(selectFilterDropdown);
        vendorFilter.selectByValue("3");
    }

    private By vendorTypeDynamic(int count) {
        return By.xpath("((//tbody/tr)[" + count + "]/td)[2]");
    }

    public void verifyVendorType() {

        int num= getDriver().findElements(By.xpath("//tbody/tr")).size();
        waitABit(2000);
        for(int i=1;i<=num;i++){
            String vType = element(vendorTypeDynamic(i)).getText();
            Assert.assertEquals("Electricity Provider", vType);
        }

    }

    public void tapOnResetButton() { withTimeoutOf(10,TimeUnit.SECONDS).waitFor(resetButton).click();
    waitABit(1000);}

    public void enterKeywordInSearchField(){ withTimeoutOf(10,TimeUnit.SECONDS).waitFor(searchVendor).sendKeys("Vendor"); }

    public void tapOnFilterButton(){ waitFor(filterButton).withTimeoutOf(10,TimeUnit.SECONDS).click(); }

    public void pressEnterKey(){ withTimeoutOf(10,TimeUnit.SECONDS).waitFor(searchVendor).sendKeys(Keys.ENTER); }

    private By vendorNameSearch(int count) {
        return By.xpath("((//tbody/tr)[" + count + "]/td)[1]");
    }

    public void verifyVendorName() {
        int num = getDriver().findElements(By.xpath("//tbody/tr")).size();
        waitABit(2000);
        for (int i = 1; i <= num; i++) {
            String vName = element(vendorNameSearch(i)).getText();
            Assert.assertTrue(vName.contains("Vendor"));
        }
    }

    public void verifyIntergrationOfSearchFilter(){
        int num = getDriver().findElements(By.xpath("//tbody/tr")).size();
        waitABit(2000);
        for (int i = 1; i <= num; i++) {
            String vType = element(vendorTypeDynamic(i)).getText();
            Assert.assertEquals("Electricity Provider", vType);
            String vName = element(vendorNameSearch(i)).getText();
            Assert.assertTrue(vName.contains("Vendor"));
        }
    }

    public void clickOnDeleteIcon(){
        withTimeoutOf(10,TimeUnit.SECONDS).waitFor(deleteIcon).click();
    }

    public void clickOnDeleteButton(){
        withTimeoutOf(10,TimeUnit.SECONDS).waitFor(actionButton).click();
        withTimeoutOf(10,TimeUnit.SECONDS).waitFor(deleteButton).click();
    }

    public void acceptOptionInJSPopup(){
        Alert alert = getDriver().switchTo().alert();
        alert.accept();

    }


}
