package com.BSR.FinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BSR.FinalProject.entity.Stop;

@Repository
public interface StopRepository extends JpaRepository<Stop, Integer> {

}
