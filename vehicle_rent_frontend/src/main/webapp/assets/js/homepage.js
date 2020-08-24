$(document).ready(function() {
	// Add smooth scrolling to all links in navbar + footer link
	$(".navbar a, footer a[href='#myPage']").on('click', function(event) {
		// Make sure this.hash has a value before overriding default behavior
		if (this.hash !== "") {
			// Prevent default anchor click behavior
			event.preventDefault();

			// Store hash
			var hash = this.hash;

			// Using jQuery's animate() method to add smooth page scroll
			// The optional number (900) specifies the number of milliseconds it
			// takes to scroll to the specified area
			$('html, body').animate({
				scrollTop : $(hash).offset().top
			}, 900, function() {

				// Add hash (#) to URL when done scrolling (default click
				// behavior)
				window.location.hash = hash;
			});
		} // End if
	});

	$(window).scroll(function() {
		$(".slideanim").each(function() {
			var pos = $(this).offset().top;

			var winTop = $(window).scrollTop();
			if (pos < winTop + 600) {
				$(this).addClass("slide");
			}
		});
	});

	/*
	 * $("#dialog").dialog({ autoOpen: false, modal: true, title: "Details",
	 * buttons: { Close: function () { $(this).dialog('close'); } } });
	 */
	/*
	 * console.log("abc 1"); if(window.onAction === "singIn" &&
	 * window.hasValidationError){ setTimeout(function(){ alert("Hello"); },
	 * 3000);
	 * setTimeout(function(){document.getElementById("signInBtn").click();},3000);
	 * console.log("abc 2"); }
	 */

})

/*
 * window.onload = downloadFunction; function downloadFunction(){
 * console.log("abc 1"); if(window.onAction === "singIn" &&
 * window.hasValidationError){ setTimeout(function(){ alert("Hello"); }, 3000);
 * setTimeout(function(){document.getElementById("signInBtn").click();},3000);
 * console.log("abc 2"); } }
 */

function tabActive(evt, divName) {
	console.log(evt + " - " + divName);
	var i, tabcontent, tablinks;
	tabcontent = document.getElementsByClassName("tabcontent");
	for (i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	}
	tablinks = document.getElementsByClassName("tablinks");
	for (i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	}
	document.getElementById(divName).style.display = "block";
	evt.currentTarget.className += " active";

}
function model(closeBookModal, closeEditUserModal, closeUserModal,
		closeVehicleModal, type, id) {
	console.log(closeBookModal + " - " + closeEditUserModal + " - "
			+ closeUserModal + " - " + closeVehicleModal + " : " + type + " : "
			+ id);
	if (closeBookModal === "") {
		document.getElementById(closeEditUserModal).click();
		document.getElementById(closeUserModal).click();
		document.getElementById(closeVehicleModal).click();
	}
	if (closeEditUserModal === "") {
		document.getElementById(closeBookModal).click();
		document.getElementById(closeUserModal).click();
		document.getElementById(closeVehicleModal).click();
		if ((id !== "") && (type === "2" || type === "3")) {
			getMmodifingProfileInfo(type, id);
		}
		if (type === "1") {
			console.log("oooo");
			document.getElementById("editUserBtn").click();
		} else if (type === "2") {
			document.getElementById("editVehicleBtn").click();
		} else if (type === "3") {
			document.getElementById("editBookingBtn").click();
		} else {
			document.getElementById("editUserBtn").click();
		}
	}
	if (closeUserModal === "") {
		document.getElementById(closeBookModal).click();
		document.getElementById(closeEditUserModal).click();
		document.getElementById(closeVehicleModal).click();
		document.getElementById("defaultOpen").click();
	}
	if (closeVehicleModal === "") {
		document.getElementById(closeBookModal).click();
		document.getElementById(closeEditUserModal).click();
		document.getElementById(closeUserModal).click();
	}

}
function submitNewVehicle() {
	console.log("Hello");
}

function vehicleInfoForBooking(vId) {

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/vehicle_rent_backend/vehicle/getVehicleInfo/" + vId,
		data : JSON.stringify(data),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			displaySuccess(data,"");
			$("#bookModelShowingBtn").click();
			// setTimeout(function(){$("#bookModelShowingBtn").click();},1);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayError(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}

function displayError(data) {
	/*
	 * var errRes = "<h4>Ajax Response</h4>&lt;pre&gt;" +
	 * JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
	 * $('#errRes').html(errRes);
	 */
	alert("Error Occured");
}
function getMmodifingProfileInfo(type, id) {
	console.log("type : " + type + ",id : " + id);
	stUurl = "";
	if (type === "2") {
		stUurl = "/vehicle_rent_backend/vehicle/getVehicleInfo/" + id
	}
	if (type === "3") {
		stUurl = "/vehicle_rent_backend/book/getBookInfo/" + id
	}
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : stUurl,
		data : JSON.stringify(data),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			displaySuccess(data,type);
			// $("#bookModelShowingBtn").click();
			// setTimeout(function(){$("#bookModelShowingBtn").click();},1);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayError(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}

function displaySuccess(data, type) {
	console.log("data.id  : "+data.id+", type : "+type);
	if (type === "") {
		$('#vName').val(data.name);
		$('#vId').val(data.id);		
		$('#vNumber').val(data.vNumber);
		$('#condition').val(data.conditions);
		$('#perKm').val(data.perKm);
		$('#PerDay').val(data.perDay);
		var contact = data.user.tp + " - " + data.user.name + " , "
				+ data.user.email + "";
		$('#contactDetails').html(contact);

	} else if (type === "2") {
		$('#vIdModifyVIew').val(data.id);
		$('#vImageModifyVIew').val(data.image);
		$('#vNameModifyVIew').val(data.name);
		//$('#vcListModifyVIew').val(data.vType);
		$('#vNumberModifyVIew').val(data.vNumber);
		$('#vConditionModifyVIew').val(data.conditions);
		$('#vPerKmModifyVIew').val(data.perKm);
		$('#vPerDayModifyVIew').val(data.perDay);
		$('#vRateModifyVIew').val(data.rate);
		
	} else if (type === "3") {
		$('#bIdModifyVIew').val(data.id);
		$('#bStatusModifyVIew').val(data.status);
		$('#bpickUpPointModifyVIew').val(data.pickUpPoint);		
		$('#bpickOffPointModifyVIew').val(data.pickOffPoint);
		$('#bdurationModifyVIew').val(data.duration);
		$('#bdaysModifyVIew').val(data.days);
		$('#bdatetimeModifyVIew').val(data.datetime);
		$('#bavgCostModifyVIew').val(data.avgCost);
		//$('#vcListModifyVIew').val(data.vType);
	}

}

function getUserProfileData(){
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/vehicle_rent_backend/main/getUserProfileData",
		data : JSON.stringify(data),
		dataType : 'html',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			$('#data').empty();
			$('#data').html(data);
			//displaySuccess(data);
			//$("#bookModelShowingBtn").click();
			// setTimeout(function(){$("#bookModelShowingBtn").click();},1);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayError(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
	
}

function getAvilbleVehicleData(){
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/vehicle_rent_backend/main/getAvilbleVehicleData",
		data : JSON.stringify(data),
		dataType : 'html',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			$('#data').empty();
			$('#data').html(data);
			//displaySuccess(data);
			//$("#bookModelShowingBtn").click();
			// setTimeout(function(){$("#bookModelShowingBtn").click();},1);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayError(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
	
}
