package runner_class;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin= {"html:target/register.html","pretty"},
		features="src/test/java/feacture_file",
		glue="StepDefinations",
		tags="@Reg"
		)
public class Register_runner extends AbstractTestNGCucumberTests{
	
	
}
