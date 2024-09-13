package samplePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Selenium\\TestDataSeleniumFramework.xlsx");
		Workbook book = WorkbookFactory.create(fis); // Creates workbook sheet
		Sheet sh = book.getSheet("PIM");
		DataFormatter df = new DataFormatter(); // This method is used to convert integer to string values
		String value = df.formatCellValue(sh.getRow(1).getCell(3));
		System.out.println(value);

	}

}
