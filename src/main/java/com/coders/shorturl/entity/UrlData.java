package com.coders.shorturl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UrlData {

    public Long getUrlId() {
		return urlId;
	}
	public void setUrlId(Long urlId) {
		this.urlId = urlId;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	public int getNo_hits() {
		return no_hits;
	}
	public void setNo_hits(int no_hits) {
		this.no_hits = no_hits;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	
	 public void setShortUrl(String shortUrl) {
			this.shortUrl = shortUrl;
		}
	 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long urlId;
    private String longUrl;
    private String shortUrl;
   
	private int no_hits;
}