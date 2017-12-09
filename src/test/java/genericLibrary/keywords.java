package genericLibrary;

import org.openqa.selenium.WebElement;

public class keywords {
	
	public static void sendKeys(WebElement ele, String val){
		ele.clear();
		ele.sendKeys(val);		
	}
	
	
	public static void click(WebElement ele){		
		ele.click();		
	}
	
	public static String getText(WebElement ele){		
		return ele.getText();		
	}
	

}
