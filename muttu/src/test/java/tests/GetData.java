package tests;

import java.io.File;
import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetData extends BaseOne {

	private Logger logger = LogManager.getLogger(GetData.class);

	public String[][] getData() {
		String[][] strArray = null;
		XSSFWorkbook book = null;

		try {
			book = new XSSFWorkbook(
					new FileInputStream(new File("C:\\Users\\Mitturaj.h\\muttu\\muttu\\Excel Files\\data.xlsx")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = book.getSheetAt(0);

		int rowcount = sheet.getLastRowNum();

		strArray = new String[rowcount + 1][2];

		for (int i = 0; i < rowcount + 1; i++) {

			Row row = sheet.getRow(i);

			int lastCellNumber = row.getLastCellNum();

			for (int j = 0; j < lastCellNumber; j++) {

				Cell ceelValue = row.getCell(j);

				final DataFormatter df = new DataFormatter();

				strArray[i][j] = df.formatCellValue(ceelValue);

			}

		}
		return strArray;

	}

	@DataProvider(name = "data")
	public Object[][] getDataProvider() {

		Object[][] objects = getData();
		return objects;

	}

	@Test(dataProvider = "data")
	public void test1(String fname, String lname) {

		logger.info(fname + "  " + lname);

	}

}
