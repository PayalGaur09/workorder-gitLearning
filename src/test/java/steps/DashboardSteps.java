package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.DashboardPage;

public class DashboardSteps {

    DashboardPage dashboard;

    @And("^User tap on the \"([^\"]*)\" link from side navigation$")
    public void userTapOnTheLinkFromSideNavigation(String arg0)  {
        dashboard.tapOnMenuItems(arg0);
    }


}
