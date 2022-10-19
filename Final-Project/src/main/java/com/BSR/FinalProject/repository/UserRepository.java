package com.BSR.FinalProject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BSR.FinalProject.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	Boolean existsByemail(String email);
	
	User findByemail(String email);
	
	User findByrolesId(int rolesId);
	
	Optional<User> findById(Integer id);
	

}
