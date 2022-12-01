package com.Instagram.login;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.testyourskill.genericutility.IConstants;

public class ExcelUtility
{


	public org.apache.poi.ss.usermodel.Row getSheet(Workbook wb,String sheet,int row)
	{
		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheet);
		return sh.getRow(row);
	}

	public String getCell(org.apache.poi.ss.usermodel.Row ro, int cell) 
	{
		return ro.getCell(cell).toString();
	}

	public int getRowCount(Workbook wb,String sheet) 
	{	
		return wb.getSheet(sheet).getLastRowNum();	
	}

	public int getCellCount(Workbook wb, String sheet, int row)
	{
		return wb.getSheet(sheet).getRow(row).getLastCellNum();
	}

	public String getExcelData(String sheet, int row, int cell) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheet).getRow(row).getCell(cell).toString();
	}

}


