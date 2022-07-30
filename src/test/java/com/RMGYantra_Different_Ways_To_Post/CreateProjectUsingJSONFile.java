package com.RMGYantra_Different_Ways_To_Post;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJSONFile 
{
	@Test
	public void createProjectUsingJSONFile()
	{
		File F = new File("D:\\Java Practice\\RestAssured\\CommonData.json");
		given()
		.contentType(ContentType.JSON)
		.body(F)
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
	}
}
