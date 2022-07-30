package com.RMGYantra_CRUD_Operations_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutUpdateProject 
{
	@Test
	public void putUpdateProject()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("projectName", "MSK_TESTING");
		jobj.put("createdBy", "Srikanth1234");
		jobj.put("status", "Created");
		jobj.put("teamSize", 11);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_006")
		.then()
		.assertThat().statusCode(200)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
}
