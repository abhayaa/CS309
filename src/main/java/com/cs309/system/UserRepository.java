package com.cs309.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs309.users.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	public List<Users> getById(Long id);

	Users findByUsername(String username);

}
