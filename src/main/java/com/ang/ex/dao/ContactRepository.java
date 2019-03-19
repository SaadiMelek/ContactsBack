package com.ang.ex.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ang.ex.entites.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

	@Query("select c from Contact c where nom like %:mc%")
	public Page<Contact> chercher(@Param("mc") String mc, Pageable pageable);
}
