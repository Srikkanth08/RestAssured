package com.RMGYantra_Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter 
{
	@Test
	public void queryParameter()
	{
		given()
		.queryParam("page", 2)
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.log().all();
	}
}
