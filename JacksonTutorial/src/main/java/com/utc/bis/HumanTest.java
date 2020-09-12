package com.utc.bis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HumanTest {
	
	
	public static void main(String[] args) throws IOException {
		HumanTest test= new HumanTest();
		test.readJsonWithObjectMapper();
		test.readPersonalInformation();
		test.readPhoneNumbers();
	}
	
	public Map<String,String> readPersonalInformation() throws IOException
	 {
		ObjectMapper objectMapper=new ObjectMapper();
		JsonNode rootNode= objectMapper.readTree(new File("Human.json"));
	     JsonNode personalInformationNode = rootNode.get("personalInformation");
	     System.out.println("\n-----------READ PERSONAL INFO-----------------\n");
	     Map<String, String> personalInformationMap = objectMapper.convertValue(personalInformationNode, Map.class);
	     for (Map.Entry<String, String> entry : personalInformationMap.entrySet())
	     {
	    	 System.out.println("\n"+entry.getKey() + "=" + entry.getValue()+"\n");
	     }
	       return personalInformationMap;
	 }
	 public Iterator<JsonNode> readPhoneNumbers() throws JsonProcessingException, IOException{
		 ObjectMapper objectMapper=new ObjectMapper();
			JsonNode rootNode= objectMapper.readTree(new File("Human.json"));
	     JsonNode phoneNumbersNode = rootNode.path("phoneNumbers");
	     Iterator<JsonNode> elements = phoneNumbersNode.elements();
	     System.out.println("\n-----------READ PH.NUMBERS-----------------");
	     while(elements.hasNext()){
	         JsonNode phoneNode = elements.next();
	         System.out.println("\n"+phoneNode.asLong());
	     }
	     return elements;
	 }
	 
	 public void readJsonWithObjectMapper() throws IOException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        Map<?,?> empMap = objectMapper.readValue(new FileInputStream("Human.json"),Map.class);
	        System.out.println("\n----------READ OBJECT-----------------");
	        for (Map.Entry<?, ?> entry : empMap.entrySet())
	        {
	            System.out.println("\n"+entry.getKey() + "=" + entry.getValue()+"\n");
	        }
	    }

}
