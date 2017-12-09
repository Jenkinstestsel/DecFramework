package dataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import genericLibrary.Commonlib;
import genericLibrary.ExcelRW;

import org.testng.annotations.DataProvider;

public class Dp {
	
	
	public static Iterator<Object[]> commonDp(String sheetName, String scriptName) throws Exception{
		ExcelRW ex = new ExcelRW(Commonlib.getProp("TestData"));

		
		int row = ex.getRowCount(sheetName);
		int col = ex.getColCount(sheetName);
		
		List<Object[]> ls = new ArrayList<Object[]>();
		
		for(int i = 1;i<=row;i++){
			String execute = ex.readCellValue(sheetName, i, 2);
			String script = ex.readCellValue(sheetName, i, 3);
			if(execute.equals("y") && script.equals(scriptName)){
//				create object array
				Object[] x = new Object[1];
//				crrate map
				Map<String, String> hm = new HashMap<String,String>();
//				iterate column
				for(int j = 0 ;j<col;j++){
					
					String key=ex.readCellValue(sheetName, 0, j);
					String val=ex.readCellValue(sheetName, i, j);
					hm.put(key, val);
					
				}
				x[0]=hm;
				ls.add(x);
				
			}	
			
		}
		
		return ls.iterator();
	}
	

//	@DataProvider(name="dp")
//	public static Iterator<Object[]> singleDp(Method m) throws Exception{
//		Iterator<Object[]> commonDp = null;
//		
//		if(m.getName().equals("validLogin")){
//			 commonDp= commonDp("Login","validLogin");
//		}else if(m.getName().equals("invalidLogin")){
//			commonDp= commonDp("Login","invalidLogin");
//		}else if(m.getName().equals("validSearch")){
//			commonDp= commonDp("Search","validSearch");
//		}else if(m.getName().equals("invalidSearch")){
//			commonDp= commonDp("Search","invalidSearch");
//		}
//		
//		
//		return commonDp;
//		
//		
//		
//	}
//	
	
	
	@DataProvider(name="dp")
	public static Iterator<Object[]> singleDp(Method m) throws Exception{
		
//		Login_invalidLogin
//		----------------------------------
//		String[] sname = m.getName().split("_");		
//		return  commonDp(sname[0],sname[1]);
//		-----------------------------------------------
		return commonDp(m.getName().split("_")[0],m.getName().split("_")[1]);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}







