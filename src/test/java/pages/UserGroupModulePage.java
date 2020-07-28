package pages;

import cucumber.api.DataTable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.LoadProperties;
import utilities.RandomGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static utilities.LoadProperties.getValueFromPropertyFile;


public class UserGroupModulePage extends PageObject {
    List<String> selectedItems;
    public static String groupname;
    public static String Editusergroup;
    String[] memberAssigned;

    @FindBy(xpath = "//h3[text()=' User Groups ']")
    private WebElementFacade verifyUsergroupRedirection;
    @FindBy(xpath = "//h4[@class='kt-widget24__title text-center fs-20']/a[text()='User Group']")
    private WebElementFacade usergroup;
    @FindBy(xpath = "//a[@class='btn btn-brand btn-elevate btn-icon-sm']")
    private WebElementFacade newusergroup;
    @FindBy(xpath = "//input[@name='userGroupName']")
    private WebElementFacade entervalueingroupname;
    @FindBy(xpath = "//div[@class='dropdown-list']")
    private WebElementFacade memberassigneddropdown;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElementFacade deleteButton;
    @FindBy(xpath = "(//span[@class='link'])[1]")
    private WebElementFacade clicksOnCompany;
    @FindBy(xpath = "href=")
    private WebElementFacade userGroupcompany;
    @FindBy(xpath = "//div[@class='multiselect-dropdown']")
    private WebElementFacade selectedUserGroup;
    @FindBy(xpath = "//ul[@class='item1']//div")
    private WebElementFacade selectAlluser;
    @FindBy(xpath = "//span[contains(@class,'kt-badge kt-badge--primary')]")
    private WebElementFacade verifymemberassigned;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElementFacade deactivateButton;


    private By deleteUserGroup(String companyname) {
        return By.xpath("//*[text()='" + companyname + "']/ancestor::tr//em[@title='Delete']");
    }

    private By getDeactivateUsergroup(String verifyusergroupstatus) {
        return By.xpath("//*[text()='" + verifyusergroupstatus + "']/ancestor::tr//em[@title= 'Deactivate']");
    }

    private By geActivateUsergroup(String verifysergroupstatus) {
        return By.xpath("//*[text()='" + verifysergroupstatus + "']/ancestor::tr//em[@title= 'Activate']");
    }

    private By userEditDetails(String companynameedit) {
        return By.xpath("//*[contains(text(),'" + companynameedit + "')]/ancestor::tr//em[@title='Edit']");
    }

    private By verifyCreateUserGroupDetails(String usergroup) {
        return By.xpath("//*[text()='" + usergroup + "']");
    }


    public void verifyRedirection() {
        Assert.assertTrue(verifyUsergroupRedirection.waitUntilVisible().isDisplayed());


    }

    public void userClicksOnNewUserGroupButton() {
        newusergroup.click();
    }

    public void userEntersTheValueInGroupNameField(DataTable dataTable) throws IOException, ConfigurationException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        groupname = data.get(0).get("userGroupName") + RandomGenerator.randomAlphanumeric(2);
        LoadProperties.saveValueInPropertiesFile("userGroupName", groupname, "testData");
        entervalueingroupname.sendKeys(groupname);


    }

    public void selectMemberDropdown() {

    }

    public void selectMultipleUserGroupCheckbox() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//ul[@class='item2']//li"));
        elements.get(0).click();
        elements.get(1).click();
    }

    public void verifyUserGroupDetails() {
        element(verifyCreateUserGroupDetails(groupname)).waitUntilVisible();
        element(verifyCreateUserGroupDetails(groupname)).isDisplayed();
    }



    public void userDeleteUsergroup() {
        String usergroup = getValueFromPropertyFile("testData", "userGroupName");
        element(deleteUserGroup(usergroup)).waitUntilVisible().click();
        deleteButton.click();

    }

    public void userClicksOnDeactivatiingButton() {
        String usergroup = getValueFromPropertyFile("testData", "userGroupName");
        element(getDeactivateUsergroup(usergroup)).waitUntilVisible().click();
        deactivateButton.click();


    }

    public void userClicksOnActivatingButton() {
        String usergroup = getValueFromPropertyFile("testData", "userGroupName");
        element(geActivateUsergroup(usergroup)).waitUntilVisible().click();


    }

    public void userCkicksOnEditButton() {
        String usergroup = getValueFromPropertyFile("testData", "userGroupName");
        element(userEditDetails(usergroup)).waitUntilVisible().click();


    }

    public void UserEditUserGroupDetails(DataTable editusergroupname) {
        Editusergroup = editusergroupname.asMaps(String.class, String.class).get(0).get("userGroupName") + RandomGenerator.randomAlphanumeric(2);
        waitABit(2000);
        waitFor(entervalueingroupname).waitUntilVisible().clear();
        waitABit(2000);
        waitFor(entervalueingroupname).waitUntilVisible().sendKeys(Editusergroup);
        waitABit(2000);

    }

    public void userCheckValidationMessage(DataTable value) {
        List<Map<String, String>> data = value.asMaps(String.class, String.class);
        groupname = data.get(0).get("userGroupName");
        validation(groupname);


    }

    public void validation(String groupname) {
        entervalueingroupname.sendKeys(groupname);

    }

    public void userEntersTheDetails(DataTable value) throws IOException, ConfigurationException {
        groupname = value.asMaps(String.class, String.class).get(0).get("userGroupName") + RandomGenerator.randomAlphanumeric(2);
        waitFor(entervalueingroupname).waitUntilVisible().sendKeys(groupname);
        LoadProperties.saveValueInPropertiesFile("userGroupName", groupname, "testData");


    }

    public void userCheckSameNameUsergroupIsNotExist() {
        String usergroup = LoadProperties.getValueFromPropertyFile("testData", "userGroupName");
        waitFor(entervalueingroupname).waitUntilVisible().clear();
        waitFor(entervalueingroupname).waitUntilVisible().sendKeys(usergroup);
    }



    public void userClicksOnDeleteButton() {
        deleteButton.click();


    }

    public void userClicksOnAnyCompany() {
        clicksOnCompany.click();
    }

    public void userClicksOnUserGroupTab() {
        usergroup.click();

    }

    public void userTapOnUserAssignedDropdown() {
        waitABit(5000);
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(selectedUserGroup).click();
    }

    public void selectUserGroupCheckbox() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//ul[@class='item2']//li"));
        elements.get(0).click();
        waitABit(2000);

    }


    public void selectAllUserGroupCheckbox() {
        selectAlluser.click();

    }

    public void userRemovesTheUseGroup() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//ul[@class='item2']//li"));
        selectedItems = new ArrayList<>();
        elements.get(0).click();
    }
    public void userCrossVerifyTheEditDetails(){
        element(verifyCreateUserGroupDetails(Editusergroup)).waitUntilVisible();
        element(verifyCreateUserGroupDetails(Editusergroup)).isDisplayed();

    }
    public void UserClicksOnDeactivateButton(){
        deactivateButton.click();
    }

}








