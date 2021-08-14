package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
		WebDriver driver;
		public MyAccountPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//ul[@class='breadcrumb']//*[text()='Account']")
		private WebElement check;
		
		public WebElement show() {
			return check;
		}

		
}
