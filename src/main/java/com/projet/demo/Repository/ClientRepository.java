package com.projet.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.demo.Model.Client;

public interface ClientRepository extends JpaRepository<Client , Integer>{

	Optional<Client> findByEmail(String email);

}
