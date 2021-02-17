package com.urlshortener.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.urlshortener.controller.URLShortenerController;
import com.urlshortener.model.URL;


public class UnitTesting {
	
	//Check if URL is empty string
	@Test
    public void validateURLEmpty() {
         // MyClass is tested
		URLShortenerController objURLShortenerController = new URLShortenerController();
		
        // assert statements
        assertEquals(false, objURLShortenerController.validateURL(""), "String is empty");
           
    }
	
	//Check if URL string passed is null
		@Test
	    public void validateURLIsNull() {
	         // MyClass is tested
			URLShortenerController objURLShortenerController = new URLShortenerController();
			String s = null;
	        // assert statements
	        assertEquals(false, objURLShortenerController.validateURL(s), "Empty string object");
	           
	    }
		
		//Check if URL string passed is not a valid string
				@Test
			    public void validateURLIsProper() {
			         // MyClass is tested
					URLShortenerController objURLShortenerController = new URLShortenerController();
					String s = "https://www.google.com";
			        // assert statements
			        assertEquals(true, objURLShortenerController.validateURL(s), "Proper url");
			           
			    }
				
		//Shortening a new URL string
				@Test
			    public void validateStringShortening() {
			         // MyClass is tested
					URLShortenerController objURLShortenerController = new URLShortenerController();
					String s = "https://www.google.com";
					URL urlVO = new URL();
					urlVO.setOriginalURL(s);
			        // assert statements
			        assertEquals("0", objURLShortenerController.generateShortURL(urlVO, null).getStatusCode(), "Success");
			           
			    }
				
		//Shortening a new URL string
				@Test
			    public void redirectURL() {
			         // MyClass is tested
					URLShortenerController objURLShortenerController = new URLShortenerController();
					String s = "http://vsurl.com/b";
					URL urlVO = new URL();
					urlVO.setShortURL(s);
			        // assert statements
			        assertEquals("0", objURLShortenerController.redirectToURL(urlVO, null).getStatusCode(), "Success");
			           
			    }
	
	

}
