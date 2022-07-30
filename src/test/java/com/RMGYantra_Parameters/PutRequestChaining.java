package com.RMGYantra_Parameters;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PutRequestChaining 
{
	@Test
	public void putRequestChaining()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("projectName", "MS_TESTING");
		jobj.put("createdBy", "Srikanth1234");
		jobj.put("status", "Created");
		jobj.put("teamSize", 11);
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject");
		
		String proID = resp.jsonPath().get("projectId");
		
		given()
		.pathParam("projID", proID)
		.when()
		.delete("http://localhost:8084/projects/{projID}")
		.then()
		.log()
		.all();
		
		
	}
}
