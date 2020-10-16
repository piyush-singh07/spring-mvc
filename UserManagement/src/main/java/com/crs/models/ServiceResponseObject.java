package com.crs.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponseObject {
	@JsonProperty("status")
	String status;
	@JsonProperty("message")
	String message;
	@JsonProperty("data")
	JsonNode data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public JsonNode getData() {
		return data;
	}
	public void setData(JsonNode data) {
		this.data = data;
	}
	
	

}
