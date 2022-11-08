package com.BSR.FinalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BSR.FinalProject.dto.TripsStopDto;
import com.BSR.FinalProject.entity.Trip;
@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
	  List<Trip> findBySourceStopAndDesStop(Integer text, Integer text2);
	  
	
	  
//	  Query Join Column
	  @Query(value = "SELECT new com.BSR.FinalProject.dto.TripsStopDto(t.fare,t.journeyTime,b.name,s.detail)"
				+ " FROM Trip t " + "INNER JOIN Stop s ON s._id = t.sourceStop INNER JOIN Agency b ON t.agency = b._id")
	  List<TripsStopDto> getAllTripStop();
	  
	  

}
