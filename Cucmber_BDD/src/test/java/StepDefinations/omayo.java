package StepDefinations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class omayo {
	
	WebDriver driver;
	
	@Before("@Smoke11")
	public void setup() {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
	}
	
	
	 @Given("^i ender into application$")
	    public void i_ender_into_application() {
		  driver.get("http://omayo.blogspot.com/");
	        
	    }

	    @When("^i scrool down and find \"([^\"]*)\" and \"([^\"]*)\" into fields$")
	    public void i_scrool_down_and_find_and_into_fields(String username, String password){
	      
	    	driver.findElement(By.name("userid")).sendKeys(username);
	    	driver.findElement(By.name("pswrd")).sendKeys(password);
	    
	    }

	    @And("^i click on login button$")
	    public void i_click_on_login_button(){
	    	
	    	driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
	    }
	    @Then("^i login to the \"([^\"]*)\" selenium143 page$")
	    public void i_login_to_the_selenium143_page(String condition) {
	    	String conf = null;
	    	try {
	    	Alert alert=driver.switchTo().alert();
	    	
	    	
	    	if(alert.getText().contains("Error Password or Username")) {
	    		conf="Fail";
	    	}
	 
	    	}
	    	catch(Exception e) {
	    		conf="pass";
	    	}
	       	Assert.assertEquals(condition,conf); 
	       	
	       	
	    }
	    @After("@Smoke11")
	    public void stop() {
	    	driver.quit();
	    }

}

