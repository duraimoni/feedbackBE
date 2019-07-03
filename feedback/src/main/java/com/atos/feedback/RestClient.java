package com.atos.feedback;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.atos.feedback.vo.DomainVO;

public class RestClient {
	public static void main(String args[]) {
		postCallTest();
	}

	private static void getCallTest() {
		final String uri = "http://localhost:8080/feedback/user/all";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity entity = new HttpEntity("");
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}

	private static void postCallTest() {
		final String uri = "http://localhost:8080/feedback/login/test";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new MyErrorHandler());
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		DomainVO domainVO = new DomainVO();
		HttpEntity<DomainVO> entity = new HttpEntity<DomainVO>(domainVO, headers);
		String responseVal = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class).getBody();
		System.out.println(responseVal);
	}
}

class MyErrorHandler implements ResponseErrorHandler {
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		System.out.println("re" + response.getStatusCode());
	}

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return true;
	}
}
