package pages;

import cucumber.api.DataTable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import utilities.RandomGenerator;

import java.util.List;
import java.util.Map;

public class CompanyModulePage extends PageObject {
    public static String Name;
    public static String Address;
    public static String Zipcode;
    public static String website;
    public static String contactnumber;
    public static String email;
    public static String Accountownername;
    public static String Accountowneremail;
    public static String Accountownercontactnumber;
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElementFacade enterusername;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElementFacade enterpassword;
    @FindBy(xpath = "//button[text()='Sign In']")
    WebElementFacade signinButton;
    @FindBy(xpath = "//a[@class='btn btn-brand btn-elevate btn-icon-sm']")
    WebElementFacade createnewcompany;
    @FindBy(xpath = "//h3[@class='kt-portlet__head-title']")
    WebElementFacade verfyredirection;
    @FindBy(xpath = "//input[@id='name']")
    WebElementFacade entername;
    @FindBy(xpath = "//input[@name='address']")
    WebElementFacade enteraddress;
    @FindBy(xpath = "//input[@name='zipCode']")
    WebElementFacade enterzipcode;
    @FindBy(xpath = "//input[@name='website']")
    WebElementFacade  enterwebsite;
    @FindBy(xpath = "//input[@name='contactNumber']")
    WebElementFacade  entercontactnumber;
    @FindBy(xpath = "//input[@name='email']")
    WebElementFacade  enteremail;
    @FindBy(xpath = "//input[@name='accountOwnerContactNumber']")
    WebElementFacade  enterownercontactnumber;
    @FindBy(xpath = "//input[@name='accountOwnerName']")
    WebElementFacade  accountownername;
    @FindBy(xpath = "//input[@name='accountOwnerEmail']")
    WebElementFacade  accountownernemail;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElementFacade  submitbtnofcompany;


    public void enterCredentialsForAdministrator(String username, String password) {
        try {
            enterusername.sendKeys(username);
            enterpassword.sendKeys(password);
            waitFor(signinButton).click();
        } catch (Exception ignored) {


        }
    }

    public void crateNewCompany() {
        waitFor(createnewcompany).click();
    }

    public void verifyRedirection() {
        Assert.assertTrue(verfyredirection.waitUntilVisible().isDisplayed());

    }
    public void addDetailsForCreatingNewCompany(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String name=data.get(0).get("Name")+ RandomGenerator.randomAlphanumeric(3);
        String email=data.get(0).get("Email")+ RandomGenerator.randomEmailAddress(2)+"@mailinator.com";
        String contactNumber=data.get(0).get("Contact Number")+ RandomGenerator.randomInteger(2);
        String accContactNumber=data.get(0).get("Account Owner Contact Number")+ RandomGenerator.randomInteger(2);
        String accEmail=data.get(0).get("Account Owner Email")+ RandomGenerator.randomEmailAddress(2)+"@mailinator.com";
        entername.sendKeys(name);
        enteraddress.sendKeys(data.get(0).get("Address"));
        enterzipcode.sendKeys(data.get(0).get("Zip Code"));
        entercontactnumber.sendKeys(contactNumber);
        enteremail.sendKeys(email);
        accountownername.sendKeys(data.get(0).get("Account Owner Name"));
        accountownernemail.sendKeys(accEmail);
        enterownercontactnumber.sendKeys(accContactNumber);
    }
    public void userClicksOnSubmitButton(){
        submitbtnofcompany.click();


    }

}




