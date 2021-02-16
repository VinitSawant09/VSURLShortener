package com.urlshortener.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.urlshortener.model.URLVO;
import com.urlshortener.util.URLValidator;
import com.urlshortener.model.OutputVO;


@CrossOrigin
@Component
@Controller
@Scope("session")
public class URLShortenerController {

	
	 @RequestMapping(value = "/generateShortURL", method = { RequestMethod.GET, RequestMethod.POST })  
     @ResponseBody
	 public OutputVO generateShortURL(@RequestBody URLVO  lURLVO,HttpServletRequest request)
	 {
		System.out.println("Inside generateShortURL method of controller class URLShortenerController");
        System.out.println(lURLVO.getOriginalURL());
        OutputVO lOutputVO = new OutputVO();
        try
        {
           if(validateURL(lURLVO.getOriginalURL()))
           {
        	   System.out.println("It is a valid URL");
        	   
        	   
           }
        
        }
        catch(Exception e)
        {
        	lOutputVO.setStatus("Failure Creating Short URL");
        	lOutputVO.setStatusCode("1");
        }
        return lOutputVO; 
         
    }  
	 
	 public static boolean validateURL(String originalURL)
	 {
		 System.out.println("Inside validateURL method of controller class URLShortenerController");
		 boolean flag = false ;
		 
		 if(!originalURL.equals("") && originalURL != null && originalURL != "" && URLValidator.urlValidator(originalURL))
		 { 
			 flag = true;
		 }
		 
		 
		 return flag;
	 }
	 
	
	
	
}
