package Scripts;

import genericLibrary.Commonlib;
import genericLibrary.keywords;

import java.util.Map;

import org.testng.annotations.Test;

import pageFactory.pf_Home;

import com.relevantcodes.extentreports.LogStatus;

public class Scenario_Search extends Commonlib{
	
	@Test(dataProvider="dp" , dataProviderClass=dataProvider.Dp.class,groups={"dev"})
	public void Search_invalidSearch(Map<String, String> hm) throws Exception{
		
		
		TCID=hm.get("TC_ID");
		Orderid =hm.get("Order");	
		startTest = eReports.startTest(TCID + "_" + Orderid);
		startTest.assignCategory(cur_Browser);
//		POM
		pf_Home home = new pf_Home(ff);
		
		
		
		if(ff.getTitle().toLowerCase().contains("books")){
			startTest.log(LogStatus.PASS, "Home page validation","Passed as user is in Home page");
		}else{
			startTest.log(LogStatus.FAIL, "Home page validation","Failed as user not able to locate Home page" + startTest.addScreenCapture(getScreenshot()));
		}
		
		
//		search book
		home.searchBook(hm);
		
		String actual = keywords.getText(home.lbl_errmsg);
		
//		validation
		if(actual.equals(hm.get("expmsg"))){
			startTest.log(LogStatus.PASS, "Search error message validation","Passed as Search error message is matching");
		}else{
			startTest.log(LogStatus.FAIL, "Search error message validation","Failed as Search error message as actual is " + actual + " and expected was " + hm.get("expmsg") + startTest.addScreenCapture(getScreenshot()));
		}
		
				
	}
	
	
	
	@Test(dataProvider="dp" , dataProviderClass=dataProvider.Dp.class,groups={"qa"})
	public void Search_validSearch(Map<String, String> hm) throws Exception{
		
		
		TCID=hm.get("TC_ID");
		Orderid =hm.get("Order");	
		startTest = eReports.startTest(TCID + "_" + Orderid);
		startTest.assignCategory(cur_Browser);
//		POM
		pf_Home home = new pf_Home(ff);
		
		
		
		if(ff.getTitle().toLowerCase().contains("books")){
			startTest.log(LogStatus.PASS, "Home page validation","Passed as user is in Home page");
		}else{
			startTest.log(LogStatus.FAIL, "Home page validation","Failed as user not able to locate Home page" + startTest.addScreenCapture(getScreenshot()));
		}
		
		
//		search book
		home.searchBook(hm);
		
		String actual = keywords.getText(home.lbl_searchCount);
		
//		validation
		if(actual.equals(hm.get("expmsg").replace(".0",""))){
			startTest.log(LogStatus.PASS, "Search count  validation","Passed as Search count is matching");
		}else{
			startTest.log(LogStatus.FAIL, "Search count validation","Failed the Search count validation as actual is " + actual + " and expected was " + hm.get("expmsg") + startTest.addScreenCapture(getScreenshot()));
		}
		
		
		
		
	}

}
