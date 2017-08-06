<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="private/_header.jsp">
	<jsp:param name="_nav" value="device" />
</jsp:include>

<!-- Page Content -->
<div class="container">
	<!-- Service Panels -->
	<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
	<div class="row">
		<div class="col-lg-12">
			<h2 class="page-header">내 디바이스 관리</h2>
		</div>
		<!-- 검색필터-->
		<div class="row">
		<div class="col-sm-12">
			<div class="col-sm-2">
				<div class="input-group">
					<select name="" id="location1"
					style="width: 180px; height: 35px;">
					<option value="">소프트웨어명</option>
					<option value="">Microsoft Excel</option>
					<option value="">Parallels Desktop</option>
					<option value="">Adobe CC</option>
					<option value="">Football Manager</option>
				</select>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="input-group">
					<select name="" id="location1"
					style="width: 180px; height: 35px;">
					<option value="">등록 날짜</option>
					<option value="">오름차순</option>
					<option value="">내림차순</option>
				</select>
				</div>
			</div>
			<div class="col-sm-6">
			<input type="text" class="col-md-4" placeholder="검색어를 입력하세요"
					id="searchField" style="width: 300px; height: 35px;">&nbsp;&nbsp;
			<button class="btn btn-primary" type="button" id="searchButton"
					data-loading-text="Searching..">
					<i class="fa fa-search"></i>
				</button>
				</div>
				<div class="col-sm-2" align="right">
				<a class="btn btn-danger">디바이스 추가하기</a>
				</div>
			</div>

		</div>
		<br> <br>
		<div class="col-md-3 col-sm-7">
			<div class="panel panel-default text-center">
				<div class="panel-heading">
					<h3>GD's Phone</h3>
				</div>
				<div class="panel-body">
					<div>
						<img src=".\img\smartphone.png"
							style="margin-left: auto; margin-right: auto; display: auto"
							width="100px">
						<p></p>
						<p>
							<a href="#" class="btn btn-warning btn-filter"
								style="width: 80px">수정</a>&nbsp; &nbsp; &nbsp;
							<a href="#" class="btn btn-danger btn-filter" style="width: 80px">삭제</a>
						</p>
					</div>
					<div>
						<ul class="list-group text-center">
							<li class="list-group-item"><b>장치명 :</b> iPhone7 (mobile)</li>
							<li class="list-group-item"><b>장치정보 :</b> DC9601-2792-2DD4</li>
							<li class="list-group-item"><b>등록일 :</b> 2017 - 01 - 01</li>
						</ul>
						<a href="#" class="btn btn-default" style="width: 180px">라이센스 조회</a>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-7">
			<div class="panel panel-default text-center">
				<div class="panel-heading">
					<h3>Home-PC</h3>
				</div>
				<div class="panel-body">
					<div>
						<img src=".\img\pc.png"
							style="margin-left: auto; margin-right: auto; display: auto"
							width="100px">
						<p></p>
						<p>
							<a href="#" class="btn btn-warning btn-filter"
								style="width: 80px">수정</a>&nbsp; &nbsp; &nbsp; <a href="#"
								class="btn btn-danger btn-filter" style="width: 80px">삭제</a>
						</p>
					</div>
					<div>
						<ul class="list-group text-center">
							<li class="list-group-item"><b>장치명 :</b> SAMSUNG-PC (PC)</li>
							<li class="list-group-item"><b>장치정보 :</b> DC9601-2792-2DD4</li>
							<li class="list-group-item"><b>등록일 :</b> 2017 - 01 - 01</li>
						</ul>
						<a href="#" class="btn btn-default" style="width: 180px">라이센스 조회</a>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-7">
			<div class="panel panel-default text-center">
				<div class="panel-heading">
					<h3>Office-PC</h3>
				</div>
				<div class="panel-body">
					<div>
						<img src=".\img\pc.png"
							style="margin-left: auto; margin-right: auto; display: auto"
							width="100px">
						<p></p>
						<p>
							<a href="#" class="btn btn-warning btn-filter"
								style="width: 80px">수정</a>&nbsp; &nbsp; &nbsp; <a href="#"
								class="btn btn-danger btn-filter" style="width: 80px">삭제</a>
						</p>
					</div>
					<div>
						<ul class="list-group text-center">
							<li class="list-group-item"><b>장치명 :</b> LG-PC (PC)</li>
							<li class="list-group-item"><b>장치정보 :</b> DC9601-2792-2DD4</li>
							<li class="list-group-item"><b>등록일 :</b> 2017 - 01 - 01</li>
						</ul>
						<a href="#" class="btn btn-default" style="width: 180px">라이센스 조회</a>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-7">
			<div class="panel panel-default text-center">
				<div class="panel-heading">
					<h3>My-MAC</h3>
				</div>
				<div class="panel-body">
					<div>
						<img src=".\img\pc.png"
							style="margin-left: auto; margin-right: auto; display: auto"
							width="100px">
						<p></p>
						<p>
							<a href="#" class="btn btn-warning btn-filter"
								style="width: 80px">수정</a>&nbsp; &nbsp; &nbsp; <a href="#"
								class="btn btn-danger btn-filter" style="width: 80px">삭제</a>
						</p>
					</div>
					<div>
						<ul class="list-group text-center">
							<li class="list-group-item"><b>장치명 :</b> MacBook Pro(PC)</li>
							<li class="list-group-item"><b>장치정보 :</b> DC9601-2792-2DD4</li>
							<li class="list-group-item"><b>등록일 :</b> 2017 - 01 - 01</li>
						</ul>
						<a href="#" class="btn btn-default" style="width: 180px">라이센스 조회</a>
					</div>
				</div>
			</div>
		</div>
		<!-- /.container -->
		<!-- /.row -->
		<hr>
	</div>
	<div class="row"></div>

	<hr>
</div>

<!-- Footer -->
<jsp:include page="private/_footer_content.jsp" />

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<jsp:include page="private/_footer.jsp" />
