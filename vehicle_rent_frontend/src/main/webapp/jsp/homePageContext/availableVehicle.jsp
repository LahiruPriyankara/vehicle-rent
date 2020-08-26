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


<%
	int count = 0;
%>

<table id="availableVehicleTbl" class="table table-striped" style="width:100%">
        <thead>
            <tr style="background-color: #1a1a1a">
                <th>order</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${vehicles}" var="vehicle">
			<%if (count == 0 || count % 4 == 0) { %>
			 <tr>
			<% } %>
		        <td style="width: 25%">
		              <div id="vehicleDiv"
			onclick="vehicleInfoForBooking(${vehicle.id})">
			<div class="panel panel-default text-center">
				<%-- <div class="panel-body">
					<img src="${images}/vehicleImage/${vehicle.image}.jpg" alt=""
						style="width: 300px; height: 300px; border-radius: 2%;">
				</div> --%>
				<div>
					<img src="${images}/vehicleImage/${vehicle.image}.jpg" alt=""
						style="width: 100%; height: 300px; border-radius: 0%;">
				</div>

				<div class="panel-footer" style="height: 160px;">
					<div class="row">
						<div class="col-md-3" style="background-color: #333333">
							<span style="color: #ffffff; font-size: 10px">Vehicle</span>
						</div>
						<div class="col-md-3" style="background-color: #333333">
							<span style="color: #ffffff; font-size: 10px">${vehicle.name}</span>
						</div>
						<div class="col-md-3" style="background-color: #1a1a1a">
							<span style="color: #ffffff; font-size: 10px">PerDay</span>
						</div>
						<div class="col-md-3" style="background-color: #1a1a1a">
							<span style="color: #ffffff; font-size: 10px">${vehicle.perDay}</span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3" style="background-color: #333333">
							<span style="color: #ffffff; font-size: 10px">Number</span>
						</div>
						<div class="col-md-3" style="background-color: #333333">
							<span style="color: #ffffff; font-size: 10px">${vehicle.vNumber}</span>
						</div>
						<div class="col-md-3" style="background-color: #1a1a1a">
							<span style="color: #ffffff; font-size: 10px">Per1KM</span>
						</div>
						<div class="col-md-3" style="background-color: #1a1a1a">
							<span style="color: #ffffff; font-size: 10px">${vehicle.perKm}</span>
						</div>
					</div>
					<div class="row">
						<span style="font-size: 10px; color: #ffffff">Condition
							&nbsp;&nbsp;:&nbsp;&nbsp;</span><span
							style="font-size: 10px; color: #ffffff">${vehicle.conditions}</span>
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
		        </td>		               
		     <% count += 1;
			if (count % 4 == 0) {%>
			</tr>
		    <%}%>
		    
       </c:forEach>
        </tbody>
    </table>
<%-- 


<%
	int count = 0;
%>

<c:forEach items="${vehicles}" var="vehicle" varStatus="theCount">
	<%if (count == 0 || count % 4 == 0) { %>
	<div class="row slideanim">
	<% } %>
		<div id="${theCount.count}"></div>
		<div class="col-sm-3 col-xs-12" id="vehicleDiv"
			onclick="vehicleInfoForBooking(${vehicle.id})">
			<div class="panel panel-default text-center">
				<div class="panel-body">
					<img src="${images}/vehicleImage/${vehicle.image}.jpg" alt=""
						style="width: 300px; height: 300px; border-radius: 2%;">
				</div>
				<div>
					<img src="${images}/vehicleImage/${vehicle.image}.jpg" alt=""
						style="width: 100%; height: 300px; border-radius: 0%;">
				</div>

				<div class="panel-footer" style="height: 160px;">
					<div class="row">
						<div class="col-md-3" style="background-color: #333333">
							<span style="color: #ffffff; font-size: 10px">Vehicle</span>
						</div>
						<div class="col-md-3" style="background-color: #333333">
							<span style="color: #ffffff; font-size: 10px">${vehicle.name}</span>
						</div>
						<div class="col-md-3" style="background-color: #1a1a1a">
							<span style="color: #ffffff; font-size: 10px">PerDay</span>
						</div>
						<div class="col-md-3" style="background-color: #1a1a1a">
							<span style="color: #ffffff; font-size: 10px">${vehicle.perDay}</span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3" style="background-color: #333333">
							<span style="color: #ffffff; font-size: 10px">Number</span>
						</div>
						<div class="col-md-3" style="background-color: #333333">
							<span style="color: #ffffff; font-size: 10px">${vehicle.vNumber}</span>
						</div>
						<div class="col-md-3" style="background-color: #1a1a1a">
							<span style="color: #ffffff; font-size: 10px">Per1KM</span>
						</div>
						<div class="col-md-3" style="background-color: #1a1a1a">
							<span style="color: #ffffff; font-size: 10px">${vehicle.perKm}</span>
						</div>
					</div>
					<div class="row">
						<span style="font-size: 10px; color: #ffffff">Condition
							&nbsp;&nbsp;:&nbsp;&nbsp;</span><span
							style="font-size: 10px; color: #ffffff">${vehicle.conditions}</span>
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
		<% count += 1;
		if (count % 4 == 0) {%>
	</div>
		<%}%>
</c:forEach> --%>
<br>
<div style="background-color: #1a1a1a;height: 2px"></div>
<br>
