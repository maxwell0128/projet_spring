package com.projet.demo.Validateur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.projet.demo.Dto.Reservationdto;


public class ValReservation {


	public static List<String> validateur(Reservationdto reservationdto){
		List<String> erros = new ArrayList<String>();
		
		if(reservationdto == null) {
			erros.add("veuillez renseigner le code de la reservation");
			erros.add("veuillez renseigner la date d'arrive de la reservation");
			erros.add("veuillez renseigner la date de depart de la reservation");
			erros.add("veuillez selectionner le client de la reservation");
			erros.add("veuillez selectionner la chambre de la reservation");
			
			return erros;
		}
		
		if (!StringUtils.hasLength(reservationdto.getCodereservation())) {
			erros.add("veuillez renseigner le code de la reservation");
		}
		if (reservationdto.getDateArrive()== null) {
			erros.add("veuillez renseigner la date d'arrive de la reservation");
		}
		if (reservationdto.getDateDepart()== null) {
			erros.add("veuillez renseigner la date de depart de la reservation");
		}
		if (reservationdto.getClient()==null) {
			erros.add("veuillez selectionner le client de la reservation");
		}
		if (reservationdto.getChambre()==null) {
			erros.add("veuillez selectionner la chambre de la reservation");
		}
		return erros;
	}


	
}
