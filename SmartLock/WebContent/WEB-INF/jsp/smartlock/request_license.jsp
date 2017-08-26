<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="smartlock.license.vo.LicenseManagerVO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:bundle basename="resources/properties/softwareInfo">
<jsp:include page="include/_header.jsp">
	<jsp:param name="_nav" value="softwareUser" />
</jsp:include>

<div class="container">
		<!-- Service Panels -->
		<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">라이센스 요청</h2>
				<ol class="breadcrumb">
					<li><a href="License_user.html">라이센스 발급현황</a></li>
					<li><a href="License_user_request.html">라이센스 요청현황</a></li>
				</ol>
			</div>
			<!-- 검색필터-->
			<br>
			<div class="row">
				
				<div class="col-md-4"></div>
				<div class="col-md-4">

					<div class="panel text-center">
						<div class="panel-body" align="left">
						<h4>프로그램 사용을 위한 라이센스를 요청합니다.</h4>
							<hr>
							<form>
								<label>회사명</label><br>
								<div class="input-group">
									<select name="corp_name" id="corp_name"
										style="width:335px; height: 35px;">
										<option value="">${software.corp_name }</option>
									</select>
								</div>
								<br>
								<label>소프트웨어명</label>
								<div class="input-group">
									<select name="sw_name" id="sw_name"
										style="width: 335px; height: 35px;">
										<option value="">${software.sw_name }</option>
									</select>
								</div>
								<br>
								<label>종류</label><br>
								<div class="input-group">
									<select name="state" id="state"
										style="width: 335px; height: 35px;">
										<option value="">종류</option>
										<option value="1">정식 버젼</option>
										<option value="2">데모 버젼</option>
									</select>
								</div>
								
							<br>
							</form>
							<div align="center">
							<a class="btn btn-lg btn-default btn-block" onclick="request();" style="width:200px">라이센스
								요청하기</a>
								</div>
						</div>
					</div>

				</div>
			</div>

			<!-- 검색필터-->
		</div>

	</div>
<hr>
</fmt:bundle>
<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />

<!-- /.container -->

<script>
	function detail(swName) {
		// TODO: 상세보기
		alert(swName + " 에 대한 상세보기를 클릭했습니다.");
	}

	function search(name) {
		if (name.value != "default") {
			$.ajax({
				url : "/license/manager?name=" + name.value,
				type : "GET",
				contentType : "application/json",
				data : {
					name : name.value
				},
				success : function(data) {
					window.location = "/license/manager?name=" + name.value;
				},
				error : function(data, textStatus, errorThrown) {
					console.log(data);
				}
			});
		} else {
			$.ajax({
				url : "/license/manager?name",
				type : "GET",
				contentType : "application/json",
				data : {
					name : name.value
				},
				success : function(data) {
					window.location = "/license/manager?name";
				},
				error : function(data, textStatus, errorThrown) {
					console.log(data);
				}
			});
		}
	}
</script>

<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />
