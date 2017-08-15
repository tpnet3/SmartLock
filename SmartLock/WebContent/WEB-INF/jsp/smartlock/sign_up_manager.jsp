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
						<br>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">아이디</label>
							<div class="col-md-3">
								<input id="textinput" name="textinput" type="text"
									placeholder="아이디를 입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">비밀번호</label>
							<div class="col-md-3">
								<input id="textinput" name="textinput" type="text"
									placeholder="비밀번호를 입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">비밀번호
								확인</label>
							<div class="col-md-3">
								<input id="textinput" name="textinput" type="text"
									placeholder="비밀번호를 재입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">이름</label>
							<div class="col-md-3">
								<input id="textinput" name="textinput" type="text"
									placeholder="이름을 입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">이메일</label>
							<div class="col-md-3">
								<input id="textinput" name="textinput" type="text"
									placeholder="이메일을 입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">기업명</label>
							<div class="col-md-3">
								<input id="textinput" name="textinput" type="text"
									placeholder="기업명을 입력해주세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">기업 연락처</label>
							<div class="col-md-3">
								<input id="textinput" name="textinput" type="text"
									placeholder="기업 연락처를 입력해주세요." class="form-control input-md">
							</div>
						</div>
						<br>
						<!-- Button -->
						<div class="form-group" align="center">
							<button class="btn btn-default btn-md"
								style="height: 40px; width: 80px"
								onclick="location.href='sign_up_finish.jsp' ">submit</button>
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

<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />
