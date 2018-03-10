package com.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.extract.entity.ManagersEntity;
import com.extract.entity.ManagersPrimaryKey;
public interface ManagerRepository extends JpaRepository<ManagersEntity, ManagersPrimaryKey>  {
	
	public ManagersEntity findByOffice(String office); 

}
