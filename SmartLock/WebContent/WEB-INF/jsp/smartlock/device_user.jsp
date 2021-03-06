<%@ page import="smartlock.device.vo.DeviceVO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!-- Page Content -->
<div id="pageContainer" class="container">
<jsp:include page="include/_header.jsp">
	<jsp:param name="_nav" value="device" />
</jsp:include>
	<!-- Service Panels -->
	<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">내 단말기 관리</h1>
		</div>
		<!-- 검색필터-->
		<div class="row">
			<div class="col-sm-12">
				<div class="col-sm-2">
					<div class="input-group">
						<select name="" id="sw_list" style="width: 180px; height: 35px;"
							data-toggle="tooltip" data-placement="bottom" title="소프트웨어">
							<option>소프트웨어명</option>
							<c:forEach var="sw" items="${swNameList}">
								<option>${sw}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="input-group">
						<select name="" id="order" style="width: 180px; height: 35px;"
							data-toggle="tooltip" data-placement="bottom" title="날짜">
							<option>등록날짜</option>
							<option>오름차순</option>
							<option>내림차순</option>
						</select>
					</div>
				</div>
				<div class="col-sm-6">
					<!-- <input type="text" class="col-md-4" placeholder="검색어를 입력하세요"
						id="searchField" style="width: 300px; height: 35px;">&nbsp;&nbsp; -->
					<button class="btn btn-primary" type="button" id="searchBtn"
						data-loading-text="Searching.." onclick="search();"
						data-toggle="tooltip" data-placement="bottom" title="검색">
						<i class="fa fa-search"></i>
					</button>
				</div>
				<!--
				<div class="col-sm-2" align="right">
				<a class="btn btn-danger">디바이스 추가하기</a>
				</div>-->
			</div>

		</div>
		<br> <br>
		<c:forEach var="device" items="${deviceList}">
			<div class="col-md-3 col-sm-7">
				<div class="panel panel-default text-center">
					<div class="panel-heading">
						<h3>${device.nickname}</h3>
					</div>
					<div class="panel-body">
						<div>
							<%
								// TODO: PC 와 스마트폰 구분
							%>
							<c:choose>
								<c:when test="${device.type eq 1}">
									<img src="/html/img/smartphone.png"
										style="margin-left: auto; margin-right: auto; display: auto"
										width="100px" data-toggle="tooltip" data-placement="bottom"
										title="모바일">
								</c:when>
								<c:when test="${device.type ne 1}">
									<img src="/html/img/pc.png"
										style="margin-left: auto; margin-right: auto; display: auto;"
										width="100px" data-toggle="tooltip" data-placement="bottom"
										title="PC">
								</c:when>
							</c:choose>
							<p></p>
							<p>
								<a href="#" class="btn btn-warning btn-filter"
									style="width: 80px"
									onclick="return clickEdit(${device.id}, '${device.nickname}');"
									data-toggle="tooltip" data-placement="bottom" title="디바이스 수정">수정</a>&nbsp;
								&nbsp; &nbsp; <a href="#" class="btn btn-danger btn-filter"
									style="width: 80px"
									onclick="return clickDelete(${device.id}, '${device.nickname}');"
									data-toggle="tooltip" data-placement="bottom" title="디바이스 삭제">삭제</a>
							</p>
						</div>
						<div>
							<ul class="list-group text-center">
								<%
									// TODO: 장치명, 장치정보, 등록일 정보 표시
								%>
								<!--<li class="list-group-item"><b>장치명 :</b> iPhone7 (mobile)</li>-->
								<li class="list-group-item"><b>단말기정보 : </b>${device.mac}</li>
								<li class="list-group-item"><b>등록일 : </b>${device.reg_date}</li>
							</ul>
							<a href="#" class="btn btn-default" style="width: 180px"
								onclick="return clickShowLicense('${device.id}');"
								data-toggle="tooltip" data-placement="bottom" title="라이선스 조회">라이선스
								조회</a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- Footer -->
	<jsp:include page="include/_footer_content.jsp" />
</div>
<!-- /.container -->


<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />

