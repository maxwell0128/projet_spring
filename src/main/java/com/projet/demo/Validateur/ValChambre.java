package com.projet.demo.Validateur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.projet.demo.Dto.Chambredto;


public class ValChambre {

	public static List<String> validateur(Chambredto chambredto){
		List<String> erros = new ArrayList<String>();
		
		if(chambredto == null) {
			erros.add("veuillez renseigner le numero de la chambre");
			erros.add("veuillez renseigner les infomartion de la chambre");
			erros.add("veuillez renseigner le numbre de place de la chambre");
			erros.add("veuillez renseigner la photo principal de la chambre");
			erros.add("veuillez renseigner la photo 1 de la chambre");
			erros.add("veuillez renseigner la photo 2 de la chambre");
			erros.add("veuillez renseigner la photo 3 de la chambre");
			
			return erros;
		}
		
		if (!StringUtils.hasLength(chambredto.getNumchambre())) {
			erros.add("veuillez renseigner le numero de la chambre");
		}
		if (!StringUtils.hasLength(chambredto.getInfochambre())) {
			erros.add("veuillez renseigner les infomartion de la chambre");
		}
		if (!StringUtils.hasLength(chambredto.getNumplacechambre())) {
			erros.add("veuillez renseigner le numbre de place de la chambre");
		}
		if (!StringUtils.hasLength(chambredto.getPhotoP())) {
			erros.add("veuillez renseigner la photo principal de la chambre");
		}
		if (!StringUtils.hasLength(chambredto.getPhoto1())) {
			erros.add("veuillez renseigner la photo 1 de la chambre");
		}
		if (!StringUtils.hasLength(chambredto.getPhoto2())) {
			erros.add("veuillez renseigner la photo 2 de la chambre");
		}
		if (!StringUtils.hasLength(chambredto.getPhoto3())) {
			erros.add("veuillez renseigner la photo 3 de la chambre");
		}
		if (chambredto.getCategorie()==null) {
			erros.add("veuillez selectionner une categorie pour la chambre");
		}
		return erros;
	}

	
}
