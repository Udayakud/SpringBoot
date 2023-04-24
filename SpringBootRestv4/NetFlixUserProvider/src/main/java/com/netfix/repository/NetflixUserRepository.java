package com.netfix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netfix.model.NetFlixAdminUser;

public interface NetflixUserRepository extends JpaRepository<NetFlixAdminUser,Integer>{

}
