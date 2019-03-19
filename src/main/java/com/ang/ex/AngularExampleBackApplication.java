package com.ang.ex;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ang.ex.dao.ContactRepository;
import com.ang.ex.entites.Contact;

@SpringBootApplication
public class AngularExampleBackApplication implements CommandLineRunner{

	@Autowired
	ContactRepository contactRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AngularExampleBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		contactRepository.save(new Contact(null,"Saadi","Melek", new Date(),"saadi.melek@gmail.com","22261785","IMG"));
		contactRepository.save(new Contact(null,"Zitoun","Houssem", new Date(),"zitoun.houssem@gmail.com","22261785","IMG"));
		contactRepository.save(new Contact(null,"Saoudi","Mohamed", new Date(),"saoudi.mohamed@gmail.com","22261785","IMG"));
		contactRepository.save(new Contact(null,"Hasni","Badis", new Date(),"hasni.badis@gmail.com","22261785","IMG"));
		contactRepository.save(new Contact(null,"Garraoui","Marwen", new Date(),"garraoui.marwen@gmail.com","22261785","IMG"));
		contactRepository.save(new Contact(null,"Achouri","Oussama", new Date(),"achouri.oussama@gmail.com","22261785","IMG"));
	}

}

