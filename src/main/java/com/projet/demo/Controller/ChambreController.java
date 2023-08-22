package com.projet.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.projet.demo.Controller.ControllerApi.ChambreApi;
import com.projet.demo.Dto.Chambredto;
import com.projet.demo.Service.ChambreService;

@RestController
public class ChambreController implements ChambreApi {

	private ChambreService chambreService;
	
	@Autowired
	public ChambreController(
		ChambreService chambreService
		) {
		this.chambreService = chambreService;
	}
	
	@Override
	public Chambredto save(Chambredto dto) {
		return chambreService.save(dto);
	}

	@Override
	public Chambredto findById(Integer id) {
		return chambreService.findById(id);
	}

	@Override
	public Chambredto findBynumchambre(String numchambre) {
		return chambreService.findBynumchambre(numchambre);
	}

	@Override
	public List<Chambredto> findAll() {
		return chambreService.findAll();
	} 

	@Override
	public void delete(Integer id) {
		chambreService.delete(id);
	}

}
