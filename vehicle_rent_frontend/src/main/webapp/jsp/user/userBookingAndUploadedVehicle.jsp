<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10">
		<h3>My Profile</h3>
		<table class="table">
			<tr>
				<th>Image</th>
				<th>Email</th>
				<th>Type</th>
				<th>TP</th>
				<th>Status</th>
				<th>Edit</th>
			</tr>
			<tr>
				<td>Image</td>
				<td>Email</td>
				<td>Type</td>
				<td>TP</td>
				<td>Status</td>
				<td style="text-align:right;">
					<button class="btn"
						data-toggle="modal" data-target="#editUser"
						onclick="model('closeBookModal','','closeUserModal','closeVehicleModal','1','')"
						style="width: 100px;background-color: green">
						Edit
					</button>					
				</td>
			</tr>
		</table>
	</div>
	<div class="col-md-1"></div>
</div>


<div class="row">
<div class="col-md-1"></div>
	<div class="col-md-10">
	<h3>My Vehicle</h3>
		<table class="table">
			<tr>
			    <th>Image</th>
				<th>Name</th>
				<th>Type</th>
				<th>Number</th>
				<th>Condition</th>
				<th>PerKm</th>
				<th>PerDay</th>
				<th>Rate</th>				
				<th>Edit</th>
			</tr>
			<tr>
				<td>Image</td>
				<td>Name</td>
				<td>Type</td>
				<td>Number</td>
				<td>Condition</td>
				<td>PerKm</td>
				<td>PerDay</td>
				<td>Rate</td>
				<td  style="text-align:right;">
					<button class="btn"
						data-toggle="modal" data-target="#editUser"
						onclick="model('closeBookModal','','closeUserModal','closeVehicleModal','2','1')"
						style="width: 100px;background-color: green">
						Edit
					</button>					
				</td>
			</tr>
		</table>
	</div>
	<div class="col-md-1"></div>
</div>


<div class="row">
	<div class="col-md-1"></div>	
	<div class="col-md-10">
	<h3>My Booking</h3>
		<table class="table">
			<tr>
				<th>Vehicle</th>
				<th>PickUp</th>
				<th>PickOff</th>
				<th>Duration</th>
				<th>Days</th>
				<th>Date</th>
				<th>WithDriver</th>
				<th>AvarageCost</th>
				<th>Edit</th>

			</tr>
			<tr>
				<td>Name</td>
				<td>Type</td>
				<td>Number</td>
				<td>Condition</td>
				<td>PerKm</td>
				<td>PerDay</td>
				<td>Rate</td>
				<td>Image</td>
				<td  style="text-align:right;">
					<button class="btn"
						data-toggle="modal" data-target="#editUser"
						onclick="model('closeBookModal','','closeUserModal','closeVehicleModal','3','12')"
						style="width: 100px;background-color: green">
						Edit
					</button>					
				</td>
			</tr>
		</table>
	</div>
	<div class="col-md-1"></div>
</div>