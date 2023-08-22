package com.projet.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.demo.Model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer>{

	Optional<Categorie> findByCodecategorie(String codecategorie);

	

}
