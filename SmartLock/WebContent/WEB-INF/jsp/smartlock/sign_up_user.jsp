<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="components/_header.jsp">
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
			<h2 class="page-header">일반사용자 회원가입</h2>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form class="form-horizontal">
					<fieldset>
						<br>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">아이디</label>
							<div class="col-md-3">
								<div class="input-append">
									<input id="id" name="textinput" type="text"
										   placeholder="아이디를 입력하세요." class="form-control with-btn input-md">
									<button id="check-id-btn" type="button" class="btn">중복확인</button>
									<input id="checked-id" style="display:none"/>
									<input id="is-ckeck-id" value="false" style="display:none"/>
								</div>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">비밀번호</label>
							<div class="col-md-3">
								<input id="pwd" name="textinput" type="password"
									   placeholder="비밀번호를 입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">비밀번호
								확인</label>
							<div class="col-md-3">
								<input id="check-pwd" name="textinput" type="password"
									   placeholder="비밀번호를 재입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">이름</label>
							<div class="col-md-3">
								<input id="name" name="textinput" type="text"
									   placeholder="이름을 입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">이메일</label>
							<div class="col-md-3">
								<input id="email" name="textinput" type="text"
									   placeholder="이메일을 입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">전화번호</label>
							<div class="col-md-3">
								<input id="phone" name="textinput" type="text"
									   placeholder="전화번호를 입력해주세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">

							<label class="col-md-5 control-label" for="textinput">기업명</label>
							<div class="col-md-3">
								<div class="input-append">
									<input id="corp_name" type="text" class="form-control input-md" placeholder="기업명을 입력해주세요.">
									<button type="submit" class="btn">기업검색</button>
								</div>
							</div>
						</div>
						<br>
						<!-- Button -->
						<div class="form-group" align="center">
							<button id="signup-btn" class="btn btn-default btn-md"
									style="height: 40px; width: 80px" type="button">회원가입</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<!-- /.row -->
	<hr>

	<!-- Footer -->
	<jsp:include page="components/_footer_content.jsp" />

</div>

<jsp:include page="components/_jslib.jsp" >
	<jsp:param name="_js" value="/html/js/member.js" />
</jsp:include>

<jsp:include page="components/_footer.jsp" />
