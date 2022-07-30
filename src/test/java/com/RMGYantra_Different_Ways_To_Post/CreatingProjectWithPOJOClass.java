package com.RMGYantra_Different_Ways_To_Post;

import org.testng.annotations.Test;

import com.RMGYantra_POJO_Library.POJO;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatingProjectWithPOJOClass 
{
	@Test
	public void creatingProjectWithPOJOClass()
	{
	POJO P = new POJO("SRIKANTH_007", "POJO_Project", "Completed", 11);
	
	given()
	.contentType(ContentType.JSON)
	.body(P)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON)
	.log().all();
			
			
	}
}
