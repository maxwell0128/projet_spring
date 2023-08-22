package com.projet.demo.Controller.ControllerApi;

import static com.projet.demo.Utils.Constants.App_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projet.demo.Dto.Reservationdto;


public interface ReservationApi {
	
	@PostMapping(value = App_ROOT + "/Reservations/AjouterReservation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	Reservationdto save(@RequestBody Reservationdto Dto);
	
	@GetMapping(value = App_ROOT + "/Reservations/{idReservation}", produces = MediaType.APPLICATION_JSON_VALUE)
	Reservationdto findById(@PathVariable("idReservation") Integer id);
	
	@GetMapping(value = App_ROOT + "/Reservations/{codereservation}", produces = MediaType.APPLICATION_JSON_VALUE)
	Reservationdto findBycodereservation(@PathVariable("codereservation") String codereservation);
	
	@GetMapping(value = App_ROOT + "/Reservations/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Reservationdto> findAll();

	@DeleteMapping(value = App_ROOT + "/Reservations/SupprimerReservation/{idReservation}", produces = MediaType.APPLICATION_JSON_VALUE)
	void delete(@PathVariable("idReservation") Integer id);

}
