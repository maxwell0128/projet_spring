package com.projet.demo.Service;

import java.util.List;

import com.projet.demo.Dto.Categoriedto;


public interface CategorieService {
	Categoriedto save(Categoriedto dto);
	
	Categoriedto findById(Integer id);

	Categoriedto findBycodecategorie(String codecategorie);
	
	List<Categoriedto> findAll();

	void delete(Integer id);



}
