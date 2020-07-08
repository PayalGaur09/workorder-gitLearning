package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import net.thucydides.core.pages.PageObject;
import utilities.LoadProperties;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class UserSigninPage extends PageObject {

    @FindBy(xpath = "//input[@name='userName']")
    private WebElementFacade userName;
    @FindBy(xpath = "//input[@name='password']")
    private WebElementFacade password;
    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElementFacade signinButton;
    @FindBy(xpath = "//h3[text()=' Dashboard ']")
    private WebElementFacade dashboardTitle;
    @FindBy(xpath = "//span[text()='Sign Out']")
    private WebElementFacade signoutLink;
    @FindBy(xpath = "//div[text()=' Invalid credential. ']")
    private WebElementFacade invalidCredentials;
    @FindBy(xpath = "//a[@class='kt-link kt-login__link-forgot']")
    private WebElementFacade Forgotpwd;
    @FindBy(xpath = "//h3[contains(text(),'Reset Password')]")
    private WebElementFacade redirectiononresetpwd;
    @FindBy(xpath = "//input[@placeholder='Email*']")
    private WebElementFacade forgotPwd;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-elevate kt-login__btn-primary']")
    private WebElementFacade submitbuttonForgotPwd;
    @FindBy(xpath = "//input[@name='login']")
    private WebElementFacade yopmail;
    @FindBy(xpath = "//input[@class='sbut']")
    private WebElementFacade clicksoncheckbox;
    @FindBy(xpath = "//a[text()='Reset Password']")
    private WebElementFacade clicksonmailtab;
    @FindBy(xpath = "//input[@name='newPassword']")
    private WebElementFacade newpwd;
    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElementFacade confirmpwd;



    private By validationOnLoginScreen(String errorMessage) {
        return By.xpath("//div[contains(text(),'" + errorMessage + "')]");
    }


    public void enterCredentials(String userEmail, String pwd) {
        try {
            userName.sendKeys(userEmail);
            password.sendKeys(pwd);
            withTimeoutOf(20, TimeUnit.SECONDS).waitFor(signinButton).click();
        } catch (Exception ignored) {

        }

    }


    public void verifyHomepage() {
        dashboardTitle.isVisible();
    }

    public void signout() {
        waitABit(1000);
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(signoutLink).click();
    }

    public void errorForInvalidCredentials() {
        waitFor(invalidCredentials).withTimeoutOf(20, TimeUnit.SECONDS).isDisplayed();
    }

    public void validationMessage(String err) {
        element(validationOnLoginScreen(err)).withTimeoutOf(20, TimeUnit.SECONDS).isDisplayed();
    }
    public void userClicksOnForgotPasswordLink() {
                Forgotpwd.click();

                    }

            public void redirectsOnResetPasswordPage() {
               assertTrue(redirectiononresetpwd.waitUntilVisible().isDisplayed());


                           }

            public void enterEmailForForgotPaasword() {
                String userEmail = LoadProperties.getValueFromPropertyFile("testData", "UserEmailForgotPwd");
                forgotPwd.sendKeys(userEmail);


                            }

            public void userClicksOnSubmitBtn() {
                submitbuttonForgotPwd.click();
           }

            public void userEnttersEmailInMailnator() {
                String userEmail = LoadProperties.getValueFromPropertyFile("testData", "UserEmailForgotPwd");
               yopmail.sendKeys(userEmail);
               clicksoncheckbox.click();
                    }
   public void userCliksOnTheLinkResetPassword(){
               getDriver().switchTo().frame("ifmail");
               clicksonmailtab.click();
               getDriver().switchTo().defaultContent();
                    }
   public void switchToNextTab(){
               ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
               getDriver().switchTo().window(tabs2.get(1));

                    }

            public void userEnterNewAndConfirmPwd(){
              String pwd = LoadProperties.getValueFromPropertyFile("testData", "UserEmailForgotPwd");
               newpwd.sendKeys(pwd);
                confirmpwd.sendKeys(pwd);
                   }
}


