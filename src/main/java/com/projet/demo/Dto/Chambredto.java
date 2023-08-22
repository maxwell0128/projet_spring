package com.projet.demo.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projet.demo.Model.Chambre;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Chambredto {
	
	private Integer id ;
	
	private String numchambre;
	
	private String infochambre;
	
	private String numplacechambre;
	
	private String photoP;
	
	private String photo1;

	private String photo2;

	private String photo3;
	
	private Categoriedto categorie;
	
	@JsonIgnore
	private List<Reservationdto> reservation;
	
	public static Chambredto fromEntity(Chambre chambre) {
		if (chambre == null) {
			return null;
		}
		return Chambredto.builder()
				.id(chambre.getId())
				.numchambre(chambre.getNumchambre())
				.infochambre(chambre.getInfochambre())
				.numplacechambre(chambre.getNumplacechambre())
				.photoP(chambre.getPhotoP())
				.photo1(chambre.getPhoto1())
				.photo2(chambre.getPhoto2())
				.photo3(chambre.getPhoto3())
				.categorie(Categoriedto.fromEntity(chambre.getCategorie()))
				.build();
		
	}

	public static Chambre toEntity(Chambredto chambredto) {
		if (chambredto == null) {
			return null;
		}
		Chambre chambre = new Chambre();	
				chambre.setId(chambredto.getId());
				chambre.setNumchambre(chambredto.getNumchambre());
				chambre.setInfochambre(chambredto.getInfochambre());
				chambre.setNumplacechambre(chambredto.getNumplacechambre());
				chambre.setPhotoP(chambredto.getPhotoP());
				chambre.setPhoto1(chambredto.getPhoto1());
				chambre.setPhoto2(chambredto.getPhoto2());
				chambre.setPhoto3(chambredto.getPhoto3());
				
				return chambre;
		
	}



}
