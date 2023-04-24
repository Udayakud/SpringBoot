package com.example.demo.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;



public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUserEmail(String userEmail);
}
