package pages;

import com.typesafe.config.Config;
import cucumber.api.DataTable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.tools.ant.taskdefs.WaitFor;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.ConfigLoader;
import utilities.LoadProperties;
import utilities.RandomGenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.LoadProperties.getValueFromPropertyFile;


public class CompanyModulePage extends PageObject {
    private static Config conf = ConfigLoader.load();
    private static final Logger log = LoggerFactory.getLogger(CompanyModulePage.class);


    private static String dataFileName = File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "testdata" + File.separator + "testdata.properties";


//    String brandName = (String) new PropertiesConfiguration(testdataFileName).getProperty("bulkInviteVendorBrand");

    public static String name;
    public static String Name;
    public static String Address;
    public static String Zipcode;
    public static String website;
    public static String contactnumber;
    public static String email;
    public static String contactNumber;
    public static String accContactNumber;
    public static String accEmail;
    public static String Accountownername;
    public static String Accountowneremail;
    public static String Accountownercontactnumber;
    @FindBy(xpath = "//input[@name='userName']")
    WebElementFacade userName;
    @FindBy(xpath = "//*[@placeholder='Filter companies']")
    WebElementFacade searchCompany;
    @FindBy(xpath = "//td[text()='No matching records found']")
    WebElementFacade noList;
    @FindBy(xpath = "//input[@name='password']")
    WebElementFacade password;
    @FindBy(xpath = "//span[text()='Sign Out']")
    WebElementFacade signoutLink;
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
    WebElementFacade enterwebsite;
    @FindBy(xpath = "//input[@name='contactNumber']")
    WebElementFacade entercontactnumber;
    @FindBy(xpath = "//input[@name='email']")
    WebElementFacade enteremail;
    @FindBy(xpath = "//input[@name='accountOwnerContactNumber']")
    WebElementFacade enterownercontactnumber;
    @FindBy(xpath = "//input[@name='accountOwnerName']")
    WebElementFacade accountownername;
    @FindBy(xpath = "//input[@name='accountOwnerEmail']")
    public WebElementFacade accountownernemail;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElementFacade submitbtnofcompany;
    @FindBy(xpath = "//input[@placeholder='Type DELETE to confirm']")
    WebElementFacade writevalueintextbox;
    @FindBy(xpath = "//button[text()='OK']")
    WebElementFacade confirmbutton;
    @FindBy(xpath = "//a[text()='Cancel']")
    WebElementFacade cancelbutton;
    @FindBy(xpath = "//h3[text()=' Companies ']")
    WebElementFacade verifyredirection;
    @FindBy(xpath = "//em[@title='Account Owner Name']")
    WebElementFacade accountownernameverify;
    @FindBy(xpath = "(//*[text()='Account Owner Detail']/ancestor::div//a[contains(@class,'btn btn-sm btn-outline-brand btn-elevate btn-icon')])[2]")
    WebElementFacade editaccountownerdetails;
    @FindBy(xpath = "(//span[text()='Inactive'])[1]")
    WebElementFacade comanyprofileinactive;
    @FindBy(xpath = "(//span[text()='Active'])[1]")
    WebElementFacade comanyprofilenactive;
    @FindBy(xpath = "//select[@name='status']")
    WebElementFacade selectStatus;

    private By deleteCompany(String companyname) {
        return By.xpath("//*[text()='" + companyname + "']/ancestor::tr//em[@title='Delete']");
    }


    private By editCompany(String companynameedit) {
        return By.xpath("//*[contains(text(),'" + companynameedit + "')]/ancestor::tr//em[@title='Edit']");
    }

    private By getEditCompany(String editCompany) {
        return By.xpath("//span[text()='" + editCompany + "']");

    }

    private By getEditOwner(String editOwner) {
        return By.xpath("(//a[@class='" + editOwner + "'])[2]");

    }

    private By getEditAccountOwnerDetails(String verifydetails) {
        return By.xpath("//*[text()='" + verifydetails + "']");
    }

    private By getActivateOrDeactivateTheCompany(String verifycompanystatus) {
        return By.xpath("//*[text()='" + verifycompanystatus + "']/ancestor::tr//em[@title= 'Deactivate']");

    }

    private By getDeactivateTheCompany(String verifycompanystatus) {
        return By.xpath("//*[text()='" + verifycompanystatus + "']/ancestor::tr//em[@title= 'Activate']");

    }


