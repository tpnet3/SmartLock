<%@ page import="smartlock.member.vo.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UserVO userVO = (UserVO) session.getAttribute("user"); %>

<jsp:include page="include/_header.jsp">
	<jsp:param name="_title" value="Profile" />
    <jsp:param name="_nav" value="" />
</jsp:include>

<!-- Page Content -->
<div class="container">
    <!-- Service Panels -->
    <!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">마이페이지</h2>
            <ol class="breadcrumb">
	       		<li><a href="/profile">회원정보 수정</a></li>
	       		<li class="active">비밀번호 변경</li>
        		<li><a href="/profile/quit">회원탈퇴</a></li>
        </ol>
        </div>
        
        <br>        
		<br>
		
        <div id="changePassword">
        		<br>
        		<div class="spc_header">
						<p class="contxt contxt_list">안전한 비밀번호로 내정보를 보호하세요.</p>
						<p class="contxt contxt_list">다른 아이디/사이트에서 사용한 적 없는 비밀번호</p>
						<p class="contxt contxt_list">이전에 사용한 적 없는 비밀번호가 안전합니다.</p>								
				</div>
				<br>    
                                                     		
              	<!-- Text input-->
                <div class="form-group">                            
          	     	<div class="col-md-3">
                  		<input id="password" name="textinput" type="password"
                                 placeholder="현재 비밀번호" class="form-control input-md">
                   	</div>
                </div>
                
                <br>
				<br>

                 <!-- Text input-->
             	 <div class="form-group">                            
                 	<div class="col-md-3">
                      	<input id="new_password1" name="textinput" type="password"
                             placeholder="새 비밀번호" class="form-control input-md">
                  	</div>
             	 </div>
             	 
             	 <br>

              	<!-- Text input-->
              	<div class="form-group">                            
                	<div class="col-md-3">
                     	<input id="new_password2" name="textinput" type="password"
                             placeholder="새 비밀번호 확인" class="form-control input-md">
                  	</div>
              	</div>
              	<br>
              	<br>
              	<!-- Button -->              
              	<button id="changePassword_btn" type="button" style="height: 40px; width: 80px">확인</button>
         </div>
    </div>
    <!-- /.row -->
    <hr>

    <!-- Footer -->
    <jsp:include page="include/_footer_content.jsp" />

</div>

<jsp:include page="include/_jslib.jsp" >
	<jsp:param name="_js" value="/html/js/profile.js" />
</jsp:include>

<jsp:include page="include/_footer.jsp" />
