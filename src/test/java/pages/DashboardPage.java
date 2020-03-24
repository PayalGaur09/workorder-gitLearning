package pages;

import models.DetailsModel;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class DashboardPage extends PageObject {


    private By menuItems(String module) {
        return By.xpath("//span[text()='" + module + "']");
    }

    public void tapOnMenuItems(String module){
        element(menuItems(module)).withTimeoutOf(10,TimeUnit.SECONDS).click();
    }
}
