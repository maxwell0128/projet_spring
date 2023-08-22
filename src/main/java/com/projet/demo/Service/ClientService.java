package com.projet.demo.Service;

import java.util.List;

import com.projet.demo.Dto.Clientdto;


public interface ClientService {

	Clientdto save(Clientdto dto);
	
	Clientdto findById(Integer id);
	
	Clientdto findByemail(String email);
	
	List<Clientdto> findAll();

	void delete(Integer id);
}
