package StepDefinations;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Register {
		
	WebDriver driver;
	@Before("@Reg")
	public void open1() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}
	@Given("^i navigate to register page$")
	public void Url() {
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
	}
	
	@When("^i enter below details$")
	
	public void details(DataTable data) {
		 Map<String,String> data1 = data.asMap(String.class, String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(data1.get("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(data1.get("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(data1.get("email"));
		driver.findElement(By.id("input-telephone")).sendKeys(data1.get("Telephone"));
		driver.findElement(By.id("input-password")).sendKeys(data1.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(data1.get("password"));
		
	}
	@And("^i select check box$")
	public void box() {
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
	}
	@And("^i click continue$")
	public void submit() {
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	}
}
