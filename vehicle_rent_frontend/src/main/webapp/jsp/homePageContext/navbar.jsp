<div class="container">
	
	<div class="navbar-header">
		<a class="navbar-brand" href="${contextRoot}/vehicle_rent_backend/main/home"><span><img
				src="${images}/logo.png" alt="" style="width: 30px; height: 30px;"></span><span>&nbsp;&nbsp;&nbsp;
				Better Tour</span></a>
	</div>
	
	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#myPage">HOME</a></li>
			<li><a href="#vehicle">VEHICLES</a></li>
			<li><a href="#myBooking">MY BOOKING</a></li>
			<li><a href="#contact">CONTACT</a></li>
			<li><a href="#about">ABOUT</a></li>
			<li><a href="#services">SERVICES</a></li>
			<li><a href="#contact">CONTACT</a></li>
			<span>&nbsp;&nbsp;&nbsp;</span>
			
			<button id="control" type="button" class="btn btn-xs"
				data-toggle="modal" data-target="#vehicleModal" onclick="model('closeLogModal')">
				add new
			</button>
			
			<button id="control" type="button" class="btn btn-xs"
				data-toggle="modal" data-target="#myUserModal" onclick="model('closeAddnewModal')">
				signIn
			</button>
		</ul>
		<div></div>
	</div>
</div>
