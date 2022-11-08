package com.BSR.FinalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BSR.FinalProject.entity.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Integer> {
//	Melakukan Pencarian Data Berdasarkan Owner
	List<Agency> findByOwner(int owner);
	
//	Agency findByOwner(int owner);
	

}
