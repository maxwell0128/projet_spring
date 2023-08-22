package com.projet.demo.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import com.projet.demo.Dto.Reservationdto;
import com.projet.demo.Exception.*;
import com.projet.demo.Model.Reservation;
import com.projet.demo.Repository.ReservationRepository;
import com.projet.demo.Service.ReservationService;
import com.projet.demo.Validateur.ValReservation;


@Service
@Slf4j
public class ReservationServiceImpli implements ReservationService {
	
	private ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationServiceImpli(
		ReservationRepository reservationRepository
			) {
		this.reservationRepository = reservationRepository;
	}
	

	@Override
	public Reservationdto save(Reservationdto dto) {
		List<String> errors = ValReservation.validateur(dto);
		if (!errors.isEmpty()) {
			log.error("reservation is not valid {}", dto);
			throw new EntityInvalidException("la reservation n'est pas valider",ErrorCodes.RESERVATION_NOT_VALID,errors);
		}
		return Reservationdto.fromEntity(reservationRepository.save(
				Reservationdto.toEntity(dto)));
	}

	@Override
	public Reservationdto findById(Integer id) {
		if (id==null) {
			log.error("reservation id is null");
			return null;
		}
		Optional<Reservation> reservation = reservationRepository.findById(id);
		
		Reservationdto dto = Reservationdto.fromEntity(reservation.get());
 		
		return Optional.of(dto).orElseThrow(()->
			new EntityNotFoundException(
					"Aucune reservation avec l'ID" + id + "n'a ete trouve dans la base de donnee",
					ErrorCodes.RESERVATION_NOT_FOUND)
			);
	}

	@Override
	public Reservationdto findBycodereservation(String codereservation) {
		if (!StringUtils.hasLength(codereservation)) {
			log.error("reservation code is null");
			return null;
		}
		
		Optional<Reservation> reservation = reservationRepository.findByCodereservation(codereservation);
				
				Reservationdto dto = Reservationdto.fromEntity(reservation.get());
		 		
				return Optional.of(dto).orElseThrow(()->
					new EntityNotFoundException(
							"Aucune reservation avec le code" + codereservation + "n'a ete trouve dans la base de donnee",
							ErrorCodes.RESERVATION_NOT_FOUND)
					);
	}

	@Override
	public List<Reservationdto> findAll() {
		return reservationRepository.findAll().stream()
				.map(Reservationdto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id==null) {
			log.error("reservation id is null");
			return ;
		}
		reservationRepository.deleteById(id);
		
	}

}
