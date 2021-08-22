package runner_class;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				plugin= {"html:target/cucumber_Testng.html","pretty"},
				features="src/test/java/feacture_file",
				glue="StepDefinations",
				tags="@Ninja123"
		)
public class TestRunner extends AbstractTestNGCucumberTests{
		
}
