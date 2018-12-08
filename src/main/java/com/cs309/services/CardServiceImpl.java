package com.cs309.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs309.system.BusinessCardRepository;
import com.cs309.users.BusinessCard;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private BusinessCardRepository cardRepo;

	@Override
	public List<BusinessCard> getAll() {
		return cardRepo.findAll();
	}

	@Override
	public void remove(int id) {
		cardRepo.deleteById((long) id);
	}

	@Override
	public Optional<BusinessCard> getbyId(int id) {
		return cardRepo.findById((long) id);
	}

	@Override
	public BusinessCard save(BusinessCard card) {
		return cardRepo.saveAndFlush(card);
	}

}