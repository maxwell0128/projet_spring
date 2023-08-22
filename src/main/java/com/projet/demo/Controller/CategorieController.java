package com.projet.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projet.demo.Controller.ControllerApi.CategorieApi;
import com.projet.demo.Dto.Categoriedto;
import com.projet.demo.Service.CategorieService;


public class CategorieController implements CategorieApi{

	private CategorieService categorieService;
	
	@Autowired
	public CategorieController(
		CategorieService categorieService
		) {
		this.categorieService = categorieService;
	}
	
	@Override
	public Categoriedto save(Categoriedto Dto) {
		return categorieService.save(Dto);
	}

	@Override
	public Categoriedto findById(Integer id) {
		return categorieService.findById(id);
	}

	@Override
	public Categoriedto findBycodecategorie(String codecategorie) {
		return categorieService.findBycodecategorie(codecategorie);
	}

	@Override
	public List<Categoriedto> findAll() {
		return categorieService.findAll();
	} 

	@Override
	public void delete(Integer id) {
		categorieService.delete(id);
	}
}
