package com.testyourskill.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromExcecuteUpdate {
	public static void main(String[] args) throws SQLException {
		//step1:Create object for Driver
		Driver driverRef=new Driver();
		Connection con=null;
		
		//step2:Resister the driver
		DriverManager.registerDriver(driverRef);
		
		//step3:Establish the connection-provide data base name
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Manju","root","root");
		
		//step:4 create a statement
		Statement state=con.createStatement();
		
		//Step5:Execute the Query
		String query="insert into empinfo values('manju',24,10000);";
		int result =state.executeUpdate(query);
		System.out.println(result);
		
		//step6:validate
		if(result==1)

		{
			System.out.println("data added successfully");
			
		}
		else
		{
			System.out.println("data not added");
		}
		 
		//Step7: close the connection 
		con.close();
		System.out.println("connection closed");
		
		
	}

	
}
