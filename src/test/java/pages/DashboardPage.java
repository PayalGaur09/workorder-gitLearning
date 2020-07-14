package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

public class DashboardPage extends PageObject {

    String number;
    String number2;


    @FindBy(xpath = "//h3[contains(text(),'Work Orders')]")
    private WebElementFacade workOrderheading;
    @FindBy(xpath = "//div[@class='dataTables_info']")
    private WebElementFacade dataTableOnList;
    @FindBy(xpath = "//a[text()='View All']")
    private WebElementFacade viewAllButton;
    @FindBy(xpath = "//a[text()='View Record']")
    private WebElementFacade viewRecordButton;
    @FindBy(xpath = "//h3[contains(text(),'Status')]/../../..//*[name()='g']")
    private WebElementFacade pieChart;
    @FindBy(xpath = "//h3[contains(text(),'Log')]/../../..//*[name()='g']")
    private WebElementFacade offlineLogGraph;
    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElementFacade dashboardSideMenu;


    private By pageTitle(String heading) {
        return By.xpath("//h3[contains(text(),'" + heading + "')]");
    }

    private By menuItems(String module) {
        return By.xpath("//span[text()='" + module + "']");
    }

    private By workOrderSubtitle(String tile) {
        return By.xpath("//a[contains(text(),'" + tile + "')]");
    }

    private By companySubtitle(String tile) {
        return By.xpath("//div[@class='kt-widget17']//span[contains(text(),'" + tile + "')]");
    }

    private By woCount(String tile) {
        return By.xpath("//a[contains(text(),'" + tile + "')]/../..//span");
    }

    private By moduleCount(String tile){return By.xpath("//span[contains(text(),'" + tile + "')]");}

    public void verifyHeading(String heading) {
        WebElementFacade a = element(pageTitle(heading));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(a).shouldBeVisible();
    }

    public void tapOnMenuItems(String module) {
        waitABit(2000);
        withTimeoutOf(30,TimeUnit.SECONDS).waitFor(dashboardSideMenu).waitUntilVisible();
//        element(menuItems(module)).withTimeoutOf(20, TimeUnit.SECONDS).click();
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(false);", find(menuItems(module)));
        Actions act = new Actions(getDriver());
        act.moveToElement(find(menuItems(module))).click().build().perform();
        waitABit(1000);

    }

    public void verifyWorkOrderTiles(String tile) {
        WebElementFacade woTile = element(workOrderSubtitle(tile));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(woTile).shouldBeVisible();
    }

    public void verifyCompanyTiles(String tile) {
        WebElementFacade companyTile = element(companySubtitle(tile));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(companyTile).shouldBeVisible();
    }

    public void verifyComponentOfHealthStatus() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(viewAllButton).shouldBeVisible();
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(pieChart).shouldBeVisible();
    }

    public void verifyComponentOfOfflineLog() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(viewRecordButton).shouldBePresent();
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(offlineLogGraph).shouldBePresent();
    }

    public void tapOnWOSubtitle(String tile) {
        WebElementFacade a = element(workOrderSubtitle(tile));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(a).click();
    }

    public void tapOnCompanySubtitle(String tile) {
        WebElementFacade d = element(companySubtitle(tile));
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(d).click();
    }

    public void countWorkOrdersOnDashboard(String count) {
        WebElementFacade c = element(woCount(count));
        number = withTimeoutOf(10, TimeUnit.SECONDS).waitFor(c).getText();
    }

    public void verifyItemCountInList() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(dataTableOnList).shouldBeVisible();
        Assert.assertTrue(dataTableOnList.getText().contains(number));
    }

    public void observeModuleCountOnDashboard(String tile){
        String value = element(moduleCount(tile)).getText();
        number2=value.replaceAll("[^0-9]","");
    }

    public void verifyItemCountOfModule(){
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(dataTableOnList).shouldBeVisible();
        Assert.assertTrue(dataTableOnList.getText().contains(number2));
    }
}
