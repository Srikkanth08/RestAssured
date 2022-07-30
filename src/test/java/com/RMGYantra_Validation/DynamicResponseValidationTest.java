package com.RMGYantra_Validation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidationTest 
{
	@Test
	public void dynamicResponseValidationTest()
	{
		String expData = "MS_TESTING";
		
		Response resp = when().get("http://localhost:8084/projects");
		
		List<String> actData = resp.jsonPath().get("projectName");
		
		for(String allData:actData)
		{
			if(actData.equals(expData))
			{
				System.out.println("Project name matched");
				break;
			}
		}
	}
}
