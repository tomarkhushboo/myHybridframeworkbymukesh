package dataprovider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	FileInputStream fls;

	//create the constructor and keep all file loading thing so one once object is created
	//constructor is called and files are loaded

	public ExcelDataProvider() throws Exception {
		File src = new File("./ApplicationTestdata/AppData.xlsx");
		
		//File src = new File("C:\\seleniumjava3.141.59\\readandwriteExcel\\testdata.xlsx");
		
		//read excel

		fls = new FileInputStream(src);
		wb = new XSSFWorkbook(fls);

	}

	//create method to read sheet and row in excel sheet

	public String getData(int sheetIndex,int row,int column) {
	
		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;

	}

	public String getData(String sheetName,int row, int column) {

		String data = wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;

	}


}
