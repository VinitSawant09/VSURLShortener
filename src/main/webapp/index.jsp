<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
   
  <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
   <script src="<c:url value="/resources/js/index.js"/>"></script>
    
  
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  
  <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>

<center><h1>VS URL Shortener</h1></center>

<div>
  <form>
    <h2><label for="urlstring">Enter URL</label></h2>
    <input type="text" id="urlfield" name="urlfield" placeholder="Your original url..">

    
  
    <input type="button" value="Shorten URL" onClick="shortenURL();">
    
    <span id="errorMessage" style="color:red">
    
    </span>
    
    <input type="text" id="shorturlfield" name="urlfield" placeholder="Shortened url will be generated here.." disabled>
    
     <input type="button" id="redirectButton" value="Redirect to URL" onClick="redirect();">
  </form>
</div>

</body>
</html>
</html>
