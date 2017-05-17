import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/feature files/"}, glue = {"stepdefinitions"},
        format = {
        "json:target/cucumber.json" } )

//        tags = {"@imp, @NonFuntcional,~@wip"}, dryRun = true,strict = true,monochrome = true,snippets = SnippetType.CAMELCASE     )
//plugin = {"pretty", "html:target/cucumber", "json:target/ekta"},
public class RunCukesTest {
}