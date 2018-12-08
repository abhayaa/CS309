package com.cs309.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs309.system.UserRepository;
import com.cs309.users.Users;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImp implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public Optional<Users> getbyId(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById((long) id);
	}

	@Override
	public Users save(Users user) {
		return userRepo.saveAndFlush(user);
	}

	@Override
	public void remove(int id) {
		userRepo.deleteById((long) id);
	}

	@Override
	public Users userLogin(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public Users findUserByEmail(String username) {
		return userRepo.findByUsername(username);
	}
}
