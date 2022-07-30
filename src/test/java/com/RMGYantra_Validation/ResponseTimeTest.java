package com.RMGYantra_Validation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ResponseTimeTest 
{
	@Test
	public void responseTimeTest()
	{
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(5000L),TimeUnit.SECONDS)
		.assertThat().body("[0].projectName", Matchers.equalTo("MS_TESTING"))
		.log().all();
	}
}
