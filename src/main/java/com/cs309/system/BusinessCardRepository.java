package com.cs309.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs309.users.BusinessCard;

public interface BusinessCardRepository extends JpaRepository<BusinessCard, Long> {

	public List<BusinessCard> getById(Long id);
	
}

