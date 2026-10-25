package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void verify_Login() 
	{
	logger.info("**** Starting TC002_LoginTest **** ");
		
		try {
		//homepage
		HomePage hp=new HomePage(driver);		
		hp.clickmyaccount();		
		hp.clicklogin();
		
		
		//login account
		Loginpage lp=new Loginpage(driver);		
		lp.setEmail(p.getProperty("email"));
		lp.setpsw(p.getProperty("password"));
		lp.clickLogin();
		
		//my account
		
		MyAccountPage ma=new MyAccountPage(driver);	
		boolean targetpage=ma.isMyAccountPageExists();
		//Assert.assertEquals(targetpage, true,"Login failed");
		
		Assert.assertTrue(targetpage);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		
	logger.info("**** Finising TC002_LoginTest **** ");
	}
}
