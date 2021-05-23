package com.coders.shorturl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coders.shorturl.entity.UrlData;

@Repository
public interface UrlRepository  extends JpaRepository<UrlData,Long> {
    UrlData findByUrlId(Long urlId);
  
    List<UrlData> findBylongUrl(String longUrl);
 
}