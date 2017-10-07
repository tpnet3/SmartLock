<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="smartlock.license.vo.LicenseManagerVO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<jsp:include page="include/_header.jsp">
	<jsp:param name="_nav" value="software_upload" />
</jsp:include>

<div class="container">
	<!-- Service Panels -->
	<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
	<div class="row">
		<div class="col-lg-12">
			<h2 class="page-header">소프트웨어 정보 등록</h2>
		</div>
		<!-- 검색필터-->
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">

				<div class="panel text-center">
					<div class="panel-body">
						<h4>소프트웨어 정보를 업로드합니다.</h4>
						<hr>
						<form id="softwareForm" align="left" action="/software/upload" method="POST" enctype="multipart/form-data">
							<label>회사 명</label>
							<div class="form-group">
								<input id="corp_name" value="${corp_name}" style="width: 335px; background: #ffffff"
									class="form-control input-md" readonly>
							</div>
							<label>소프트웨어 명</label>
							<div class="form-group">
								<%-- <select id="select" class="form-control" onchange="change(this.value);">
									<c:forEach var="software" items="${softwareList}">
									  <option>${software.value.sw_name}</option>
									</c:forEach>
									<option>직접입력</option>
								</select> --%>
							<input id="sw_name" name="sw_name" placeholder="소프트웨어명을 입력하세요."
								style="width: 335px;" class="form-control input-md">
							</div>
							<label>소프트웨어 버전</label>
							<div class="form-group">
								<input id="sw_version" name="version" placeholder="소프트웨어 버전을 입력하세요."
									style="width: 335px;" class="form-control input-md">
							</div>
							<label>프로세스 명</label>
							<div class="form-group">
								<input id="proc_name" name="proc_name" placeholder="프로세스 명을 입력하세요."
									style="width: 335px;" class="form-control input-md">
							</div>
							<label>설명</label>
							<div class="form-group">
								<textarea class="form-control" id="info" name="info" rows="5" cols="30"
								 style="width:335px" placeholder="소프트웨어에 대한 간단한 설명을 입력하세요."></textarea>
							</div>
							 <div class="form-group">
							    <label for="exampleInputFile">이미지 파일</label>
							    <input type="file" id="sw_img" name="sw_img">
							 </div>
							</form>
						<br>
						<div align="center">
							<a class="btn btn-lg btn-default btn-block" onclick="request();"
								style="width: 180px" data-toggle="tooltip" data-placement="bottom" title="소프트웨어 업로드">업로드</a>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>
<!-- /.container -->

<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />

<script>
	/*
	 * select 바뀔 시
	 */
	 function change(name)
	{
		if(name == '직접입력')
		{
			$('#sw_name').removeAttr('type');	
		}
		else
		{
			$('#sw_name').attr('type', 'hidden');
		}
	}
	
	/*
	 * 업로드 버튼 클릭 시 onclick
	 */
	function request() 
	{
		/*
		 * 필수 입력 필드를 모두 입력하지 않은 경우
		 */
		if($('#sw_name').val() == '')
			alert('소프트웨어 명을 입력해주세요.');
		else if($('#sw_version').val() == '')
			alert('소프트웨어 버전을 입력해주세요.');
		else if($('#proc_name').val() == '')
			alert('프로세스 명을 입력해주세요.');
		/*
		 * 입력 필드를 모두 입력했을 경우
		 */
		else
		{
			$('#softwareForm').submit();
			alert('업로드되었습니다.');
			
		}
	}
</script>

<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />