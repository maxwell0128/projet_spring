package com.projet.demo.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import com.projet.demo.Dto.Categoriedto;
import com.projet.demo.Exception.*;
import com.projet.demo.Model.Categorie;
import com.projet.demo.Repository.CategorieRepository;
import com.projet.demo.Service.CategorieService;
import com.projet.demo.Validateur.ValCategorie;


@Service
@Slf4j
public class CategorieServiceImpli implements CategorieService {

	private CategorieRepository categorieRepository;
	
	@Autowired
	public CategorieServiceImpli(
		CategorieRepository categorieRepository
			) {
		this.categorieRepository = categorieRepository;
	}
	

	@Override
	public Categoriedto save(Categoriedto dto) {
		List<String> errors = ValCategorie.validateur(dto);
		if (!errors.isEmpty()) {
			log.error("categorie is not valid {}", dto);
			throw new EntityInvalidException("la categorie n'est pas valider",ErrorCodes.CATEGORIE_NOT_VALID,errors);
		}
		return Categoriedto.fromEntity(categorieRepository.save(
				Categoriedto.toEntity(dto)));
	}

	@Override
	public Categoriedto findById(Integer id) {
		if (id==null) {
			log.error("cartegorie id is null");
			return null;
		}
		Optional<Categorie> categorie = categorieRepository.findById(id);
		
		Categoriedto dto = Categoriedto.fromEntity(categorie.get());
 		
		return Optional.of(dto).orElseThrow(()->
			new EntityNotFoundException(
					"Aucun categorie avec l'ID" + id + "n'a ete trouve dans la base de donnee",
					ErrorCodes.CATEGORIE_NOT_FOUND)
			);
	}

	@Override
	public Categoriedto findBycodecategorie(String codecategorie) {
		if (!StringUtils.hasLength(codecategorie)) {
			log.error("categorie codecategorie is null");
			return null;
		}
		
		Optional<Categorie> categorie = categorieRepository.findByCodecategorie(codecategorie);
				
				Categoriedto dto = Categoriedto.fromEntity(categorie.get());
		 		
				return Optional.of(dto).orElseThrow(()->
					new EntityNotFoundException(
							"Aucune code cartegorie" + codecategorie + "n'a ete trouve dans la base de donnee",
							ErrorCodes.CATEGORIE_NOT_FOUND)
					);
	}

	@Override
	public List<Categoriedto> findAll() {
		return categorieRepository.findAll().stream()
				.map(Categoriedto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id==null) {
			log.error("categorie id is null");
			return ;
		}
		categorieRepository.deleteById(id);
		
	}

}
