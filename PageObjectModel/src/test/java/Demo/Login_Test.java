package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepositry.LoginPage;
import objectRepositry.MyAccountPage;

public class Login_Test {
	
	WebDriver driver;
	@Test
	public void login() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		
		LoginPage log=new LoginPage(driver);
		log.emailField().sendKeys("veera2@gmail.com");
		log.passwordfield().sendKeys("8374797223");
		log.loginbutton().click();
		
		MyAccountPage c=new MyAccountPage(driver);
		Assert.assertTrue(c.show().isDisplayed());
	}
		@AfterMethod
		public void closer() {
			driver.close();
		}
		
}
