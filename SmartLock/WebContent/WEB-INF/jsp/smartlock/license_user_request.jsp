<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="smartlock.license.vo.LicenseUserReqVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="include/_header.jsp">
	<jsp:param name="_title" value="License" />
	<jsp:param name="_nav" value="license" />
	<jsp:param name="_css" value="/html/css/mouse-over.css" />
</jsp:include>

<!-- Page Content -->
<div class="container" id="pageContainer">
	<div class="row">
		<div class="col-lg-12">
			<h2 class="page-header">라이센스 요청현황</h2>
			<ol class="breadcrumb">
				<li><a href="/license/user?name">라이센스 발급현황</a>
				</li>
				<li class="active">라이센스 요청현황</li>
			</ol>
		</div>
		<!-- 검색필터-->
		 <div class="row">
		<div class="col-sm-12">
			<div class="col-sm-2">
				<div class="input-group">
					<select name="" id="sw_list"
					style="width: 180px; height: 35px;">
					<option value="">소프트웨어명</option>
					<c:forEach var="sw" items="${swNameList}" varStatus="count">
					<option value="${swIdList[count.count-1]}">${sw }</option>
					</c:forEach>
				</select>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="input-group">
					<select name="" id="order"
					style="width: 180px; height: 35px;">
					<option value=0>요청 날짜</option>
					<option value=1>오름차순</option>
					<option value=2>내림차순</option>
				</select>
				</div>
			</div>
			<div class="col-sm-6">
			<input type="text" class="col-md-4" placeholder="검색어를 입력하세요"
					id="searchField" style="width: 300px; height: 35px;">&nbsp;&nbsp;
					<button class="btn btn-primary" type="button" id="searchButton" onclick="search();"
					data-loading-text="Searching..">
					<i class="fa fa-search"></i>
				</button>
				</div>
			</div>

		</div>
		<br>
		<!-- 검색필터-->
</div>
<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 class="text-center">
				</h2>
			</div>
			<div id="no-more-tables">
				<table class="col-sm-12 table-bordered table-striped table-condensed cf">
					<thead class="cf" align="center">
						<tr>
							<td width="10px"><h4><b>No.</b></h4></td>
							<td width="230px"><h4><b>소프트웨어</b></h4></td>
							<td width="200px"><h4><b>회사명</b></h4></td>
							<td width="150px"><h4><b>요청일자</b></h4></td>
							<td width="100px"><h4><b>상태</b></h4></td>
						</tr>
					</thead>
					<tbody align="center">
					<c:forEach var="license" items="${licenseUserReqList}" varStatus="count">
					<tr>
						<td data-bind="no" class="data-no">${count.count }</td>
						<td data-bind="소프트웨어">${license.sw_name }</td>
						<td data-bind="회사명">${license.corp_name }</td>
						<td data-bind="요청일자"><fmt:formatDate value="${license.request_date}" pattern="yyyy-MM-dd"/></td>
						<c:choose>
								<c:when test="${license.state eq 1 }">
						<td data-bind="상태일반요청">
							<span class="label label-success">
								일반 요청
							</span>
						</td>
						</c:when>
							<c:when test="${license.state eq 2}">
						<td data-bind="상태데모요청">
							<span class="label label-success">데모 요청
							</span>
						</td>
						</c:when>
							<c:when test="${license.state eq 3}">
						<td data-bind="상태발급거절">
							<span class="label label-danger"
								  onmouseout="this.style.background='#DF5A5A';this.innerText='발급 거절';"
								  onmouseover="this.style.background='#58ACFA';this.innerText='발급 재요청';"
								  onclick="return requestLicense('${license.sw_name}');">
								발급거절
							</span>
						</td>
						</c:when>
							</c:choose>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</div>

<hr>

<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />

<jsp:include page="include/_jslib.jsp" />

<script>
    function requestDemo(swName) {
        alert(swName + " 에 대한 데모 기간 연장을 요청합니다.");
    }

    function requestLicense(swName) {
        alert(swName + " 에 대한 라이센스를 요청합니다.");
    }
    
    function search() {
    	var sw_id = $("#sw_list option:selected").val();
    	var sw_name = $("#sw_list option:selected").text();
    	var orderIndex = $("#order option").index($("#order option:selected"));
    	var order = "";
    	
    	
    	if(orderIndex == 1) {
    		order = "ASC";
    	} else if(orderIndex == 2) {
    		order = "DESC";
    	} else if (orderIndex == 0) {
    		order = "DEFAULT";
    	}
    	
    	$.ajax({
			url:"/license/user/request",
			type:"GET",
			contentType: "application/json",
		 	data : {
			sw_id : sw_id,
			order : order
		},
         success : function (data) {
        	 $("#pageContainer").html(data);
         },
         error : function(data, textStatus, errorThrown) {
             console.log(data);
         }
		}); 
	}
</script>

<jsp:include page="include/_footer.jsp" />
