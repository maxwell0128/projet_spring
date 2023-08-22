package com.projet.demo.Controller.ControllerApi;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projet.demo.Dto.Chambredto;

import static com.projet.demo.Utils.Constants.App_ROOT;

public interface ChambreApi {

	@PostMapping(value = App_ROOT + "/Chambres/AjouterChambres", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	Chambredto save(@RequestBody Chambredto Dto);
	
	@GetMapping(value = App_ROOT + "/Chambres/{idChambre}", produces = MediaType.APPLICATION_JSON_VALUE)
	Chambredto findById(@PathVariable("idChambre") Integer id);
	
	@GetMapping(value = App_ROOT + "/Chambres/{numchambre}", produces = MediaType.APPLICATION_JSON_VALUE)
	Chambredto findBynumchambre(@PathVariable("numchambre") String numchambre);
	
	@GetMapping(value = App_ROOT + "/Chambres/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Chambredto> findAll();

	@DeleteMapping(value = App_ROOT + "/Chambres/SupprimerChambres/{idChambre}", produces = MediaType.APPLICATION_JSON_VALUE)
	void delete(@PathVariable("idChambre") Integer id);
}
