<%@page import="com.lhu.vehicle_rent_backend.DTO.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="images" value="/resources/images" />

<%
	User loggedUser = session.getAttribute("userInfo") != null ? (User) (session.getAttribute("userInfo"))
			: new User();
%>

<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10">
		<h3>My Profile</h3>
		<table class="table table-striped">
			<tr style="background-color: #404040; color: #ffffff;">
				<th>Image</th>
				<th>Email</th>
				<th>Name</th>
				<th>Type</th>
				<th>TP</th>
				<th>Status</th>
				<th></th>
			</tr>
			<tr>
				<td><img
					src="${images}/userImage/<%=loggedUser.getImage() %>.jpg" alt=""
					style="width: 30px; height: 30px;"></td>
				<td><%=loggedUser.getEmail()%></td>
				<td><%=loggedUser.getName()%></td>
				<td><%=loggedUser.getRole()%></td>
				<td><%=loggedUser.getTp()%></td>
				<td><%=loggedUser.getStatus()%></td>

				<td style="text-align: right;">
					<button class="btn" data-toggle="modal" data-target="#editUser"
						onclick="model('closeBookModal','','closeUserModal','closeVehicleModal','1','')"
						style="width: 100px; background-color: green">Edit</button>
				</td>
			</tr>
		</table>
	</div>
	<div class="col-md-1"></div>
</div>

<hr>
<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10">
		<h3>My Vehicle</h3>
		<table class="table table-striped">
			<tr style="background-color: #404040; color: #ffffff">
				<th>Image</th>
				<th>Name</th>
				<th>Type</th>
				<th>Number</th>
				<th>Condition</th>
				<th>PerKm</th>
				<th>PerDay</th>
				<th>Rate</th>
				<th></th>
			</tr>

			<c:forEach items="${vehicles}" var="vehicle">
				<tr>
					<td><img src="${images}/vehicleImage/${vehicle.image}.jpg"
						alt="" style="width: 30px; height: 30px;"></td>

					<td>${vehicle.name}</td>
					<td>${vehicle.vType}</td>
					<td>${vehicle.vNumber}</td>
					<td>${vehicle.conditions}</td>
					<td>${vehicle.perKm}</td>
					<td>${vehicle.perDay}</td>
					<td>${vehicle.rate}</td>
					<td style="text-align: right;">
						<button class="btn" data-toggle="modal" data-target="#editUser"
							onclick="model('closeBookModal','','closeUserModal','closeVehicleModal','2','${vehicle.id}')"
							style="width: 100px; background-color: green">Edit</button>
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>
	<div class="col-md-1"></div>
</div>

<hr>
<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10">
		<h3>My Booking</h3>
		<table class="table table-striped">
			<tr style="background-color: #404040; color: #ffffff">
				<th>Vehicle</th>
				<th>PickUp</th>
				<th>PickOff</th>
				<th>Date</th>
				<th></th>

			</tr>
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.vehicle.name}</td>
					<td>${book.pickUpPoint}</td>
					<td>${book.pickOffPoint}</td>
					<td>${book.datetime}</td>
					<td style="text-align: right;">
						<button class="btn" data-toggle="modal" data-target="#editUser"
							onclick="model('closeBookModal','','closeUserModal','closeVehicleModal','3','${book.id}')"
							style="width: 100px; background-color: green">Edit</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="col-md-1"></div>
</div>