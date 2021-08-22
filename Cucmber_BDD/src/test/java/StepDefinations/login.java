package StepDefinations;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
	WebDriver driver;
	@Before("@Ninja123")
	public void open() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}
	
	@Given("^i navigate to login page of application$")
	public void url_of_Website() {
		
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		}
	
	@When("^i enter email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void enter_email_Password(String e,String p ) {
		driver.findElement(By.cssSelector("input[id='input-email']")).sendKeys(e);
		driver.findElement(By.id("input-password")).sendKeys(p);
		
	}
	
	@And("^i click on login button2$")
	public void login_button() {
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	}
	
	@Then("^i login to the application$")
	public void check_login() {
		WebElement check=null;
		try {
		check=driver.findElement(By.xpath("//*[@class='breadcrumb']//*[text()='Account']abc"));
		}
		catch(Exception e) {
			System.out.println("login has failed");
		}
	//	Assert.assertNotNull(check);
		Assert.assertNotNull(check,"Log in fail");
	//	Assert.fail();
	}
	@After("@Ninja123")
	public void close() {
		driver.close();
	}
	
}
