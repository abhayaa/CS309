package com.cs309.services;

import java.util.List;
import java.util.Optional;

import com.cs309.users.Contacts;

public interface ContactService {

	List<Contacts> getAll();

	Optional<Contacts> getbyId(int id);

	Contacts save(Contacts contact);

	

}
