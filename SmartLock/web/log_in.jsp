<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="private/_header.jsp">
	<jsp:param name="_title" value="Log in" />
	<jsp:param name="_nav" value="" />
	<jsp:param name="_css" value="/css/login.css" />
</jsp:include>

<div class="container">
    <div class="card card-container">
        <img id="logo-img" class="logo-img" src="./img/login.png" />
        <form class="form-signin">
            <input type="id" id="inputID" class="form-control" placeholder="아이디" required autofocus>
            <input type="pwd" id="inputPwd" class="form-control" placeholder="비밀번호" required>
            <button id="login-btn" class="btn btn-lg btn-primary btn-block btn-signin" type="submit">로그인</button>
        </form><!-- /form -->
        <div class="login-help">
			<p>비밀번호를 잊으셨나요? <a href="search_pw.jsp">여기를 클릭하세요</a></p>
			<p>아직 회원이 아니신가요? <a href="sign_up_select.jsp">지금 가입하세요</a></p>
		</div>
    </div>
</div>
<div class="col-md-12">
		<br>
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
