package com.utc.bis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MapFunction {

	public static void main(String[] args) throws IOException {
		MapFunction obj= new MapFunction();
	        obj.readJsonWithObjectMapper_Map();
		

	}
	
	 public void readJsonWithObjectMapper() throws IOException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        Map<?,?> empMap = objectMapper.readValue(new FileInputStream("Human.json"),Map.class);
	        for (Map.Entry<?, ?> entry : empMap.entrySet())
	        {
	            System.out.println("\n----------------------------\n"+entry.getKey() + "=" + entry.getValue()+"\n");
	        }
	    }
	 
	 public void readJsonWithObjectMapper_Map() throws IOException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        String json_val=
	        			"{\"responseBody\":\"{\\\"access_token\\\":\\\"0eafe310660068bf522e7931b3d7bdec\\\",\\\"token_type\\\":\\\"Bearer\\\",\\\"expires_in\\\":300}\",\"contentType\":{\"type\":\"application\",\"subtype\":\"json\",\"parameters\":{\"charset\":\"UTF-8\"},\"qualityValue\":1.0,\"charset\":\"UTF-8\",\"concrete\":true,\"charSet\":\"UTF-8\",\"wildcardType\":false,\"wildcardSubtype\":false},\"status\":200}";
	        Map<?,?> empMap = objectMapper.readValue(json_val,Map.class);
	        for (Map.Entry<?, ?> entry : empMap.entrySet())
	        {
	            System.out.println("\n----------------------------\n"+entry.getKey() + "=" + entry.getValue()+"\n");
	        }
	    }
	
	

}
