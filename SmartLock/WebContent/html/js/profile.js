$("#profile-form").submit(function() {
	// check validation
	if($("#email").val() == '') {
		$("#email").focus();
		alert("이메일을 입력하세요.");
		return;
	}
	if($("#phone_number").val() == '') {
		$("#phone_number").focus();
		alert("전화번호를 입력하세요.");
		return;
	}
	if($("#password").val() == '') {
		$("#password").focus();
		alert("비밀번호를 입력하세요.");
		return;
	}
	/*
	if($("#password").val() != $("#check-pwd").val()) {
		$("#check-pwd").focus();
		alert("비밀번호가 다릅니다.");
		return;
	}
	*/
	
	$.ajax({
		url : "/profile/update",
		type : "POST",
        contentType: "application/json",
		dataType : "json",
		data : JSON.stringify({
			"id" : SmartLock.user.id,
			"password" : $("#password").val(),
			"userName" : SmartLock.user.name,
			"email" : $("#email").val(),
			"phoneNumber" : $("#phone_number").val(),
            "corpId" : SmartLock.user.corpId,
            "authority" : SmartLock.user.authority
		}),
		success : function (data){
			if(data.status == "success") {
				//회원정보 수정 성공 페이지로 이동(메인페이지 이동버튼 제공)
				location.href="/profile/ok";
			} else {
				alert("회원정보수정실패");
			}
		},
		error : function(data, textStatus, errorThrown) {
			
		}
	});
	
	return false;
});

$("#changePassword_btn").on("click",function() {
	// check validation
	if($("#password").val() == '') {
		$("#password").focus();
		alert("현재 비밀번호를 입력하세요.");
		return false;
	}	
	else if($("#new_password1").val() == '') {
		$("#new_password1").focus();
		alert("새 비밀번호를 입력하세요.");
		return false;
	}
	else if($("#new_password2").val() == '') {
		$("#new_password2").focus();
		alert("새 비밀번호를 입력하세요.");
		return false;
	}
	else if($("#new_password1").val()!=$("#new_password2").val()){
		$("#new_password2").focus();
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	else{
		$.ajax({
			url : "/profile/change/success",
			type : "POST",
	        contentType: "application/json",
			dataType : "json",
			data : JSON.stringify({
				"id" : SmartLock.user.id,
				"password" : $("#password").val(),
				"new_password" : $("#new_password1").val()
			}),
			success : function (data){
				if(data.status == "success") {
					//회원정보 수정 성공 페이지로 이동(메인페이지 이동버튼 제공)
					location.href="/profile/changePassword/ok";
				} else {
					$("#password").focus();
					alert("현재 비밀번호가 일치하지 않습니다.");
					return false;
				}
			},
			error : function(data, textStatus, errorThrown) {
					
			}
		});		
	}
});
