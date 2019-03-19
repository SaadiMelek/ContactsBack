package com.ang.ex.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ang.ex.dao.ContactRepository;
import com.ang.ex.entites.Contact;

@CrossOrigin("*")
@RestController
public class ContactsController {

	@Autowired
	ContactRepository contactRepository;

	@GetMapping("/contacts")
	public List<Contact> allContacts() {
		return contactRepository.findAll();
	}

	@GetMapping("/chercherContacts")
	public Page<Contact> chercherContacts(@RequestParam(value = "mc", defaultValue = "") String mc,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		return contactRepository.chercher(mc, new PageRequest(page, size));
	}

	@GetMapping("/contacts/{id}")
	public Contact getAllContact(@PathVariable("id") Long id) {
		return contactRepository.findOne(id);
	}

	@PostMapping("/contacts")
	public Contact getContact(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}

	@DeleteMapping("/contacts/{id}")
	public void deleteContact(@PathVariable("id") Long id) {
		contactRepository.delete(id);
	}

	@PutMapping("/contacts/{id}")
	public Contact update(@PathVariable("id") Long id, @RequestBody Contact contact) {
		contact.setId(id);
		return contactRepository.save(contact);
	}

}
