package com.xie.elem.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xie.elem.jpa.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	User findByUsernameAndPassword(String username, String password);

	Boolean existsByUsername(String username);

	@Query(value = "from User u where u.username=:username")
	User findUser(@Param("username") String username);

	// Boolean existsByUsername(String username);

}
