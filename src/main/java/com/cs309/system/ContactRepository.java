package com.cs309.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs309.users.Contacts;

public interface ContactRepository extends JpaRepository<Contacts, Long> {


	public List<Contacts> getByusername(String name);
}
