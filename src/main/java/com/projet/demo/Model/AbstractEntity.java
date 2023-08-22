package com.projet.demo.Model;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable{
	
	//ici on creer une abstration id qui vas etre utiliser dans tous les autres tables   
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@CreatedDate
	@Column(name = "creationDate" , nullable= false)
	@JsonIgnore
	private Instant creationDate;
	
	@LastModifiedDate
	@Column(name = "lastUpdateDate")
	@JsonIgnore
	private Instant lastUpdateDate;
	


}