package dataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import genericLibrary.Commonlib;
import genericLibrary.ExcelRW;

import org.testng.annotations.DataProvider;

public class Dp_base {
	
	
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
	
	
	
		
	@DataProvider(name="dp_invalidLogin")
	public static Iterator<Object[]> dp_invalidLogin() throws Exception {
		
		return commonDp("Login","invalidLogin");
	}
	
	@DataProvider(name="dp_validLogin")
	public static Iterator<Object[]> dp_validLogin() throws Exception{
		return commonDp("Login","validLogin");	
		
	}
	
	
	@DataProvider(name="dp_validSearch")
	public static Iterator<Object[]> dp_validSearch() throws Exception{
		return commonDp("Search","validSearch");
		
	}
	
	
	@DataProvider(name="dp_invalidSearch")
	public static Iterator<Object[]> dp_invalidSearch() throws Exception{
		return commonDp("Search","invalidSearch");
		
		
	}
}
