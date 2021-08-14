package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendMailFromText {
	public static void main(String[] args) throws Exception{
		File file =new File("D:\\text.txt");
	
		BufferedReader read =new BufferedReader(new FileReader(file));
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\eclipse-workspace\\xml\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://mail.google.com/mail");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("kveera24@jnn.edu.in");
		driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf'][@name='password']")).sendKeys("8374797223v");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
		Thread.sleep(2000);
		WebElement t=driver.findElement(By.xpath("//textarea[@name='to']"));
		t.sendKeys("kveer");
		
		WebElement sub=driver.findElement(By.xpath("//input[@name='subjectbox']"));
		sub.sendKeys("Practice");
		WebElement text = driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']"));
		String line;
		while((line=read.readLine())!=null) {
			line=read.readLine();
			text.sendKeys(line);
		}
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//button[@name='ok']")).click();
		
		read.close();
	}
}
