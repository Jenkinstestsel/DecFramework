package genericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Commonlib {
	
	public WebDriver ff;
	public String TCID ;
	public String Orderid;
	public static ExtentReports eReports;
	public ExtentTest startTest;
	public String cur_Browser;
	
		
	@BeforeSuite(groups={"qa","dev","prod"})
	public void initializeReport(){
		eReports = new ExtentReports("E:\\AReport\\Report\\Report _" + getdatetimestamp() + ".html");
	}
	
	@Parameters("browser")
	@BeforeMethod(groups={"qa","dev","prod"})
	public void launchApp(String brow) throws Exception{
		cur_Browser = brow;
		if(brow.equals("ff")){
			ff = new FirefoxDriver();
		}else if(brow.equals("ch")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
			ff = new ChromeDriver();
		}else if(brow.equals("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\IEDriverServer.exe");
			ff = new InternetExplorerDriver();
		}
		

		ff.get(getProp("url"));
		ff.manage().window().maximize();	
		ff.manage().timeouts().implicitlyWait (30, TimeUnit.SECONDS);
	}
	
	@AfterMethod(groups={"qa","dev","prod"})
	public void tearDown(){		
		eReports.endTest(startTest);
		eReports.flush();
		ff.quit();		
	}
	
	
//	screenshot
	public String getScreenshot() throws Exception{
	TakesScreenshot tk = (TakesScreenshot)ff;
	File screenshotAs = tk.getScreenshotAs(OutputType.FILE);
	String path= "E:\\AReport\\Screenshot\\Snap_" + TCID + "_" + Orderid + "_" + getdatetimestamp() + ".png";
	FileUtils.copyFile(screenshotAs, new File(path));
	return path;
	}
	
	
//	getdatatimestamp
	public String getdatetimestamp(){	
		
		Date date = new Date();	
		System.out.println(date);
		SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		String unique = sf.format(date);
		return unique;
	}
	
	
//	utility method
	public static String getProp(String key) throws Exception{
				
	     FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\Settings.properties");
			
	     Properties prop = new Properties();	
	     prop.load(fis);
	     	
	    return prop.getProperty(key);	
		
	}
	
	
	
}



