$("#login-btn").on("click", function() {
	/*var data = new FormData();
	alert($("#id").val());
	data.append("id", $("#id").val());
	data.append("pwd", $("#pwd").val());*/
	/*console.log($("#id").val());
	console.log($("#pwd").val());
	alert(11)*/
	$.ajax({
		url : "/login",
		type : "POST",
		dataType : "json",
		data : {
			"id" : $("#id").val(),
			"pwd" : $("#pwd").val()
		},
		//processData : false,
		//contentType : false,
		success : function (data){
			if(data.result == "success") {
				
			} else {
				
			}
		},
		error : function(data, textStatus, errorThrown) {
			
		}
	});
});
