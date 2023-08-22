package com.projet.demo.Dto;

import java.time.Instant;

import com.projet.demo.Model.Reservation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reservationdto {
	
	private Integer id ;
	
	private String codereservation;
	
	private Instant dateArrive;
	
	private Instant dateDepart;
	
	private Clientdto client;
	
	private Chambredto chambre;
	
	
	public static Reservationdto fromEntity(Reservation reservation) {
		if (reservation == null) {
			return null;
		}
		return Reservationdto.builder()
			.id(reservation.getId())
			.codereservation(reservation.getCodereservation())
			.dateArrive(reservation.getDateArrive())
			.dateDepart(reservation.getDateDepart())
			.client(Clientdto.fromEntity(reservation.getClient()))
			.chambre(Chambredto.fromEntity(reservation.getChambre()))
			.build();
		
	}
	
	public static Reservation toEntity(Reservationdto reservationdto) {
		if (reservationdto == null) {
			return null;
		}
		Reservation reservation = new Reservation();
			reservation.setId(reservationdto.getId());
			reservation.setCodereservation(reservationdto.getCodereservation());
			reservation.setDateArrive(reservationdto.getDateArrive());
			reservation.setDateDepart(reservationdto.getDateDepart());
			return reservation;
		
	}


}
