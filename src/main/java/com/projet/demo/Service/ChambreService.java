package com.projet.demo.Service;

import java.util.List;

import com.projet.demo.Dto.Chambredto;

public interface ChambreService {
	Chambredto save(Chambredto dto);
	
	Chambredto findById(Integer id);
	
	Chambredto findBynumchambre(String numchambre);
	
	List<Chambredto> findAll();

	void delete(Integer id);

}
