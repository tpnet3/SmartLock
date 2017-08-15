$("#login-form").submit(function() {
	var data = {
		"id" : $("#id").val(),
		"pwd" : $("#pwd").val()
	};

	$.ajax({
		url : "/login",
		type : "POST",
        contentType: "application/json",
		data : JSON.stringify(data),
		success : function (data) {
			if(data.status == "success" && data.data) {
				// 메인페이지로이동
                window.location.href = "/";
			} else {
				alert("아이디 또는 비밀번호가 잘못되었습니다");
			}
		},
		error : function(data, textStatus, errorThrown) {
			console.log(data);
		}
	});

	return false;
});

$("#check-id-btn").on("click",function(){
	if($("#id").val() == '') {
		$("#id").focus();
		return;
	}
	
	$.ajax({
		url : "/check/id",
		type : "GET",
		dataType : "json",
		data : {
			"id" : $("#id").val(),
		},
		success : function (data){
			if(data.status == "success") {
				if(data.data == "ok") {
					alert("사용가능한 아이디 입니다.");
					$("#is-ckeck-id").val("true");
					$("#checked-id").val($("#id").val());
				} else {
					alert("중복된 아이디 입니다.");
					$("#is-ckeck-id").val("false");
					$("#checked-id").val();
				}
			} else {
				
			}
		},
		error : function(data, textStatus, errorThrown) {
			
		}
	});
});

$("#signup-form").submit(function() {
	// check validation
	if($("#id").val() == '') {
		$("#id").focus();
		alert("아이디를 입력하세요.");
		return;
	}
	if($("#pwd").val() == '') {
		$("#pwd").focus();
		alert("비밀번호를 입력하세요.");
		return;
	}
	if($("#check-pwd").val() == '') {
		$("#pwd").focus();
		alert("비밀번호 확인을 입력하세요.");
		return;
	}
	if($("#name").val() == '') {
		$("#name").focus();
		alert("이름을 입력하세요.");
		return;
	}
	if($("#email").val() == '') {
		$("#email").focus();
		alert("이메일을 입력하세요.");
		return;
	}
	if($("#phone").val() == '') {
		$("#phone").focus();
		alert("전화번호를 입력하세요.");
		return;
	}
	if($("#corp_id").val() == '') {
		$("#corp_name").focus();
		alert("기업명을 입력하세요.");
		return;
	}
	if($("#checked-id").val() != $("#id").val()) {
		$("#is-check-id").val("false");
	} else {
		$("#is-check-id").val("true");
	}
	if($("#is-check-id").val() == "false") {
		$("#id").focus();
		alert("아이디 중복체크를 하세요.");
		return;
	}
	if($("#pwd").val() != $("#check-pwd").val()) {
		$("#check-pwd").focus();
		alert("비밀번호가 다릅니다.");
		return;
	}

	$.ajax({
		url : "/signup",
		type : "POST",
        contentType: "application/json",
		dataType : "json",
		data : JSON.stringify({
			"id" : $("#id").val(),
			"pwd" : $("#pwd").val(),
			"name" : $("#name").val(),
			"email" : $("#email").val(),
			"phone" : $("#phone").val(),
			"company" : $("#company").val()
		}),
		success : function (data){
			if(data.status == "success") {
				//회원가입 성공 페이지로 이동(로그인페이지이동버튼제공)
				location.href="/signup/ok";
			} else {
				
			}
		},
		error : function(data, textStatus, errorThrown) {
			
		}
	});

	return false;
});