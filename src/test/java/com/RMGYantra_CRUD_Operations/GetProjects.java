package com.RMGYantra_CRUD_Operations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetProjects 
{
	@Test
	public void getprojects()
	{
		Response resp = RestAssured.get("http://localhost:8084/projects");
		ValidatableResponse valid = resp.then();
		valid.assertThat().statusCode(200);
		valid.assertThat().contentType(ContentType.JSON);
		valid.log().all();
	}
}
