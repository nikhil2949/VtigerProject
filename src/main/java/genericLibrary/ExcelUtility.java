package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This class is a generic method to read single data from excel
	 * 
	 * @author Nikhil A
	 * @return
	 * @throws Exception
	 */
	public String readDataFromExcel(String SheetName, int rowNum, int cellNum) throws Exception {
		FileInputStream fis = new FileInputStream(IconstantUtility.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(SheetName);
		DataFormatter df = new DataFormatter();
		String value = df.formatCellValue(sh.getRow(rowNum).getCell(cellNum));
		return value;
	}

	/**
	 * @throws Exception This is a generic method to write data in excel
	 * @author Nikhil A
	 */
	public void writeDataInExcel(String sheetName, int rowNum, int cellNum, String value) throws Exception {
		FileInputStream fis = new FileInputStream(IconstantUtility.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		sh.createRow(rowNum).createCell(cellNum).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IconstantUtility.excelPath);
		book.write(fos);
	}
}
