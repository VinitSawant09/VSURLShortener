function shortenURL()
{
	var originalUrl = document.getElementById("urlfield").value;
	
	if(validateURL(originalUrl))
	{
		document.getElementById("errorMessage").innerHTML="";
		var registerData = 
		{
			"originalURL":originalUrl
			
		}
		            $.ajax(
					       {
					        url  : "./generateShortURL",
					       headers: {
					            "Accept": "application/json",
					            "Content-Type": "application/json"
								
					        },
					        type:"POST",
					        data : JSON.stringify(registerData),
					        contentType: 'application/json',
					        cache: false,
					        processData: false,
					        success: function(response){
						             document.getElementById("urlCounter").innerHTML="";
						             console.log(response.shortURL);
                                     console.log(response.urlCount);
									 document.getElementById("shorturlfield").value=response.shortURL;
								     document.getElementById("urlCounter").innerHTML="URL Count = "+response.urlCount;
						        }
					});
	}
	
}

function validateURL(originalURL)
{
	
	if(originalURL==null || originalURL=="")
	{
		
		document.getElementById("errorMessage").innerHTML="URL Field cannot be empty.";
		return false;
	}
	else if(!isUrlValid(originalURL))
	{
		document.getElementById("errorMessage").innerHTML="Invalid URL.";
		return false;
		
	}
	return true;
	
	
}

function isUrlValid(originalURL) {
    var res = originalURL.match(/(http(s)?:\/\/.)?(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)/g);
    if(res == null)
        return false;
    else
        return true;
}



function redirect()
{
	var shortURL = document.getElementById("shorturlfield").value;
	
	
	var registerData = 
		{
			"shortURL":shortURL
			
		}
		            $.ajax(
					       {
					        url  : "./redirectToURL",
					       headers: {
					            "Accept": "application/json",
					            "Content-Type": "application/json"
								
					        },
					        type:"POST",
					        data : JSON.stringify(registerData),
					        contentType: 'application/json',
					        cache: false,
					        processData: false,
					        success: function(response){
									 var url = response.originalURL;
						             console.log(response.originalURL);
									 console.log(response.urlCount);
									 window.location.replace(url);
						        }
					});
	
	
}

