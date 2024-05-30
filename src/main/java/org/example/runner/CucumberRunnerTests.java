package org.example.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.example.steps"},
        plugin = {}
)
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}
