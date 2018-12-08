package com.cs309.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs309.system.CompanyRepository;
import com.cs309.users.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository compRepo;

	@Override
	public List<Company> getAll() {
		return compRepo.findAll();
	}

	@Override
	public Optional<Company> getbyId(int id) {
		return compRepo.findById((long) id);
	}

	@Override
	public Company save(Company company) {
		return compRepo.saveAndFlush(company);
	}

	@Override
	public void remove(int id) {
		compRepo.deleteById((long) id);
	}

}
