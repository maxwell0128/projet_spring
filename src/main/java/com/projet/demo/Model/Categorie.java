package com.projet.demo.Model;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity

//creation de table 

@Table(name = "categorie")
public class Categorie extends AbstractEntity {
	
	//creation des colonnes ***ici il y'a une abstraction*** 
	
	@Column(name="codecategorie")
	private String codecategorie;
	
	@Column(name="classe")
	private String classe;
	
	@Column(name="prixheure")
	private String prixheure;
	
	@Column(name="prixjours")
	private String prixjours;
	
	@Column(name="prixsemaines")
	private String prixsemaines;
	
	@Column(name="prixweekends")
	private String prixweekends;
	
	@Column(name="prixmois")
	private String prixmois;
	
	//***ici l'ID sera utiliser comme cle etrangers*** 
	@OneToMany(mappedBy = "categorie")
	private List<Chambre> chambres;

}
