package com.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{
public UserModel findByUsernameAndPassword(String username,String password);
}
