package pages;

import cucumber.api.DataTable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
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
    @FindBy(xpath = "//label[contains(text(),'Account Owner Contact Number:*')]")
    WebElementFacade  enterownercontactnumber;
    @FindBy(xpath = "//input[@name='accountOwnerName']")
    WebElementFacade  accountownername;
    @FindBy(xpath = "//input[@name='accountOwnerEmail']")
    WebElementFacade  accountownernemail;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElementFacade  submitbtn;


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
    public void addDetailsForCreatingNewCompany(DataTable adddetails) {
        Name = adddetails.asMaps(String.class, String.class).get(0).get("Name");
        Address = adddetails.asMaps(String.class, String.class).get(0).get("Address");
        Zipcode = adddetails.asMaps(String.class, String.class).get(0).get("Zip Code");
        website = adddetails.asMaps(String.class, String.class).get(0).get("Website");
        contactnumber = adddetails.asMaps(String.class, String.class).get(0).get("Contact Number");
        email = adddetails.asMaps(String.class, String.class).get(0).get("Email");
        Accountownername = adddetails.asMaps(String.class, String.class).get(0).get("Account Owner Name");
        Accountowneremail = adddetails.asMaps(String.class, String.class).get(0).get("Account Owner Email");
        Accountownercontactnumber = adddetails.asMaps(String.class, String.class).get(0).get("Account Owner Contact Number");
        waitABit(2000);
        waitFor(entername).waitUntilVisible().sendKeys(Name);
        waitFor(enteraddress).waitUntilVisible().sendKeys(Address);
        waitFor(enterzipcode).waitUntilVisible().sendKeys(Zipcode);
        waitFor(enterwebsite).waitUntilVisible().sendKeys(website);
        waitFor(entercontactnumber).waitUntilVisible().sendKeys(contactnumber);
        waitFor(enteremail).waitUntilVisible().sendKeys(email);
        waitFor(accountownername).waitUntilVisible().sendKeys(Accountownername);
        waitFor(accountownernemail).waitUntilVisible().sendKeys(Accountowneremail);
        waitFor(enterownercontactnumber).waitUntilVisible().sendKeys(Accountownercontactnumber);

    }
    public void userClicksOnSubmitButton(){
        submitbtn.click();

    }

}




