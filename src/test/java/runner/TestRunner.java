package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(features={"src/test/java/features"},
                glue ="stepDefinition",
                tags="@11119",
                plugin={"html:target/cucumber-html-report"}
                //,
            //    "json:target/cucumber.json",
            //   "pretty:target/cucumber-pretty.txt",
           //     "usage:target/cucumder-usage.json",
           //     "junit:target/cucumber-results.xml"}
         )

public class TestRunner {
}
