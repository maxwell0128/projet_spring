package com.projet.demo.Service;

import java.io.InputStream;

import com.flickr4java.flickr.FlickrException;


public interface FlickrService {

	String savePhoto(InputStream photo, String tittle) throws FlickrException;
	
}
