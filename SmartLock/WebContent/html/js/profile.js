$("#profile-btn").on("click", function() {
	// check validation
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
	if($("#pwd").val() != $("#check-pwd").val()) {
		$("#check-pwd").focus();
		alert("비밀번호가 다릅니다.");
		return;
	}

	$.ajax({
		url : "/profile_user",
		type : "POST",
        contentType: "application/json",
		dataType : "json",
		data : {
			"email" : $("#email").val(),
			"phone" : $("#phone").val(),
		},
		success : function (data){
			if(data.status == "success") {
				//회원가입 성공 페이지로 이동(로그인페이지이동버튼제공)
				location.href="/profile_finish";
			} else {
				
			}
		},
		error : function(data, textStatus, errorThrown) {
			
		}
	});
});