package com.projet.demo.Service;

import java.util.List;

import com.projet.demo.Dto.Reservationdto;

public interface ReservationService {

	Reservationdto save(Reservationdto dto);
	
	Reservationdto findById(Integer id);
	
	Reservationdto findBycodereservation(String codereservation);
	
	List<Reservationdto> findAll();

	void delete(Integer id);
}
