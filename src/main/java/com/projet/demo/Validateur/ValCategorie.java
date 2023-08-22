package com.projet.demo.Validateur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.projet.demo.Dto.Categoriedto;

public class ValCategorie {
	public static List<String> validateur(Categoriedto categoriedto){
		List<String> erros = new ArrayList<String>();
		
		if (categoriedto == null) {
			erros.add("veuillez renseigner le code de la categrie");
			erros.add("veuillez renseigner la classe de la categrie");
			erros.add("veuillez renseigner le prix heure de la categrie");
			erros.add("veuillez renseigner le prix jours de la categrie");
			erros.add("veuillez renseigner le prix weekends categrie");
			erros.add("veuillez renseigner le prix mois categrie");
			
			return erros;
			
		}
		if (!StringUtils.hasLength(categoriedto.getCodecategorie())) {
			erros.add("veuillez renseigner le code de la categrie");
		}
		if (!StringUtils.hasLength(categoriedto.getClasse())) {
			erros.add("veuillez renseigner la classe de la categrie");
		}
		if (!StringUtils.hasLength(categoriedto.getPrixheure())) {
			erros.add("veuillez renseigner le prix heure de la categrie");
		}
		if (!StringUtils.hasLength(categoriedto.getPrixjours())) {
			erros.add("veuillez renseigner le prix jours de la categrie");
		}
		if (!StringUtils.hasLength(categoriedto.getPrixweekends())) {
			erros.add("veuillez renseigner le prix weekends de la categrie");
		}
		if (!StringUtils.hasLength(categoriedto.getPrixsemaine())) {
			erros.add("veuillez renseigner le prix semaine de la categrie");
		}
		if (!StringUtils.hasLength(categoriedto.getPrixmois())) {
			erros.add("veuillez renseigner le prix mois de la categrie");
		}
		return erros;
	}

}
