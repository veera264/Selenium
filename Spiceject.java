package MvnPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Spiceject {
	@Test(priority=1)
	public void move() throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@id='citydropdown']/tbody/tr[2]//td[2]/div[3]/div[1]/div/ul[3]/li[5]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//table[@id='citydropdown']/tbody/tr[2]//td[2]/div[3]/div[1]/div/ul[2]/li[5])[2]")).click();
		Thread.sleep(3000);
		
		while(!driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]")).getText().toString().contains("October")) {
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		driver.findElement(By.xpath("(//table[@class='ui-datepicker-calendar']/tbody/tr[4]/td[4])[1]")).click();
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Thread.sleep(2000);
		Select select=new Select(driver.findElement(By.xpath("//select[@name='ctl00$mainContent$ddl_Adult']")));
		select.selectByVisibleText("4");
		Select s=new Select(driver.findElement(By.xpath("//select[@name='ctl00$mainContent$DropDownListCurrency']")));
		s.selectByVisibleText("USD");
		
		
	}
	
	
}
