package Serialization_DataBinding_Classes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTest {


	
	public void readJson() throws JsonParseException, JsonMappingException, IOException{
	
		ObjectMapper obj = new ObjectMapper();
		
		Map<?, ?> map = obj.readValue(Paths.get("Utilities\\JsonData.json").toFile(), Map.class);
			
		 for (Map.Entry<?, ?> entry : map.entrySet()) {
		        System.out.println(entry.getKey() + "=" + entry.getValue());
		    }
		
	}
	
	
	
	public Users readJsonIntoPOJO() throws JsonParseException, JsonMappingException, IOException{
		
		ObjectMapper obj = new ObjectMapper();
		Users user = obj.readValue(Paths.get("Utilities\\JsonData.json").toFile(), Users.class);
		return user;
		
	}
	
	
}
