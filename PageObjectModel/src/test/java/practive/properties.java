package practive;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class properties {
		@Test
		public void test() throws Exception{
		Properties prob=new Properties();
		FileInputStream fi=new FileInputStream("Data.Properties");
		prob.load(fi);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prob.getProperty("url"));
		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prob.getProperty("email"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prob.getProperty("pass"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	/*	prob.setProperty("result","pass");
		FileOutputStream fo=new FileOutputStream("Data.Properties");
		prob.store(fo,null);*/
	}
}
