<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>Bootstrap Example</title>
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	  <div class="jumbotron">
       <h1>Web Cart</h1>
        <p>Webtown nagy feladatsor , Java .</p>
       
        <form method="get" action="Info.html">
   		<button type="submit" class="btn btn-info" >Részletek</button>
</form>
      </div>
	
	<form action="DiscountServlet" method="POST">
	<div class="row">
		<div class="form-group col-md-1">
		    <label for="formGroupExampleInput">Télicsizma</label>
		    <%   out.print(
		    		" <input type=\"number\" class=\"form-control\" name=\"pro0\" value="+'"'+ 
		    		(request.getAttribute("prod0")==null ? "0" : request.getAttribute("prod0"))+'"'+ " id=\"formGroupExampleInput\" placeholder=\"0\" min=\"0\">"
		    ); %>
		</div>
		</div>
		<div class="row">
		  <div class="form-group col-md-1">
		    <label for="formGroupExampleInput">Gumikacsa</label>
		    <%   out.print(
		    		" <input type=\"number\" class=\"form-control\" name=\"pro1\" value="+'"'+ 
		    		(request.getAttribute("prod1")==null ? "0" : request.getAttribute("prod1"))+'"'+ " id=\"formGroupExampleInput\" placeholder=\"0\" min=\"0\">"
		    ); %>
		   </div>
		  </div>
		<div class="row">
		  <div class="form-group col-md-1">
		    <label for="formGroupExampleInput">Uborka</label>
		    <%   out.print(
		    		" <input type=\"number\" class=\"form-control\" name=\"pro2\" value="+'"'+ 
		    		(request.getAttribute("prod2")==null ? "0" : request.getAttribute("prod2"))+'"'+ " id=\"formGroupExampleInput\" placeholder=\"0\" min=\"0\">"
		    ); %>
		    </div>
		  </div>
		<div class="row">
		  <div class="form-group col-md-1">
		    <label for="formGroupExampleInput">Gesztenye</label>
		  <%   out.print(
		    		" <input type=\"number\" class=\"form-control\" name=\"pro3\" value="+'"'+ 
		    		(request.getAttribute("prod3")==null ? "0" : request.getAttribute("prod3"))+'"'+ " id=\"formGroupExampleInput\" placeholder=\"0\" min=\"0\">"
		    ); %>
		   </div>
		  </div>
		  <input type="submit" class="btn btn-success" value="Select Subject" />
	</form>
</div>	
	</br>
	<% if( request.getAttribute("discount")!=null)out.println( request.getAttribute("discount"));  %>
	

</body>
</html>