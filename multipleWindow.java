package MvnPack;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class multipleWindow {
	public static void main(String[] args) throws Exception {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		 String main = driver.getWindowHandle();
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("document.getElementById('newWindowBtn').click();");
		 js.executeScript("document.getElementById('newTabBtn').click();");
		 
		 Set<String> ids = driver.getWindowHandles();
		 Iterator<String> window1 = ids.iterator();
		 
		 while(window1.hasNext()) {
			 String hold = window1.next();
			 driver.switchTo().window(hold);
			 if((driver.getTitle()).equals("Basic Controls - H Y R Tutorials")) {
				 driver.findElement(By.id("firstName")).sendKeys("veera");
			 }
			
		 }
		 Set<String> ids1 = driver.getWindowHandles();
		 Iterator<String> window2 = ids1.iterator();
		 while(window2.hasNext()) {
			 String hold = window2.next();
			 driver.switchTo().window(hold);
			 if((driver.getTitle()).equals("AlertsDemo - H Y R Tutorials")) {
				 
				js.executeScript("document.getElementById('promptBox').click();");
				 Thread.sleep(2000);
				 Alert a=driver.switchTo().alert();
				 a.sendKeys("veera");
				 a.accept();
			 }
			
		 }
		 Thread.sleep(3000);
		 driver.switchTo().window(main);
		 driver.findElement(By.xpath("//input[@class='whTextBox']")).sendKeys("this is main window");
		 
		
	}
}
