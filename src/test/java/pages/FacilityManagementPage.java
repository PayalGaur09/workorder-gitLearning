package pages;

import models.DetailsModel;
import models.FacilityModel;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.RandomGenerator;

import java.util.concurrent.TimeUnit;

public class FacilityManagementPage extends PageObject {

    private FacilityModel facilityModel = new FacilityModel();

    @FindBy(xpath = "//a[contains(text(),'New Facility')]")
    private WebElementFacade addFacilityButton;
    @FindBy(xpath = "//select[@name='complaintsAssigneeId']")
    private WebElementFacade assigneeForComplaint;

    private By facilityField(String text) {
        return By.xpath("//label[contains(text(),'" + text + "')]/..//input");
    }

    private By facilityDropdown(String text) {
        return By.xpath("//label[contains(text(),'" + text + "')]/..//select");
    }

    private By facilityDetail(String detail) {
        return By.xpath("//em[contains(@title,'" + detail + "')]/..");
    }

    public void clickAddFacility() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(addFacilityButton).click();
    }

    public void enterAllFields() {
        element(facilityField("Facility")).clear();
        waitABit(1000);
        facilityModel.setFacilityName(RandomGenerator.randomAlphabetic(5) + "Pvt Ltd");
        element(facilityField("Facility")).sendKeys(facilityModel.getFacilityName());
        element(facilityField("Address")).clear();
        waitABit(1000);
        facilityModel.setFacilityAddress("Sector 11 Noida");
        element(facilityField("Address")).sendKeys(facilityModel.getFacilityAddress());
        element(facilityField("Zip")).clear();
        waitABit(1000);
        facilityModel.setZipCode("123456");
        element(facilityField("Zip")).sendKeys(facilityModel.getZipCode());
        element(facilityField("Manager Name")).clear();
        waitABit(1000);
        facilityModel.setPmName("Aditya " + RandomGenerator.randomAlphabetic(4));
        element(facilityField("Manager Name")).sendKeys(facilityModel.getPmName());
        element(facilityField("Email")).clear();
        waitABit(1000);
        facilityModel.setPmEmail("pm" + RandomGenerator.randomInteger(4) + "@mailinator.com");
        element(facilityField("Email")).sendKeys(facilityModel.getPmEmail());
        element(facilityField("Phone")).clear();
        waitABit(1000);
        facilityModel.setPmPhone("9879879879");
        element(facilityField("Phone")).sendKeys(facilityModel.getPmPhone());
        element(facilityField("Type")).clear();
        waitABit(1000);
        facilityModel.setTypeOfConstruction("IT");
        element(facilityField("Type")).sendKeys(facilityModel.getTypeOfConstruction());
 //       Select dropdown = new Select(assigneeForComplaint);
  //      dropdown.selectByValue("2ddc4dca-762c-462b-bf28-d1300e2c7c1d");
      //  element(facilityDropdown("complaints")).selectByIndex(2);
     //   element(facilityDropdown("Move")).selectByIndex(1);
    }

    public void selectDropdown(){
        waitABit(1000);
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(assigneeForComplaint);
       // assigneeForComplaint.withTimeoutOf(10, TimeUnit.SECONDS).click();
        Select complaint = new Select(assigneeForComplaint);
        complaint.selectByIndex(1);
        waitABit(3000);
    }

    public void verifyDetails(){
        WebElementFacade a = element(facilityDetail("Name"));
        Assert.assertEquals(facilityModel.getFacilityName(),
                withTimeoutOf(20,TimeUnit.SECONDS).waitFor(a).getText());
        Assert.assertEquals( facilityModel.getFacilityAddress() + ", " + facilityModel.getZipCode(),element(facilityDetail("Address")).getText());
        Assert.assertEquals(facilityModel.getPmName(),element(facilityDetail("Manager Name")).getText());
        Assert.assertEquals(facilityModel.getPmEmail(),element(facilityDetail("Email")).getText());
        Assert.assertEquals(facilityModel.getPmPhone(),element(facilityDetail("Number")).getText());
        Assert.assertEquals(facilityModel.getTypeOfConstruction(),element(facilityDetail("Type")).getText());

    }
}
