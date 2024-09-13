package samplePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
FileInputStream fis = new FileInputStream("C:\\\\Selenium\\\\TestDataSeleniumFramework.xlsx");
Workbook book = WorkbookFactory.create(fis);
Sheet sh = book.getSheet("Admin");
sh.createRow(1).createCell(4).setCellValue("Testing");
FileOutputStream fos = new FileOutputStream("C:\\\\Selenium\\\\TestDataSeleniumFramework.xlsx");
book.write(fos);
	}

}
