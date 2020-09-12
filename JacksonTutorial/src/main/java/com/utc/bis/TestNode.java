package com.utc.bis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;

public class TestNode {

	public static void main(String[] args) {

		ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
		node.put("client_id", "fewefwefwe");
		node.put("client_secret", "feqfewqfqewegweg111111");
		String data = null;
		try {
			data = new ObjectMapper().writeValueAsString(node);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(data);

	}

}
