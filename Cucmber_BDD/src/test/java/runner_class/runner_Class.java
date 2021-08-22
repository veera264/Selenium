package runner_class;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)									//insted of Ancii Escape control we use Monochrome=true in
																		//cucumberoptions
@CucumberOptions( 
					plugin= {"html:target/cucumber_html_report.html","pretty"},
				  	features="src/test/java/feacture_file",
				  	glue="StepDefinations",
				  	tags="@Ninja123"
				  	)
public class runner_Class {
		
}
