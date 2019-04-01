package tests;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetData {

	

	public String[][] getData()  {
		String[][] strArray=null;
		XSSFWorkbook book = null;
		
		try {
			book = new XSSFWorkbook(
					new FileInputStream(new File("C:\\Users\\Mitturaj.h\\Desktop\\data.xlsx")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		XSSFSheet sheet = book.getSheetAt(0);

		int rowcount = sheet.getLastRowNum(); 

		System.out.println("Row Numbers " + rowcount);
		
		strArray=new String[rowcount+1][2];

		for (int i = 0; i < rowcount + 1; i++) {

			Row row = sheet.getRow(i);

			int lastCellNumber = row.getLastCellNum();

			System.out.println("Last Cell Number " + lastCellNumber);
			
			for (int j = 0; j < lastCellNumber; j++) {

				Cell ceelValue = row.getCell(j);

				final DataFormatter df = new DataFormatter();

				String valueAsString = df.formatCellValue(ceelValue);

				System.out.println(valueAsString);
				
				strArray[i][j]=df.formatCellValue(ceelValue);
				

			}

		}
		return strArray;
		
	}
	
	@DataProvider(name="data")
	public Object[][] getDataProvider(){
		
		Object[][] objects=getData(); 
		return objects;
		
		
	}
	
	@Test(dataProvider="data")
	public void test1(String fname,String lname){
		
		System.out.println();
	}

}
