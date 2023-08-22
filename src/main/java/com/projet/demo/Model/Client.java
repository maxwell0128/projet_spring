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

@Table(name = "client")
public class Client extends AbstractEntity{
	
	//creation des colonnes ***ici il y'a une abstraction*** 

	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="numtel")
	private String numtel;
	
	@Column(name="email")
	private String email;
	
	@Column(name="profession")
	private String profession;
	
	//***ici l'ID sera utiliser comme cle etrangers*** 
	
	@OneToMany(mappedBy = "client")
	private List<Reservation> reservation;
	
	
	
	
	
	
}
