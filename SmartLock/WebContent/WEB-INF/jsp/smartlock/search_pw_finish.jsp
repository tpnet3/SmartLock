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
			 width="100px"  src="html/img/success.png" alt="">
			<h1 align="center">비밀번호가 정상적으로 변경되었습니다.</h1>
			<h3 align="center">새로운 비밀번호로 로그인하세요.</h3>
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
