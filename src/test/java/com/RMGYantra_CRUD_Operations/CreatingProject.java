package com.RMGYantra_CRUD_Operations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreatingProject 
{
	@Test
	public void creatingProject()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("projectName", "MSK_TESTING");
		jobj.put("createdBy", "Srikanth1234");
		jobj.put("status", "Created");
		jobj.put("teamSize", 11);
		
		
		RequestSpecification rs = RestAssured.given();
		rs.contentType(ContentType.JSON);
		rs.body(jobj);
		
		Response res = rs.post("http://localhost:8084/addProject");
		ValidatableResponse valid = res.then();
		valid.assertThat().statusCode(201);
		valid.log().all();
	}
}
