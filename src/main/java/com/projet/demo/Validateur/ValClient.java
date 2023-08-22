package com.projet.demo.Validateur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.projet.demo.Dto.Clientdto;


public class ValClient {

	public static List<String> validateur(Clientdto clientdto){
		List<String> erros = new ArrayList<String>();
		if(clientdto == null) {
			erros.add("veuillez renseigner le nom du client");
			erros.add("veuillez renseigner le prenom du client");
			erros.add("veuillez renseigner l'adresse du client");
			erros.add("veuillez renseigner le numero de telephone");
			erros.add("veuillez renseigner l'email du client");
			erros.add("veuillez renseigner la profession du client");
			
			return erros;
		}
		
		if (!StringUtils.hasLength(clientdto.getNom())) {
			erros.add("veuillez renseigner le nom du client");
		}
		if (!StringUtils.hasLength(clientdto.getPrenom())) {
			erros.add("veuillez renseigner le prenom du client");
		}
		if (!StringUtils.hasLength(clientdto.getAdresse())) {
			erros.add("veuillez renseigner l'adresse du client");
		}
		if (!StringUtils.hasLength(clientdto.getNumtel())) {
			erros.add("veuillez renseigner le numero de telephone");
		}
		if (!StringUtils.hasLength(clientdto.getEmail())) {
			erros.add("veuillez renseigner l'email du client");
		}
		if (!StringUtils.hasLength(clientdto.getProfession())) {
			erros.add("veuillez renseigner la profession du client");
		}
		return erros;
	}

}
