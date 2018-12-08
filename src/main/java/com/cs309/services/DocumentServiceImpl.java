package com.cs309.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs309.system.DocumentRepository;
import com.cs309.users.Documents;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository docRepo;

	@Override
	public List<Documents> getAll() {
		return docRepo.findAll();
	}

	@Override
	public Optional<Documents> getbyId(int id) {
		return docRepo.findById((long) id);
	}

	@Override
	public Documents save(Documents document) {
		return docRepo.saveAndFlush(document);
	}

	@Override
	public void remove(int id) {
		docRepo.deleteById((long) id);
	}

}