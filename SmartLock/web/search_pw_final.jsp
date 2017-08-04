<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="private/_header.jsp">
	<jsp:param name="_nav" value="" />
	<jsp:param name="_css" value="/css/login.css" />
</jsp:include>

<!-- Page Content -->
<div class="container">
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					비밀번호 찾기
				</h1>
				<h4>새로운 비밀번호를 설정해 주세요.</h4>
			</div>
		</div>
	</div>
	<br>
			</div>
	<div class="container">
	<div class="card" style="width:500px">

	<input type="id" id="inputID" class="form-control" placeholder="기존 비밀번호" style="height:50px"
			required autofocus> <br>
			<input type="id" id="inputID" class="form-control" placeholder="새 비밀번호" style="height:50px"
			required autofocus>
			<input type="id" id="inputID" class="form-control" placeholder="새 비밀번호 확인" style="height:50px"
			required autofocus> <br>
		<button id="login-btn"
			class="btn btn-lg btn-primary btn-block btn-signin" type="submit"
			onclick="location.href='search_pw_finish.jsp'">다음</button>
			</div>
	</div>

	<div class="col-md-12">
		<br> <br>
		<hr>
	</div>

	<!-- Footer -->
	<jsp:include page="private/_footer_content.jsp" />

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<jsp:include page="private/_footer.jsp" />
