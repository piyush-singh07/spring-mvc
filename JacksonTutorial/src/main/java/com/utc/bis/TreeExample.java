package com.utc.bis;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TreeExample {

	public static void main(String[] args) throws JsonProcessingException, IOException {
		
		String jsonString = "{\"name\":\"Mahesh Kumar\",  \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
		ObjectMapper mapper= new ObjectMapper();
		JsonNode rootNode= mapper.readTree(jsonString);
		JsonNode nameNode = rootNode.get("name");
        System.out.println("Name: "+ nameNode.asText());

        JsonNode ageNode = rootNode.get("age");
        System.out.println("Age: " + ageNode.asInt());

      /*  JsonNode verifiedNode = rootNode.path("verified");
        System.out.println("Verified: " + (verifiedNode.booleanValue() ? "Yes":"No"));

        JsonNode marksNode = rootNode.path("marks");
        Iterator<JsonNode> iterator = marksNode.elements();
        System.out.print("Marks: [ ");

        while (iterator.hasNext()) {
           JsonNode marks = iterator.next();
           System.out.print(marks.intValue() + " "); 
        }

        System.out.println("]");*/
		
		
		

	}

}
