package com.coders.shorturl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coders.shorturl.entity.UrlData;
import com.coders.shorturl.repository.UrlRepository;
import com.coders.shorturl.util.ShortUrlGenerator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;
    
    @Autowired
    private ShortUrlGenerator shortUrlGenerator;


    public UrlData saveUrlData(UrlData urlData) {
    	if(!(shortUrlGenerator.isValidlongUrl(urlData.getLongUrl())))
    	{
    		urlData.setLongUrl("/"+urlData.getLongUrl());	
    	}
    	List<UrlData> presentUrl=urlRepository.findBylongUrl(urlData.getLongUrl());
    	if(presentUrl.isEmpty())
    	{
    	String shortUrl="/"+shortUrlGenerator.getAlphaNumericString();
    	urlData.setShortUrl(shortUrl);
    	return urlRepository.save(urlData);
    	}
		return null;
    }
    
	
	public UrlData updateUrlHits(Long urlId) {
		UrlData modUrlData = getUrlData(urlId);
		modUrlData.setNo_hits(modUrlData.getNo_hits()+1);
        return urlRepository.save(modUrlData);
    }
    

   
    
    public UrlData getUrlData(Long UrlData) {
        UrlData url = urlRepository.findByUrlId(UrlData);
        return  url;
    }



	public List<UrlData> findAll() {
		List<UrlData> urlDataList = urlRepository.findAll();
		return urlDataList;
		
	}
    
    
    
    
}
