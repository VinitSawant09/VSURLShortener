package com.urlshortener.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 

public class URLValidator
{
    private static final String URL_REGEX =
            "^((((https?|ftps?|www?|gopher|telnet|nntp)://)|(mailto:|news:))" +
            "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
            "([).!';/?:,][[:blank:]])?$";
 
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
 
    public static boolean urlValidator(String url) {
        
    	System.out.println("Inside urlValidator method of URLValidator util class");
    	
        if (url == null) {
            return false;
        }
 
        Matcher matcher = URL_PATTERN.matcher(url);
        System.out.println("End of urlValidator method of URLValidator util class");
        return matcher.matches();
    }
 
    public static void main(String[] args)
    {
        String url = "http://www.techiedelight.com/";
 
        // Validate an url
        if (urlValidator(url)) {
            System.out.print("The URL " + url + " is valid");
        }
        else {
            System.out.print("The URL " + url + " isn't valid");
        }
    }
}
