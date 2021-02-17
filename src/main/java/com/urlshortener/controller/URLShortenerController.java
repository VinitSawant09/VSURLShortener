package com.urlshortener.controller;

import java.util.ArrayList;
import java.util.List;

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

	/*generateShortURL method will take input in the form of json with originalURL field and will return the shortened url as well as 
	 count of urls in db
	 */
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
	 
	 /*Validate url method will check if the url string is empty, null etc and will also check if it is valid url or not */
	 
	 public  boolean validateURL(String originalURL)
	 {
		 System.out.println("Inside validateURL method of controller class URLShortenerController");
		 boolean flag = false ;
		 
		 
		 if(originalURL == null)
		 {
			 
			 return false;
		 }
		 else
		 if(!originalURL.equals("") && originalURL != "" && URLValidator.urlValidator(originalURL))
		 { 
			 flag = true;
		 }
		 
		 
		 return flag;
	 }
	 
	 /*This method will convert short url to particular integer value and find the corresponding original url from table URL*/
	 
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
	
	 /*The method getCountURL will be used for analytics to find out the number of unique URLs shortened*/
	 
	 @RequestMapping(value = "/getCountURL", method = { RequestMethod.GET, RequestMethod.POST })  
     @ResponseBody
	 public OutputVO getCountURL(HttpServletRequest request)
	 {
		System.out.println("Inside getCountURL method of controller class URLShortenerController");
        
        OutputVO lOutputVO = new OutputVO();
        
        URLDAO lURLDAO = new URLDAO();
        try
        {
        	  
        	   lOutputVO.setUrlCount(lURLDAO.getCountOfURL());
        	   lOutputVO.setStatus("Success Fetching Count of URL");
           	   lOutputVO.setStatusCode("0");
         
        
        }
        catch(Exception e)
        {
        	lOutputVO.setStatus("Failure Fetching Count of URL");
        	lOutputVO.setStatusCode("1");
        }
        return lOutputVO; 
         
    }  
	 
	 /*The method fetchTop5URL will be used for analytics to find out the top 5 shortened URLs*/

	 
	 @RequestMapping(value = "/fetchTop5URL", method = { RequestMethod.GET, RequestMethod.POST })  
     @ResponseBody
	 public OutputVO fetchTop5URL(HttpServletRequest request)
	 {
		System.out.println("Inside fetchTop5URL method of controller class URLShortenerController");
        
        OutputVO lOutputVO = new OutputVO();
        
        URLDAO lURLDAO = new URLDAO();
        List<URL> urllist = new ArrayList<URL>();
        try
        {
        	   
        	   urllist = lURLDAO.fetchTop5URL();
        	   lOutputVO.setUrlList(urllist);
        	   lOutputVO.setStatus("Success Fetching List of top 5 URL");
           	   lOutputVO.setStatusCode("0");
         
        
        }
        catch(Exception e)
        {
        	lOutputVO.setStatus("Failure Fetching List of top 5 URL");
        	lOutputVO.setStatusCode("1");
        }
        return lOutputVO; 
         
    }  
	
	
}
