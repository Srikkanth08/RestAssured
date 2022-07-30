package com.RMGYantra_Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest 
{
	@Test
	public void pathParameterTest()
	{
		given()
		.pathParam("pro_Id", "TY_PROJ_003")
		.when()
		.get("http://localhost:8084/projects/{pro_Id}")
		.then()
		.log().all();
	}
}
