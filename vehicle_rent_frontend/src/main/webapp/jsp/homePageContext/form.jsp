<div class="row">
	<div class="col-md-8">

		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="${images}/banner1.jpg" alt="Los Angeles"
						style="width: 100%;">
				</div>
				<div class="item">
					<img src="${images}/banner4.jpg" alt="New york"
						style="width: 100%;">
				</div>
				<div class="item">
					<img src="${images}/banner2.jpg" alt="Chicago" style="width: 100%;">
				</div>
				<div class="item">
					<img src="${images}/banner5.jpg" alt="New york"
						style="width: 100%;">
				</div>

				<div class="item">
					<img src="${images}/banner3.jpg" alt="New york"
						style="width: 100%;">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>

	<div class="col-md-4" style="background-color: #0d0d0d; height: 100%;opacity:1">
	<br>
		<div class="row" style="background-color: #0d0d0d;">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-8">
						<input type="range" name="costRange" id="costRange" min="0" max="10000" onchange="updatetxtField(this.value)"/>
					</div>
					<div class="col-md-1">
						<input type="number" value="0" name="rangeShowingTxtField" id="rangeShowingTxtField" style="width: 100px;height: 25px ;border-radius:5px;color: #000000" max="10000" min="0"/>
					</div>			
				</div>
				<br>
			   <input type="text" class="form-control" placeholder="name of searching vehicle" name="searchTxt" id="searchTxt" style="width: 100%;height: 25px" style=";color: #000000" value=""/>
			   <button id="homeScreenSearchBtn" style="width: 100%;height: 25px" type="button" class="btn btn-xs" onclick="getSearchResult()">Search</button>
			</div>
			<div class="col-md-1"></div>			
		</div>
		<br>
	</div>
</div>