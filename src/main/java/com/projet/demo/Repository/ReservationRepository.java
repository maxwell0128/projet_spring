package com.projet.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.demo.Model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	Optional<Reservation> findByCodereservation(String codereservation);

}
