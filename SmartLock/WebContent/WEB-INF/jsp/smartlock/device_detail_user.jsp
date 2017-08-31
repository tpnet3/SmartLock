<%@ page import="smartlock.device.vo.DeviceVO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

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
			<!-- 검색필터-->
			<div class="row">
			<div class="col-sm-12">
				<div class="col-sm-2">
					<div class="input-group">
						<select name="" id="location1"
						style="width: 180px; height: 35px;">
						<option value="">소프트웨어명</option>
						<option value="">Microsoft Excel</option>
						<option value="">Parallels Desktop</option>
						<option value="">Adobe CC</option>
						<option value="">Football Manager</option>
					</select>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="input-group">
						<select name="" id="location1"
						style="width: 180px; height: 35px;">
						<option value="">등록 날짜</option>
						<option value="">오름차순</option>
						<option value="">내림차순</option>
					</select>
					</div>
				</div>
				<div class="col-sm-6">
				<input type="text" class="col-md-4" placeholder="검색어를 입력하세요"
						id="searchField" style="width: 300px; height: 35px;">&nbsp;&nbsp;
				<button class="btn btn-primary" type="button" id="searchButton"
						data-loading-text="Searching..">
						<i class="fa fa-search"></i>
					</button>
					</div>
				</div>
				
			</div>
			<br> <br>
			<div class="col-md-3 col-sm-7">
				<div class="panel panel-default text-center">
					<div class="panel-heading">
						<h3 data-bind="title">GD's Phone</h3>
					</div>
					<div class="panel-body">
						<div>
							<img data-bind="image" src=".\img\smartphone.png"
								style="margin-left: auto; margin-right: auto; display: auto"
								width="100px">
                            <p></p>
							<p>
								<a href="#" class="btn btn-warning btn-filter"
									style="width: 80px">수정</a>&nbsp; &nbsp; &nbsp;
								<a href="#" class="btn btn-danger btn-filter" style="width: 80px">삭제</a>
							</p>
						</div>
						<div>
							<ul class="list-group text-center">
								<li class="list-group-item"><b>장치명 :</b> <span data-bind="장치명">iPhone7 (mobile)</span></span></li>
								<li class="list-group-item"><b>장치정보 :</b> <span data-bind="장치정보">DC9601-2792-2DD4</span></li>
								<li class="list-group-item"><b>등록일 :</b> <span data-bind="등록일">2017 - 01 - 01</span></li>
							</ul>
							<a href="#" class="btn btn-default" style="width: 180px">라이센스 조회</a>
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
								<td width="180px"><h4><b>장치명</h4></td>
								<td width="200px"><h4><b>회사명</h4></td>
								<td width="150px"><h4><b>시작일자</h4></td>
								<td width="150px"><h4><b>만료기간</h4></td>
								<td width="100px"><h4><b>상태</h4></td>
                			</tr>
                		</thead>
                		<tbody align="center">
                			<tr>
        						<td data-title="No.">1</td>
                				<td data-title="소프트웨어">Microsoft Excel</td>
                				<td data-title="장치명">GD's Phone</td>
                				<td data-title="회사명">Microsoft</td>
                				<td data-title="시작일자">2016-11-31</td>
                				<td data-title="만료기간">9999-99-99</td>
                				<td data-title="상태"><span class="label label-success">발급 완료</span></td>
                			</tr>
                			<tr>
        						<td data-title="No.">2</td>
                				<td data-title="소프트웨어">Microsoft Excel</td>
                				<td data-title="장치명">GD's Phone</td>
                				<td data-title="회사명">Microsoft</td>
                				<td data-title="시작일자">2016-11-31</td>
                				<td data-title="만료기간">9999-99-99</td>
                				<td data-title="상태"><span class="label label-success">발급 완료</span></td>
                			</tr>
                			<tr>
        						<td data-title="No.">3</td>
                				<td data-title="소프트웨어">Microsoft Excel</td>
                				<td data-title="장치명">GD's Phone</td>
                				<td data-title="회사명">Microsoft</td>
                				<td data-title="시작일자">2016-11-31</td>
                				<td data-title="만료기간">9999-99-99</td>
                				<td data-title="상태"><span class="label label-success">발급 완료</span></td>
                			</tr>
                			<tr>
        						<td data-title="No.">4</td>
                				<td data-title="소프트웨어">Parallels Desktop</td>
                				<td data-title="장치명">GD's Phone</td>
                				<td data-title="회사명">Parallels International</td>
                				<td data-title="시작일자">2017-03-21</td>
                				<td data-title="만료기간">2017-04-21</td>
                				<td data-title="상태"><span class="label label-success" onmouseout="this.style.background='#5cb85c';
                				this.innerText='데모 버전';" onmouseover="this.style.background='#58ACFA';this.innerText='연장 요청';">데모 버전</span></td>
                			</tr>
                			<tr>
        						<td data-title="No.">5</td>
                				<td data-title="소프트웨어">Parallels Desktop</td>
                				<td data-title="장치명">GD's Phone</td>
                				<td data-title="회사명">Parallels International</td>
                				<td data-title="시작일자">2017-03-21</td>
                				<td data-title="만료기간">2017-04-21</td>
                				<td data-title="상태"><span class="label label-success" onmouseout="this.style.background='#5cb85c';
                				this.innerText='데모 버전';" onmouseover="this.style.background='#58ACFA';this.innerText='연장 요청';">데모 버전</span></td>
                			</tr>
                			

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