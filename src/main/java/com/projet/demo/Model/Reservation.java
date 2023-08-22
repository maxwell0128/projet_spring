package com.projet.demo.Model;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

@Table(name = "reservation")
public class Reservation extends AbstractEntity{
	
	@Column(name="codereservation")
	private String codereservation;
	
	@Column(name="dateArrive")
	private Instant dateArrive;
	
	@Column(name="dateDepart")
	private Instant dateDepart;
	
	//***ici on vas introduire une cle etrangers*** 
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	//***ici on vas introduire une cle etrangers*** 
	
	@ManyToOne
	@JoinColumn(name="idChambre")
	private Chambre chambre;

}
