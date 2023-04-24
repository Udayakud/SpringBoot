package com.example.demo.service;

import com.example.demo.entity.User;

public interface IUserService {

	public Integer saveUser(User user);
	public User findByUsername(String username);
}
