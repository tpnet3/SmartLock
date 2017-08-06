<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="components/_header.jsp">
	<jsp:param name="_title" value="" />
	<jsp:param name="_nav" value="" />
</jsp:include>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.html">Smart Lock</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="Main.html">Home</a></li>
				<li><a href="about_us.jsp">About Us</a></li>
				<li><a href="software.jsp">Software</a></li>
				<li><a href="container/_download_guest.jsp">Download</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="log_in.jsp">로그인</a></li>
				<li class="divider-vertical"></li>
				<li><a href="sign_up_select.jsp">회원가입</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

	<!-- Page Heading/Breadcrumbs -->
	<div class="row">
		<div class="col-lg-12">
		<br><br>
			<img class="img-responsive" style="margin-left: auto; margin-right: auto; display: block;"
			 width="100px"  src="html/img/success.png" alt="">
			<h1 align="center">정상적으로 로그아웃 되었습니다.</h1>
			<h3 align="center">스마트락을 이용해주셔서 감사합니다.</h3>
		</div>
	</div>

	<br>

	<br><br>
	<div class="col-md-5">
	</div>
	<div class="col-md-2">
		<a class="btn btn-lg btn-default btn-block" href="main.html"><strong>메인으로</strong></a>
	</div>
	<div class="col-md-5">
	</div>
	<br>

	<div class="col-md-12">
		<br>
		<hr>
	</div>

	<!-- Footer -->
	<jsp:include page="components/_footer_content.jsp" />

</div>
<!-- /.container -->

<jsp:include page="components/_jslib.jsp" />
<jsp:include page="components/_footer.jsp" />
