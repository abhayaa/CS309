package com.cs309.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs309.users.Documents;

public interface DocumentRepository extends JpaRepository<Documents, Long> {

	public List<Documents> getById(Long id);

	public List<Documents> findByusername(String name);

}
