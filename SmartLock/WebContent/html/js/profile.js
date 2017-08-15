$("#profile-form").submit(function() {
	// check validation
	if($("#email").val() == '') {
		$("#email").focus();
		alert("이메일을 입력하세요.");
		return;
	}
	if($("#phone_number").val() == '') {
		$("#phone").focus();
		alert("전화번호를 입력하세요.");
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
			"id": SmartLock.user.id, // smartlock.id -> SmartLock.user.id 로 수정되었습니다.
			"email" : $("#email").val(),
			"phone" : $("#phone_number").val(),
		}),
		success : function (data){
			if(data.status == "success") {
				//회원정보 수정 성공 페이지로 이동(메인페이지 이동버튼 제공)
				location.href="/profile_finish";
			} else {
				
			}
		},
		error : function(data, textStatus, errorThrown) {
			
		}
	});
	
	return false;
});