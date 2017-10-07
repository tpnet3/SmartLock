<%@ page import="smartlock.member.vo.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UserVO userVO = (UserVO) session.getAttribute("user"); %>

<jsp:include page="include/_header.jsp">
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
            <h1 class="page-header">마이페이지</h1>
            <ol class="breadcrumb">
	       		<li><a href="/profile" data-toggle="tooltip" data-placement="bottom" title="회원정보 수정">회원정보 수정</a></li>
	       		<li class="active">비밀번호 변경</li>
        		<li><a href="/profile/quit" data-toggle="tooltip" data-placement="bottom" title="회원탈퇴">회원탈퇴</a></li>
        	</ol>
        </div>
        <br><br><br><br><br><br>
		<!-- Form -->
		<div class="card card-container">
			<div class="profile-help">
	            <p>안전한 비밀번호로 내정보를 보호하세요.</p>
	            <p>다른 아이디/사이트에서 사용한 적 없는 비밀번호</p>
	            <p>이전에 사용한 적 없는 비밀번호가 안전합니다.</p>
	            <br>
	        </div>
	        <form class="form-profile" id="changePassword">
	            <input type="password" id="password" class="form-control" placeholder="현재 비밀번호" required autofocus
	            data-toggle="tooltip" data-placement="bottom" title="현재 비밀번호">
	            <br>
	            <input type="password" id="new_password1" class="form-control" placeholder="새 비밀번호" required
	            data-toggle="tooltip" data-placement="bottom" title="새 비밀번호">
	            <input type="password" id="new_password2" class="form-control" placeholder="새 비밀번호 확인" required
	            data-toggle="tooltip" data-placement="bottom" title="새 비밀번호 확인">
	            <br>
	            <button id="profile-btn" type="submit" class="btn btn-lg btn-primary btn-block btn-signin"
	            data-toggle="tooltip" data-placement="bottom" title="비밀번호 변경">비밀번호 변경</button>
	        </form><!-- /form -->
	    </div>		
    </div>
</div>

<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />


<jsp:include page="include/_jslib.jsp" >
	<jsp:param name="_js" value="/html/js/profile.js" />
</jsp:include>

<jsp:include page="include/_footer.jsp" />
