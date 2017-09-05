<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="smartlock.license.vo.LicenseManagerVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="include/_header.jsp">
	<jsp:param name="_nav" value="license" />
</jsp:include>

<!-- Header Carousel -->
<div class="container">
	<!-- Page Heading/Breadcrumbs -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">라이센스 관리
				<small>발급 완료 현황</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="/license/manager/request?order=DEFAULT">발급 대기 현황</a></li>
				<li class="active">발급 완료 현황</li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="row">
			<div class="col-sm-12">
				<div class="col-sm-2">
					<div class="input-group">
						<select name="" id="sw_list"
								style="width: 180px; height: 35px;">
							<option value="">소프트웨어명</option>
							<c:forEach var="sw" items="${swNameList}" varStatus="count">
								<option value= "${swIdList[count.count-1]}">${sw}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="input-group">
						<select name="" id="order"
								style="width: 180px; height: 35px;">
							<option value=0>만료 날짜</option>
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
				<h2 class="text-center"></h2>
			</div>
			<div id="no-more-tables">
				<table
						class="col-sm-12 table-bordered table-striped table-condensed cf">
					<thead class="cf" align="center">
					<tr>
						<td width="10px"><h4><b>No.</h4></td>
						<td width="250px"><h4><b>소프트웨어명</h4></td>
						<td width="100px"><h4><b>이름</h4></td>
						<td width="100px"><h4><b>발급날짜</h4></td>
						<td width="100px"><h4><b>만료날짜</h4></td>
						<td width="150px"><h4><b>분류</h4></td>
						<td width="100px"><h4><b>상세보기</h4></td>
					</tr>
					</thead>
					<tbody align="center">
					<c:forEach var="license" items="${licenseManagerList}" varStatus="count">
					<tr>
						<td data-title="No.">${count.count }</td>
						<td data-title="소프트웨어">${license.sw_name }</td>
						<td data-title="이름">${license.user_name }</td>
						<td data-title="발급날짜"><fmt:formatDate value="${license.start_date}" pattern="yyyy-MM-dd"/></td>
						<td data-title="만료날짜"><fmt:formatDate value="${license.end_date}" pattern="yyyy-MM-dd"/></td>
						<c:choose>
							<c:when test="${license.state eq 1 }">
								<td data-title="상태"><span class="label label-success">일반
										신청</span></td>
							</c:when>
							<c:when test="${license.state eq 2}">
								<td data-title="상태"><span class="label label-warning">데모
										신청</span></td>
							</c:when>
						</c:choose>
						<td data-title="상세보기">
							<span class="label" style="background-color: darkgray; color: black"
							      onclick="detail('${license.sw_name}');">
								상세 보기
							</span>
						</td>
					</tr>
					</c:forEach>
						</tbody>
				</table>
			</div>
		</div>

	</div>
</div>
<!-- /.row -->

<!-- /.row -->
<hr>

<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />

<!-- /.container -->

<script>
    function detail(swName) {
        // TODO: 상세보기
        alert(swName + " 에 대한 상세보기를 클릭했습니다.");
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
			url:"/license/manager",
			type:"GET",
			contentType: "application/json",
		 	data : {
			sw_id : sw_id,
			order : order
		},
         success : function (data) {
        	 window.location = "/license/manager?sw_id="+sw_id+"&order="+order;
         },
         error : function(data, textStatus, errorThrown) {
             console.log(data);
         }
		});
    }
</script>

<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />
