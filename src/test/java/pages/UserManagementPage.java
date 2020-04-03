package pages;

import models.DetailsModel;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.RandomGenerator;

import java.util.concurrent.TimeUnit;

public class UserManagementPage extends PageObject {

    private DetailsModel detailsModel = new DetailsModel();
    String userStatus;
    @FindBy(xpath = "//span[text()='Users']")
    private WebElementFacade userLink;
    @FindBy(xpath = "//a[contains(text(),'New User')]")
    private WebElementFacade addUserButton;
    @FindBy(xpath = "//label[contains(text(),'First')]/..//input")
    private WebElementFacade userFirstName;
    @FindBy(xpath = "//label[contains(text(),'Last')]/..//input")
    private WebElementFacade userLastName;
    @FindBy(xpath = "//label[contains(text(),'Email')]/..//input")
    private WebElementFacade userEmailId;
    @FindBy(xpath = "//label[contains(text(),'Phone')]/..//input")
    private WebElementFacade userContactNo;
    @FindBy(xpath = "//select")
    private WebElementFacade userRoleDropdown;

    @FindBy(xpath = "//label[contains(text(),'First')]/..//p")
    private WebElementFacade userFirstNameDetail;
    @FindBy(xpath = "//label[contains(text(),'Last')]/..//p")
    private WebElementFacade userLastNameDetail;
    @FindBy(xpath = "//label[contains(text(),'Email')]/..//p")
    private WebElementFacade userEmailIdDetail;
    @FindBy(xpath = "//label[contains(text(),'Phone')]/..//p")
    private WebElementFacade userContactNoDetail;
    @FindBy(xpath = "//label[contains(text(),'Role')]/..//p")
    private WebElementFacade userRoleDetail;

    @FindBy(xpath = "(//select)[1]")
    private WebElementFacade roleDropdown;
    @FindBy(xpath = "(//select)[2]")
    private WebElementFacade statusDropdown;
    @FindBy(xpath = "//button[contains(text(),'Filter')]")
    private WebElementFacade filterButton;
    @FindBy(xpath = "//input[contains(@placeholder,'Filter')]")
    private WebElementFacade searchUser;
    @FindBy(xpath = "(//label[contains(text(),'Status')]/..//label)[2]")
    private WebElementFacade statusOnDetailScreen;
    @FindBy(xpath = "//span[contains(text(),'Activate')]")
    private WebElementFacade activateFromAction;
    @FindBy(xpath = "//span[contains(text(),'Deactivate')]")
    private WebElementFacade deactivateFromAction;


