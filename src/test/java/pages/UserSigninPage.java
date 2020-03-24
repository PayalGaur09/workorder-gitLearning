package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.concurrent.TimeUnit;



public class UserSigninPage extends PageObject {

    @FindBy(xpath = "//input[@name='userName']")
    WebElementFacade userName;
    @FindBy(xpath = "//input[@name='password']")
    WebElementFacade password;
    @FindBy(xpath = "//button[text()='Sign In']")
    WebElementFacade signinButton;
    @FindBy(xpath = "//h3[text()=' Dashboard ']")
    WebElementFacade dashboardTitle;
    @FindBy(xpath = "//span[contains(@class,'kt-header__topbar-username')]")
    WebElementFacade topbarUsername;
    @FindBy(xpath = "//a[text()='Sign Out']")
    WebElementFacade signoutButton;
    @FindBy(xpath = "//span[text()='Sign Out']")
    WebElementFacade signoutLink;


    @FindBy(xpath = "//div[text()=' Invalid credential. ']")
    WebElementFacade invalidCredentials;


    private By validationOnLoginScreen(String errorMessage) {
        return By.xpath("//div[contains(text(),'"+errorMessage+"')]");
    }

    public void homePage() {
//        setEnvironMent("test");
    }

    public void enterCredentials(String userEmail, String pwd) {
        try {
                userName.sendKeys(userEmail);
                password.sendKeys(pwd);
                waitFor(signinButton).click();
        }
        catch (Exception ignored){

        }

    }


    public void verifyHomepage() {
        dashboardTitle.isVisible();
    }

    public void signout() {
       // withTimeoutOf(10,TimeUnit.SECONDS).waitFor(topbarUsername).click();
        withTimeoutOf(10,TimeUnit.SECONDS).waitFor(signoutLink).click();
    }

    public void errorForInvalidCredentials() {
        waitFor(invalidCredentials).withTimeoutOf(20,TimeUnit.SECONDS).isDisplayed();
    }

    public void validationMessage(String err) {
        element(validationOnLoginScreen(err)).withTimeoutOf(20,TimeUnit.SECONDS).isDisplayed();
    }
}
