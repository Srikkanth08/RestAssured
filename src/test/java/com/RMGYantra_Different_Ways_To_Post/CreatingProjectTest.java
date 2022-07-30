package com.RMGYantra_Different_Ways_To_Post;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatingProjectTest 
{
	@Test
	public void creatingProjectTest()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("projectName", "RestAssured_Project");
		jobj.put("createdBy", "Srikanth");
		jobj.put("status", "On Going");
		jobj.put("teamSize", "16");
		
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
