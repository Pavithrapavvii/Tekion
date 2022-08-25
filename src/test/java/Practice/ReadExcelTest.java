package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelTest {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
	FileInputStream file = new FileInputStream("./src/test/resources/Data.xlsx");
	Workbook wb = WorkbookFactory.create(file);
	Sheet sh = wb.getSheet("Sheet2");
	
	for(int i=0; i<=sh.getLastRowNum();i++)
	{
		Row r = sh.getRow(i);
		for(int j=0;j<r.getLastCellNum();j++)
		{
			Cell cell = r.getCell(j);
			System.out.println(cell.toString());
		}
	}
	
}
}
