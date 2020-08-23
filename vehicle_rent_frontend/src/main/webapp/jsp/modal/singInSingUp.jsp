<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- Modal -->
<div class="modal fade" id="myUserModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" style="margin-top: 5%">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header" style="background-color: black">
				<div class="row">
					<div class="tab col-md-10">
						<button class="tablinks" onclick="tabActive(event, 'singIn')" id="defaultOpen" style="padding: 0px 10px 0px 10px;width: 30%">singIn</button>
						<button class="tablinks" onclick="tabActive(event, 'singUp')" style="padding: 0px 10px 0px 10px;width: 30%">singUp</button>
					</div>
					<div class="col-md-2">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" id="closeUserModal">
							<span aria-hidden="true" style="color: #ffffff"><b>&times;</b></span>
						</button>
					</div>
				</div>
			</div>
			<div class="modal-body"><div id="editBooking" class="tabcontent"><h3>HI 02</h3></div>
				<div id="singIn" class="tabcontent">
					<sf:form class="form-horizontal" modelAttribute="user"
						action="${contextRoot}/vehicle_rent_backend/User/singIn"
						method="POST">

						<div class="form-group">
							<label class="control-label col-md-2">Email</label>
							<div class="col-md-10 validate">
								<sf:input type="text" path="email" class="form-control"
									placeholder="abc@gmail.com" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">Password</label>
							<div class="col-md-10 validate">
								<sf:input type="password" path="password" class="form-control"
									placeholder="**********" />
									<sf:errors path="password" cssClass="errorMsg" element="em"/> 
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-2"></div>
							<div class="col-md-10">
								<input type="submit" name="submit" value="SingIn"
									class="btn btn-primary"
									style="width: 100%; text-align: center;" />
							</div>
						</div>
					</sf:form>


				</div>

				<div id="singUp" class="tabcontent">
					<sf:form class="form-horizontal" modelAttribute="user"
						action="${contextRoot}/vehicle_rent_backend/User/singUp"
						method="POST" enctype="multipart/form-data">

						<div class="form-group">
							<label class="control-label col-md-2">Email</label>
							<div class="col-md-10 validate">
								<sf:input type="text" path="email" class="form-control"
									placeholder="abc@gmail.com" />
									<sf:errors path="file" cssClass="help-block" element="em"/> 
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">Telephone</label>
							<div class="col-md-10 validate">
								<sf:input type="text" path="tp" class="form-control"
									placeholder="TP Number" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-2">Role</label>
							<div class="col-md-10 validate">
								<!-- 	<sf:radiobutton path="role" value="S" label="SUPPLIER"/> -->
								<sf:radiobuttons path="role" items="${roleList}" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-2">Image</label>
							<div class="col-md-10 validate">
								<sf:input type="file" path="file" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">Status</label>
							<div class="col-md-10 validate">
								<sf:select path="status" items="${statusList}"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">Password</label>
							<div class="col-md-10 validate">
								<sf:input type="password" path="password" class="form-control"
									placeholder="**********" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2"></label>
							<div class="col-md-10 validate">
								<sf:input type="password" path="confirmPassword"
									class="form-control" placeholder="**********" />
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-2"></div>
							<div class="col-md-10">
								<input type="submit" name="submit" value="SingUp"
									class="btn btn-primary"
									style="width: 100%; text-align: center;" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>