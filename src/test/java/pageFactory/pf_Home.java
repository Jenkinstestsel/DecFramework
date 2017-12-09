package pageFactory;

import java.util.Map;

import genericLibrary.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_Home {
	
	@FindBy(linkText="Sign In")
	public WebElement lk_signIn;

	@FindBy(id="username")
	public WebElement lbl_welcomeUser;
	
	@FindBy(id="srchword")
	public WebElement txt_search;
	
	@FindBy(className="newsrchbtn")
	public WebElement btn_search;
	
	@FindBy(id="find")
	public WebElement lbl_searchCount;
	
	@FindBy(className="sorrymsg")
	public WebElement lbl_errmsg;
	
	
	public pf_Home(WebDriver driver){		
		PageFactory.initElements(driver, this);		
	}
	
	
	public void searchBook(Map<String, String> hm){
		
		keywords.sendKeys(txt_search, hm.get("search"));	
		keywords.click(btn_search);
		
	}
	

}









