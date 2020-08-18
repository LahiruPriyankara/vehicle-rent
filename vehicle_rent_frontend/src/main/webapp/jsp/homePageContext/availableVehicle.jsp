<div class="text-center">
	<p>
		<span style="color: #000000;font-size: 20px"><b>Available vehicles&nbsp;&nbsp;&nbsp;</b></span>&nbsp;&nbsp;&nbsp;Our vehicles are availabe in every
		where.Select vehicles for your trip.
	</p>
</div>
<div class="row slideanim">

	<c:forEach items="${vehicles}" var="vehicle">

		<div class="col-sm-3 col-xs-12" id="vehicleDiv" onclick="vehicleInfoForBooking(${vehicle.id})">
			<div class="panel panel-default text-center">
				<div class="panel-body">
					<img src="${images}/vehicleImage/${vehicle.image}.jpg" alt=""
						style="width: 300px; height: 300px;">
				</div>
				<div class="panel-footer">
					<table style="width: 100%">
						<tr>
							<td style="background-color: #333333"><h5
									style="color: #ffffff">Vecicle</h5></td>
							<td style="background-color: #333333"><h5>${vehicle.name}</h5></td>
							<td style="background-color: #1a1a1a"><h5
									style="color: #ffffff">Per Day</h5></td>
							<td style="background-color: #1a1a1a"><h5>${vehicle.perDay}</h5></td>
						</tr>
						<tr>
							<td style="background-color: #333333"><h5
									style="color: #ffffff">Number</h5></td>
							<td style="background-color: #333333"><h5>${vehicle.vNumber}</h5></td>
							<td style="background-color: #1a1a1a"><h5
									style="color: #ffffff">Per 1KM</h5></td>
							<td style="background-color: #1a1a1a"><h5>${vehicle.perKm}</h5></td>
						</tr>
					</table>
					<span style="font-size: 12px; color: #ffffff">Condition
						&nbsp;&nbsp;:&nbsp;&nbsp;</span><span
						style="font-size: 12px; color: #ffffff">${vehicle.conditions}</span>
					<button type="button" class="btn btn-primary" style="width: 100%;">Book</button>
				</div>
			</div>
		</div>

	</c:forEach>

</div>