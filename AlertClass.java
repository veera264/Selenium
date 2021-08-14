 package selenium;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertClass	 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\eclipse-workspace\\practice\\Drivers\\chromedriver.exe");
		WebDriver object=new ChromeDriver();
		
		object.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		//ob.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); //implicit wait
		object.manage().window().maximize();
		
		object.findElement(By.id("alertBox")).click();
		Alert a1=object.switchTo().alert();
		a1.accept();
		Thread.sleep(2000);
		object.findElement(By.id("confirmBox")).click();
		Alert al1=object.switchTo().alert();
		al1.accept();
		Thread.sleep(2000);
		object.findElement(By.id("promptBox")).click();
		Alert al2=object.switchTo().alert();
		al2.sendKeys("VEERA"); 
		al2.accept();
	  
		
		}

		
	
}
