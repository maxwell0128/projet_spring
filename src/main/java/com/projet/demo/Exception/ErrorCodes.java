package com.projet.demo.Exception;

public enum ErrorCodes {
	CHAMBRES_NOT_FOUND(1000),
	CHAMBRES_NOT_VALID(1001),
	CATEGORIE_NOT_FOUND(2000),
	CATEGORIE_NOT_VALID(2001),
	CLIENT_NOT_FOUND(3000),
	CLIENT_NOT_VALID(3001),
	RESERVATION_NOT_FOUND(4000),
	RESERVATION_NOT_VALID(4001),
	;
	private int code;
	
	ErrorCodes(int code){
		this.code = code;
	}
	public int getCode() {
		return code;
	}

}
