package com.zps.qr.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zps.qr.db.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String username);

}

