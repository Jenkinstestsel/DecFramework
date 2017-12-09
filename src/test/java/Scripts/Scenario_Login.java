package Scripts;

import java.util.Map;

import genericLibrary.Commonlib;
import genericLibrary.keywords;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageFactory.pf_Home;
import pageFactory.pf_Login;

public class Scenario_Login extends Commonlib {

	Logger loginlog = Logger.getLogger(Scenario_Login.class);
	
//	valid login
	@Test(dataProvider="dp",dataProviderClass = dataProvider.Dp.class,groups={"qa","dev"})
	public void Login_validLogin(Map<String,String> hm) throws Exception{
		System.out.println("hello");
		TCID =hm.get("TC_ID");
		Orderid =hm.get("Order");
		startTest = eReports.startTest(TCID + "_" + Orderid);
		startTest.assignCategory(cur_Browser);
		loginlog.info("Started execution of " + TCID + "_" + Orderid);
		pf_Home home = new pf_Home(ff);
		pf_Login login = new pf_Login(ff);
	
		if(ff.getTitle().contains("books")){
			loginlog.info("Currently in Home Page");
			startTest.log(LogStatus.PASS, "Home page Validation","Successfully validated Home Page");
		}else{
			loginlog.error("Didnot reach Home Page");
			startTest.log(LogStatus.FAIL, "Home page Validation","Failed validated Home Page as Expected was Rediff  and actual is " + ff.getTitle() );
		}
		
		System.out.println("hello");
//		ff.findElement(By.linkText("Sign In")).click();
//		home.lk_signIn.click();
		keywords.click(home.lk_signIn);
		
		
//		ff.findElement(By.name("logid")).sendKeys(hm.get("uname"));
//		ff.findElement(By.name("pswd")).sendKeys(hm.get("pwd"));
//		ff.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
//		login.txt_userid.sendKeys(hm.get("uname"));
//		login.txt_pwd.sendKeys(hm.get("pwd"));
//		login.btn_login.click();;	
		login.enterUserCredentials(hm);
		
		
//		String output = home.lbl_welcomeUser.getText();
		String output = keywords.getText(home.lbl_welcomeUser);
		
		if(output.equals(hm.get("exp_msg"))){			
			startTest.log(LogStatus.PASS, "Valid user Welcome","Successfuly validated the valid login" + startTest.addScreenCapture(getScreenshot()));		
		}else{
			startTest.log(LogStatus.FAIL, "Valid user Welcome","Failed as Valid login not working" + startTest.addScreenCapture(getScreenshot()));	
		}
		
		
	}
	
	
//	invalid login
	@Test(dataProvider="dp",dataProviderClass = dataProvider.Dp.class,groups={"dev","prod"})
	public void Login_invalidLogin(Map<String ,String> hm) throws Exception{	
		TCID =hm.get("TC_ID");
		Orderid =hm.get("Order");
		startTest = eReports.startTest(TCID + "_" + Orderid);
		startTest.assignCategory(cur_Browser);
		loginlog.info("Started execution of " + TCID + "_" + Orderid);
		pf_Home home = new pf_Home(ff);
		pf_Login login = new pf_Login(ff);
		if(ff.getTitle().contains("books")){
			loginlog.info("Currently in Home Page");
			startTest.log(LogStatus.PASS, "Home page Validation","Successfully validated Home Page");
		}else{
			loginlog.error("Didnot reach Home Page");
			startTest.log(LogStatus.FAIL, "Home page Validation","Failed validated Home Page as Expected was Rediff  and actual is " + ff.getTitle() );
		}
//		ff.findElement(By.linkText("Sign In")).click();
		home.lk_signIn.click();
		
//		ff.findElement(By.name("logid")).sendKeys(hm.get("uname"));
//		ff.findElement(By.name("pswd")).sendKeys(hm.get("pwd"));
//		ff.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
//		############################################
//		login.txt_userid.sendKeys(hm.get("uname"));
//		login.txt_pwd.sendKeys(hm.get("pwd"));
//		login.btn_login.click();;	
		login.enterUserCredentials(hm);
		
//		String output = login.msg_loginErr.getText();
		String output = keywords.getText(login.msg_loginErr);
		
		if(output.equals(hm.get("exp_msg"))){			
			startTest.log(LogStatus.PASS, "Invalid user login error message","Successfuly validated the Error message" +startTest.addScreenCapture(getScreenshot()));		
		}else{
			startTest.log(LogStatus.FAIL, "Invalid user login error message","Failed as Error message not matching" +startTest.addScreenCapture(getScreenshot()));	
		}
	
		
	}
	
	
	
	
	

}
