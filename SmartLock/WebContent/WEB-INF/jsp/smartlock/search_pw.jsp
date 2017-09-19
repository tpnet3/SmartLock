<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="include/_header.jsp">
	<jsp:param name="_nav" value="" />
</jsp:include>

<script type="text/javascript">
	if('${resultMsg}')
		alert('${resultMsg}');
</script>

<!-- Page Content -->
<div class="container">
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					비밀번호 찾기
				</h1>
				<h4>비밀번호를 찾고자 하는 아이디와 회원가입시 입력한 이메일을 입력해 주세요.</h4>
			</div>
		</div>
	</div>
	<br><br>
	
	<div class="col-lg-12" align="center">
		<div class="col-lg-4"></div>
		<div class="col-lg-4" align="center">
			<form action="/search_pw/email/authenticate" id="findForm" method="post">
					<input type="id" id="id" name="id" class="form-control" placeholder="아이디" style="height:50px"
							required autofocus> <br>
					<input type="email" id="email" name="email" class="form-control" placeholder="이메일" style="height:50px"
							required> <br>
					<button id="login-btn"
						class="btn btn-lg btn-primary btn-block btn-signin" type="submit" onclick="find_button();">비밀번호 찾기</button>
			</form>
		</div>
	</div>
	
	<div class="col-md-12">
		<br> <br>
		<hr>
	</div>

	<!-- Footer -->
	<jsp:include page="include/_footer_content.jsp" />

</div>
<!-- /.container -->

<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />