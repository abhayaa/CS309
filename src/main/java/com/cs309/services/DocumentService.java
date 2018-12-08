package com.cs309.services;

import java.util.List;

import java.util.Optional;

import com.cs309.users.Documents;


public interface DocumentService {
	
	List<Documents> getAll();
	
	Optional<Documents> getbyId(int id);
	
	Documents save(Documents document);
	
	void remove(int id);
	
}
