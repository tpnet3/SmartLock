<%@ page import="smartlock.member.vo.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UserVO userVO = (UserVO) session.getAttribute("user"); %>

<jsp:include page="../include/_header.jsp">
	<jsp:param name="_title" value="Profile" />
    <jsp:param name="_nav" value="" />
    <jsp:param name="_css" value="/html/css/profile.css" />
</jsp:include>

<!-- Page Content -->
<div class="container">
    <!-- Service Panels -->
    <!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
    <div class="row">
        <!-- 탭메뉴 -->
        <div class="col-lg-12">
            <h2 class="page-header">마이페이지</h2>
            <ol class="breadcrumb">
	       		<li><a href="/profile">회원정보 수정</a></li>	       		
        		<li><a href="/profile/changePassword">비밀번호 변경</a></li>
        		<li class="active">회원탈퇴</li>
        	</ol>
        </div>
        <br><br><br><br><br><br>
		<!-- Form -->
		<div class="card card-container">
			<div class="profile-help">
	            <p>회원탈퇴를 위한 회원정보 인증절차</p>
	            <p>회원가입 시 등록한 정보를 입력해주세요.</p>
	            <br>
	        </div>
	        <form class="form-profile" id="removeUser">
	            <input type="password" id="password1" class="form-control" placeholder="현재 비밀번호" required autofocus>
	            <br>
	            <input type="password" id="password2" class="form-control" placeholder="현재 비밀번호 확인" required>
	            <br>
	            <button id="profile-btn" type="submit" class="btn btn-lg btn-primary btn-block btn-signin">회원탈퇴</button>
	        </form><!-- /form -->
	    </div>		
        
         
    </div>
    <!-- /.row -->
    <hr>

    <!-- Footer -->
    <jsp:include page="../include/_footer_content.jsp" />

</div>

<jsp:include page="../include/_jslib.jsp" >
	<jsp:param name="_js" value="/html/js/profile.js" />
</jsp:include>

<jsp:include page="../include/_footer.jsp" />