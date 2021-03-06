package com.coders.shorturl.util;

import org.springframework.stereotype.Component;

@Component
public class ShortUrlGenerator {

	public String getAlphaNumericString() {

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		StringBuilder sb = new StringBuilder(6);

		for (int i = 0; i < 6; i++) {

			int index = (int) (AlphaNumericString.length() * Math.random());

			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}
	
	public boolean isValidlongUrl(String longUrl)
	{
		if(longUrl.startsWith("https") || longUrl.startsWith("http") || longUrl.startsWith("/"))
		{
		   return true;	
		}
		else
		{
			return false;
		}		
	}
}