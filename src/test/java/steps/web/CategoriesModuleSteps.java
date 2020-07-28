package steps.web;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.configuration.ConfigurationException;
import pages.CategoriesModulePage;

import java.io.IOException;
import java.util.List;


public class CategoriesModuleSteps extends PageObject {
    CategoriesModulePage categoriesmodule;

    @Given("^user is on the Categories page of workorder application$")
    public void userIsOnTheCategoriesPageOfWorkorderApplication() {
        categoriesmodule.userIsOnCategoriesPage();

    }

    @When("^User enters the categories name in add categories field$")
    public void userEntersTheCategoriesNameInAddCategoriesField(DataTable categoriesname) throws IOException, ConfigurationException {
        categoriesmodule.userEntersTheCategoriesName(categoriesname);
    }

    @And("^user clicks on the add button$")
    public void userClicksOnTheAddButton() {
        categoriesmodule.userClicksOnAddButton();

    }

    @When("^user clicks on the deactivate button for category$")
    public void userClicksOnTheDeactivateButtonForCategory() {
        categoriesmodule.userClicksOnDeactivateButton();
    }

    @And("^user clicks on the activate button for category$")
    public void userClicksOnTheActivateButtonForCategory() {
        categoriesmodule.userClicksOnActivateButton();
    }

    @When("^user create the existing groupname again$")
    public void userCreateTheExistingGroupnameAgain() {
        categoriesmodule.userCreateTheExistingCategoryNameAgain();
    }

    @And("^Cross verify the create details$")
    public void crossVerifyTheCreateDetails() {
        categoriesmodule.userCrossVerifyTheCreateCategory();
    }

    @And("^user clicks on Add All button$")
    public void userClicksOnAddAllButton() {
        categoriesmodule.userClicksOnAddAllButton();
    }

    @And("^user clicks on Remove All button$")
    public void userClicksOnRemoveAllButton() {
        categoriesmodule.userClicksOnRemoveAllButton();
    }

    @And("^user clicks on save selected categories button$")
    public void userClicksOnSaveSelectedCategoriesButton() {
        categoriesmodule.userClicksOnSaveSelectedCategoriesButton();
    }

    @And("^user clicks on local categories tab$")
    public void userClicksOnLocalCategoriesTab() {
        categoriesmodule.userClicksOnLocalCategoriesTab();
    }

    @And("^user clicks on delete button$")
    public void userClicksOnDeleteButton() {
        categoriesmodule.userDeleteTheLocalCategories();
    }

    @And("^user clicks on the follow categories icon$")
    public void userClicksOnTheFollowCategoriesIcon() {
        categoriesmodule.userclicksOnFollowButton();
    }

    @And("^user clicks on the unfollow button$")
    public void userClicksOnTheUnfollowButton() {
        categoriesmodule.userClicksOnUnfollowButton();
    }

    @And("^user select the one or more than one categories from available Categories box$")
    public void userSelectTheOneOrMoreThanOneCategoriesFromAvailableCategoriesBox() {
        categoriesmodule.userSelectTheCategoriesFromAvailableCategoriesBox();
    }


    @And("^clicks on the add button$")
    public void clicksOnTheAddButton() {
        categoriesmodule.clicksOnAddButton();
    }

    @And("^user select the categories from selected categories box$")
    public void userSelectTheCategoriesFromSelectedCategoriesBox() {
        categoriesmodule.userSelectTheCategoriesFromSelectedCategoriesBox();
    }

    @And("^user clicks on the remove button$")
    public void userClicksOnTheRemoveButton() {
        categoriesmodule.userClicksOnRemoveButton();
    }
}
