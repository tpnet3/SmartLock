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
		return false;
	}

	if ( ! checkId(true)) {
        $("#id").focus();
		return false;
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

$("#copr-searh-btn").on("click",function(){
	//var buttonText = "Ok" ;
    var title = "The page says:";

    var div = $('<div id="dialog">');
    div.attr('title', "회사명 검색");
    div.html('<div>'+
    			'<div style="width:100%" align="center">'+
    				'<input id="dialog-corp-name" type="text" placeholder="기업명을 입력해주세요." style="width:70%">'+
    				'<button id="dialog-corp-search-btn" style="width:30%">검색</button>'+
    			'</div>'+
    			'<table id="table-corp" style="text-align:center; margin-top:10px; margin-bottom:10px" width="100%">'+
    				'<thead>'+
    					'<tr>'+
    						'<td width="50%">회사명</>'+
    						'<td width="50%">전화번호</>'+
    					'</tr>'+
    				'</thead>'+
    			'</ul>'+
    		'</div>');
    div.dialog({
        autoOpen: true,
        modal: true,
        draggable: false,
        resizable: false/*,
        buttons: [{
            text: buttonText,
            click: function () {
                $(this).dialog("close");
                div.remove();
            }
        }]*/
    });
	
    $("#dialog-corp-search-btn").on("click",function(){
    	if($("#dialog-corp-name").val() == '') {
    		$("#dialog-corp-name").focus();
    		alert("회사명을 입력해주세요.")
    		return;
    	}
    	
    	$.ajax({
    		url : "/check/corpname",
    		type : "POST",
    		dataType : "json",
    		data : {
    			"corp_name" : $("#dialog-corp-name").val(),
    		},
    		success : function (data){
    			if(data.status == "success") {
    				if(data.data != null) {
    					$('#table-corp > tbody').remove();
    					$('#no-serch-result').remove();
    					$('#table-corp').append('<tbody></tbody>');
    					if(data.data.length != 0) {
    						for(var i=0;i<data.data.length; i++) {
        						$('#table-corp > tbody:last').append('<tr>'+
        																'<td><a onclick="clickCorp(\''+data.data[i].id+'\',\''+data.data[i].corp_name+'\')">'+data.data[i].corp_name+'</a></td>'+
        																'<td>'+data.data[i].phone+'</td>'+
        															'</tr>');
        					}
    					} else {
    						$("#dialog").append('<h5 id="no-serch-result" style="text-align:center">검색 결과가 존재하지 않습니다.</h5>')
    					}
    				} else {
    					
    				}
    			} else {
    				
    			}
    		},
    		error : function(data, textStatus, errorThrown) {
    			
    		}
    	});
    });
});

function clickCorp(corp_id, corp_name) {
	$("#corp-id").val(corp_id);
	$("#corp-name").val(corp_name);
	$("#dialog").dialog("close");
}
function checkId(checkOnlyPattern) {
    var idVal = $("#id").val();
    var pattern = /^[0-9a-z]+$/;

	if ( ! idVal) {
		$("#id").focus();
		alert("아이디를 입력하세요.");
		return false;
	}

    if (idVal.length < 6) {
        $("#id").focus();
        alert("아이디는 6자 이상이어야 합니다..");
        return false;
    }

    if (idVal.length > 20) {
        $("#id").focus();
        alert("아이디는 20자 이하여야 합니다.");
        return false;
    }

    if ( ! idVal.match(pattern)) {
        $("#id").focus();
        alert("아이디는 영문 소문자와 숫자로 이루어져야합니다.");
        return false;
    }

    if ( ! checkOnlyPattern) {

        if($("#checked-id").val() != $("#id").val()) {
            $("#is-check-id").val("false");
        } else {
            $("#is-check-id").val("true");
        }

        if($("#is-check-id").val() == "false") {
            $("#id").focus();
            alert("아이디 중복체크를 하세요.");
            return false;
        }
	}

	return true
}
function checkPwd() {
	var pwdVal = $("#pwd").val();

	if ( ! pwdVal) {
		$("#pwd").focus();
		alert("비밀번호를 입력하세요.");
		return false;
	}

    if (pwdVal.length < 8) {
        $("#pwd").focus();
        alert("비밀번호는 8자 이상이어야 합니다.");
        return false;
    }

    if (pwdVal.length > 100) {
        $("#pwd").focus();
        alert("비밀번호는 100자 이하여야 합니다.");
        return false;
    }

	if (pwdVal.match())

	if($("#check-pwd").val() == '') {
		$("#check-pwd").focus();
		alert("비밀번호 확인을 입력하세요.");
		return false;
	}

	if($("#pwd").val() != $("#check-pwd").val()) {
		$("#check-pwd").focus();
		alert("비밀번호가 다릅니다.");
		return false;
	}

	return true;
}

function checkEmail() {
    var pattern1 = /^([0-9A-Za-z_.-])+$/;
    var pattern2 = /^(([a-zA-Z]{1})|([a-zA-Z]{1}[a-zA-Z]{1})|([a-zA-Z]{1}[0-9]{1})|([0-9]{1}[a-zA-Z]{1})|([a-zA-Z0-9][a-zA-Z0-9-_]{1,61}[a-zA-Z0-9]))\.([a-zA-Z]{2,6}|[a-zA-Z0-9-]{2,30}\.[a-zA-Z]{2,3})$/;
	var email1Val = $("#email-1").val();
	var email3Val = $("#email-3").val();

	if ( ! email1Val) {
		$("#email-1").focus();
		alert("이메일을 입력하세요.");
		return false;
	}

    if (email1Val.length > 50) {
        $("#email-1").focus();
        alert("이메일은 50자 이하여야 합니다.");
        return false;
    }

    if ( ! email1Val.match(pattern1)) {
        $("#email-1").focus();
        alert("이메일은 숫자, 영문자, 특수문자(-, _, .)으로 이루어져야합니다.");
        return false;
	}

	if ($("#email-2").val() == '직접입력') {

		if ( ! email3Val) {
			$("#email-3").focus();
			alert("이메일 도메인을 입력하세요.");
			return false;
		}

        if ( ! email3Val.match(pattern2)) {
            $("#email-3").focus();
            alert("도메인 주소가 올바르지 않습니다.");
            return false;
        }
	}

	return true;
}

function checkPhone(phone2ElemKey, phone3ElemKey) {
    phone2ElemKey = phone2ElemKey || "#phone-2";
    phone3ElemKey = phone3ElemKey || "#phone-3";

    var phone2Val = $(phone2ElemKey).val();
    var phone3Val = $(phone3ElemKey).val();
	var pattern = /^[0-9]+$/;

	if( ! phone2Val) {
		$(phone2ElemKey).focus();
		alert("전화번호를 입력하세요.");
		return false;
	}

    if(phone2Val.match(pattern)) {
        $(phone2ElemKey).focus();
        alert("전화번호가 올바르지 않습니다.");
        return false;
    }

    if( ! phone3Val) {
        $(phone3ElemKey).focus();
        alert("전화번호를 입력하세요.");
        return false;
    }

	if(phone3Val.match(pattern)) {
		$(phone3ElemKey).focus();
        alert("전화번호가 올바르지 않습니다.");
		return false;
	}

	return true;
}

function signup(div) {
	// check validation
	if(!checkId()){
		return false;
	}
	if(!checkPwd()){
		return false;
	}
	if($("#name").val() == '') {
		$("#name").focus();
		alert("이름을 입력하세요.");
		return false;
	}
	if(!checkEmail()){
		return false;
	}
	if(!checkPhone()){
		return false;
	}
	
	var phone = $("#phone-1").val()+"-"+$("#phone-2").val()+"-"+$("#phone-3").val();
	var email;
	
	if($("#email-2").val() == '직접입력') {
		email = $("#email-1").val()+"@"+ $("#email-3").val();
	} else {
		email = $("#email-1").val()+"@"+ $("#email-2").val();
	}
	
	if(div == 'user') {
		if($("#corp-id").val() == '') {
			$("#corp_name").focus();
			alert("기업명을 입력하세요.");
			return false;
		}
		var data = {
			"id" : $("#id").val(),
			"pwd" : $("#pwd").val(),
			"name" : $("#name").val(),
			"email" : email,
			"phone" : phone,
		    "corp_id" : $("#corp-id").val(),
		    "authority" : $("#authority").val()
		};
				
		sigupPost(data);
	} else {
		if ( ! check("#corp-phone-2", "#corp-phone-3")) {
			return;
		}

		var corpPhone = $("#corp-phone-1").val()+"-"+$("#corp-phone-2").val()+"-"+$("#corp-phone-3").val();
		
		var corpDate = {
			"corp_name" : $("#corp-name").val(),
			"phone" : corpPhone
		};
		
		$.ajax({
			url : "/insert/corp",
			type : "POST",
	        contentType: "application/json",
			dataType : "json",
			data : JSON.stringify(corpDate),
			success : function (data){
				if(data.status == "success") {
					var formData = {
						"id" : $("#id").val(),
						"pwd" : $("#pwd").val(),
						"name" : $("#name").val(),
						"email" : email,
						"phone" : phone,
						"corp_id" : data.data[0].id,
						"authority" : $("#authority").val()
					};
					
					sigupPost(formData)
				} else {
					
				}
			},
			error : function(data, textStatus, errorThrown) {
				
			}
		});
	}
}

function sigupPost(data) {
	$.ajax({
		url : "/signup",
		type : "POST",
        contentType: "application/json",
		dataType : "json",
		data : JSON.stringify(data),
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
}

function maxLengthCheck(object) {
	if (object.value.length > object.maxLength) {
		object.value = object.value.slice(0, object.maxLength);
	}
}

$("#email-2").on("change", function() {
	if($(this).val() == '직접입력') {
		$("#email-2").css("width","15%");
		$("#email-3").css("display", "inline");
	} else {
		$("#email-2").css("width","45%");
		$("#email-3").val("");
		$("#email-3").css("display", "none");
	}
})
