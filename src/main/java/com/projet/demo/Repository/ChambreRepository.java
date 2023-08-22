package com.projet.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.demo.Model.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre,Integer>{

	Optional<Chambre> findByNumchambre(String numchambre);
}
