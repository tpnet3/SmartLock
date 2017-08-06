<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="include/_header.jsp">
	<jsp:param name="_nav" value="device" />
	<jsp:param name="_css" value="/html/css/statistics.css" />
</jsp:include>

<!-- Page Content -->
<div class="container">

	<!-- Page Heading/Breadcrumbs -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Statistics
				<small>Statistics</small>
			</h1>
		</div>
	</div>
	<!-- /.row -->

	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-6">
				<div class="progress blue">
					<span class="progress-left">
						<span class="progress-bar"></span>
					</span>
					<span class="progress-right">
						<span class="progress-bar"></span>
					</span>
					<div class="progress-value">30</div>
				</div>
				<h4 class="text-center">다운로드 수</h4>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="progress yellow">
					<span class="progress-left"> <span class="progress-bar"></span>
					</span> <span class="progress-right"> <span class="progress-bar"></span>
					</span>
					<div class="progress-value">5</div>
				</div>
				<h4 class="text-center">라이센스 요청</h4>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="progress pink">
					<span class="progress-left"> <span class="progress-bar"></span>
					</span> <span class="progress-right"> <span class="progress-bar"></span>
					</span>
					<div class="progress-value">5</div>
				</div>
				<h4 class="text-center">발급 된라이센스</h4>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="progress green">
					<span class="progress-left"> <span class="progress-bar"></span>
					</span> <span class="progress-right"> <span class="progress-bar"></span>
					</span>
					<div class="progress-value">12</div>
				</div>
				<h4 class="text-center">만료될 라이센스</h4>
			</div>
		</div>
	</div>

	<hr>

	<!-- Footer -->
	<jsp:include page="include/_footer_content.jsp" />

</div>
<!-- /.container -->

<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />
