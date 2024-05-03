package com.iastech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iastech.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
