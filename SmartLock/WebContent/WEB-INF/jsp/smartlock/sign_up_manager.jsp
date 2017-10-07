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
			<h1 class="page-header">관리자 회원가입</h1>
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
								<!-- <input id="email" name="textinput" type="text" placeholder="이메일을 입력하세요." class="form-control input-md"> -->
								<input id="email-1" type="text" style="width:40%; display:inline; text-align:center" class="form-control input-md"  placeholder="이메일을 입력하세요.">
								<b style="width:5%">@</b>
								<input id="email-3" type="text" style="width:33%; text-align:center; display: none;" class="form-control input-md">
								<select id="email-2" style="width:45%; display:inline; text-align-last:center;" class="form-control input-md">
									<option>naver.com</option>
									<option>daum.net</option>
									<option>gmail.com</option>
									<option>직접입력</option>
								</select>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="phone">전화번호</label>
							<div class="col-md-3">
								<!-- <input id="phone" name="textinput" type="text" placeholder="전화번호를 입력해주세요." class="form-control input-md"> -->
								<select id="phone-1" style="width:28%; display:inline;text-align-last:center;" class="form-control input-md">
									<option>010</option>
									<option>011</option>
									<option>016</option>
									<option>017</option>
									<option>018</option>
									<option>019</option>
								</select>
								<b style="width:5%">-</b>
								<input id="phone-2" type="number" style="width:28%; display:inline; text-align:center" class="form-control input-md" max="9999" maxlength="4" oninput="maxLengthCheck(this)">
								<b style="width:5%">-</b>
								<input id="phone-3" type="number" style="width:28%; display:inline; text-align:center" class="form-control input-md" max="9999" maxlength="4" oninput="maxLengthCheck(this)">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="company">기업명</label>
							<div class="col-md-3">
								<input id="corp-name" type="text" placeholder="기업명을 입력해주세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="phone">기업 전화번호</label>
							<div class="col-md-3">
								<!-- <input id="phone" name="textinput" type="text" placeholder="전화번호를 입력해주세요." class="form-control input-md"> -->
								<select id="corp-phone-1" style="width:28%; display:inline;text-align-last:center;" class="form-control input-md">
									<option>02</option>
									<option>031</option>
									<option>032</option>
									<option>033</option>
									<option>041</option>
									<option>042</option>
									<option>043</option>
									<option>051</option>
									<option>052</option>
									<option>053</option>
									<option>054</option>
									<option>055</option>
									<option>061</option>
									<option>062</option>
									<option>063</option>
									<option>064</option>
									<option>010</option>
									<option>011</option>
									<option>016</option>
									<option>017</option>
									<option>018</option>
									<option>019</option>
								</select>
								<b style="width:5%">-</b>
								<input id="corp-phone-2" type="number" style="width:28%; display:inline; text-align:center" class="form-control input-md" max="9999" maxlength="4" oninput="maxLengthCheck(this)">
								<b style="width:5%">-</b>
								<input id="corp-phone-3" type="number" style="width:28%; display:inline; text-align:center" class="form-control input-md" max="9999" maxlength="4" oninput="maxLengthCheck(this)">
							</div>
						</div>
						
						<br>
						<!-- Button -->
						<div class="form-group" align="center">
							<button type="button" class="btn btn-default btn-md"
								style="height: 40px; width: 80px" onclick="signup('manager')">회원가입</button>
						</div>

					</fieldset>
				</form>

			</div>
		</div>
	</div>
</div>
<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />

<jsp:include page="include/_jslib.jsp" >
	<jsp:param name="_js" value="/html/js/member.js" />
</jsp:include>

<jsp:include page="include/_footer.jsp" />
