package com.RMGYantra_Different_Ways_To_Post;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RMGYantra_POJO_Library.POJO;

import io.restassured.http.ContentType;

public class CreatingProjectUsingPOJOTest 
{
	@Test(dataProvider = "multipleData")
	public void creatingProjectUsingPOJOTest(String createdBy, String projectName, String status, int teamSize)
	{
		POJO P = new POJO(createdBy, projectName, status, teamSize);
		
		given()
		.contentType(ContentType.JSON)
		.body(P)
		.post("http://localhost:8084/addProject")
		.then()
		.log().all();	
	}
	
	@DataProvider
	public Object multipleData()
	{
		Object obj [][]= new Object[2][4];
		obj[0][0] = "Srikkanth";
		obj[0][1] = "POJO Project_02";
		obj[0][2] = "On Going";
		obj[0][3] = 11;
		
		obj[1][0] = "Srikkanth1";
		obj[1][1] = "POJO Project_03";
		obj[1][2] = "On Going";
		obj[1][3] = 15;
		
		return obj;
	}
}
