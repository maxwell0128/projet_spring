package com.projet.demo.Service.impl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.projet.demo.Service.FlickrService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FlickrServiceImpl implements FlickrService {

	private Flickr flickr;
	
	@Autowired
	public FlickrServiceImpl(Flickr flickr) {
		this.flickr = flickr;
	}
	
	@Override
	public String savePhoto(InputStream photo, String tittle) throws FlickrException {
		UploadMetaData uploadMetaData = new UploadMetaData();
		uploadMetaData.setTitle(tittle);
		
		String photoId = flickr.getUploader().upload(photo, uploadMetaData);
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	}
	
}
