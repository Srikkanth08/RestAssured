package com.RMGYantra_CRUD_Operations_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PatchUpdateProject 
{
	@Test
	public void patchUpdateProject()
	{
	JSONObject jobj = new JSONObject();
	jobj.put("projectName", "MSD_TESTING");
	jobj.put("createdBy", "SrikKanth1234");
	jobj.put("status", "Created");
	jobj.put("teamSize", 15);
	
	given()
	.contentType(ContentType.JSON)
	.when()
	.patch("https://reqres.in/api/users/2")
	.then()
	.assertThat().statusCode(200)
	.and()
	.assertThat().contentType(ContentType.JSON)
	.log().all();
	
	}
}
