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
	
	/*$("#dialog").dialog({
        autoOpen: false,
        modal: true,
        title: "Details",
        buttons: {
            Close: function () {
                $(this).dialog('close');
            }
        }
    });*/
	
	
})

function loginAction(evt, divName) {
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
function model(modalName){
	document.getElementById(modalName).click();
	// Get the element with id="defaultOpen" and click on it
	document.getElementById("defaultOpen").click();	
}
function submitNewVehicle(){
	console.log("Hello");
}



function vehicleInfoForBooking(vId) {

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/vehicle_rent_backend/vehicle/getVehicleInfo/"+vId,
		data : JSON.stringify(data),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			displaySuccess(data);
			$("#bookModelShowingBtn").click();
			//setTimeout(function(){$("#bookModelShowingBtn").click();},1);
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
function displaySuccess(data) {
	console.log(data.id);
	$('#vName').val(data.name); 
	$('#vId').val(data.id); 
	$('#vNumber').val(data.vNumber); 
	$('#condition').val(data.conditions); 
	$('#perKm').val(data.perKm); 
	$('#PerDay').val(data.perDay); 
}

function displayError(data) {
	var errRes = "<h4>Ajax Response</h4>&lt;pre&gt;"
			+ JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
	$('#errRes').html(errRes);
}