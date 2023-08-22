package com.projet.demo.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projet.demo.Model.Categorie;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Categoriedto {

	private Integer id ;
	
	private String codecategorie;
	
	private String classe;
	
	private String prixheure;
	
	private String prixjours;
	
	private String prixsemaine;
	
	private String prixweekends;
	
	private String prixmois;
	
	@JsonIgnore
	private List<Chambredto> chambres;
	
	public static Categoriedto fromEntity(Categorie categorie) {
		if (categorie == null) {
			return null;
		}
		return Categoriedto.builder()
				.id(categorie.getId())
				.codecategorie(categorie.getCodecategorie())
				.classe(categorie.getClasse())
				.prixheure(categorie.getPrixheure())
				.prixjours(categorie.getPrixjours())
				.prixsemaine(categorie.getPrixsemaines())
				.prixweekends(categorie.getPrixweekends())
				.prixmois(categorie.getPrixmois())
				.build();
		
	}
	
	public static Categorie toEntity(Categoriedto categoriedto) {
		if (categoriedto == null) {
			return null;
		}
		Categorie categorie = new Categorie();
				categorie.setId(categoriedto.getId());
				categorie.setCodecategorie(categoriedto.getCodecategorie());
				categorie.setClasse(categoriedto.getClasse());
				categorie.setPrixheure(categoriedto.getPrixheure());
				categorie.setPrixjours(categoriedto.getPrixjours());
				categorie.setPrixsemaines(categoriedto.getPrixsemaine());
				categorie.setPrixweekends(categoriedto.getPrixweekends());
				categorie.setPrixmois(categoriedto.getPrixmois());
				
				return categorie;
	}

}
