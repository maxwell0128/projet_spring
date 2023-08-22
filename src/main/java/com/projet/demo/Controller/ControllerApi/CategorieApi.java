package com.projet.demo.Controller.ControllerApi;

import static com.projet.demo.Utils.Constants.App_ROOT;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projet.demo.Dto.Categoriedto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(App_ROOT + "/categorie")
public interface CategorieApi {

	@PostMapping(value = App_ROOT + "/Categories/AjouteCrategorie", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "enregistrer une categorie", notes = "ajouter ou modifier", response = Categoriedto.class)
	@ApiResponses(value = {
			@ApiResponse(code= 200, message= "categorie creer ou modifier"),
			@ApiResponse(code= 400, message= "categorie non valider")
	})
	Categoriedto save(@RequestBody Categoriedto Dto);
	
	@GetMapping(value = App_ROOT + "/Categories/{idCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "rechercher une categorie", notes = "chercher", response = Categoriedto.class)
	@ApiResponses(value = {
			@ApiResponse(code= 200, message= "categorie trouver"),
			@ApiResponse(code= 404, message= "aucune categorie" )
	})
	Categoriedto findById(@PathVariable("idCategorie") Integer id);
	
	@GetMapping(value = App_ROOT + "/Categories/{codecategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "rechercher un code categorie", notes = "cherche code", response = Categoriedto.class)
	@ApiResponses(value = {
			@ApiResponse(code= 200, message= "code categorie trouver"),
			@ApiResponse(code= 404, message= "aucun code  categorie" )
	})
	Categoriedto findBycodecategorie(@PathVariable("codecategorie") String codecategorie);
	
	@GetMapping(value = App_ROOT + "/Categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "affiche liste categorie", notes = "cherche la liste categorie", responseContainer = "List<Categoriedto>")
	@ApiResponses(value = {
			@ApiResponse(code= 200, message= "liste des categorie")
	})
	List<Categoriedto> findAll();

	@DeleteMapping(value = App_ROOT + "/Categories/SupprimerCategorie/{idCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "supprimer une categorie", notes = "supprimer", response = Categoriedto.class)
	@ApiResponses(value = {
			@ApiResponse(code= 200, message= "la categorie a ete supprimer")
	})
	void delete(@PathVariable("idCategorie") Integer id);
}
