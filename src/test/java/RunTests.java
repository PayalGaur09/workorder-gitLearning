import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/feature/web/", tags="@DemoTest")
//@CucumberOptions(features = "src/test/resources/feature/web/facility.feature")
public class RunTests {
}
