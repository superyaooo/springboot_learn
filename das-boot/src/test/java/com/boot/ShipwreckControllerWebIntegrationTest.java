package com.boot;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class ShipwreckControllerWebIntegrationTest {

	@Test
	public void testListAll() throws IOException {
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());
		
		assertThat(responseJson.isMissingNode(), is(false));
		assertThat(responseJson.toString(), equalTo("[{\"id\":1,\"name\":\"test\",\"description\":\"test\",\"condition\":\"good\",\"depth\":85,\"latitude\":44.5,\"longitude\":120.5,\"yearDiscovered\":2017}]"));
		assertThat(responseJson.get(0).toString(), equalTo("{\"id\":1,\"name\":\"test\",\"description\":\"test\",\"condition\":\"good\",\"depth\":85,\"latitude\":44.5,\"longitude\":120.5,\"yearDiscovered\":2017}"));
	}
}
