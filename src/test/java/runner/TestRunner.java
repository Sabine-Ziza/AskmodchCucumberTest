package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;


@CucumberOptions(
            features = "src/test/resources/guest_place_an_order.feature",
            //glue = {"stepDefinitions", "hooks"},
            plugin = {
                    "pretty",
                    "json:target/cucumber.json",
                    "html:target/cucumber-html-report",

            },
            snippets = CAMELCASE,
            dryRun = false


    )
    public class TestRunner extends  AbstractTestNGCucumberTests {
    }


