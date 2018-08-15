package com.xie.elem.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xie.elem.jpa.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long>{
	Store findByName(String name);
	
	Store findById(long id);
	
	Boolean existsByName(String name);

	@Query(value = "from Store u where u.name=:name")
	Store findStore(@Param("name") String name);
}
