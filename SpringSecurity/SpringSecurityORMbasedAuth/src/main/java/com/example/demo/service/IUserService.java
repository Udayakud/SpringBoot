package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.User;

public interface IUserService {

	Integer saveUser(User user);
	Optional<User> getOneUser(Integer id);
}
