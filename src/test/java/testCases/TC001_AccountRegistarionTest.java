package testCases;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistarionTest extends BaseClass {
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_resgistration() 
	{
		logger.info("**** Starting TC001_AccountRegistarionTest **** ");
		
		try {
			
		HomePage hp=new HomePage(driver);
		hp.clickmyaccount();	
		logger.info("Clicked on my account link..");
		
		hp.clickmyregister();	
		logger.info("Clicked on register link..");

		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("providing customer details..");

		regpage.firstName(randomeString());
		regpage.lastName(randomeString());
		regpage.setEmail(randomeString()+"@gamil.com");//randomly generated the email	
		regpage.setTelephone(RandomNumber());
		
	String password=randomAlphaNumber();
		
		regpage.setPassword(password);	
		regpage.setConfirmPassword(password);
		
		regpage.checkPolicyMsg();
		regpage.checkContinuebtn();
		
		logger.info("Validating expected message..");
	
	String confmsg=regpage.getconfirmmsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		}
		
		catch(Exception e) {
			logger.error("your execution having error...");
			logger.debug("your execution debugging the process...");
			Assert.fail();
			
		}
		
		logger.info("**** Finising TC001_AccountRegistarionTest **** ");
	}
	
	
	


}
