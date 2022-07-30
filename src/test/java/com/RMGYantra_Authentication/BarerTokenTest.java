package com.RMGYantra_Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BarerTokenTest 
{
	@Test
	public void barerTokenTest()
	{
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.log()
		.all();
		
	}
}
