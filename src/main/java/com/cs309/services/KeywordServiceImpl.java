package com.cs309.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs309.system.KeywordRepository;
import com.cs309.users.Keywords;

@Service
public class KeywordServiceImpl implements KeywordService {

	@Autowired
	private KeywordRepository keyRepo;

	@Override
	public List<Keywords> getAll() {
		return keyRepo.findAll();
	}

	@Override
	public Optional<Keywords> getById(int id) {
		return keyRepo.findById((long) id);
	}

	@Override
	public Keywords save(Keywords keyword) {
		return keyRepo.saveAndFlush(keyword);
	}

	@Override
	public void remove(int id) {
		keyRepo.deleteById((long) id);
	}

}
