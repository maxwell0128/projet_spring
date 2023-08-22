package com.projet.demo.Handlers;

import java.util.ArrayList;
import java.util.List;

import com.projet.demo.Exception.ErrorCodes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

	private Integer httpcode;
	private ErrorCodes code;
	private String message;
	private List<String>errors = new ArrayList<String>();
	
}