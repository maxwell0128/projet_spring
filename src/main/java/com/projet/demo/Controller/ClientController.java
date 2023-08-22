package com.projet.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projet.demo.Controller.ControllerApi.ClientApi;
import com.projet.demo.Dto.Clientdto;
import com.projet.demo.Service.ClientService;



public class ClientController implements ClientApi {
	
private ClientService clientService;
	
	@Autowired
	public ClientController(
		ClientService clientService
		) {
		this.clientService = clientService;
	}
	
	@Override
	public Clientdto save(Clientdto dto) {
		return clientService.save(dto);
	}

	@Override
	public Clientdto findById(Integer id) {
		return clientService.findById(id);
	}

	@Override
	public Clientdto findByemail(String email) {
		return clientService.findByemail(email);
	}

	@Override
	public List<Clientdto> findAll() {
		return clientService.findAll();
	} 

	@Override
	public void delete(Integer id) {
		clientService.delete(id);
	}

}
