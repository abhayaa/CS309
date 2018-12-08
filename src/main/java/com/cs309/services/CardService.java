package com.cs309.services;

import java.util.List;

import java.util.Optional;

import com.cs309.users.BusinessCard;

public interface CardService {

	List<BusinessCard> getAll();

	Optional<BusinessCard> getbyId(int id);

	BusinessCard save(BusinessCard card);

	void remove(int id);

}