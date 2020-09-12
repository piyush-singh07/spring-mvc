package com.utc.bis;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author singhpi
 *
 */
public class Test1 {

	public static void main(String[] args) throws JsonProcessingException, IOException {
		String jsonString = "{\"name\":\"Mahesh Kumar\",  \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
		ObjectMapper mapper= new ObjectMapper();
		ObjectNode obj= (ObjectNode) mapper.readTree(jsonString);
		System.out.println(obj.get("name").asText());
		System.out.println(obj.get("age"));
		ArrayNode arr = (ArrayNode) obj.get("marks");
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println(arr.get(0));
		

	}

}
