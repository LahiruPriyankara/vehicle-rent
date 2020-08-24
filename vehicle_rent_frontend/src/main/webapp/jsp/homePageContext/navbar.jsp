<%@page import="com.lhu.vehicle_rent_backend.DTO.User"%>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand"
				href="${contextRoot}/vehicle_rent_backend/main/home"><span><img
					src="${images}/logo.png" alt="" style="width: 30px; height: 30px;"></span><span>&nbsp;&nbsp;&nbsp;
					Better Tour</span></a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="#myPage" onclick="getAvilbleVehicleData()">HOME</a></li>
			<li><a href="#vehicle">VEHICLES</a></li>
			<li><a href="#myBooking">MY BOOKING</a></li>
			<li><a href="#contact">USERS</a></li>
			<li><a href="#about">ABOUT</a></li>
			<li><a href="#services">SERVICES</a></li>
			<li><a href="#contact">CONTACT</a></li>
			<li><a href="#"
				onclick="getUserProfileData('/vehicle_rent_backend/main/getAllSysDataForAdmin')">SUMMARY</a></li>
			<span>&nbsp;&nbsp;&nbsp;</span>
			<li>
				<button id="control" type="button" class="btn btn-xs"
					data-toggle="modal" data-target="#vehicleModal"
					onclick="model('closeBookModal','closeEditUserModal','closeUserModal','','','')">
					AddNew</button>
			</li>

			<li>&nbsp;&nbsp;&nbsp;
				<button id="control" type="button" class="btn btn-xs"
					data-toggle="modal" data-target="#myUserModal"
					onclick="model('closeBookModal','closeEditUserModal','','closeVehicleModal','','')"
					id="signInBtn">signIn</button>
			</li>
			<%
				if (isloggedUser) {
			%>
			<li>&nbsp;&nbsp;&nbsp;
				<button type="button" style="margin-top: 7px; height: 35px;"
					onclick="getAvilbleVehicleData()">VIEW VEHICLE</button>
				&nbsp;&nbsp;&nbsp;
				<button type="button" style="margin-top: 7px"
					onclick="getUserProfileData('/vehicle_rent_backend/main/getUserProfileData')">
					<img src="${images}/userImage/<%= loggedUser.getImage() %>.jpg"
						alt="" style="width: 35px; height: 30px;">&nbsp;&nbsp;&nbsp;
					<%=loggedUser.getName()%>
				</button>
			</li>
			<li><a href="${contextRoot}/vehicle_rent_backend/User/singOff"
				style="margin-top: -5px"> <img src="${images}/signOff.png"
					alt="" style="width: 30px; height: 30px;">
			</a></li>
			<%
				}
			%>
		</ul>
		<!-- <form class="navbar-form navbar-left" action="/action_page.php">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search"
					name="search">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form> -->
	</div>
</nav>
