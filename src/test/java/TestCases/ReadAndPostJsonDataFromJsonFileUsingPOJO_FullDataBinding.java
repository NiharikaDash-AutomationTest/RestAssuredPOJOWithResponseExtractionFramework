package TestCases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Serialization_DataBinding_Classes.Data;
import Serialization_DataBinding_Classes.ObjectMapperTest;
import Serialization_DataBinding_Classes.ResponseExtractor;
import Serialization_DataBinding_Classes.Users;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ReadAndPostJsonDataFromJsonFileUsingPOJO_FullDataBinding {

	
	@Test
	public void foo() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapperTest mapperObj = new ObjectMapperTest();
		Users u = mapperObj.readJsonIntoPOJO();
		System.out.println("The content of Json as POJO is " + u.getTotal_pages()) ;
	
		for(Data e : u.getData()){
			System.out.println(" content of List  " + e.getEmail());
			
			
		}
		
		
		System.out.println("Content of Support" + u.getSupport().getUrl());
		
	}
	
	
	
	@Test
	public void validateAllResponses() throws IOException{
		
		Response  responses = given()
				.when()
				.get("https://reqres.in/api/users?page=2");
		
		ResponseExtractor responseextra = new ResponseExtractor();
		
		String str = responseextra.extractJsonObject(responses, "total_pages");
		System.out.println(" Th etotal pages are " + str);
		List<Map<String,String>>  listMap= responseextra.extractJsonList(responses, "data");
		responseextra.extractJsonListObjects(listMap,"first_name" , "Tobias" , "last_name");
		
				
		String textInnerJsonObject = responseextra.extractPOJOJsonResponse(responses, "support", "text");
		System.out.println(" The text is  " + textInnerJsonObject);
		
	}
	
}
