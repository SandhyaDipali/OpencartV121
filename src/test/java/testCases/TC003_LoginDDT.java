package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilites.DataProviders;

/*Data is valid -login success -test pass -logout
 * data is valid -- login failed-test fail
 * 
 * data is invalid-login success -test fail-logout
 * data is invalid -login failed-test pass
 */

	public class TC003_LoginDDT extends BaseClass{
		@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven")	//if dataprovider are presents inside another pakage and class then dataprovider class required		
	 public void verify_loginDDT(String email,String pwd,String exp) throws InterruptedException
	 {		 
			logger.info("**** Starting TC003_LoginDDT **** ");
			
			try {
			
			//homepage
			HomePage hp=new HomePage(driver);			
			hp.clickmyaccount();		
			hp.clicklogin();
			
			//loginpage
			Loginpage lp=new Loginpage(driver);			
			lp.setEmail(email);
			lp.setpsw(pwd);
			lp.clickLogin();
			
			//my account	
			MyAccountPage ma=new MyAccountPage(driver);			
			boolean targetpage=ma.isMyAccountPageExists();
			
/*Data is valid -login success -test pass -logout
 *  * data is valid -- login failed-test fail
 */
		if(exp.equalsIgnoreCase("valid")) 
		{
		   if(targetpage==true) 
			{
			  ma.clickLogout();
			  Assert.assertTrue(true);//assertion always should be after the action beacuse after assertion no statement will execute				
			}
		   else
		   {
			Assert.assertFalse(false);
		   }
		}
/*data is invalid-login success -test fail-logout
 * data is invalid -login failed-test pass
 * */
		
		else
		{		
			if(targetpage==true)
			{
				ma.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}			
		}		
			}
			catch(Exception e) {
				Assert.fail();
			}
		Thread.sleep(3000);
		logger.info("**** finishing TC003_LoginDDT **** ");
	}
		
	
	

}
