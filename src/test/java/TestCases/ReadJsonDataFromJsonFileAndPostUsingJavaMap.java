package TestCases;


import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Serialization_DataBinding_Classes.ObjectMapperTest;
public class ReadJsonDataFromJsonFileAndPostUsingJavaMap {

	
	@Test
	public void foo() throws JsonParseException, JsonMappingException, IOException{
		
		ObjectMapperTest mapperObj = new ObjectMapperTest();
		mapperObj.readJson();
		
		
	}
	
	

}
