package main;

import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelTesting {
	@Test
	public void DataReadTest() throws Exception{
		File file = new File("C:\\Users\\Dina\\eclipse-workspace\\TaskExcel\\TestScript1.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook xsf = new XSSFWorkbook(inputStream);
		XSSFSheet data = xsf.getSheetAt(0);
		
		String firstLog = data.getRow(1).getCell(0).getStringCellValue();
		String firstPas = data.getRow(1).getCell(1).getStringCellValue();
		String secondLog = data.getRow(2).getCell(0).getStringCellValue();
		String secondPas = data.getRow(2).getCell(1).getStringCellValue();
		
		assertEquals("Ayok123",firstLog);
		assertEquals("pas123",firstPas);
		assertEquals("Test123",secondLog);
		assertEquals("testpass",secondPas);
		
		xsf.close();
	}
}
