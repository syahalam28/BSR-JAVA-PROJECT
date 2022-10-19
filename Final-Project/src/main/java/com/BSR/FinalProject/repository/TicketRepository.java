package com.BSR.FinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BSR.FinalProject.entity.Ticket;
import com.BSR.FinalProject.entity.Trip;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	  Ticket findBypassenger (int passenger);
}
