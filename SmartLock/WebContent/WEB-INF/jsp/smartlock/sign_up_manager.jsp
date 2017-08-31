<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="include/_header.jsp">
	<jsp:param name="_title" value="Signup" />
	<jsp:param name="_nav" value="" />
	<jsp:param name="_css" value="/html/css/login.css" />
</jsp:include>

<!-- Page Content -->
<div class="container">
	<!-- Service Panels -->
	<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
	<div class="row">
		<div class="col-lg-12">
			<h2 class="page-header">사업자 회원가입</h2>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form class="form-horizontal" id="signup-form">
					<fieldset>
						<input type="hidden" id="authority" value="1" />

						<br>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="id">아이디</label>
							<div class="col-md-3">
								<div class="input-append">
									<input id="id" name="id" type="text"
										   placeholder="아이디를 입력하세요." class="form-control with-btn input-md" style="width:70%; float:left">
									<button id="check-id-btn" type="button" class="btn" style="width:30%">중복확인</button>
									<input type="hidden" id="checked-id" style="display:none"/>
									<input type="hidden" id="is-check-id" value="false" style="display:none"/>
								</div>
							</div>
						</div>
						<!--
						<div class="form-group">
							<label class="col-md-5 control-label" for="id">아이디</label>
							<div class="col-md-3">
								<input id="id" name="textinput" type="text"
									placeholder="아이디를 입력하세요." class="form-control input-md">
							</div>
						</div>
						-->

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="pwd">비밀번호</label>
							<div class="col-md-3">
								<input id="pwd" name="pwd" type="password"
									placeholder="비밀번호를 입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="check-pwd">비밀번호
								확인</label>
							<div class="col-md-3">
								<input id="check-pwd" name="check-pwd" type="password"
									placeholder="비밀번호를 재입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="name">이름</label>
							<div class="col-md-3">
								<input id="name" name="name" type="text"
									placeholder="이름을 입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="email">이메일</label>
							<div class="col-md-3">
								<input id="email" name="email" type="text"
									placeholder="이메일을 입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="company">기업명</label>
							<div class="col-md-3">
								<input id="company" name="company" type="text"
									placeholder="기업명을 입력해주세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="phone">기업 연락처</label>
							<div class="col-md-3">
								<input id="phone" name="phone" type="text"
									placeholder="기업 연락처를 입력해주세요." class="form-control input-md">
							</div>
						</div>
						<br>
						<!-- Button -->
						<div class="form-group" align="center">
							<button type="submit" class="btn btn-default btn-md"
								style="height: 40px; width: 80px">회원가입</button>
						</div>

					</fieldset>
				</form>

			</div>
		</div>
	</div>
	<!-- /.row -->
	<hr>

	<!-- Footer -->
	<jsp:include page="include/_footer_content.jsp" />

</div>

<jsp:include page="include/_jslib.jsp" >
	<jsp:param name="_js" value="/html/js/member.js" />
</jsp:include>

<jsp:include page="include/_footer.jsp" />
