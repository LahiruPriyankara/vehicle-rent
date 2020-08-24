<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="images" value="/resources/images" />
<div class="text-center">
	<p>
		<span style="color: #000000; font-size: 20px"><b>Available
				vehicles&nbsp;&nbsp;&nbsp;</b></span>&nbsp;&nbsp;&nbsp;Our vehicles are
		availabe in every where.Select vehicles for your trip.
	</p>
</div>
<div class="row slideanim">

	<c:forEach items="${vehicles}" var="vehicle">

		<div class="col-sm-3 col-xs-12" id="vehicleDiv"
			onclick="vehicleInfoForBooking(${vehicle.id})">
			<div class="panel panel-default text-center">
				<%-- <div class="panel-body">
					<img src="${images}/vehicleImage/${vehicle.image}.jpg" alt=""
						style="width: 300px; height: 300px; border-radius: 2%;">
				</div> --%>
				<div>
					<img src="${images}/vehicleImage/${vehicle.image}.jpg" alt=""
						style="width: 100%; height: 100%; border-radius: 0%;">
				</div>

				<div class="panel-footer">
					<div class="row">
						<div class="col-md-3" style="background-color: #333333">
							<h5>Vehicle</h5>
						</div>
						<div class="col-md-3" style="background-color: #333333">
							<h5>${vehicle.name}</h5>
						</div>
						<div class="col-md-3" style="background-color: #1a1a1a">
							<h5>PerDay</h5>
						</div>
						<div class="col-md-3" style="background-color: #1a1a1a">
							<h5>${vehicle.perDay}</h5>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3" style="background-color: #333333">
							<h5>Number</h5>
						</div>
						<div class="col-md-3" style="background-color: #333333">
							<h5>${vehicle.vNumber}</h5>
						</div>
						<div class="col-md-3" style="background-color: #1a1a1a">
							<h5>Per1KM</h5>
						</div>
						<div class="col-md-3" style="background-color: #1a1a1a">
							<h5>${vehicle.perKm}</h5>
						</div>
					</div>
					<div class="row">
						<span style="font-size: 12px; color: #ffffff">Condition
							&nbsp;&nbsp;:&nbsp;&nbsp;</span><span
							style="font-size: 12px; color: #ffffff">${vehicle.conditions}</span>
						<hr>
					</div>

					<div class="row">
						<div style="background-color: #333333; width: 100%">
							<img src="${images}/userImage/${vehicle.user.image}.jpg"
								style="width: 30px; height: 30px; border-radius: 50%; align: left">
							<span style="font-size: 12px; color: #ffffff">
								&nbsp;&nbsp;&nbsp;&nbsp;${vehicle.user.tp}
								&nbsp;&nbsp;:&nbsp;&nbsp;${vehicle.user.name}
								&nbsp;&nbsp;:&nbsp;&nbsp;${vehicle.user.email} </span>
						</div>
					</div>

				</div>
			</div>
		</div>

	</c:forEach>

</div>