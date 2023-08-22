package com.projet.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projet.demo.Controller.ControllerApi.ReservationApi;
import com.projet.demo.Dto.Reservationdto;
import com.projet.demo.Service.ReservationService;


public class ReservationController implements ReservationApi{

private ReservationService reservationService;
	
	@Autowired
	public ReservationController(
		ReservationService reservationService
		) {
		this.reservationService = reservationService;
	}
	
	@Override
	public Reservationdto save(Reservationdto dto) {
		return reservationService.save(dto);
	}

	@Override
	public Reservationdto findById(Integer id) {
		return reservationService.findById(id);
	}

	@Override
	public Reservationdto findBycodereservation(String codereservation) {
		return reservationService.findBycodereservation(codereservation);
	}

	@Override
	public List<Reservationdto> findAll() {
		return reservationService.findAll();
	} 

	@Override
	public void delete(Integer id) {
		reservationService.delete(id);
	}
}
