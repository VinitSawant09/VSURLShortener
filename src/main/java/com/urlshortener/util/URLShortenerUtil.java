package com.urlshortener.util;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Random;
import java.util.Scanner;

import com.urlshortener.dao.URLDAO;
import com.urlshortener.model.URL;

public class URLShortenerUtil {

	public static String shortURLGenerator(URL lURLVO)
	{
		String shortURL = "";
		/*
		Random random = new Random();
		int randomInteger = random.nextInt(Integer.MAX_VALUE);
	    System.out.println("Int : " + randomInteger);
	    */
		URLDAO lURLDAO = new URLDAO();
        shortURL = idToShortURL(lURLDAO.getURLId(lURLVO));
        System.out.println("Shortened Url is:");
		System.out.println("http://vsurl.com/"+shortURL);
		
		
		return "http://vsurl.com/"+shortURL;
	}
	
	
	static String idToShortURL(int n)  
    {  
        // Map to store 62 possible characters  
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();  
      
        StringBuffer shorturl = new StringBuffer();  
      
        // Convert given integer id to a base 62 number  
        while (n > 0)  
        {  
            // use above map to store actual character  
            // in short url  
            shorturl.append(map[n % 62]); 
            n = n / 62;  
        }  
      
        // Reverse shortURL to complete base conversion  
        return shorturl.reverse().toString();  
    }  
	
	
	static int shortURLtoID(String shortURL)  
    {  
        int id = 0; // initialize result  
      
        // A simple base conversion logic  
        for (int i = 0; i < shortURL.length(); i++)  
        {  
            if ('a' <= shortURL.charAt(i) &&  
                       shortURL.charAt(i) <= 'z')  
            id = id * 62 + shortURL.charAt(i) - 'a';  
            if ('A' <= shortURL.charAt(i) &&  
                       shortURL.charAt(i) <= 'Z')  
            id = id * 62 + shortURL.charAt(i) - 'A' + 26;  
            if ('0' <= shortURL.charAt(i) &&  
                       shortURL.charAt(i) <= '9')  
            id = id * 62 + shortURL.charAt(i) - '0' + 52;  
        }  
        return id;  
    }  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String url = "https://www.google.com/";
        // System.out.println("="+URLShortenerUtil.shortURLGenerator(url));
         /*
         String shortUrl = URLShortenerUtil.shortURLGenerator(url);
         System.out.println("="+URLShortenerUtil.shortURLtoID(shortUrl));
     */    
	}

}
