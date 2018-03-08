package com.extract.application;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.NameRespone;
import dto.SortResponse;

public interface UserRepository extends JpaRepository<User, Integer> {
public User findByName(String name);                                          
public User findById(int ID);
public List<User> findAllByOrderByNameAsc();
public List<User> findAllByOrderByAddressAsc();
public List<User> findAllByOrderByNameDesc();
}
