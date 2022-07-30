package com.RMGYantra_EndToEnd_Scenario;

import org.testng.annotations.Test;

import com.RMGYantra_GenericLibrary.BaseAPI;
import com.RMGYantra_GenericLibrary.EndPoint;
import com.RMGYantra_GenericLibrary.JavaUtility;
import com.RMGYantra_POJO_Library.POJO;

import static io.restassured.RestAssured.*;

import java.sql.ResultSet;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEndScenario_Test extends BaseAPI 
{
	@Test
	public void endToEnd() throws Throwable
	{
		 baseURI = "http://localhost";
		 port = 8084;
		
	    JavaUtility javautil=new JavaUtility();
		POJO po= new POJO("Srikanth","EndToEndScenario"+javautil.generateRandom(),"Created",20);
		
		Response resp= given()
			    .contentType(ContentType.JSON)
			    .body(po)
			    .when()
			    .post(EndPoint.createProject);
			    resp.prettyPrint();
		       String proId = resp.jsonPath().get("projectId");
		    
		       Response resp2=  given()
		        .pathParam("project", proId)
				.when()
				.get(EndPoint.getProject+"/{project}");
		          resp2.prettyPrint();
				 String proName = resp2.jsonPath().get("projectName");
				System.out.println(proName);
			ResultSet result = dutil.CreateStatement("select project_name from project where project_id='"+proId+"'");
				while(result.next())
				{
					if(proName.equals(result.getString(1)))
		           {
					System.out.println(proName+":Is available in DataBase");
					break;
				   }
				}
	}
}
