package Scripts;

import java.util.Map;

import genericLibrary.Commonlib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Scenario_Login_base extends Commonlib {
	
//	valid login
	@Test(dataProvider="dp_validLogin",dataProviderClass = dataProvider.Dp.class)
	public void validLogin(Map<String,String> hm){
		
	
		ff.findElement(By.linkText("Sign In")).click();
		
		ff.findElement(By.name("logid")).sendKeys(hm.get("uname"));
		ff.findElement(By.name("pswd")).sendKeys(hm.get("pwd"));
		ff.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
		
		String output = ff.findElement(By.id("username")).getText();
		
		if(output.equals(hm.get("exp_msg"))){			
			System.out.println("pass");			
		}else{
			System.out.println("fail");
		}
		
		
	}
	
	
//	invalid login
	@Test(dataProvider="dp_invalidLogin",dataProviderClass = dataProvider.Dp.class)
	public void invalidLogin(Map<String ,String> hm){	
		
		
		ff.findElement(By.linkText("Sign In")).click();
		
		ff.findElement(By.name("logid")).sendKeys(hm.get("uname"));
		ff.findElement(By.name("pswd")).sendKeys(hm.get("pwd"));
		ff.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
		
		String output = ff.findElement(By.xpath("//b[contains(text(), 'Sorry')]")).getText();
		
		if(output.equals(hm.get("exp_msg"))){			
			System.out.println("pass");			
		}else{
			System.out.println("fail");
		}
	
		
	}
	
	
	
	
	

}
