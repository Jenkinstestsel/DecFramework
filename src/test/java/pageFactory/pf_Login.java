package pageFactory;

import genericLibrary.keywords;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_Login {
	
	@FindBy(name="logid")
	public WebElement txt_userid;
	
	@FindBy(name="pswd")
	public WebElement txt_pwd;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	public WebElement btn_login;
	
	@FindBy(xpath="//b[contains(text(), 'Sorry')]")
	public WebElement msg_loginErr;
	
	
	public pf_Login(WebDriver driver){		
		PageFactory.initElements(driver, this);		
	}
	
	
//	reusable business logics
	
	public void enterUserCredentials(Map<String,String> hm){		
//		txt_userid.sendKeys(hm.get("uname"));
//		txt_pwd.sendKeys(hm.get("pwd"));
//		btn_login.click();
//		##############################
		
		keywords.sendKeys(txt_userid, hm.get("uname"));
		keywords.sendKeys(txt_pwd, hm.get("pwd"));
		keywords.click(btn_login);
		
	}
	
	
	
	}







