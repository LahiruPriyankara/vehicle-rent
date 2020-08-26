<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="com.lhu.vehicle_rent_backend.DTO.User"%>

<%
	User loggedUser = session.getAttribute("userInfo") != null ? (User) (session.getAttribute("userInfo"))
			: new User();
	
	boolean isloggedUser =  session.getAttribute("isloggedUser")!=null?(boolean)session.getAttribute("isloggedUser"):false;
	boolean hasValidationError =  session.getAttribute("hasValidationError")!=null?(boolean)session.getAttribute("hasValidationError"):false;
	String onAction =  session.getAttribute("onAction")!=null?(String)session.getAttribute("onAction"):"";
	System.out.println("xxxx   "+loggedUser.toString());
	System.out.println("llll");
%>

<spring:url var="bootsrap" value="/resources/bootsrap" />
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
	<%-- 
	<script>
		window.onAction = '<%=onAction%>';
		window.hasValidationError = '<%=hasValidationError%>';
		console.log("01. "+window.onAction+" | "+window.hasValidationError);	
	</script>
	 --%>
	<!-- Theme Made By www.w3schools.com -->
	<title>Bootstrap Theme Company Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- THis also Correct
	<link href="/vehicle_rent_backend/resources/bootsrap/css/bootstrap.min.css" rel="stylesheet">
	 -->
	<link href="${bootsrap}/css/bootstrap.min.css" rel="stylesheet">
	
	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
	<script src="${js}/jQuery/jquery.js"></script>
	<script src="${bootsrap}/js/bootstrap.min.js"></script>
	
	
	
	<link href="${css}/homepage.css" rel="stylesheet">
	<script src="${js}/homepage.js"></script>
	
	<link rel="stylesheet" href="${css}/dataTable/plugings/jquery.dataTables.min.css">
	<link rel="stylesheet" href="${css}/dataTable/plugings/buttons.dataTables.min.css">
	
    <!-- Data Tables -->
    <script src="${js}/dataTable/plugins/dataExportJs/jquery.dataTables.js"></script>
    
    
     <!-- Data Tables Export-->
    <script src="${js}/dataTable/plugins/dataExportJs/dataTables.buttons.min.js"></script> 
    <script src="${js}/dataTable/plugins/dataExportJs/jszip.min.js"></script>
    <script src="${js}/dataTable/plugins/dataExportJs/pdfmake.min.js"></script>
    <script src="${js}/dataTable/plugins/dataExportJs/vfs_fonts.js"></script>    
    <script src="${js}/dataTable/plugins/dataExportJs/buttons.html5.min.js"></script>
    <script src="${js}/dataTable/plugins/dataExportJs/buttons.print.min.js"></script>

</head>

<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="60">

	<nav class="navbar navbar-default navbar-fixed-top"> <%@include
		file="homePageContext/navbar.jsp"%> </nav>
	<div id="errRes"></div>
	<div class="jumbotron text-center">
		<%@include file="homePageContext/form.jsp"%>
	</div>


	<button type="button" data-toggle="modal" data-target="#bookVehicle" onclick="model('','closeEditUserModal','closeUserModal','closeVehicleModal','','')"
		id="bookModelShowingBtn" hidden>Open Modal</button>

	<!-- Modal -->
	<%@include file="modal/editUser.jsp"%>
	<%@include file="modal/bookVehicle.jsp"%>
	<%@include file="modal/singInSingUp.jsp"%>
	<%@include file="modal/vehicleModal.jsp"%>
	<br>	
	<div class="data">
		<!-- Container (Main Section) -->
		<div id="data" class="container-fluid">
			<%@include file="homePageContext/availableVehicle.jsp"%>
		</div>
	</div>
	
	<!-- Container (About Section) -->
	<div id="about" class="container-fluid text-center">
		<%@include file="homePageContext/about.jsp"%>
	</div>

	<!-- Container (Services Section) -->
	<div id="services" class="container-fluid text-center">
		<%@include file="homePageContext/services.jsp"%>
	</div>

	<!-- Container (Contact Section) -->
	<div id="contact" class="container-fluid bg-grey">
		<%@include file="homePageContext/contact.jsp"%>
	</div>

	<%@include file="homePageContext/footer.jsp"%>
</body>

</html>
