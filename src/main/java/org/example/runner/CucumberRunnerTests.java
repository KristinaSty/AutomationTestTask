package org.example.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"{path-to-the-project}/src/main/resources/features"},
        glue = {"org.example.steps"},
        plugin = {}
)
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}
