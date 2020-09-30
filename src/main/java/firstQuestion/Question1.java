package firstQuestion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Question1 {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	FileInputStream file;

	public void doesFileExist(String path) {

		try {

			file = new FileInputStream(path);

		} catch (FileNotFoundException e) {

			System.out.println("File is not found");

		}

	}
	
	/*
	 * I wanted to write a second method for reading the file although I could write everything 
	 * in the same method "doesFileExist()".
	 */
	public void readingFile(String path) {

		try {

			workbook = new XSSFWorkbook(path);

		} catch (IOException e) {

			e.printStackTrace();
		}

		sheet = workbook.getSheetAt(0);

		int maxNumOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= maxNumOfRows; i++) {

			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {

				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}

		}

	}



}
