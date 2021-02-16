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

import com.urlshortener.model.URL;
import com.urlshortener.util.URLShortenerUtil;
import com.urlshortener.util.URLValidator;
import com.urlshortener.dao.URLDAO;
import com.urlshortener.model.OutputVO;


@CrossOrigin
@Component
@Controller
@Scope("session")
public class URLShortenerController {

	
	 @RequestMapping(value = "/generateShortURL", method = { RequestMethod.GET, RequestMethod.POST })  
     @ResponseBody
	 public OutputVO generateShortURL(@RequestBody URL  lURLVO,HttpServletRequest request)
	 {
		System.out.println("Inside generateShortURL method of controller class URLShortenerController");
        System.out.println(lURLVO.getOriginalURL());
        OutputVO lOutputVO = new OutputVO();
        String url = lURLVO.getOriginalURL();
        URLDAO lURLDAO = new URLDAO();
        try
        {
           if(validateURL(url))
           {
        	   System.out.println("It is a valid URL");
        	   
        	   
        	   int flag = lURLDAO.registerURL(lURLVO);
        	   lOutputVO.setShortURL(URLShortenerUtil.shortURLGenerator(lURLVO));
        	   lOutputVO.setUrlCount(lURLDAO.getCountOfURL());
        	   lOutputVO.setStatus("Success Creating Short URL");
           	   lOutputVO.setStatusCode("0");
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
	 
	 
	 @RequestMapping(value = "/redirectToURL", method = { RequestMethod.GET, RequestMethod.POST })  
     @ResponseBody
	 public OutputVO redirectToURL(@RequestBody URL  lURLVO,HttpServletRequest request)
	 {
		System.out.println("Inside redirectToURL method of controller class URLShortenerController");
        System.out.println(lURLVO.getShortURL());
        OutputVO lOutputVO = new OutputVO();
        String url = lURLVO.getShortURL();
        URLDAO lURLDAO = new URLDAO();
        try
        {
        	   url = url.replace("http://vsurl.com/",""); 
        	   lURLVO.setId(URLShortenerUtil.shortURLtoID(url));
        	   System.out.println(lURLVO.getId());
        	   String originalURL = lURLDAO.getOriginalURL(lURLVO);
        	   
        	   lOutputVO.setOriginalURL(originalURL);
        	   lOutputVO.setUrlCount(lURLDAO.getCountOfURL());
        	   lOutputVO.setStatus("Success Fetching Original URL");
           	   lOutputVO.setStatusCode("0");
         
        
        }
        catch(Exception e)
        {
        	lOutputVO.setStatus("Failure Fetching Original URL");
        	lOutputVO.setStatusCode("1");
        }
        return lOutputVO; 
         
    }  
	
	
	
}
