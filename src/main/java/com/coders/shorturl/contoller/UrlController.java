package com.coders.shorturl.contoller;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coders.shorturl.entity.UrlData;
import com.coders.shorturl.exception.ResourceNotFoundException;
import com.coders.shorturl.service.UrlService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/url")
@Slf4j
public class UrlController {

	@Autowired
    private UrlService urlService;

    @PostMapping("/")
    public UrlData  saveUrlData(@RequestBody UrlData urlData) {
        return urlService.saveUrlData(urlData);
    }
    
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResponseEntity<List<UrlData>> getAll() {
		List<UrlData> urlDataList = urlService.findAll();
		return new ResponseEntity<>(urlDataList, HttpStatus.OK);
	}

    @GetMapping("/{id}")
    public UrlData getUrlData(@PathVariable("id") Long urlId) {
        return urlService.getUrlData(urlId);
    }
    
    @PutMapping(path="/{id}")
    public ResponseEntity<UrlData> updateUrlDataHit(@PathVariable("id") Long urlId) throws 
    URISyntaxException {
    	if (urlService.getUrlData(urlId) == null) {
            throw new ResourceNotFoundException("Url id should not be null");
        }
    	UrlData result = urlService.updateUrlHits(urlId);
        return ResponseEntity.ok().body(result);
    }
    
    
}