package ExcelOperations;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelOperations {

	public static void main(String args[]) {

		// You need to use File class which will ask for file location.I
		// specified base// directory //using dot(.) operator then inside data
		// folder I have testdata.xls// stored

		File src = new File("./SeleniumWookbook.xls");

		try {
			// Workbook is a class in Jexcel which will take file as an argument
			// and getWork//book is a predefined method which will read the
			// workbook and will return the w//Workbook object

			Workbook wb = Workbook.getWorkbook(src);

			// Workbook is loaded now we have to load sheet so using workbook
			// object (wb) we// can call getSheet method which will take index
			// as an argument and will load t//he sheet, we can also specify the
			// sheetname also

			Sheet sh1 = wb.getSheet(0);

			// Sheet is loaded then we have to read cell so using sh1 object
			// call getCell me//thod which we take two arguments
			// getCell(column,row)
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 2; j++) {

					Cell c1 = sh1.getCell(j, i);

					// Cell is loaded then using getContents method we have to
					// extract
					// the data usin//g getContents() methods
					// this method will always return you String.
					// now you are done

					String data1 = c1.getContents();

					System.out.println("Sheet data is " + data1);
				}
			}

		} catch (BiffException e) {

			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}