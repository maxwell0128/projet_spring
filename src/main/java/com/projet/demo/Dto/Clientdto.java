package com.projet.demo.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projet.demo.Model.Client;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Clientdto {
	
	private Integer id ;
	
	private String nom;
	
	private String prenom;
	
	private String adresse;
	
	private String numtel;
	
	private String email;
	
	private String profession;
	
	@JsonIgnore
	private List<Reservationdto> reservation;
	
	public static Clientdto fromEntity(Client client) {
		if (client == null) {
			return null;
		}
		return Clientdto.builder()
				.id(client.getId())
				.nom(client.getNom())
				.prenom(client.getPrenom())
				.adresse(client.getAdresse())
				.numtel(client.getNumtel())
				.email(client.getEmail())
				.profession(client.getProfession())
				.build();
		
	}
	
	public static Client toEntity(Clientdto clientdto) {
		if (clientdto == null) {
			return null;
		}
		Client client = new Client();
				client.setId(clientdto.getId());
				client.setNom(clientdto.getNom());
				client.setPrenom(clientdto.getPrenom());
				client.setAdresse(clientdto.getAdresse());
				client.setNumtel(clientdto.getNumtel());
				client.setEmail(clientdto.getEmail());
				client.setProfession(clientdto.getProfession());
				
				return client;
		
	}



}
