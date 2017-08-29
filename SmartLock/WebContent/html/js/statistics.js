$(document).ready(function(){ 
	var total = $("#total-value").html();
	var getLicense = Math.round($("#getLicense-value").html()/total*10);
	var demo = Math.round($("#demo-value").html()/total*10);
	
	$("#total").children(".progress-left").children(".progress-bar").css("animation", "loading-5 0.5s linear forwards 0.5s");
	$("#total").children(".progress-right").children(".progress-bar").css("animation", "loading-5 0.5s linear forwards 0s");
  
	$("#license").children(".progress-left").children(".progress-bar").css("animation", "loading-5 0.5s linear forwards 0.5s");
	$("#license").children(".progress-right").children(".progress-bar").css("animation", "loading-5 0.5s linear forwards 0s");

	if(getLicense<6) {
		$("#getLicense").children(".progress-left").children(".progress-bar").css("animation", "loading-0 0.5s linear forwards 0.5s");
		$("#getLicense").children(".progress-right").children(".progress-bar").css("animation", "loading-"+(getLicense)+" 0.5s linear forwards 0s");
	} else {
		$("#getLicense").children(".progress-left").children(".progress-bar").css("animation", "loading-"+(getLicense-5)+" 0.5s linear forwards 0.5s");
		$("#getLicense").children(".progress-right").children(".progress-bar").css("animation", "loading-5 0.5s linear forwards 0s");
	}
	
	if(demo<6) {
		$("#demo").children(".progress-left").children(".progress-bar").css("animation", "loading-0 0.5s linear forwards 0.5s");
		$("#demo").children(".progress-right").children(".progress-bar").css("animation", "loading-"+(demo)+" 0.5s linear forwards 0s");
	} else {
		$("#demo").children(".progress-left").children(".progress-bar").css("animation", "loading-"+(demo-5)+" 0.5s linear forwards 0.5s");
		$("#demo").children(".progress-right").children(".progress-bar").css("animation", "loading-5 0.5s linear forwards 0s");
	}
	
	$.ajax({
		url : "/software/corp",
		type : "GET",
        contentType: "application/json",
		data : "",
		success : function (data) {
			console.log(data)
			if(data.status == "success" && data.data) {

				console.log(data.data);
				
				for (var i=0;i<data.data.length; i++) {
					$("#select-software").append("<option value='"+data.data[i].id+"'>"+data.data[i].sw_name+"</option>");
				   // console.log(sw.id);
				   // console.log(sw.sw_name);
				}
			} else {
				alert("");
			}
		},
		error : function(data, textStatus, errorThrown) {
			console.log(data);
		}
	});
});