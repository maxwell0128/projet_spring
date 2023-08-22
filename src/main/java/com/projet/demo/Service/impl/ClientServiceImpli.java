package com.projet.demo.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import com.projet.demo.Dto.Clientdto;
import com.projet.demo.Exception.*;
import com.projet.demo.Model.Client;
import com.projet.demo.Repository.ClientRepository;
import com.projet.demo.Service.ClientService;
import com.projet.demo.Validateur.ValClient;


@Service
@Slf4j
public class ClientServiceImpli implements ClientService{
	
	private ClientRepository clientRepository;
	
	@Autowired
	public ClientServiceImpli(
		ClientRepository clientRepository
			) {
		this.clientRepository =clientRepository;
	}
	

	@Override
	public Clientdto save(Clientdto dto) {
		List<String> errors = ValClient.validateur(dto);
		if (!errors.isEmpty()) {
			log.error("client is not valid {}", dto);
			throw new EntityInvalidException("le client n'est pas valider",ErrorCodes.CLIENT_NOT_VALID,errors);
		}
		return Clientdto.fromEntity(clientRepository.save(
				Clientdto.toEntity(dto)));
	}

	@Override
	public Clientdto findById(Integer id) {
		if (id==null) {
			log.error("Client id is null");
			return null;
		}
		Optional<Client> client = clientRepository.findById(id);
		
		Clientdto dto = Clientdto.fromEntity(client.get());
 		
		return Optional.of(dto).orElseThrow(()->
			new EntityNotFoundException(
					"Aucun client avec l'ID" + id + "n'a ete trouve dans la base de donnee",
					ErrorCodes.CLIENT_NOT_FOUND)
			);
	}

	@Override
	public Clientdto findByemail(String email) {
		if (!StringUtils.hasLength(email)) {
			log.error("client email is null");
			return null;
		}
		
		Optional<Client> client = clientRepository.findByEmail(email);
				
				Clientdto dto = Clientdto.fromEntity(client.get());
		 		
				return Optional.of(dto).orElseThrow(()->
					new EntityNotFoundException(
							"Aucun client avec l'email" + email + "n'a ete trouve dans la base de donnee",
							ErrorCodes.CLIENT_NOT_FOUND)
					);
	}

	@Override
	public List<Clientdto> findAll() {
		return clientRepository.findAll().stream()
				.map(Clientdto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("client id is null");
			return ;
		}
		clientRepository.deleteById(id);
		
	}

}
