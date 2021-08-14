package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\eclipse-workspace\\practice\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		// main URL
		driver.get("https://www.k8oms.net/links/embed-url-iframe");
		
		//First Nested frame
		driver.switchTo().frame("1ab4fb516639a32a_1706").switchTo().frame("innerFrame");
		WebElement d=driver.findElement(By.xpath("//*[text()='Schlagerplanetradio 100% Andrea Berg']"));
		System.out.println(d.getText());
		WebElement d1=driver.findElement(By.xpath("//*[text()='Andrea Berg und Friends. Nonstop.']"));
		System.out.println(d1.getText());
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
		//Second  nested frame
		driver.switchTo().frame("7469db4c5e0f4f76_8").switchTo().frame("innerFrame").switchTo().frame("userHtmlFrame").switchTo().frame(0);
		WebElement d2=driver.findElement(By.xpath("//*[text()='Michigan Radio']"));
		System.out.println(d2.getText());
		WebElement d3=driver.findElement(By.xpath("//*[text()='News For Michigan']"));
		System.out.println(d3.getText());
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
		//Third nested frame
		driver.switchTo().frame("1ab4fb516639a32a_1714").switchTo().frame(0);
		WebElement d4=driver.findElement(By.xpath("//*[text()='Calm Radio - Classical Guitar']"));
		System.out.println(d4.getText());
		WebElement d5=driver.findElement(By.xpath("//*[text()='Canada']"));
		System.out.println(d5.getText());
		
		
		 
		
		
		
		
		
	
		
		
		
	}
}
