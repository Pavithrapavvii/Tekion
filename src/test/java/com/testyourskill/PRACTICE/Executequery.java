package com.testyourskill.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Executequery {
	public static void main(String[] args) throws SQLException {
		//step1: create object for driver
		Driver driverRef=new Driver();
		Connection con=null;
		
		//Step2:register the driver
		DriverManager.registerDriver(driverRef);
		
		//step3:establish the connection -provide the database name
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Manju","root","root");
		
		//step4: create statement
		Statement statement=con.createStatement();
		
		//step5:Execute the query -provide the table name
		String query="Select * from empinfo;";
		String expdata="manju";
	        ResultSet result = statement.executeQuery(query);
	        boolean flag=false;
	        while(result.next())
	        {
	        	String actData=result.getString(1);
	        	if(actData.equalsIgnoreCase(expdata))
	        	{
	        		System.out.println(actData);
	        		flag=true;//flag rising
	        		break;
	        	}
	        }
		if(flag)
		{
			System.out.println("data is present");
		}
		else {
			System.out.println("data is not pressent");
		}
		
		//step6:validate
		//step7:close connection
		con.close();
		}
	}


