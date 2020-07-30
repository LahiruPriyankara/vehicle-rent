<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="bootsrap" value="/resources/bootsrap" />
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<!-- Theme Made By www.w3schools.com -->
<title>Bootstrap Theme Company Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- THis also Correct
<link href="/vehicle_rent_backend/resources/bootsrap/css/bootstrap.min.css" rel="stylesheet">
 -->
<link href="${bootsrap}/css/bootstrap.min.css" rel="stylesheet">

<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
<script src="${bootsrap}/js/bootstrap.min.js"></script>
<link href="${css}/homepage.css" rel="stylesheet">
<script src="${js}/homepage.js"></script>
</head>

	<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
		<nav class="navbar navbar-default navbar-fixed-top"> 
		   <%@include file="navbar.jsp"%> 
		 </nav>
	
		<div class="jumbotron text-center">
			<%@include file="form.jsp"%>
		</div>	
	
		<!-- Container (Main Section) -->
		<div id="data" class="container-fluid">
			<%@include file="serchVecle.jsp"%>
		</div>	
	
		<%@include file="about.jsp"%>
	
		<!-- Container (Services Section) -->
		<div id="services" class="container-fluid text-center">
			<%@include file="services.jsp"%>
		</div>	
	
		<!-- Container (Contact Section) -->
		<div id="contact" class="container-fluid bg-grey">
			<%@include file="contact.jsp"%>
		</div>	
	
		<%@include file="footer.jsp"%>
	</body>

</html>