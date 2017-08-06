<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="components/_header.jsp">
	<jsp:param name="_nav" value="" />
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
				<h4>비밀번호를 찾고자 하는 아이디를 입력해 주세요.</h4>
			</div>
		</div>
	</div>
	<br><br>
	<div class="col-lg-12" align="center">
	<div class="col-lg-4"></div>
	<div class="col-lg-4" align="center">
	<input type="id" id="inputID" class="form-control" placeholder="아이디" style="height:50px"
			required autofocus> <br>
		<button id="login-btn"
			class="btn btn-lg btn-primary btn-block btn-signin" type="submit"
			onclick="location.href='search_pw_select.jsp'">다음</button>
			</div>
	</div>

	<div class="col-md-12">
		<br> <br>
		<hr>
	</div>

	<!-- Footer -->
	<jsp:include page="components/_footer_content.jsp" />

</div>
<!-- /.container -->

<jsp:include page="components/_jslib.jsp" />
<jsp:include page="components/_footer.jsp" />
