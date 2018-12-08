package com.cs309.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs309.users.Keywords;

public interface KeywordRepository extends JpaRepository<Keywords, Long> {

	public List<Keywords> getById (Long id);
}
