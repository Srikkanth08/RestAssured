package com.RMGYantra_Different_Ways_To_Post;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingHashMap 
{
	@Test
	public void createProjectUsingHashMap()
	{
	HashMap HP = new HashMap();
	HP.put("projectName", "RestAssured_Project1");
	HP.put("createdBy", "Srikanth1");
	HP.put("status", "Created");
	HP.put("teamSize", "16");
	
	given()
	.contentType(ContentType.JSON)
	.body(HP)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.log().all();
	
	}
}
