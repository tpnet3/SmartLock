<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<jsp:include page="include/_header.jsp">
	<jsp:param name="_title" value="Signup" />
	<jsp:param name="_nav" value="" />
	<jsp:param name="_css" value="/html/css/login.css" />
	<jsp:param name="_css" value="/html/css/jquery-ui.min.css" />
</jsp:include>

<!-- Page Content -->
<div class="container">
	<!-- Service Panels -->
	<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
	<div class="row">
		<div class="col-lg-12">
			<h2 class="page-header">일반 사용자 회원가입</h2>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form class="form-horizontal" id="signup-form">
					<fieldset>
						<br>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="id">아이디</label>
							<div class="col-md-3">
								<div class="input-append">
									<input id="id" name="id" type="text" placeholder="아이디를 입력하세요."
										class="form-control with-btn input-md"
										style="width: 70%; float: left" onblur="idRegFunc()">
									<button id="check-id-btn" type="button" class="btn"
										style="width: 30%">중복확인</button>
									<h6 id="idWarning"
										style="color: #ff0000; font-size: 40%; display: inline;"></h6>
									<input type="hidden" id="checked-id" style="display: none" />
									<input type="hidden" id="is-check-id" value="false"
										style="display: none" />
								</div>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="pwd">비밀번호</label>
							<div class="col-md-3">
								<input id="pwd" name="textinput" type="password"
									placeholder="비밀번호를 입력하세요." class="form-control input-md"
									onblur="pwdRegFunc()">
								<h6 id="pwdWarning"
									style="color: #ff0000; font-size: 40%; display: inline;"></h6>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="check-pwd">비밀번호
								확인</label>
							<div class="col-md-3">
								<input id="check-pwd" name="textinput" type="password"
									placeholder="비밀번호를 재입력하세요." class="form-control input-md"
									onblur="pwdCheck()">
								<h6 id="pwdCheckWarning"
									style="color: #ff0000; font-size: 40%; display: inline;"></h6>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="name">이름</label>
							<div class="col-md-3">
								<input id="name" name="textinput" type="text"
									placeholder="이름을 입력하세요." class="form-control input-md"
									onblur="nameCheck()">
								<h6 id="nameWarning"
									style="color: #ff0000; font-size: 40%; display: inline;"></h6>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="email">이메일</label>
							<div id="email-div" class="col-md-5" style="display: inline">
								<!-- <input id="email" name="textinput" type="text" placeholder="이메일을 입력하세요." class="form-control input-md"> -->
								<input id="email-1" type="text"
									style="width: 35%; display: inline; text-align: center"
									class="form-control input-md" placeholder="이메일을 입력하세요."
									onblur="emailCheckFront()"> <b style="width: 5%">@</b>
								<input id="email-3" type="text"
									style="width: 28.9%; text-align: center; display: none;"
									class="form-control input-md" onblur="emailCheckBack()">
								<select id="email-2"
									style="width: 35%; display: inline; text-align-last: center;"
									class="form-control input-md">
									<option>naver.com</option>
									<option>daum.net</option>
									<option>gmail.com</option>
									<option>직접입력</option>
								</select> <br>
								<h6 id="emailWarning"
									style="color: #ff0000; font-size: 40%; display: inline;"></h6>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="phone">전화번호</label>
							<div class="col-md-3">
								<!-- <input id="phone" name="textinput" type="text" placeholder="전화번호를 입력해주세요." class="form-control input-md"> -->
								<select id="phone-1"
									style="width: 28%; display: inline; text-align-last: center;"
									class="form-control input-md">
									<option>010</option>
									<option>011</option>
									<option>016</option>
									<option>017</option>
									<option>018</option>
									<option>019</option>
								</select> <b style="width: 5%">-</b> <input id="phone-2" type="text"
									style="ime-mode: disable; width: 28%; display: inline; text-align: center"
									class="form-control input-md" maxlength="4"
									onkeydown="return onlyNumber(event)"
									onkeyup="removeChar(event)" oninput="maxLengthCheck(this)">
								<b style="width: 5%">-</b> <input id="phone-3" type="text"
									style="ime-mode: disable; width: 28%; display: inline; text-align: center"
									class="form-control input-md" maxlength="4"
									onkeydown="return onlyNumber(event)"
									onkeyup="removeChar(event)" oninput="maxLengthCheck(this)">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">

							<label class="col-md-5 control-label" for="company">기업명</label>
							<div class="col-md-3">
								<div class="input-append">
									<input id="corp-name" type="text" class="form-control input-md"
										placeholder="기업명을 입력해주세요." readonly
										style="width: 70%; float: left; background: #ffffff;">
									<button id="corp-searh-btn" type="button" class="btn"
										style="width: 30%">기업검색</button>
									<h6 id="corpWarning"
										style="color: #ff0000; font-size: 40%; display: inline;"></h6>
									<input id="corp-id" style="display: none" />
									<!-- <input id="checked-corp" style="display:none"/>
									<input id="is-check-corp" value="false" style="display:none"/> -->
								</div>
							</div>
						</div>
						<br>
						<!-- Button -->
						<div class="form-group" align="center">
							<button class="btn btn-default btn-md"
								style="height: 40px; width: 80px" type="button"
								onclick="signup('user')">회원가입</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />


