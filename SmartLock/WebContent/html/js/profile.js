function checkEamil(newEmail) {
    var emailVal = newEmail.val();
	var pattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

	if ( ! emailVal) {
        newEmail.focus();
        alert("이메일을 입력하세요.");
        return false;
	}

    if ( ! emailVal.match(pattern)) {
        newEmail.focus();
        alert("이메일 패턴이 올바르지 않습니다.");
        return false;
    }

    return true;
}

function checkPhone(newPhone) {
    var phoneVal = newPhone.val();
    var pattern = /^[0-9]+-[0-9]+-[0-9]+/;

    if ( ! phoneVal) {
        newPhone.focus();
        alert("전화번호를 입력하세요.");
        return false;
    }

    if ( ! phoneVal.match(pattern)) {
        newPhone.focus();
        alert("전화번호 패턴이 올바르지 않습니다.");
        return false;
    }

    return true;
}

function checkPwd(newPwd) {
    var pwdVal = newPwd.val();

    if ( ! pwdVal) {
        newPwd.focus();
        alert("비밀번호를 입력하세요.");
        return false;
    }

    if (pwdVal.length < 8) {
        newPwd.focus();
        alert("비밀번호는 8자 이상이어야 합니다.");
        return false;
    }

    if (pwdVal.length > 100) {
        newPwd.focus();
        alert("비밀번호는 100자 이하여야 합니다.");
        return false;
    }

    return true;
}

$("#updateProfile").submit(function() {
	if ( ! checkEamil($("#email"))) {
		return false;
	}

    if ( ! checkPhone($("#phone_number"))) {
        return false;
    }

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
	if ($("#new_password1").val() != $("#new_password2").val()) {
        $("#new_password2").focus();
        alert("새 비밀번호가 일치하지 않습니다.");
        return false;
	}

	if ( ! checkPwd($("#new_password1"))) {
		return false;
	}

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
            if (data.status=="success"){
                location.href = "/profile/changePassword/ok";
            }
            else {
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
