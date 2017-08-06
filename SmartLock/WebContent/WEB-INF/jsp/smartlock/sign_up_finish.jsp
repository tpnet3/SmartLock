<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="components/_header.jsp">
	<jsp:param name="_nav" value="" />
</jsp:include>

<!-- Page Content -->
<div class="container">

	<!-- Page Heading/Breadcrumbs -->
	<div class="row">
		<div class="col-lg-12">
		<br><br>
			<img class="img-responsive" style="margin-left: auto; margin-right: auto; display: block;"
			 width="100px"  src=".\img\success.png" alt="">
			<h1 align="center">정상적으로 회원가입 되었습니다.</h1>
			<h3 align="center"><b>홍길동</b> 님의 아이디는 <b>gildonghong123</b> 입니다.</h3>
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