<script>

	if('${sw}' == "") {
		$("#sw_list option:eq(0)").prop("selected", true);
	} else {
		$("#sw_list").val('${sw}').prop("selected", true);	
	}
	
	if('${order}' == "") {
		$("#order option:eq(0)").prop("selected", true);
	} else {
		$("#order").val('${order}').prop("selected", true);
	}

	/**
	 * 디바이스 수정 클릭시
	 * @param {number} deviceId 디바이스 아이디
	 * @param {string} oldNickname 기존 디바이스 닉네임
	 * @return {boolean} False
	 */
	function clickEdit(deviceId, oldNickname) {
        //var newNickname = prompt("닉네임을 입력해주세요...", oldNickname);
        var name;
        
        swal({
	  		  text: "닉네임을 변경하시겠습니까?",
	  		  icon: "info",	//error, success, info, warning
	  		  buttons: {
	  			  cancel : "취소",
	  			  confirm : "확인",
	  		  },
	  		  dangerMode: false,
	  		}).then(function(isConfirm){
	  			if(isConfirm == null){
	  				 swal({
	  			  		  text: "변경을 취소합니다.",
	  			  		  icon: "info",	//error, success, info, warning
	  			  		  button: {
	  			  			  confirm : "확인",
	  			  		  },
	  			  		  dangerMode: false,
	  			  		});
	  			} else {
	  				swal({
	  		  		  text: "닉네임을 입력해주세요.",
	  		  		  icon: "info",	//error, success, info, warning
	  		  		  button: {
	  		  			  confirm : "확인",
	  		  		  },
	  		  		  dangerMode: false,
	  		  			content: {
	  		  		    	element: "input",
	  		  		   	 	attributes: {
	  		  		   	   		placeholder: "닉네임을 입력하세요.",
	  		  		    	},
	  		  		  },
	  		  		}).then(newNickname =>{
		  		  		if (newNickname && newNickname != oldNickname) {
		  		            $.ajax({
		  		                url : "/device/update/nickname",
		  		                type : "POST",
		  		                contentType: "application/json",
		  		                data : JSON.stringify({
		  		                    id: deviceId,
		  		                    nickname: newNickname
		  		                }),
		  		                success : function (data) {
		  		                    if(data.status == "success") {
		  		                        //alert("단말기 닉네임이 수정되었습니다.");
		  		                      swal({
		  			  			  		  text: "단말기 닉네임이 수정되었습니다.",
		  			  			  		  icon: "success",	//error, success, info, warning
		  			  			  		  button: {
		  			  			  			  confirm : "확인",
		  			  			  		  },
		  			  			  		  dangerMode: false,
		  			  			  		});
		  		                      setTimeout(3000);
		  		                        location.reload();
		  		                    } else {
		  		                        //alert("단말기 닉네임을 수정하는데 실패했습니다.");
		  		                      	swal({
		  			  			  		  text: "단말기 닉네임을 수정하는데 실패했습니다..",
		  			  			  		  icon: "error",	//error, success, info, warning
		  			  			  		  button: {
		  			  			  			  confirm : "확인",
		  			  			  		  },
		  			  			  		  dangerMode: false,
		  			  			  		});
		  		                      setTimeout(3000);
		  		                    }
		  		                },
		  		                error : function(data, textStatus, errorThrown) {
		  		                    console.log(data);
		  		                }
		  		            });
		  		        }
	  		  		});
	  			}
	  		});
        
       
		return false;
	}

    /**
	 * 디바이스 삭제 클릭시
     * @param {number} deviceId 디바이스 아이디
     * @param {string} nickname 디바이스의 닉네임
     * @return {boolean} False
     */
	function clickDelete(deviceId, nickname) {
        //var checkDelete = confirm(nickname + " 를 삭제하시겠습니까?");
        swal({
  			text: nickname + "를 삭제하시겠습니까?",
  			icon: "warning",	//error, success, info, warning
  			buttons : {
			  cancel : "취소",
			  confirm : "확인",
		  },
  		  dangerMode: false,
  		}).then(function(isConfirm){
  		  if(isConfirm == null)
  			swal({
  	  		  text: "취소되었습니다",
  	  		  icon: "info",	//error, success, info, warning
  	  		button: {
	  			  confirm : "확인",
	  		  },
  	  		  dangerMode: false,
  	  		});
  		  else
  			$.ajax({
                url : "/device/delete",
                type : "POST",
                contentType: "application/json",
                data : JSON.stringify({
					id: deviceId
				}),
                success : function (data) {
                    if(data.status == "success") {
						//alert("단말기가 삭제되었습니다.");
						swal({
				  	  		  text: "단말기가 삭제되었습니다.",
				  	  		  icon: "success",	//error, success, info, warning
				  	  		  button: {
				  	  			  confirm : "확인",
				  	  		  },
				  	  		  dangerMode: false,
				  	  		});
						setTimout(3000);
						location.reload();
                    } else {
                        //alert("단말기를 삭제하는데 실패했습니다.");
                        swal({
				  	  		  text: "단말기를 삭제하는데 실패했습니다.",
				  	  		  icon: "error",	//error, success, info, warning
				  	  		  button: {
				  	  			  confirm : "확인",
				  	  		  },
				  	  		  dangerMode: false,
				  	  		});
                        setTimout(3000);
                    }
                },
                error : function(data, textStatus, errorThrown) {
                    console.log(data);
                }
            });
  	  });
	}

    /**
	 * 라이선스 보기 클릭시
     * @param deviceId 디바이스 아이디
     */
	function clickShowLicense(deviceId) {
    	 $.ajax({
    		url: "/device/license",
    		type: "GET",
    		contentType: "application/json",
    		data: ({
    			id: deviceId
    		}),
    		success: function(data) {
    			$(location).attr("href", "/device/license?id="+deviceId);
    		},
    		error: function(data, textStatus, errorThrown) {
    			console.log(data);
    		}
    	 });
	}
    
    
   /*
   	* 검색버튼 클릭 - 소프트웨어 별 단말기 조회, 닉네임으로 오름차순 내림차순 정렬
    */
    function search() {
    	var swIndex = $("#sw_list option").index($("#sw_list option:selected"));
    	var sw = $("#sw_list option:selected").val();
    	var orderIndex = $("#order option").index($("#order option:selected"));
    	var order = "";
    	
    	if(orderIndex == 1) {
    		order = "ASC";
    	} else if(orderIndex == 2) {
    		order = "DESC";
    	}
    	
    	if(swIndex == 0) {
    		sw = "";
    	}

    	$.ajax({
    		url: "/device",
    		type: "GET",
    		contentType: "application/json",
    		data: {
    			sw: sw,
    			order: order
    		},
    		success: function (data) {
    				console.log(data);
    				$("#pageContainer").html(data);
					$(".dropdown-toggle").dropdown();
    		},
    		error: function (data, textStatus, errorThrown) {
    			console.log(data);
    		}
    	});
    }

</script>
