package sdcprojekt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PrimeNumbers {

	public static void main(String[] args) throws IOException {
		File excelFile = new File("vzorek_dat.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();
		System.out.println("Prime numbers: ");
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				try {
					int number = Integer.parseInt(cell.toString().trim());
					boolean prvocislo = true;
					for (int i = 2; i < number; i++) {
						if (number % i == 0) {
							prvocislo = false;
						}
					}
					if (prvocislo) {
						System.out.println(number);
					}
				} catch (NumberFormatException e) {
				}
			}
		}
		workbook.close();
		fis.close();
	}
}
