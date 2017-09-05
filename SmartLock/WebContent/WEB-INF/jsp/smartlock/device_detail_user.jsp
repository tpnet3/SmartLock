<%@ page import="smartlock.device.vo.DeviceVO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="include/_header.jsp">
	<jsp:param name="_nav" value="device" />
</jsp:include>

<!-- Page Content -->
	<div class="container">
		<!-- Service Panels -->
		<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">내 디바이스 관리</h2>
			</div>
			<br> <br>
			<div class="col-md-3 col-sm-7">
				<div class="panel panel-default text-center">
					<div class="panel-heading">
						<h3 data-bind="title">${device.nickname}</h3>
					</div>
					<div class="panel-body">
						<div>
							<c:choose>
								<c:when test="${device.type eq 1}">
									<img src="/html/img/smartphone.png"
										style="margin-left: auto; margin-right: auto; display: auto"
										width="100px">
								</c:when>
								<c:when test="${device.type ne 1}">
									<img src="/html/img/pc.png"
										style="margin-left: auto; margin-right: auto; display: auto"
										width="100px">
								</c:when>
							</c:choose>
                            <p></p>
							<p>
								<a href="#" class="btn btn-warning btn-filter"
									style="width: 80px">수정</a>&nbsp; &nbsp; &nbsp;
								<a href="#" class="btn btn-danger btn-filter" style="width: 80px">삭제</a>
							</p>
						</div>
						<div>
							<ul class="list-group text-center">
								<li class="list-group-item"><b>장치정보 :</b>${device.mac}</li>
								<li class="list-group-item"><b>등록일 :</b>${device.reg_date}</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-9 col-sm-7">
			<table class="col-sm-12 table-bordered table-striped table-condensed cf">
                		<thead class="cf" align="center">
                			<tr>
        						<td width="10px"><h4><b>No.</h4></td>
								<td width="250px"><h4><b>소프트웨어</h4></td>
								<td width="200px"><h4><b>회사명</h4></td>
								<td width="150px"><h4><b>시작일자</h4></td>
								<td width="150px"><h4><b>만료기간</h4></td>
								<td width="100px"><h4><b>상태</h4></td>
                			</tr>
                		</thead>
                		<tbody align="center">
                			<c:forEach var="license" items="${licenseList}" varStatus="index">
                				<tr>
	                				<td data-title="No.">${index.count}</td>
	                				<td data-title="소프트웨어">${license.sw_name}</td>
	                				<td data-title="회사명">${license.corp_name}</td>
	                				<td data-title="시작일자"><fmt:formatDate value="${license.start_date}" pattern="yyyy-MM-dd"/></td>
	                				<td data-title="만료기간"><fmt:formatDate value="${license.end_date}" pattern="yyyy-MM-dd"/></td>
	                				<c:choose>
										<c:when test="${license.state eq 1 }">
											<td data-title="상태"><span class="label label-success">
											발급 완료 </span></td>
										</c:when>
										<c:when test="${license.state eq 2}">
										<td data-title="상태"><span class="label label-success"
										onmouseout="this.style.background='#5cb85c';this.innerText='데모 버전';"
										onmouseover="this.style.background='#58ACFA';this.innerText='연장 요청';"
										onclick="requestDemo('${license.sw_name}');">
											데모 버전 </span></td>
										</c:when>
									</c:choose>
	                				</tr>
                			</c:forEach>
            			</tbody>
            	</table>
			</div>
			<hr>
		</div>
		<div class="row"></div>

		<hr>
	</div>
<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />
<jsp:include page="include/_jslib.jsp" />