    public void tapOnAddUserButton() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(addUserButton).click();
    }

    public void addInputFiledsOfUserForm() {
        detailsModel.setName("Madhvan" + RandomGenerator.randomAlphabetic(3));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(userFirstName).sendKeys(detailsModel.getName());
        detailsModel.setSurname(RandomGenerator.randomAlphabetic(3));
        userLastName.sendKeys(detailsModel.getSurname());
        detailsModel.setContact(RandomGenerator.randomInteger(10));
        userContactNo.sendKeys(detailsModel.getContact());
        userEmailId.clear();
        detailsModel.setEmail("User" + RandomGenerator.randomInteger(2) + "@mailinator.com");
        userEmailId.sendKeys(detailsModel.getEmail());
    }

    public void selectRole(String roles) {
        userRoleDropdown.withTimeoutOf(10, TimeUnit.SECONDS).click();
        Select type = new Select(userRoleDropdown);
        detailsModel.setUserRole(roles);
        type.selectByVisibleText(detailsModel.getUserRole());
    }

    public void userDetailsVerify() {
        Assert.assertEquals(detailsModel.getName(), userFirstNameDetail.getText());
        Assert.assertEquals(detailsModel.getSurname(), userLastNameDetail.getText());
        Assert.assertEquals(detailsModel.getEmail(), userEmailIdDetail.getText());
        Assert.assertEquals(detailsModel.getContact(), userContactNoDetail.getText());
        Assert.assertEquals(detailsModel.getUserRole(), userRoleDetail.getText());
        waitFor(2000);
    }

    public void selectRoleDropdown() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(roleDropdown).click();
    }

    public void selectStatusDropdown() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(statusDropdown).click();
    }

    private By dropdownOptions(String opt) {
        return By.xpath("//option[text()='" + opt + "']");
    }

    private By status(String opt) {
        return By.xpath("//label[contains(text(),'" + opt + "')]");
    }

    public void selectFilterDropdown(String opt) {
        element(dropdownOptions(opt)).click();
    }

    public void enterKeyInSearchField(String searchKey) {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(searchUser);
        detailsModel.setKeyword(searchKey);
        searchUser.sendKeys(detailsModel.getKeyword());
       // withTimeoutOf(10, TimeUnit.SECONDS).waitFor(searchUser).sendKeys("Madhvan");
    }

    public void tapOnFilterButton() {
        waitFor(filterButton).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    private By userNameSearch(int count) {
        return By.xpath("((//tbody/tr)[" + count + "]/td)[1]");
    }

    public void verifyUserName() {
        waitABit(5000);
        // withTimeoutOf(20,TimeUnit.SECONDS).waitFor("//tbody/tr");
        int num = getDriver().findElements(By.xpath("//tbody/tr")).size();
        for (int i = 1; i <= num; i++) {
            String vName = element(userNameSearch(i)).getText();
            Assert.assertTrue(vName.contains(detailsModel.getKeyword()));
            //Assert.assertTrue(vName.contains("Madhvan"));

        }
    }

    private By roleInTable(int count) {
        return By.xpath("(//tbody//tr[" + count + "]/td)[4]");
    }


    public void verifyUserRole(String userRoles) {
        waitABit(2000);
        int num = getDriver().findElements(By.xpath("//tbody/tr")).size();
        for (int i = 1; i <= num; i++) {
            String vType = element(roleInTable(i)).getText();
            if (userRoles.equals("Administrator")) {
                Assert.assertEquals("Admin", vType);

            } else if (userRoles.equals("Personnel")) {
                Assert.assertEquals("Personnel", vType);
            }
        }

    }

    private By statusInTable(int count) {
        return By.xpath("(//tbody//tr[" + count + "]/td)[6]");
    }


    public void verifyStatus(String userStatus) {
        waitABit(2000);
        int num = getDriver().findElements(By.xpath("//tbody/tr")).size();
        for (int i = 1; i <= num; i++) {
            String vType = element(statusInTable(i)).getText();
            if (userStatus.equals("Active")) {
                Assert.assertEquals("Active", vType);

            } else if (userStatus.equals("Inactive")) {

                Assert.assertEquals("Inactive", vType);
            }
        }

    }

    private By statusIcon(String title) {
        return By.xpath("//em[@title='" + title + "']");
    }

    public void tapOnStatusIcon(String title) {
        element(statusIcon(title)).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void changeUserStatus() {
        userStatus = withTimeoutOf(10, TimeUnit.SECONDS).waitFor(statusOnDetailScreen).getText();
        if (userStatus.equals("Inactive")) {
            withTimeoutOf(10, TimeUnit.SECONDS).waitFor(activateFromAction).click();
        } else if (userStatus.equals("Active")) {
            withTimeoutOf(10, TimeUnit.SECONDS).waitFor(deactivateFromAction).click();
        }
        waitFor(2000);
    }

    public void verifyChangedStatus() {

        if (userStatus.equals("Inactive")) {
            WebElementFacade status = element(status("Active"));
            withTimeoutOf(20, TimeUnit.SECONDS).waitFor(status).shouldBeVisible();
        } else if (userStatus.equals("Active")) {
            WebElementFacade status = element(status("Inactive"));
            withTimeoutOf(20, TimeUnit.SECONDS).waitFor(status).shouldBeVisible();
        }
    }

}