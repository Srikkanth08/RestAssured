package com.RMGYantra_CRUD_Operations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProjects 
{
	@Test
	public void deleteprojects()
	{
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_001");
		ValidatableResponse valid = resp.then();
		valid.assertThat().statusCode(204);
		valid.assertThat().contentType(ContentType.JSON);
	}
}
