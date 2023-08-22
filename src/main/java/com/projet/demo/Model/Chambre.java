package com.projet.demo.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

@Table(name = "chambre")
public class Chambre extends AbstractEntity{
	
	//creation des colonnes ***ici il y'a une abstraction*** 
	
	@Column(name="numchambre")
	private String numchambre;
	
	@Column(name="infochambre")
	private String infochambre;
	
	@Column(name="numplacechambre")
	private String numplacechambre;
	
	@Column(name="photoP")
	private String photoP;
	
	@Column(name="photo1")
	private String photo1;

	@Column(name="photo2")
	private String photo2;

	@Column(name="photo3")
	private String photo3;
	
	//***ici on vas introduire une cle etrangers*** 
	@ManyToOne
	@JoinColumn(name="idcategorie")
	private Categorie categorie;
	
	//***ici l'ID sera utiliser comme cle etrangers*** 
	@OneToMany(mappedBy = "chambre")
	private List<Reservation> reservation;

}