<jsp:include page="include/_jslib.jsp">
	<jsp:param name="_js" value="/html/js/member.js" />
	<jsp:param name="_js" value="/html/js/jquery-ui.min.js" />
</jsp:include>

<jsp:include page="include/_footer.jsp" />

<script>
	var is_id_checked = false;
	var is_correct_pwd = false;

	$("#check-id-btn").on("click", function() {
		var msg = document.getElementById("idWarning");
		$.ajax({
			url : "/check/id",
			type : "GET",
			dataType : "json",
			data : {
				"id" : $("#id").val(),
			},
			success : function(data) {
				if (data.data == "ok") {
					msg.style.color = "blue";
					$('#idWarning').text("사용할 수 있는 아이디 입니다.");
					is_id_checked = true;
				} else {
					msg.style.color = "red";
					$('#idWarning').text("이미 등록된 아이디 입니다.");
				}
			},
			error : function(data, textStatus, errorThrown) {
			}
		});
	});

	function onlyNumber(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if ((keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105)
				|| keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
			return;
		else
			return false;
	}
	function removeChar(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if (keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
			return;
		else
			event.target.value = event.target.value.replace(/[^0-9]/g, "");
	}

	/* 정규식 */
	function idRegFunc() {
		var idWarning = document.getElementById("idWarning");
		idWarning.style.color = "red";

		var idVal = $('#id').val();
		var reg_id = /^[0-9a-z]{6,20}$/;
		var msg = "아이디는 6~20자의 영문 소문자, 숫자만 사용 가능합니다.";
		if (!idVal.match(reg_id)) {
			$('#idWarning').text(msg);
		} else {
			$('#idWarning').text("");
		}
	}

	function pwdRegFunc() {
		var pwdVal = $('#pwd').val();
		var reg_pwd = /^[0-9a-zA-Z\~\!\@\#\$\%\^\&\*\(\)\_\+\`\-\=\<\>\,\.\?\/\\\|\{\}\[\]\:\;\"\']{8,20}$/;
		var msg = "비밀번호는 8~20자의 영문자, 숫자, 특수문자를 사용하세요.";
		if (!pwdVal.match(reg_pwd)) {
			if (pwdVal.length == 0) {
				$('#pwdWarning').text("비밀번호를 입력하세요.");
			} else {
				$('#pwdWarning').text(msg);
			}
		} else {
			$('#pwdWarning').text("");
		}
	}
	function pwdCheck() {
		var pwd = $('#pwd').val();
		var pwdCheck = $("#check-pwd").val();
		var msg = "비밀번호가 서로 다릅니다.";
		if (pwd != pwdCheck || pwd.length == 0) {
			$('#pwdCheckWarning').text(msg);
		} else {
			is_correct_pwd = true;
			$('#pwdCheckWarning').text("");
		}
	}
	function nameCheck() {
		var nameVal = $('#name').val();
		var reg_name = /^[가-힣a-zA-Z]{3,20}/;
		var msg = "이름은 3~20자의 한글과 영문자를 사용하세요. (공백문자 불가)";
		if (!nameVal.match(reg_name)) {
			$('#nameWarning').text(msg);
		} else {
			$('#nameWarning').text("");
		}
	}
	function emailCheckFront() {
		var emailValFront = $('#email-1').val();
		var reg_email_front = /^([0-9A-Za-z_.-])+$/;
		var msg = "이메일은 숫자,영문자, 특수문자(-, _, .)으로 이루어져야합니다.";
		if (!emailValFront.match(reg_email_front)) {
			$('#emailWarning').text(msg);
		} else {
			$('#emailWarning').text("");
		}
	}
	function emailCheckBack() {
		var emailValBack = $('#email-3').val();
		var reg_email_back = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var msg = "도메인 주소가 올바르지 않습니다.";
		if (!emailValBack.match(reg_email_back)) {
			$('#emailWarning').text(msg);
		} else {
			$('#emailWarning').text("");
		}
	}

	/* 이메일 css조정 */
	$("#email-2").on("change", function() {
		if ($(this).val() == '직접입력') {
			document.getElementById('email-div').className = "col-md-6";
			$("#email-1").css("width", "28.9%");
			$("#email-2").css("width", "15%");
			$("#email-3").css("display", "inline");
		} else {
			document.getElementById('email-div').className = "col-md-5";
			$("#email-1").css("width", "35%");
			$("#email-2").css("width", "35%");
			$("#email-3").val("");
			$("#email-3").css("display", "none");
		}
	});
</script>