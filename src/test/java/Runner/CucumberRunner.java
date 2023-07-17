package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features = {"src/test/resources/Feature/XYZ.feature"},
        glue = {"StepDefinition"},   monochrome = true,
        dryRun = false)

@Test
class CucumberRunner extends AbstractTestNGCucumberTests{
}
