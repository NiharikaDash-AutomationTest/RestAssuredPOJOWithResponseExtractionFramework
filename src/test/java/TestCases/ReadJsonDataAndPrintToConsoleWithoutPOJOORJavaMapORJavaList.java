package TestCases;

import java.io.File;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReadJsonDataAndPrintToConsoleWithoutPOJOORJavaMapORJavaList {

	@Test
	public void foo(){
		
		File file = new File("C:/Users/Niharika/working/RestAssured_JackSon_Simple_DataBinding/Utilities/postJsonData.json");
	given()
	.contentType(ContentType.JSON)
	.body(file)
	.when()
	.post("https://reqres.in/api/users").then().statusCode(201);

	}
	

	@Test
	public void fool(){
		
		File file = new File("C:/Users/Niharika/working/RestAssured_JackSon_Simple_DataBinding/Utilities/postJsonData.json");
	int n = given()
	.contentType(ContentType.JSON)
	.body(file)
	.when()
	.post("https://reqres.in/api/users").thenReturn().statusCode();
	
	System.out.println("  Th estatyuc code is " + n );
	}


	
	
	@Test
	public void fools(){
		
		File file = new File("C:/Users/Niharika/working/RestAssured_JackSon_Simple_DataBinding/Utilities/postJsonData.json");
	Response res = given()
	.contentType(ContentType.JSON)
	.body(file)
	.when()
	.post("https://reqres.in/api/users").thenReturn();
	
	System.out.println("  Th estatyuc code is " + res.asString() );
	}
}
