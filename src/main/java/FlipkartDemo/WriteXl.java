package FlipkartDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteXl {
	
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("C:\\Users\\dorab\\AppCRM\\JombaneProject\\src\\test\\resources\\Demo.xlsx");
		
		FileInputStream  fin = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fin);
		
		Sheet sheet = w.getSheet("Sheet2");
		
		Row row = sheet.createRow(0);
		
		Cell createCell = row.createCell(2);
		
		createCell.setCellValue("Selenium java");
		
		
		FileOutputStream fout = new FileOutputStream(f);
		
		w.write(fout);
		
	}

}
