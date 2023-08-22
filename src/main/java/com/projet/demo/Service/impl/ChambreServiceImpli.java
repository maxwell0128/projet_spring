package com.projet.demo.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import com.projet.demo.Dto.Chambredto;
import com.projet.demo.Exception.*;
import com.projet.demo.Model.Chambre;
import com.projet.demo.Repository.ChambreRepository;
import com.projet.demo.Service.ChambreService;
import com.projet.demo.Validateur.ValChambre;

@Service
@Slf4j

public class ChambreServiceImpli implements ChambreService{
	
	private ChambreRepository chambreRepository;
	
	@Autowired
	public ChambreServiceImpli(
		ChambreRepository chambreRepository
			) {
		this.chambreRepository = chambreRepository;
	}
	
	@Override
	public Chambredto save(Chambredto dto) {
		List<String> errors = ValChambre.validateur(dto);
		if (!errors.isEmpty()) {
			log.error("chambre is not valid {}", dto);
			throw new EntityInvalidException("la chambre n'est pas laditer",ErrorCodes.CHAMBRES_NOT_VALID,errors);
		}
		return Chambredto.fromEntity(chambreRepository.save(
				Chambredto.toEntity(dto)));
	}

	@Override
	public Chambredto findById(Integer id) {
		if (id==null) {
			log.error("chambre id is null");
			return null;
		}
		Optional<Chambre> chambre = chambreRepository.findById(id);
		
		Chambredto dto = Chambredto.fromEntity(chambre.get());
 		
		return Optional.of(dto).orElseThrow(()->
			new EntityNotFoundException(
					"Aucune chambre avec l'ID" + id + "n'a ete trouve dans la base de donnee",
					ErrorCodes.CHAMBRES_NOT_FOUND)
			);
		
	}

	@Override
	public Chambredto findBynumchambre(String numchambre) {
		if (!StringUtils.hasLength(numchambre)) {
			log.error("chambre numchambre is null");
			return null;
		}
		
		Optional<Chambre> chambre = chambreRepository.findByNumchambre(numchambre);
				
				Chambredto dto = Chambredto.fromEntity(chambre.get());
		 		
				return Optional.of(dto).orElseThrow(()->
					new EntityNotFoundException(
							"Aucune chambre avec le numero" + numchambre + "n'a ete trouve dans la base de donnee",
							ErrorCodes.CHAMBRES_NOT_FOUND)
					);
	}

	@Override
	public List<Chambredto> findAll() {
		return chambreRepository.findAll().stream()
				.map(Chambredto::fromEntity)
				.collect(Collectors.toList());
	}

	
	@Override
	public void delete(Integer id) {
		if (id==null) {
			log.error("chambre id is null");
			return ;
		}
		chambreRepository.deleteById(id);
	}
	
}
