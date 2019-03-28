package com.ang.ex.web;

import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ang.ex.entites.Contact;

public class RestClientUtil {

	public static Contact[] getAllContactsDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/contacts";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Contact[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Contact[].class);
		Contact[] contacts = responseEntity.getBody();
		return contacts;
	}

	public static void addContactDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/contacts";
		Contact objContact = new Contact(null, "NOM", "PRENOM", new Date(), "email@gmail.com", "tel", "IMG");
		HttpEntity<Contact> requestEntity = new HttpEntity<Contact>(objContact, headers);
		restTemplate.postForLocation(url, requestEntity);
	}

	public static void main(String args[]) {
		RestClientUtil.addContactDemo();
		Contact[] contacts = RestClientUtil.getAllContactsDemo();
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
}