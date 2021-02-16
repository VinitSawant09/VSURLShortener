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

