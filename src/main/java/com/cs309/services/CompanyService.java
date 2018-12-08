package com.cs309.services;

import java.util.List;
import java.util.Optional;

import com.cs309.users.Company;

public interface CompanyService {

	List<Company> getAll();

	Optional<Company> getbyId(int id);

	Company save(Company company);

	void remove(int id);


}
