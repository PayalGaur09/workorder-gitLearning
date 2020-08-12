package pages;

import cucumber.api.DataTable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.junit.experimental.categories.Categories;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.LoadProperties;
import utilities.RandomGenerator;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static utilities.LoadProperties.getValueFromPropertyFile;

public class CategoriesModulePage extends PageObject {
    public static String cateoryname;
    @FindBy(xpath = "//h3[text()=' Categories ']")
    private WebElementFacade categories;
    @FindBy(xpath = "//input[@name='name']")
    private WebElementFacade enterCategoriesName;
    @FindBy(xpath = "//button[text()='Add']")
    private WebElementFacade addButton;
    @FindBy(xpath = "//input[@value='Add All']")
    private WebElementFacade addAll;
    @FindBy(xpath = "//input[@value='Remove All']")
    private WebElementFacade removeAll;
    @FindBy(xpath = "//input[@value='Save Selected Categories']")
    private WebElementFacade saveSelectedCategories;
    @FindBy(xpath = "//a[@class='nav-link']")
    private WebElementFacade localCategories;
    @FindBy(xpath = "//input[@value='Add']")
    private WebElementFacade add;
    @FindBy(xpath = "//input[@value='Remove']")
    private WebElementFacade remove;

    private By getDeactivateCategory(String verifyDeactivateCategorystatus) {
        return By.xpath("//*[text()='" + verifyDeactivateCategorystatus + "']/ancestor::tr//em[@title= 'Deactivate']");
    }
    private By getActivateCategory(String verifyActivateCategorystatus) {
        return By.xpath("//*[text()='" + verifyActivateCategorystatus + "']/ancestor::tr//em[@title= 'Activate']");
    }
  private By crossVerifyTheCreateDetails(String verifydetails) {
        return By.xpath("//*[text()='" + verifydetails +"']");
    }
    private By deleteLocalCategories(String localcategories) {
        return By.xpath("//*[text()='" + localcategories + "']/ancestor::tr//em[@title='Delete']");
    }
    private By followLocalCategories(String followCategories) {
        return By.xpath("//*[text()='" + followCategories + "']/ancestor::tr//em[@title='Follow']");
    }
    private By unFollowLocalCategories(String unfollowCategories) {
        return By.xpath("//*[text()='" + unfollowCategories + "']/ancestor::tr//em[@title='Unfollow']");
    }



    public void userIsOnCategoriesPage() {
        categories.waitUntilVisible().isDisplayed();
    }
    public void userEntersTheCategoriesName(DataTable categoriesname) throws IOException, ConfigurationException {
        List<Map<String, String>> data = categoriesname.asMaps(String.class, String.class);
        cateoryname = data.get(0).get("name") + RandomGenerator.randomAlphanumeric(2);
        LoadProperties.saveValueInPropertiesFile("name", cateoryname, "testData");
        enterCategoriesName.sendKeys(cateoryname);


    }
    public void userClicksOnAddButton(){
        addButton.click();

    }
    public void userClicksOnDeactivateButton(){
        String categoryDeactivateStatus = getValueFromPropertyFile("testData", "name");
        element(getDeactivateCategory(categoryDeactivateStatus)).waitUntilVisible().click();

    }
    public void userClicksOnActivateButton(){
        String categoryActivateStatus = getValueFromPropertyFile("testData", "name");
        element(getActivateCategory(categoryActivateStatus)).waitUntilVisible().click();

    }
    public void userCreateTheExistingCategoryNameAgain(){
        String category = LoadProperties.getValueFromPropertyFile("testData", "name");
        waitFor(enterCategoriesName).waitUntilVisible().clear();
        waitFor(enterCategoriesName).waitUntilVisible().sendKeys(category);

    }
    public void userCrossVerifyTheCreateCategory(){
        element(crossVerifyTheCreateDetails(cateoryname)).waitUntilVisible();
        element(crossVerifyTheCreateDetails(cateoryname)).isDisplayed();
    }
    public void userClicksOnAddAllButton(){
        addAll.click();

    }
    public void userClicksOnRemoveAllButton(){
        removeAll.click();

    }
    public void userClicksOnSaveSelectedCategoriesButton(){
        saveSelectedCategories.click();

    }
    public void userClicksOnLocalCategoriesTab(){
        localCategories.click();

    }
    public void userDeleteTheLocalCategories(){
        String deletelocalcategories = getValueFromPropertyFile("testData", "name");
        element(deleteLocalCategories(deletelocalcategories)).waitUntilVisible().click();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        waitABit(1000);


    }
    public void userclicksOnFollowButton(){
        String followlocalcategories = getValueFromPropertyFile("testData", "name");
        element(followLocalCategories(followlocalcategories)).waitUntilVisible().click();
    }
    public void userClicksOnUnfollowButton(){
        String unfollowlocalcategories = getValueFromPropertyFile("testData", "name");
        element(unFollowLocalCategories(unfollowlocalcategories)).waitUntilVisible().click();
    }
    public void userSelectTheCategoriesFromAvailableCategoriesBox(){
        List<WebElement> elements = getDriver().findElements(By.xpath("(//ul[@class='custom-list-box-body'])[1]/li"));
        elements.get(0).click();
        elements.get(1).click();
        elements.get(2).click();


    }
    public void clicksOnAddButton(){
        add.click();
     }
     public void userSelectTheCategoriesFromSelectedCategoriesBox(){
         List<WebElement> elements = getDriver().findElements(By.xpath("(//ul[@class='custom-list-box-body'])[2]/li"));
         elements.get(0).click();
         elements.get(1).click();
         elements.get(2).click();


     }
     public void userClicksOnRemoveButton(){
        remove.click();

     }

    }








