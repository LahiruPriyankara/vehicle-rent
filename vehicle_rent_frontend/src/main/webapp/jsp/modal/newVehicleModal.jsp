<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- Modal -->
<div class="modal fade" id="vehicleModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" style="margin-top: 5%">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header"
				style="background-color: black; height: 50px">
				<div class="row">
					<div class="col-md-10">
						<span style="font-size: 15px; color: #ffffff"><b>Vehicle</b></span>
					</div>
					<div class="col-md-2">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" id="closeAddnewModal">
							<span aria-hidden="true" style="color: #ffffff"><b>&times;</b></span>
						</button>
					</div>
				</div>
			</div>

			<div class="modal-body">

				<sf:form class="form-horizontal" modelAttribute="vehicle"
					action="${contextRoot}/vehicle_rent_backend/vehicle/addNew"
					method="POST" enctype="multipart/form-data">


					<div style="display: none">
						<sf:input type="text" path="id" class="form-control" />
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">Name</label>
						<div class="col-md-10 validate">
							<sf:input type="text" path="name" class="form-control"
								placeholder="KDH/ALTO/Bjaj ThreeWeeler" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2">Type</label>
						<div class="col-md-10 validate">
							<sf:select path="vType" items="${vehicleTypeList}"
								class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2">Per KM</label>
						<div class="col-md-10 validate">
							<sf:input type="number" path="perKm" class="form-control"
								placeholder="25" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">Per Day</label>
						<div class="col-md-10 validate">
							<sf:input type="number" path="perDay" class="form-control"
								placeholder="500" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2">Number</label>
						<div class="col-md-10 validate">
							<sf:input type="text" path="vNumber" class="form-control"
								placeholder="ABC-1025" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">conditions</label>
						<div class="col-md-10 validate">
							<sf:input type="text" path="conditions" class="form-control"
								placeholder="AC/TV" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2">Rate</label>
						<div class="col-md-10 validate">
							<sf:input type="number" path="rate" class="form-control"
								placeholder="rate" />
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-md-2">Image</label>
						<div class="col-md-10 validate">
							<sf:input type="file" path="file" class="form-control" />
						</div>
					</div>


					<div class="form-group">
						<div class="col-md-2"></div>
						<div class="col-md-10">
							<input type="submit" name="modify" value="Send"
								class="btn btn-primary" style="width: 100%; text-align: center;"
								onclick="submitNewVehicle()" />
						</div>
					</div>
				</sf:form>


			</div>
		</div>
	</div>
</div>