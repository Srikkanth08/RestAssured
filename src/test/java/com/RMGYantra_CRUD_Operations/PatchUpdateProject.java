package com.RMGYantra_CRUD_Operations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PatchUpdateProject 
{
	@Test
	public void patchUpdateProject()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("projectName", "MSK_TESTING1");
		jobj.put("createdBy", "Srikkanth1234");
		jobj.put("status", "Created");
		jobj.put("teamSize", 11);
		
		
		RequestSpecification rs = RestAssured.given();
		rs.contentType(ContentType.JSON);
		rs.body(jobj); 
		
		//For Patch Update go to reqres.in website
		Response res = rs.patch("https://reqres.in/api/users/2");
		ValidatableResponse valid = res.then();
		valid.assertThat().statusCode(200);
		valid.log().all();
	}
}
