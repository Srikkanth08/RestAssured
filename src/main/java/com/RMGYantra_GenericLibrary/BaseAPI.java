package com.RMGYantra_GenericLibrary;

import org.testng.annotations.BeforeSuite;

public class BaseAPI 
{
	public DatabaseUtility dutil = new DatabaseUtility();
	@BeforeSuite
	public void getConnection() throws Throwable
	{
		dutil.createConnection();
	}
	
	public void closeConnection() throws Throwable
	{
		dutil.closeConnection();
	}
}
