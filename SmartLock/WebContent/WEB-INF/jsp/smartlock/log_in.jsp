<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="include/_header.jsp">
	<jsp:param name="_title" value="Login" />
	<jsp:param name="_nav" value="" />
	<jsp:param name="_css" value="/html/css/login.css" />
</jsp:include>

<div class="container">
    <div class="card card-container">
        <img id="logo-img" class="logo-img" src="/html/img/login.png" />
        <form class="form-signin" id="login-form">
            <input type="text" id="id" class="form-control" placeholder="아이디" required autofocus>
            <input type="password" id="pwd" class="form-control" placeholder="비밀번호" required>
            <button id="login-btn" type="submit" class="btn btn-lg btn-primary btn-block btn-signin">로그인</button>
        </form><!-- /form -->
        <div class="login-help">
            <p>비밀번호를 잊으셨나요? <a href="/search_pw">여기를 클릭하세요</a></p>
            <p>아직 회원이 아니신가요? <a href="/signup">지금 가입하세요</a></p>
        </div>
    </div>
</div>
<!-- /.container -->

<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />

<jsp:include page="include/_jslib.jsp" >
    <jsp:param name="_js" value="/html/js/jquery-cookie.js" />
    <jsp:param name="_js" value="/html/js/member.js" />
</jsp:include>

<jsp:include page="include/_footer.jsp" />
