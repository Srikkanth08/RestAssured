package com.RMGYantra_CRUD_Operations_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProject 
{
	@Test
	public void deleteProject()
	{
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_004")
		.then()
		.assertThat().statusCode(204)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
}
