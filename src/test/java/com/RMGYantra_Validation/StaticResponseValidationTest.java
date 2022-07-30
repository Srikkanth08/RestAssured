package com.RMGYantra_Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest 
{
	@Test
	public void staticResponseValidationTest()
	{
		String expData = "MS_TESTING";
		
		Response resp = when().get("http://localhost:8084/projects");
		
		String actData = resp.jsonPath().get("[0].projectName");
		
		Assert.assertEquals(expData, actData);
	}
}
