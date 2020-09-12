package com.utc.bis;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utc.dip.Transaction;

public class Tester {

	public static void main(String[] args) throws JsonProcessingException {
		Transaction transaction = new Transaction("transfer", new Date());

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		String output = objectMapper.writeValueAsString(transaction);

		System.out.println(output);

	}

}
