package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autoit {
	WebDriver driver;
	@Test
	public void show() throws Exception {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
		WebElement w=driver.findElement(By.xpath("//input[@id='uploadfile']"));
		Actions action=new Actions(driver);
		action.moveToElement(w).click().build().perform();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\Lenovo\\eclipse-workspace\\Pom\\auto\\a.exe");
		Thread.sleep(15000);
		
		}
	
}
