package com.cs309.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs309.system.ContactRepository;
import com.cs309.users.Contacts;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contRepo;

	@Override
	public List<Contacts> getAll() {
		return contRepo.findAll();
	}

	@Override
	public Optional<Contacts> getbyId(int id) {
		return contRepo.findById((long) id);
	}

	@Override
	public Contacts save(Contacts contact) {
		return contRepo.saveAndFlush(contact);
	}

	

}
