<div class="row">
	<div class="col-md-8">

		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="${images}/banner1.jpg" alt="Los Angeles"
						style="width: 100%;">
				</div>

				<div class="item">
					<img src="${images}/banner2.jpg" alt="Chicago" style="width: 100%;">
				</div>

				<div class="item">
					<img src="${images}/banner3.jpg" alt="New york"
						style="width: 100%;">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>

	<div class="col-md-4" style="background-color: #ffffff; height: 100%;">
		<div class="row" style="background-color: #0d0d0d;">
			<div class="col-md-10">
				<h4 style="color: #ffffff;">Book Your Vehicle Now</h4>
			</div>
			<div class="col-md-2">
				<img src="${images}/bookLogo.png" alt=""
					style="width: 50px; height: 50px; margin-top: 10px">
			</div>
		</div>
		<br>
		<div>
			<input type="text" class="form-control" id="name"
				placeholder="Enter name" name="name" style="margin-bottom: 10px">
			<input type="email" class="form-control" id="email"
				placeholder="Enter email" name="email" style="margin-bottom: 10px">
			<input type="password" class="form-control" id="password"
				placeholder="Enter password" name="password"
				style="margin-bottom: 10px"> <input type="text"
				class="form-control" id="pickPoint" placeholder="Enter pickup point"
				name="pickPoint" style="margin-bottom: 10px"> <input
				type="text" class="form-control" id="vehicleType"
				placeholder="Enter vehicle type" name="vehicleType"
				style="margin-bottom: 10px">


			<div class="row" style="margin-bottom: 10px">
				<div class="col-md-8">
					<input type="text" class="form-control" id="name"
						placeholder="Enter name" name="name">
				</div>
				<div class="col-md-4">
					<input type="text" class="form-control" id="name"
						placeholder="Enter name" name="name">
				</div>
			</div>
			<div class="row" style="margin-bottom: 10px">
				<div class="col-md-8">
					<input type="text" class="form-control" id="name"
						placeholder="Enter name" name="name">
				</div>
				<div class="col-md-4">
					<input type="text" class="form-control" id="name"
						placeholder="Enter name" name="name">
				</div>
			</div>
			<div class="row" style="margin-bottom: 10px">
				<div class="col-md-12">
					<label style="color: #0d0d0d;">With Drive&nbsp;&nbsp;</label><input
						type="radio" id="withDrive" name="yourOption"> <label
						style="color: #0d0d0d;">&nbsp;&nbsp; |&nbsp;&nbsp; Self
						Drive&nbsp;&nbsp;</label><input type="radio" id="selfDrive"
						name="yourOption">
				</div>
			</div>
			<hr>
			<div style="text-align: left;">
				<button type="button" class="btn btn-primary"
					style="width: 100%; margin: 0px">Book</button>
			</div>
		</div>

		<br>
	</div>
</div>