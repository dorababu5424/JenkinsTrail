package FlipkartDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXl {
	
	
	public static String ReadXls(String sheetName,int r, int c) throws IOException{
		
		File f = new File("C:\\Users\\dorab\\AppCRM\\JombaneProject\\src\\test\\resources\\Demo.xlsx");
		
		FileInputStream  fin = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fin);
		
		Sheet sheet = w.getSheet(sheetName);
		
		Row row = sheet.getRow(r);
		
		Cell cell = row.getCell(c);
		
		int cellType = cell.getCellType();   
		
		String value ="";
		
		if (cellType==1) {
			
			value = cell.getStringCellValue();
			
		}else if(DateUtil.isCellDateFormatted(cell)){
			
			Date d = cell.getDateCellValue();
			
			SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
			value = sim.format(d);
		}else {
			double d = cell.getNumericCellValue();
			 long l =(long) d;
			 
			 value = String.valueOf(l);
		}
		
		return value;
	}
	
	public static void main(String[] args) throws IOException {
		
		
		ReadXls("Sheet1", 1, 1);
	}

	
	
	
}
