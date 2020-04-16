package pages;

import cucumber.api.DataTable;
import models.ProfileModel;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriverService;
import org.openqa.selenium.support.FindBy;
import utilities.RandomGenerator;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProfilePage extends PageObject {
    ProfileModel profileModel = new ProfileModel();

    public static String CurrentPassword;
    public static String NewPassword;
    public static String ConfirmPassword;
    public static String FirstName;
    public static String EmailAdd;
    public static String MobNo;
    @FindBy(xpath = "//span[text()='personnel ']")
    WebElementFacade ownername;
    @FindBy(xpath = "//span[text()='My Profile']")
    WebElementFacade profile;
    @FindBy(xpath = "//button[text()=' Action ']/..")
    WebElementFacade actionbutton;
    @FindBy(xpath = "//h3[text()=' Edit Profile ']")
    WebElementFacade verifyeditprofile;
    @FindBy(xpath = "//input[@name='firstName']")
    WebElementFacade firstName;
    @FindBy(xpath = "//input[@name='email']")
    WebElementFacade emailAdd;
    @FindBy(xpath = "//input[@name='phone']")
    WebElementFacade mobNo;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElementFacade submitbutton;
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElementFacade cancelbutton;
    @FindBy(xpath = "//h3[text()=' My Profile ']")
    WebElementFacade myprofile;
    @FindBy(name = "firstName")
    WebElementFacade firstname;
    @FindBy(name = "email")
    WebElementFacade email;
    @FindBy(name = "phone")
    WebElementFacade phone;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElementFacade submitbutton1;
    @FindBy(xpath = "//input[@name='currentPassword']")
    WebElementFacade currentpassword;
    @FindBy(xpath = "//input[@name='newPassword']")
    WebElementFacade newpassword;
    @FindBy(xpath = "//input[@name='confirmPassword']")
    WebElementFacade confirmpassword;
    @FindBy(xpath = "//div[text()=' Please enter correct old password ']")
    WebElementFacade oldpasswordincorrect;
    @FindBy(xpath = "//a[text()='Cancel']")
    WebElementFacade changepasscancelbutton;
    @FindBy(xpath = "//h3[text()=' My Profile ']")
    WebElementFacade verifyprofilepage;


    private By validationHeader(String header) {
        return By.xpath("//*[contains(text(),'" + header + "')]/..");
    }

    private By messageRequired(String Text) {
        return By.xpath("//*[contains(text(),'" + Text + "')]/..");
    }

    private By invalidMessage(String ErrorMessage) {
        return By.xpath("//*[contains(text(),'" + ErrorMessage + "')]/..");
    }
    private By validationPopup(String successMessage) {
        return By.xpath("//*[contains(text(),'" + successMessage + "')]/..");
    }


    private By selectButton(String textbutton) {
        return By.xpath("//span[text()='" + textbutton + "']");
    }


    private By chnagePasswordValidation(String option) {
        return By.xpath("//span[text()='" + option + "']");
    }

    private By cancelMessage(String button) {
        return By.xpath("//a[text()='" + button + "']");
    }

    private By sideMenu(String SideMenu) {
        return By.xpath("//span[text()='" + SideMenu + "']");
    }


    public void setOwnername() {
        ownername.click();
    }

    public void myprofile() {
        profile.click();
        waitABit(4000);
    }

    public void verifytheprofiledetails(List<String> header) {
        waitABit(5000);
        for (int i = 0; i < header.size(); i++) {
            Assert.assertTrue(element(validationHeader(header.get(i))).waitUntilVisible().withTimeoutOf(40, TimeUnit.SECONDS).isDisplayed());
        }
    }

    public void actionButton() {
        waitABit(2000);
        actionbutton.click();

    }

    public void editbutton(String textbutton) {
        element(selectButton(textbutton)).waitUntilVisible().withTimeoutOf(40, TimeUnit.SECONDS).click();
    }

    public void verifyHeader() {
        Assert.assertTrue(verifyeditprofile.waitUntilVisible().isDisplayed());
    }

    public void editProfile(DataTable Credentials) {
        FirstName = Credentials.asMaps(String.class, String.class).get(0).get("First Name");
        EmailAdd = Credentials.asMaps(String.class, String.class).get(0).get("Email");
        MobNo = Credentials.asMaps(String.class, String.class).get(0).get("Phone");
        waitFor(firstName).waitUntilVisible().clear();
        waitABit(2000);
        waitFor(firstName).waitUntilVisible().clear();
        waitFor(firstName).waitUntilVisible().sendKeys(FirstName);
        waitFor(emailAdd).waitUntilVisible().clear();
        waitFor(emailAdd).waitUntilVisible().sendKeys(EmailAdd);
        waitFor(mobNo).waitUntilVisible().clear();
        waitFor(mobNo).waitUntilVisible().sendKeys(MobNo);
    }


    public void submitButton() {
        submitbutton.click();

    }

    public void cancelbutton() {
        cancelbutton.click();
    }

    public void myprofilepage() {
        Assert.assertTrue(myprofile.waitUntilVisible().isDisplayed());

    }

    public void clearData() {
        waitFor(firstname).waitUntilVisible().clear();
        waitFor(email).waitUntilVisible().clear();
        waitFor(phone).waitUntilVisible().clear();
    }

    public void validationMessage(String Text) {
        Assert.assertTrue(element(messageRequired(Text)).waitUntilVisible().isDisplayed());

    }


    public void submitButton1() {
        submitbutton1.click();
    }

    public void oldpasswordIncorrect(DataTable data) {
        CurrentPassword = data.asMaps(String.class, String.class).get(0).get("currentPassword");
        NewPassword = data.asMaps(String.class, String.class).get(0).get("newPassword");
        ConfirmPassword = data.asMaps(String.class, String.class).get(0).get("confirmPassword");
        waitFor(currentpassword).waitUntilVisible().sendKeys(CurrentPassword);
        waitFor(newpassword).waitUntilVisible().sendKeys(NewPassword);
        waitFor(confirmpassword).waitUntilVisible().sendKeys(ConfirmPassword);


    }

    public void invalidoldPassword() {
        oldpasswordincorrect.isDisplayed();
    }


    public void changePasscancelbutton() {
        changepasscancelbutton.click();

    }

    public void verifyProfilepage() {
        Assert.assertTrue(verifyprofilepage.waitUntilVisible().isDisplayed());
    }

    public void errorMessage(String option) {
        Assert.assertTrue(element(chnagePasswordValidation(option)).waitUntilVisible().isDisplayed());

    }


    public void cancelButton(String button) {
        element(cancelMessage(button)).waitUntilVisible().isEnabled();
        element(cancelMessage(button)).waitUntilVisible().click();
    }

    public void profileButton(String SideMenu) {
        element(sideMenu(SideMenu)).waitUntilVisible().isEnabled();
        element(sideMenu(SideMenu)).waitUntilVisible().click();
    }


    public void changeInvalidPassword(DataTable InvalidCredentials) {
        CurrentPassword = InvalidCredentials.asMaps(String.class, String.class).get(0).get("currentPassword");
        NewPassword = InvalidCredentials.asMaps(String.class, String.class).get(0).get("newPassword");
        ConfirmPassword = InvalidCredentials.asMaps(String.class, String.class).get(0).get("confirmPassword");
        enterInvalidCredentials(CurrentPassword, NewPassword, ConfirmPassword);

    }

    public void enterInvalidCredentials(String CurrentPassword, String NewPassword, String ConfirmPassword) {
        currentpassword.sendKeys(CurrentPassword);
        newpassword.sendKeys(NewPassword);
        confirmpassword.sendKeys(ConfirmPassword);
        submitbutton.click();
    }


    public void verifyMessage(String ErrorMessage) {
        Assert.assertTrue(element(invalidMessage(ErrorMessage)).waitUntilVisible().isDisplayed());
    }


    public void successPopup(String successMessage){
        Assert.assertTrue( element(validationPopup(successMessage)).waitUntilVisible().isDisplayed());
    }

    }






