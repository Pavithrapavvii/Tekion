package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchTheData {
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(".\\Dataproperty\\TYS_TestCases.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet s = book.getSheet("Sheet1");
		int lastRow = s.getLastRowNum();
		short lastCell = s.getRow(s.getLastRowNum()).getLastCellNum();
		
		for(int i=0;i < lastRow;i++)
		{
			for (int j = 0; j < lastCell; j++) {
				
				//if there is no if condition it will all row(headers also)
				if(i%2 != 0) 
				{
						String value = s.getRow(i).getCell(j).toString();
						System.out.print(value+":");
				
						
						
				}
				
			}
		}
		
	}

}