<div class="modal fade" id="bookVehicle" role="dialog" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" style="margin-top: 5%">

	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header"
				style="background-color: black; height: 50px">
				<div class="row">
					<div class="col-md-10">
						<span style="font-size: 15px; color: #ffffff"><b>Book
								Your Vehicle</b></span>
					</div>
					<div class="col-md-2">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" id="closeBookModal">
							<span aria-hidden="true" style="color: #ffffff"><b>&times;</b></span>
						</button>
					</div>
				</div>
			</div>
			<div class="modal-body">
				<form
					action="${contextRoot}/vehicle_rent_backend/book/addNewBooking"
					method="POST">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label" style="text-align: right;">Name</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="vName" id="vName"
								readonly="readonly" style="background-color: #d9d9d9"> <input
								type="hidden" class="form-control" name="vId" id="vId">
						</div>

						<label class="col-sm-2 col-form-label" style="text-align: right;">Number</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="vNumber"
								id="vNumber" readonly="readonly"
								style="background-color: #d9d9d9">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label" style="text-align: right;">Condition</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="condition"
								id="condition" readonly="readonly"
								style="background-color: #d9d9d9">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label" style="text-align: right;">Per
							Km</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="perKm" id="perKm"
								readonly="readonly" style="background-color: #d9d9d9">
						</div>

						<label class="col-sm-2 col-form-label" style="text-align: right;">Per
							Day</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="PerDay" id="PerDay"
								readonly="readonly" style="background-color: #d9d9d9">
						</div>
					</div>
					<hr>
					
					<div class="form-group row">
						<label class="col-sm-3 col-form-label" style="text-align: right;">PickUp
							Point</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="pPoint" id="pPoint">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-3 col-form-label" style="text-align: right;">PickOff
							point</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="dPoint" id="dPoint">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-3 col-form-label" style="text-align: right;">Duration(KM)</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="dKm" id="dKm">
						</div>

						<label class="col-sm-3 col-form-label" style="text-align: right;">Days</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="days" id="days">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-3 col-form-label" style="text-align: right;">Date</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="dateTime" id="dateTime">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label" style="text-align: right;">With
							a Driver</label>
						<div class="col-sm-1">
							<input type="radio" class="form-control" value="withDriver"
								name="withOrWithOutDriver" checked>
						</div>

						<label class="col-sm-3 col-form-label" style="text-align: right;">WithOut
							a Driver</label>
						<div class="col-sm-1">
							<input type="radio" class="form-control" value="withOutDriver"
								name="withOrWithOutDriver">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-3 col-form-label"></label>
						<div class="col-sm-3">
							<button type="button" style="width: 100%;">Calculate</button>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-3 col-form-label" style="text-align: right;">Average
							Cost</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="aCost" id="aCost">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label"></label>
						<div class="col-sm-10">
							<button type="submit" class="btn btn-primary"
								style="width: 100%;">Book</button>
						</div>
					</div>
				</form>
				<h5>
					Contact : <span style="color: blue" id="contactDetails"></span>
				</h5>
			</div>
		</div>
	</div>
</div>