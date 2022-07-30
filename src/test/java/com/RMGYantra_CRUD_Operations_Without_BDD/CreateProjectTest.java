package com.RMGYantra_CRUD_Operations_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest 
{
	@Test
	public void createProjectTest()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("projectName", "MSD_TESTING");
		jobj.put("createdBy", "Srikanth123");
		jobj.put("status", "Created");
		jobj.put("teamSize", 11);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
}
