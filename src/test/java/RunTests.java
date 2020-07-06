import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/feature/web/", tags="@Phase5")
//@CucumberOptions(features="src/test/resources/feature/web/unitManagement.feature")
public class RunTests {

}
