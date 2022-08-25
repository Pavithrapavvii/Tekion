package com.testyourskill.PRACTICE;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step:1 read the file using fileinputstream
		FileInputStream fis=new FileInputStream(".\\Dataproperty\\DataDriven.xlsx");
		
		//step2:Create a workbook
		Workbook book=WorkbookFactory.create(fis);
		
		//step3:load the sheet
		          Sheet sh = book.getSheet("mj");
		          
		//step4:navigate to the row
		          Row row=sh.getRow(1);
		          
		   //step5: navigate cell
		     Cell cel = row.getCell(2);
		     
		     //step6: reaad the data inside the 
		         System.out.println(cel.getStringCellValue());
		
		           
		
	}

}
