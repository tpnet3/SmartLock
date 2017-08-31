$(function() {
	$.ajax({
		url : "/profile/getCorpName",
		type : "POST",
        contentType: "application/json",
		dataType : "json",
		data : JSON.stringify({
            "id" : SmartLock.user.corpId,
		}),
       success : function (data){
			alert(data);
       },
		error : function(data, textStatus, errorThrown) {
			alert("error");
		}
	});
	
	return false;
});

$("#updateProfile").submit(function() {	
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
				$("#password").focus();
				alert("현재 비밀번호가 일치하지 않습니다.")
			}
		},
		error : function(data, textStatus, errorThrown) {
			alert("ajax통신실패");
		}
	});
	
	return false;
});

$("#changePassword").submit(function() {
	alert(SmartLock.user.corp_name);
	if($("#new_password1").val()!=$("#new_password2").val()){
		$("#new_password2").focus();
		alert("새 비밀번호가 일치하지 않습니다.");
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
				if(data.status=="success"){
					location.href="/profile/changePassword/ok";
				}
				else{
					$("#password").focus();
					alert("현재 비밀번호가 일치하지 않습니다.")
				}
			},
			error : function(data, textStatus, errorThrown) {
				alert("ajax통신실패");
			}
		});
	}
	
	return false;
});

$("#removeUser").submit(function() {
	if($("#password1").val()!=$("#password2").val()){
		$("#password2").focus();
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	else{
		$.ajax({
			url : "/profile/quit/success",
			type : "POST",
	        contentType: "application/json",
			dataType : "json",
			data : JSON.stringify({
				"id" : SmartLock.user.id,
				"password" : $("#password1").val(),
			}),
			success : function (data){				
				if(data.status=="success"){
					location.href="/profile/quit/ok";
				}
				else{
					$("#password1").focus();
					alert("비밀번호를 다시 확인해주세요.")
				}
			},
			error : function(data, textStatus, errorThrown) {
				alert("ajax통신실패");
			}
		});
	}
	
	return false;
});
