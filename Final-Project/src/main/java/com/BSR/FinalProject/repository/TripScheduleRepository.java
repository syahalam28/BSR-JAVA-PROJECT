package com.BSR.FinalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BSR.FinalProject.dto.TripScheduleDto;
import com.BSR.FinalProject.entity.Tripschedule;

@Repository
public interface TripScheduleRepository extends JpaRepository<Tripschedule, Integer> {
//List<TripSchedule> findAllByTrip_trip(Integer trip);
//	List<Tripschedule> findByTripDate(String text);

//	Query Join Column
	@Query(value = "SELECT new com.BSR.FinalProject.dto.TripScheduleDto(r.fare,r.journeyTime,t.tripDate,t.avalableSeats,s.detail,b.code,b.capasity,b.make)"
			+ " FROM Tripschedule t "
			+ "INNER JOIN Trip r ON t.tripDetail = r._id INNER JOIN Stop s ON r.sourceStop = s._id INNER JOIN Bus b ON r.bus = b._id WHERE t.tripDate = :inputtripDetail")
//	List<TripScheduleDto> getAllTripSchedule();
	List<TripScheduleDto> getAllTripSchedule(String inputtripDetail);

	@Query(value = "SELECT new com.BSR.FinalProject.dto.TripScheduleDto(r.fare,r.journeyTime,t.tripDate,t.avalableSeats,s.detail,b.code,b.capasity,b.make)"
			+ " FROM Tripschedule t "
			+ "INNER JOIN Trip r ON t.tripDetail = r._id INNER JOIN Stop s ON r.sourceStop = s._id INNER JOIN Bus b ON r.bus = b._id")
	List<TripScheduleDto> getTripSchedule();

}
