package com.RMGYantra_GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility 
{
	public Connection con = null;
	public void createConnection() throws Throwable
	{
		Driver dref = new Driver();
		DriverManager.registerDriver(dref);
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}
	
		public ResultSet CreateStatement(String Query) throws Throwable
		{
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery(Query);
			return result;
		}
		
		public void closeConnection() throws Throwable
		{
			con.close();
		}
}
