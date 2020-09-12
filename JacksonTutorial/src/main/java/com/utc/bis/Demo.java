package com.utc.bis;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Demo {

	public static void main(String[] args) throws IOException {
		ObjectMapper mapper= new ObjectMapper();
		//ObjectNode node= mapper.createObjectNode();
		//ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
		JsonNode node=mapper.readTree("{\"Id\":\"s-111\",\"username\":\"user123\"}");
		System.out.println(mapper.writeValueAsString(node));
		((ObjectNode) node).put("Id", "s-111");
		((ObjectNode) node).put("username","hello");
		System.out.println(mapper.writeValueAsString(node));
		

	}

}
