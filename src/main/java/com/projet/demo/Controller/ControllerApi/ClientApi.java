package com.projet.demo.Controller.ControllerApi;

import static com.projet.demo.Utils.Constants.App_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projet.demo.Dto.Clientdto;


public interface ClientApi {
	
	@PostMapping(value = App_ROOT + "/Clients/AjouterClient", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	Clientdto save(@RequestBody Clientdto Dto);
	
	@GetMapping(value = App_ROOT + "/Clients/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
	Clientdto findById(@PathVariable("idClient") Integer id);
	
	@GetMapping(value = App_ROOT + "/Clients/{emailClient}", produces = MediaType.APPLICATION_JSON_VALUE)
	Clientdto findByemail(@PathVariable("emailClient") String email);
	
	@GetMapping(value = App_ROOT + "/Clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Clientdto> findAll();

	@DeleteMapping(value = App_ROOT + "/Clients/SupprimerClient/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
	void delete(@PathVariable("idClient") Integer id);

}
