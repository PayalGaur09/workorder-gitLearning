package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.LoadProperties;
import utilities.RandomGenerator;
import models.DetailsModel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class VendorManagementPage extends PageObject {

    private DetailsModel detailsModel = new DetailsModel();
    String wait= LoadProperties.getValueFromPropertyFile("testData","wait");

    @FindBy(xpath = "//h3[contains(text(),'Vendors')]")
    private WebElementFacade vendorHeading;
    @FindBy(xpath = "//a[contains(text(),'New Vendor')]")
    private WebElementFacade addVendorButton;
    @FindBy(xpath = "//label[contains(text(),'Type')]/..//div")
    private WebElementFacade vendorTypeDropdown;
    @FindBy(xpath = "//option[contains(text(),'Electricity Provider')]")
    private WebElementFacade selectElectricityProvider;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElementFacade submitButton;
    @FindBy(xpath = "//a[text()='Cancel']")
    private WebElementFacade cancelButton;
    @FindBy(xpath = "//span[@class='link']")
    private WebElementFacade nameLink;


    @FindBy(xpath = "//em[contains(@title,'Edit')]")
    private WebElementFacade editIcon;
    @FindBy(xpath = "//em[contains(@class,'fa-trash')]")
    private WebElementFacade deleteIcon;


    @FindBy(xpath = "//button[contains(text(),'Action')]")
    private WebElementFacade actionButton;
    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElementFacade deleteButton;
    @FindBy(xpath = "//span[contains(text(),'Edit')]")
    private WebElementFacade editButton;
    @FindBy(xpath = "//span[contains(text(),'Notes')]")
    private WebElementFacade notesButton;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    private WebElementFacade addNoteButton;
    @FindBy(xpath = "//i/../../button")
    private WebElementFacade editNoteIcon;
    @FindBy(xpath = "//div[@class='loader']")
    private WebElementFacade loader;

    @FindBy(xpath = "//label[contains(text(),'Note')]/..//textarea")
    private WebElementFacade noteTestArea;
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElementFacade submitNoteButton;
    @FindBy(xpath = "//h3[contains(text(),'Note')]/span")
    private WebElementFacade notesCount;
    @FindBy(xpath = "//div[@class='col-md-3']//select")
    private WebElementFacade selectFilterDropdown;
    @FindBy(xpath = "//button[contains(text(),'Filter')]")
    private WebElementFacade filterButton;
    @FindBy(xpath = "//button[contains(text(),'Reset')]")
    private WebElementFacade resetButton;
    @FindBy(xpath = "//input[contains(@placeholder,'Filter')]")
    private WebElementFacade searchVendor;
    //pagination
    @FindBy(xpath = "//select[contains(@class,'custom')]")
    private WebElementFacade selectLimitDropdown;
    @FindBy(xpath = "//div[@id='DataTables_Table_0_info']")
    private WebElementFacade datatableInfo;

    private By validationMessage(String text) {
        return By.xpath("//*[contains(text(),'" + text + "')]");
    }

    private By vendorFormField(String text) {
        return By.xpath("//label[contains(text(),'" + text + "')]/..//input");
    }

    private By vendorDetail(String detail) {
        return By.xpath("//label[contains(text(),'" + detail + "')]/..//p");
    }

    private By pageRecord(String option) {
        return By.xpath("//option[text()='" + option + "']");
    }


    public void verifyValidationMessage(String text) {
        WebElementFacade a = element(validationMessage(text));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(a).shouldBeVisible();
    }

    private void enterValueInName() {
        WebElementFacade nameField = element(vendorFormField("Name"));
        waitABit(4000);
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(nameField).waitUntilClickable().click();
        nameField.clear();
        detailsModel.setName("Vendor" + RandomGenerator.randomAlphabetic(3));
        nameField.sendKeys(detailsModel.getName());
    }

    private void enterValueInPhone() {
        WebElementFacade contactField = element(vendorFormField("Contact"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(contactField).waitUntilVisible().click();
        contactField.clear();
        detailsModel.setContact(RandomGenerator.randomInteger(10));
        contactField.sendKeys(detailsModel.getContact());
    }

    private void enterValueInEmail() {
        WebElementFacade emailField = element(vendorFormField("Email"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(emailField).waitUntilVisible().click();
        emailField.clear();
        detailsModel.setEmail("vendor" + RandomGenerator.randomInteger(4) + "@mailinator.com");
        emailField.sendKeys(detailsModel.getEmail());
    }

    private void enterValueInLocation() {
        WebElementFacade locationField = element(vendorFormField("Location"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(locationField).waitUntilVisible().click();
        locationField.clear();
        detailsModel.setLocation("Location" + RandomGenerator.randomAlphabetic(6));
        locationField.sendKeys(detailsModel.getLocation());
    }

    private void enterValueInAccountNo() {
        WebElementFacade accNoField = element(vendorFormField("Account"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(accNoField).waitUntilVisible().click();
        accNoField.clear();
        detailsModel.setAccountNo(Integer.parseInt(RandomGenerator.randomInteger(5)));
        accNoField.sendKeys(detailsModel.getAccountNo().toString());
    }

    public void tapOnAddVendorButton() {
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(addVendorButton).click();
    }

    public void addInputFieldsOfVendorForm() {
        enterValueInName();
        enterValueInPhone();
        enterValueInEmail();
        enterValueInLocation();
        enterValueInAccountNo();
    }

    public void selectTypeFromDropdown() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(vendorTypeDropdown).waitUntilClickable().click();
        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(selectElectricityProvider).click();
        detailsModel.setType(selectElectricityProvider.getText());
    }

    public void enterInvalidContactNo() {
        waitFor(submitButton).withTimeoutOf(10, TimeUnit.SECONDS).sendKeys("1234");
        waitFor(2000);
    }

    public void tapOnSubmitButton() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(submitButton).click();
    }

    public void vendorDetailsVerify() {
        WebElementFacade a = element(vendorDetail("Name"));
        Assert.assertEquals(detailsModel.getName(),
                withTimeoutOf(20, TimeUnit.SECONDS).waitFor(a).getText());
        Assert.assertTrue(detailsModel.getType().contains(element(vendorDetail("Type")).getText()));
        Assert.assertEquals(detailsModel.getContact(), element(vendorDetail("Phone")).getText());
        Assert.assertEquals(detailsModel.getEmail(), element(vendorDetail("Email")).getText());
        Assert.assertEquals(detailsModel.getLocation(), element(vendorDetail("Location")).getText());
        Assert.assertEquals(detailsModel.getAccountNo().toString(), element(vendorDetail("Account Number")).getText());
    }

    public void tapOnCancelButton() {
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(cancelButton).waitUntilClickable().click();
    }

    public void tapOnEditIcon() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(editIcon).click();
    }

    public void tapOnNameLink() {
        nameLink.withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void tapOnActionButton() {
        waitABit(1000);
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(actionButton).click();
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
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(noteTestArea).click();
        noteTestArea.clear();
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(noteTestArea).sendKeys("Automation note is added.");
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(submitNoteButton).click();
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

        int num = getDriver().findElements(By.xpath("//tbody/tr")).size();
        waitABit(2000);
        for (int i = 1; i <= num; i++) {
            String vType = element(vendorTypeDynamic(i)).getText();
            Assert.assertEquals("Electricity Provider", vType);
        }

    }

    public void tapOnResetButton() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(resetButton).click();
        waitABit(1000);
    }

    public void enterKeywordInSearchField() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(searchVendor).sendKeys("Vendor");
    }

    public void tapOnFilterButton() {
        waitFor(filterButton).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void pressEnterKey() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(searchVendor).sendKeys(Keys.ENTER);
    }

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

    public void verifyIntergrationOfSearchFilter() {
        int num = getDriver().findElements(By.xpath("//tbody/tr")).size();
        waitABit(2000);
        for (int i = 1; i <= num; i++) {
            WebElementFacade a=element(vendorTypeDynamic(i));
            withTimeoutOf(20,TimeUnit.SECONDS).waitFor(a).waitUntilPresent();
            String vType = element(vendorTypeDynamic(i)).getText();
            Assert.assertEquals("Electricity Provider", vType);
            String vName = element(vendorNameSearch(i)).getText();
            Assert.assertTrue(vName.contains("Vendor"));
        }
    }

    public void clickOnDeleteIcon() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(deleteIcon).click();
    }

    public void clickOnDeleteButton() {
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(deleteButton).click();
    }

    public void acceptOptionInJSPopup() {
        withTimeoutOf(50,TimeUnit.SECONDS).waitFor(alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public void verifyEditDeleteForClientPersonnel() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(vendorHeading).isDisplayed();
        Assert.assertFalse(addVendorButton.isVisible());
        Assert.assertFalse(editIcon.isVisible());
        Assert.assertFalse(deleteIcon.isVisible());
    }

    public int totalRecordCount() {
        Scroll.to(datatableInfo);
        String str = datatableInfo.getText();
        String[] arrOfStr = str.split("of");
        String value = arrOfStr[1];
        return Integer.parseInt(value.replaceAll("[^0-9]", ""));
    }

    public int selectPageLimit(String option) {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(selectLimitDropdown).click();
        element(pageRecord(option)).click();
        return Integer.parseInt(element(pageRecord(option)).getText());
    }


    public void verifyPaginationFunction(String option) {
        int totalRecordCount = totalRecordCount();
        int recordCountPerPage = selectPageLimit(option);
        int noOfRecordInLastPage = totalRecordCount % recordCountPerPage;
        int pageCount = (noOfRecordInLastPage > 0) ? totalRecordCount / recordCountPerPage + 1 : totalRecordCount / recordCountPerPage;

        for (int noOfPage = 0; noOfPage < pageCount; noOfPage++) {
            WebElement NextButton = getDriver().findElement(By.xpath("//a[text()='" + (noOfPage + 1) + "']/.."));
            if (NextButton.isDisplayed()) {
                NextButton.click();
            }
            waitABit(3000);
            withTimeoutOf(20, TimeUnit.SECONDS).waitFor("//tbody/tr");
            int rowCountInTable = getDriver().findElements(By.xpath("//tbody//tr")).size();
            if ((noOfPage != pageCount - 1)) {
                Assert.assertEquals(rowCountInTable, recordCountPerPage);
            } else {
                int lastPageRecordCount = noOfRecordInLastPage == 0 ? recordCountPerPage : noOfRecordInLastPage;
                Assert.assertEquals(rowCountInTable, lastPageRecordCount);
                break;
            }
        }


    }

}