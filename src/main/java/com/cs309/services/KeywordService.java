package com.cs309.services;

import java.util.List;
import java.util.Optional;

import com.cs309.users.Keywords;

public interface KeywordService {

	List<Keywords> getAll();
	
	Optional<Keywords> getById(int id);
	
	Keywords save(Keywords keyword);
	
	void remove(int id);
	
}
