package com.cs309.system;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cs309.users.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	public List<Company> getById(Long id);
	
	Company findByUsername(String username);

}
