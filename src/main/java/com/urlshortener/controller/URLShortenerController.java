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
        System.out.println(lURLVO);
        OutputVO lOutputVO = new OutputVO();
        try
        {
        
        
        }
        catch(Exception e)
        {
        	lOutputVO.setStatus("Failure Creating User");
        	lOutputVO.setStatusCode("1");
        }
        return lOutputVO; 
         
    }  
	
	
}
