package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Software {
	
	@Given("^i am a \"([a-zA-Z]{1,})\" software tester$")
	public void i_am_a_good_software_tester(String test) {
		System.out.println(">>--"+test);
		
	}
	@When("^i go to work$")
	public void i_go_to_work() {
		System.out.println(">>-- i go to work");
	}
	
	@And("^i \"([a-zA-Z]{1,})\" with it$")
	public void i_mess_with_it(String test1) {
		System.out.println(">>--"+test1);
	}
	
	@Then("^my boss \"(.*)\" me$")
	public void my_boss_loves_me(String test2) {
		System.out.println(test2);
	}
	
}
