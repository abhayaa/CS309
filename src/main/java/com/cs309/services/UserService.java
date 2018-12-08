package com.cs309.services;

import java.util.List;

import java.util.Optional;

import com.cs309.users.Users;

public interface UserService {

	List<Users> getAll();

	Optional<Users> getbyId(int id);

	Users save(Users user);

	void remove(int id);

	public Users userLogin(String username, String password);

	
}
