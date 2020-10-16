package com.utc.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.crs.model.creation.GetDBUser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SslTest {
	
	
	public static void main(String[] args) throws KeyStoreException, KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {
		SslTest t= new SslTest();
		t.test();
		
	}
	
	public void test() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, KeyManagementException, UnrecoverableKeyException {
		KeyStore keyStore = KeyStore.getInstance("jks");
		ClassLoader classLoader = getClass().getClassLoader();
		File keystore = new File(classLoader.getResource("client.jks").getFile());
		keyStore.load(new FileInputStream(keystore), "password".toCharArray());
		@SuppressWarnings("deprecation")
		SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
	            new SSLContextBuilder()
	                    .loadTrustMaterial(null, new TrustSelfSignedStrategy())
	                    .loadKeyMaterial(keyStore, "password".toCharArray())
	                    .build(),
	            NoopHostnameVerifier.INSTANCE);
		HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(
		        httpClient);
		RestTemplate template = new RestTemplate(requestFactory);
		String user= template.getForObject("https://localhost:8443/UserManagement/api/users/id/1", String.class);
		ObjectMapper mapper= new ObjectMapper();
		JsonNode rootNode=mapper.readTree(user);
		JsonNode statusNode=rootNode.get("status");
		System.out.println(statusNode.asText());
		JsonNode dataNode=rootNode.get("data");
		System.out.println(dataNode.get("emailId").asText());
		

	}
	
	
	
	
	

}
