package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {
	
	public FileInputStream fis;
	public XSSFWorkbook wb;
//	Initializing WB
	public  ExcelRW(String path) throws Exception{
		
//		file input stream
		fis = new FileInputStream(path);
		
//		Excel workbook
		wb = new XSSFWorkbook(fis);
	}
	
	public  XSSFSheet getSheet(String sheetName){
		XSSFSheet sheet = wb.getSheet(sheetName);
		return sheet;
	}
	
	
//	Row COunt
	public int getRowCount(String sheetName){	
		
//		XSSFSheet sheet = wb.getSheet(sheetName);
//		int rowcount = sheet.getLastRowNum();
		
		int rowcount = getSheet(sheetName).getLastRowNum();
		return rowcount;		
	}
	
	
//	Column COunt
	public int getColCount(String sheetName){	
		

		int colcount = getSheet(sheetName).getRow(0).getLastCellNum();
		return colcount;		
	}
	
//	Read Functionality
	public String readCellValue(String sheetName,int row, int col){
		XSSFSheet sheet = wb.getSheet(sheetName);
		XSSFCell cellval = sheet.getRow(row).getCell(col);
		String Celltext="";
		if(cellval.getCellType()==Cell.CELL_TYPE_STRING){
			Celltext = cellval.getStringCellValue();
			
		}else if(cellval.getCellType()==Cell.CELL_TYPE_NUMERIC){
			Celltext  = String.valueOf(cellval.getNumericCellValue());
			
		}else if(cellval.getCellType()==Cell.CELL_TYPE_BLANK){
			Celltext="";
			
		}
		
		return Celltext;
		
		
	}
	
//	Write
	public void writeCellValue(String sheetName,int row,int col,String val){
		XSSFSheet sheet = wb.getSheet(sheetName);
//		write
		sheet.getRow(row).getCell(col).setCellValue(val);
		
	}
	
//	Save and Close
	void SaveandClose(String path) throws Exception{
	FileOutputStream fos = new FileOutputStream(path);
		
	wb.write(fos);
		
	fos.close();
	fis.close();
		
		
	}
	

}
