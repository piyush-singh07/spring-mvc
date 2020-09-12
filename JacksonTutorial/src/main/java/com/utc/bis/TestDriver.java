package com.utc.bis;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestDriver {

	public static void main(String[] args) throws JsonProcessingException, IOException {
		String json=
				"{\"responseBody\":\"{\\\"access_token\\\":\\\"0eafe310660068bf522e7931b3d7bdec\\\",\\\"token_type\\\":\\\"Bearer\\\",\\\"expires_in\\\":300}\",\"contentType\":{\"type\":\"application\",\"subtype\":\"json\",\"parameters\":{\"charset\":\"UTF-8\"},\"qualityValue\":1.0,\"charset\":\"UTF-8\",\"concrete\":true,\"charSet\":\"UTF-8\",\"wildcardType\":false,\"wildcardSubtype\":false},\"status\":200}";
		ObjectMapper mapper= new ObjectMapper();
		JsonNode rootNode= mapper.readTree(json);
		JsonNode responseNode = rootNode.get("responseBody");
//		OauthTokenDTO dto = mapper.readValue
        System.out.println("Name: "+ responseNode.asText());
       String jsonString=mapper.writeValueAsString(responseNode);
       JsonNode dto= mapper.readTree(jsonString);
       System.out.println(dto.get("access_token").asText());
        
	}

}
