package com.extract.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.extract.dto.NameRespone;
import com.extract.dto.SortResponse;
import com.extract.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
public User findByName(String name);                                          
public User findById(int ID);
public List<User> findAllByOrderByNameAsc();
public List<User> findAllByOrderByAddressAsc();
public List<User> findAllByOrderByNameDesc();
}
