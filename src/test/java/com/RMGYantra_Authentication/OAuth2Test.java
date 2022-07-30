package com.RMGYantra_Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2Test 
{
	@Test
	public void oauth()
	{
		Response resp = given()
		.formParam("client_id", "SDET_006")
		.formParam("client_secret", "bf9d6cea762a8de7c9f1c173a15dd74f")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://example.com")
		.post("http://coop.apps.symfonycasts.com/token");
		
		resp.prettyPrint();
		
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", "3277")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then()
		.log()
		.all();
	}
}
