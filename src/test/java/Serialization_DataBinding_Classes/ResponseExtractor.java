package Serialization_DataBinding_Classes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ResponseExtractor {

	public String extractJsonObject(Response res, String s){
		JsonPath jpath= new JsonPath(res.asString());
		String value = jpath.get(s).toString();
	return value;
		
	}
	
	
	
	public List<Map<String,String>> extractJsonList(Response res, String list ){
		JsonPath jpath= new JsonPath(res.asString());
		List<Map<String,String>> listExtractor = jpath.getList(list);
		return listExtractor;
		
	}
	
	
	public void extractJsonListObjects(List<Map<String,String>> listName, String listAttribute, String counterCheck, String valueToExtract){
		
		for(Map<String,String> map : listName){
			
			if(map.get(listAttribute).equalsIgnoreCase(counterCheck)){
				System.out.println(" The attribute value is  " + map.get(valueToExtract));
				
			}
			
		}
		
		
	}
	
	public String extractPOJOJsonResponse(Response res ,String field,String innerFieldValue) throws IOException{
		
		ObjectMapper mapperObj = new ObjectMapper();
		JsonNode jnode = mapperObj.readTree(res.asInputStream());
		JsonNode fieldValue = jnode.get(field);
		JsonNode j = fieldValue.get(innerFieldValue);
		
		return j.asText();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
