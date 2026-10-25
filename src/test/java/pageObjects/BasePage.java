package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {//parent of all page object class bcz it extended of all page object class
	
	WebDriver driver;
	
	public BasePage(WebDriver driver)//why it became parent class bcz the constructor is same of every page object class
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
	}

}
