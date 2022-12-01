package com.testyourskill.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadTheData {
	//public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	//step:1 read the file using fileinputstream
	@Test
	public void raad() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\Dataproperty\\DataDriven.xlsx");
		
		//step2:Create a workbook
		Workbook book=WorkbookFactory.create(fis);
		
		//step3:load the sheet.
		          Sheet sh = book.getSheet("mj");
		          
		//step4:navigate to the row
		          Row row=sh.getRow(1);
		          
		   //step5: navigate cell
		     Cell cel = row.getCell(1);
		     //step6: reaad the data inside the 
		         System.out.println(cel.getStringCellValue());	
	
	
		//FileInputStream fis=new FileInputStream(".\\Dataproperty\\DataDriven.xlsx");
		 //Workbook book = WorkbookFactory.create(fis);
		//Sheet s = book.getSheet("mj");
		Row r=sh.createRow(5);
		Cell cel1= row.createCell(5);
	   cel.setCellValue("Manjunatha S");
		FileOutputStream fout=new FileOutputStream(".\\Dataproperty\\DataDriven.xlsx");
		book.write(fout);
		
		
	}
}
	