    private By userClicksOnTheCompany(String deactivatefromdetailpage) {
        return By.xpath("//*[text()='" + deactivatefromdetailpage + "']");

    }


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
        assertTrue(verfyredirection.waitUntilVisible().isDisplayed());

    }

    public void addDetailsForCreatingNewCompany(DataTable dataTable) throws IOException, ConfigurationException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        name = data.get(0).get("Name") + RandomGenerator.randomAlphanumeric(3);
        LoadProperties.saveValueInPropertiesFile("name", name, "testData");
        email = data.get(0).get("Email") + RandomGenerator.randomEmailAddress(2) + "@mailinator.com";
         contactNumber = data.get(0).get("Contact Number") + RandomGenerator.randomInteger(2);
         accContactNumber = data.get(0).get("Account Owner Contact Number") + RandomGenerator.randomInteger(2);
        accEmail = data.get(0).get("Account Owner Email") + RandomGenerator.randomEmailAddress(2) + "@mailinator.com";
        entername.sendKeys(name);
        enteraddress.sendKeys(data.get(0).get("Address"));
        enterzipcode.sendKeys(data.get(0).get("Zip Code"));
        entercontactnumber.sendKeys(contactNumber);
        enteremail.sendKeys(email);
        accountownername.sendKeys(data.get(0).get("Account Owner Name"));
        accountownernemail.sendKeys(accEmail);
        enterownercontactnumber.sendKeys(accContactNumber);
    }

    public void userClicksOnSubmitButton() {
        waitFor(submitbtnofcompany).click();

    }

    public void userDeleteTheCompany() {
        String companyname = getValueFromPropertyFile("testData", "name");
        element(deleteCompany(companyname)).waitUntilVisible().click();
    }

    public void userCliksOnOkButtonForDeletingTheCompany() {
        writevalueintextbox.sendKeys("DELETE");
        confirmbutton.click();
        waitABit(3000);

    }

    public void userclicksOnTheEditButton() {
        String companyedit = getValueFromPropertyFile("testData", "name");
        element(editCompany(companyedit)).waitUntilVisible().click();

    }

    public void userEditTheCompanyDetails() {
        waitFor(entername).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible().clear();
        waitFor(entername).waitUntilVisible().sendKeys(name);
    }

    public void enterInvalidValueInTheFields(String Name, String Address, String Zipcode, String contactnumber, String email, String Accountownername, String Accountowneremail, String Accountownercontactnumber) {
        entername.sendKeys(Name);
        enteraddress.sendKeys(Address);
        enterzipcode.sendKeys(Zipcode);
        entercontactnumber.sendKeys(contactnumber);
        enteremail.sendKeys(email);
        accountownername.sendKeys(Accountownername);
        accountownernemail.sendKeys(Accountowneremail);
        enterownercontactnumber.sendKeys(Accountownercontactnumber);

    }

    public void checkValidationsOnAddCompany(DataTable validation) {
        List<Map<String, String>> data = validation.asMaps(String.class, String.class);
        Name = data.get(0).get("name");
        Address = data.get(0).get("address");
        Zipcode = data.get(0).get("zipCode");
        contactnumber = data.get(0).get("contactNumber");
        email = data.get(0).get("email");
        Accountownername = data.get(0).get("accountOwnerName");
        Accountowneremail = data.get(0).get("accountOwnerEmail");
        Accountownercontactnumber = data.get(0).get("accountOwnerContactNumber");
        enterInvalidValueInTheFields(Name, Address, Zipcode, contactnumber, email, Accountownername, Accountowneremail, Accountownercontactnumber);

    }

    public void userCliksOnCancelButtonOfAddCompanyPage() {
        cancelbutton.click();

    }

    public void verifyTheRedirection() {
        assertTrue(verifyredirection.waitUntilVisible().isDisplayed());

    }

    public void dataVerify() {
        String comName = element(getEditCompany(name)).getText();
        assertEquals(comName, name);

    }

    public void userCliksOnTheEditButtonForAccountOwnerDetails() {
        waitABit(3000);
        waitFor(editaccountownerdetails).click();
    }

    public void userEditTheOwnerDetails(DataTable editownerdetails) {
        Accountownername = editownerdetails.asMaps(String.class, String.class).get(0).get("Account Owner Name")+RandomGenerator.randomAlphabetic(3);
        Accountowneremail = editownerdetails.asMaps(String.class, String.class).get(0).get("Account Owner Email") + RandomGenerator.randomEmailAddress(2) + "@mailinator.com";
        Accountownercontactnumber = editownerdetails.asMaps(String.class, String.class).get(0).get("Account Owner Contact Number")+RandomGenerator.randomInteger(3);
        waitFor(accountownername).waitUntilVisible().clear();
        waitFor(accountownername).waitUntilVisible().sendKeys(Accountownername);
        waitABit(2000);
        waitFor(accountownernemail).waitUntilVisible().clear();
        waitFor(accountownernemail).waitUntilVisible().sendKeys(Accountowneremail);
        waitFor(enterownercontactnumber).waitUntilVisible().clear();
        waitFor(enterownercontactnumber).waitUntilVisible().sendKeys(Accountownercontactnumber);


    }

    public void signout() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(signoutLink).click();
    }

    public void openLoginPage() {
        getDriver().manage().deleteAllCookies();
        openUrl(conf.getString("base_url"));
        getDriver().manage().window().maximize();
        try {
            signout();
        } catch (Exception e) {
            log.info("Logout button is not available");
        }
    }

    public void loginAs(String username) {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(userName).sendKeys(username);
        if (username.equals("admin"))
            waitFor(password).sendKeys("Password@123");
        else if (username.equals("shashank.singh@successive.tech"))
            waitFor(password).sendKeys("1234567890");
        else if (username.equals("payal.gaur@successive.tech"))
            waitFor(password).sendKeys("1234567890");
        waitFor(signinButton).click();
    }

    public void enterLogindetails(String emailId, String pwd) {
        clearEnterText(enterusername, emailId);
        clearEnterText(enterpassword, pwd);
        waitFor(signinButton).click();
    }

    public void clearEnterText(WebElementFacade by, String inputText) {
        element(by).clear();
        element(by).sendKeys(inputText);
    }

    public void verifyTheDetailsOfTheEditCompany() {
        String companydetails = getValueFromPropertyFile("testData", "name");
        element(getEditAccountOwnerDetails(companydetails)).waitUntilVisible().click();
    }

    public void crossVeriyTheOwnerDetails() {
        element(verifyCompany(Accountownername)).waitUntilVisible();
        element(verifyCompany(Accountownername)).isDisplayed();


    }

    public void userCheckTheCompanyStatus() {
        if (comanyprofilenactive.isVisible()) {
            String companystatus = getValueFromPropertyFile("testData", "name");
            element(getActivateOrDeactivateTheCompany(companystatus)).waitUntilVisible().click();


        }

    }


    public WebElement searchText() {
        return waitFor(searchCompany);
    }

    public void noData() {
        element(noList).waitUntilVisible().isDisplayed();
    }

    public void verifyCompanyOnList() {
        String comOnList = getValueFromPropertyFile("testData", "name");
        String ListCompany = $("//span[contains(text(),'tester')]").getText();
        Assert.assertEquals(comOnList, ListCompany);

    }


    public void verifyCompanyProfileStatusActive() {
        if (comanyprofileinactive.isVisible()) {
            String companyactivestatusstatus = getValueFromPropertyFile("testData", "name");
            element(getDeactivateTheCompany(companyactivestatusstatus)).waitUntilVisible().click();

        }
    }

    public void userClicksOnEachTabsShowingOnCompanyDetailpage() {
        List<WebElement> tabs = getDriver().findElements(By.xpath("//h4[@class='kt-widget24__title text-center fs-20']//a"));
        int Size = tabs.size();
        for (int i = 0; i < Size; i++) {
            WebElement tab = getDriver().findElement(By.xpath("//h4[@class='kt-widget24__title text-center fs-20']//a"));
            tab.click();
            getDriver().navigate().back();


        }


    }

    public void VerifyTheActiveStatus() {
        waitFor(selectStatus).withTimeoutOf(80, TimeUnit.SECONDS).click();
        Select active = new Select(selectStatus);
        active.selectByVisibleText("Active");
    }

    public void verifyAllTheActiveStatusVisibleToTheuser() {
        List<WebElement> count = getDriver().findElements(By.xpath("//span[@class='badge badge-success']"));
        int Size = count.size();
        for (int i = 0; i < Size; i++) {
            System.out.println(count.get(i).getText());


        }
    }

    public void VerifyTheInActiveStatus() {
        waitFor(selectStatus).withTimeoutOf(80, TimeUnit.SECONDS).click();
        Select active = new Select(selectStatus);
        active.selectByVisibleText("Inactive");
    }
    public void verifyAllTheInActiveStatusVisibleToTheuser() {
        List<WebElement> inactive = getDriver().findElements(By.xpath("//span[@class='badge badge-danger']"));
        int Size = inactive.size();
        for (int i = 0; i < Size; i++) {
            System.out.println(inactive.get(i).getText());


        }
    }

    public void navigationPage() {
        String value = getValueFromPropertyFile("testData", "Total_Link");
        int inum = Integer.parseInt(value);
        for (int i = 2; i <= inum; i++) {
            String currentLink = getValueFromPropertyFile("testData", "Link_" + i);
            $(" //a[text()=' " +  currentLink +"']/ancestor::h4").click();
            String header = $("//*[contains(@class,'d-title')]").getText();
//            Assert.assertEquals(header, currentLink);
            getDriver().navigate().back();

        }
    }
        public void clickOnCompany () {
            $("//span[text()='testerbC6']").click();
        }
        public void UserClicksOnTheCompany(){
            String comp = getValueFromPropertyFile("testData", "name");
            element(userClicksOnTheCompany(comp)).waitUntilVisible().click();

        }
        public void userVerifyTheCompanyDetails(){
            element(verifyCompany(name)).waitUntilVisible();
            element(verifyCompany(name)).isDisplayed();
            element(verifyCompany(email)).waitUntilVisible();
            element(verifyCompany(email)).isDisplayed();
//            element(verifyCompany(contactNumber)).waitUntilVisible();
//            element(verifyCompany(contactNumber)).isDisplayed();

        }

    private By verifyCompany(String nameCompany){
        return By.xpath("//div[contains(@class,'col-md-12 detail-form ng-star-inserted')]//div//*[contains(text(),'"+ nameCompany +"')]");

    }


    }





























