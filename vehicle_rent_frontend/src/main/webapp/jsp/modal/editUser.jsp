<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="editUser" role="dialog" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" style="margin-top: 5%">

	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header"
				style="background-color: black; height: 50px">
				<div class="row">
					<div class="tab col-md-9">
						<button class="tablinks" onclick="tabActive(event, 'editUserModel')" id="editUserBtn" style="padding: 0px 10px 0px 10px;width: 30%">User</button>
						<button class="tablinks" onclick="tabActive(event, 'editVehicleModel')" id="editVehicleBtn" style="padding: 0px 10px 0px 10px;width: 30%">Vehicle</button>
						<button class="tablinks" onclick="tabActive(event, 'editBookingModel')" id="editBookingBtn" style="padding: 0px 10px 0px 10px;width: 30%">Booking</button>
					</div>
					<div class="col-md-3">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" id="closeEditUserModal">
							<span aria-hidden="true" style="color: #ffffff"><b>&times;</b></span>
						</button>
					</div>
				</div>
			</div>
			<div class="modal-body">
				<div id="editUserModel" class="tabcontent">
					<sf:form class="form-horizontal" modelAttribute="user"
						action="${contextRoot}/vehicle_rent_backend/User/edit"
						method="POST" enctype="multipart/form-data">

						<sf:hidden path="id" />
						<sf:hidden path="image"/>
						<div class="form-group">
							<label class="control-label col-md-3">Email</label>
							<div class="col-md-9 validate">
								<sf:input path="email" class="form-control"
									placeholder="abc@gmail.com" readonly="true" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Name</label>
							<div class="col-md-9 validate">
								<sf:input path="name" class="form-control" placeholder="name" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">TP</label>
							<div class="col-md-9 validate">
								<sf:input path="tp" class="form-control" placeholder="TP Number" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-3">Role</label>
							<div class="col-md-9 validate">
								<!-- 	<sf:radiobutton path="role" value="S" label="SUPPLIER"/> -->
								<sf:radiobuttons path="role" items="${roleList}" />

							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Image</label>

							<div class="col-md-9 validate">
								<div class="row">
									<div class="col-md-3">
										<img src="${images}/userImage/<%=loggedUser.getImage() %>.jpg"
											alt="" style="width: 30px; height: 30px;">
									</div>
									<div class="col-md-9">
										<sf:input type="file" path="file" class="form-control" />
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Status</label>
							<div class="col-md-9 validate">
								<sf:select path="status" items="${statusList}"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Password</label>
							<div class="col-md-9 validate">
								<sf:password path="password" class="form-control"
									placeholder="old password" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3"></label>
							<div class="col-md-9 validate">
								<sf:password path="confirmPassword" class="form-control"
									placeholder="new password" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3"></label>
							<div class="col-md-9 validate">
								<sf:password path="confirmPassword2" class="form-control"
									placeholder="confirm new password" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3"></label>
							<div class="col-md-3 validate">
								Edit : <input type="radio" name="actionType" value="edit"
									checked />
							</div>
							<div class="col-md-3 validate">
								Delete : <input type="radio" name="actionType" value="delete" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-3"></div>
							<div class="col-md-9">
								<input type="submit" name="submit" value="Submit"
									class="btn btn-primary"
									style="width: 100%; text-align: center;" />
							</div>
						</div>
					</sf:form>
				</div>
				<div id="editVehicleModel" class="tabcontent">

                  <sf:form class="form-horizontal" modelAttribute="vehicle"
					action="${contextRoot}/vehicle_rent_backend/vehicle/update"
					method="POST" enctype="multipart/form-data">

					<sf:hidden path="id" id="vIdModifyVIew"/>
					<sf:hidden path="image" id="vImageModifyVIew"/>

					<div class="form-group">
						<label class="control-label col-md-3">Name</label>
						<div class="col-md-9 validate">
							<sf:input path="name" class="form-control"
								placeholder="KDH/ALTO/Bjaj ThreeWeeler" id="vNameModifyVIew"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Type</label>
						<div class="col-md-9 validate">
							<sf:select path="vType" items="${vehicleTypeList}"
								class="form-control" id="vcListModifyVIew"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Number</label>
						<div class="col-md-9 validate">
							<sf:input path="vNumber" class="form-control"
								placeholder="ABC-1025" id="vNumberModifyVIew"/>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Conditions</label>
						<div class="col-md-9 validate">
							<sf:input path="conditions" class="form-control"
								placeholder="AC/TV" id="vConditionModifyVIew"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Per KM</label>
						<div class="col-md-9 validate">
							<sf:input type="number" path="perKm" class="form-control"
								placeholder="25" id="vPerKmModifyVIew"/>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Per Day</label>
						<div class="col-md-9 validate">
							<sf:input type="number" path="perDay" class="form-control"
								placeholder="500" id="vPerDayModifyVIew"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Rate</label>
						<div class="col-md-9 validate">
							<sf:input type="number" path="rate" class="form-control"
								placeholder="rate" id="vRateModifyVIew"/>
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-md-3">Image</label>
						<div class="col-md-9 validate">
							<sf:input type="file" path="file" class="form-control" id="vImageModifyVIew"/>
						</div>
					</div> 
					<div class="form-group">
						<label class="control-label col-md-3"></label>
						<div class="col-md-3 validate">
							Edit : <input type="radio" name="actionType" value="edit"
								checked />
						</div>
						<div class="col-md-3 validate">
							Delete : <input type="radio" name="actionType" value="delete" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-3"></div>
						<div class="col-md-9">
							<input type="submit" name="modify" value="Submit"
								class="btn btn-primary" style="width: 100%; text-align: center;"
								onclick="submitNewVehicle()" />
						</div>
					</div>
				</sf:form>


                </div>
				<div id="editBookingModel" class="tabcontent">

					<sf:form class="form-horizontal" modelAttribute="book"
					action="${contextRoot}/vehicle_rent_backend/book/update"
					method="POST" enctype="multipart/form-data">

                    <sf:hidden path="id" id="bIdModifyVIew"/>					
					
					<div class="form-group">
						<label class="control-label col-md-3">Status</label>
						<div class="col-md-9 validate">
							<sf:input path="status" class="form-control" id="bStatusModifyVIew" placeholder="status"/>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">PickUp Point</label>
						<div class="col-md-9 validate">
							<sf:input path="pickUpPoint" class="form-control" id="bpickUpPointModifyVIew" placeholder="pickUp Point"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">PickOff point</label>
						<div class="col-md-9 validate">
							<sf:input path="pickOffPoint" class="form-control"
								id="bpickOffPointModifyVIew" placeholder="pickOff Point"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Duration(KM)</label>
						<div class="col-md-9 validate">
							<sf:input path="duration" class="form-control"
								id="bdurationModifyVIew" placeholder="duration(KM)"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Days</label>
						<div class="col-md-9 validate">
							<sf:input path="days" class="form-control"
								id="bdaysModifyVIew" placeholder="days"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Date</label>
						<div class="col-md-9 validate">
							<sf:input path="datetime" class="form-control"
								id="bdatetimeModifyVIew" placeholder="date"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Average Cost</label>
						<div class="col-md-9 validate">
							<sf:input path="avgCost" class="form-control"
								id="bavgCostModifyVIew" placeholder="average cost"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3"></label>
						<div class="col-md-3 validate">
							Edit : <input type="radio" name="actionType" value="edit"
								checked />
						</div>
						<div class="col-md-3 validate">
							Delete : <input type="radio" name="actionType" value="delete" />
						</div>
					</div> 
					<div class="form-group">
						<div class="col-md-3"></div>
						<div class="col-md-9">
							<input type="submit" name="modify" value="Submit"
								class="btn btn-primary" style="width: 100%; text-align: center;"/>
						</div>
					</div>
				</sf:form>

				</div>
			</div>
		</div>
	</div>
</div>