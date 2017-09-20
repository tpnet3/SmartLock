<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="smartlock.license.vo.LicenseManagerVO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="include/_header.jsp">
	<jsp:param name="_nav" value="software_upload" />
</jsp:include>

<div class="container">
	<!-- Service Panels -->
	<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
	<div class="row">
		<div class="col-lg-12">
			<h2 class="page-header">소프트웨어 업로드</h2>
		</div>
		<!-- 검색필터-->
		<div class="row">

			<div class="col-md-4"></div>
			<div class="col-md-4">

				<div class="panel text-center">
					<div class="panel-body">
						<h4>소프트웨어를 업로드 합니다.</h4>
						<hr>
						<form id="softwareForm" align="left" action="/software/upload" method="POST" enctype="multipart/form-data">
							<label>회사 명</label>
							<div class="form-group">
								<input id="corp_name" value="${corp_name}" style="width: 335px;"
									class="form-control input-md" readonly>
							</div>
							<label>소프트웨어 명</label>
							<div class="form-group">
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
								<textarea class="form-control" id="sw_info" name="sw_info" rows="5" cols="30"
								 style="width:335px" placeholder="소프트웨어에 대한 간단한 설명을 입력해주세요."></textarea>
							</div>
							 <div class="form-group">
							    <label for="exampleInputFile">이미지 파일</label>
							    <input type="file" id="sw_img" name="sw_img">
							 </div>
							</form>
						<br>
						<div align="center">
							<a class="btn btn-lg btn-default btn-block" onclick="request();"
								style="width: 180px">소프트웨어 업로드</a>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

</div>
<hr>
<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />

<!-- /.container -->

<script>
	/*
	 * 업로드 버튼 클릭 시 onclick
	 */
	function request() 
	{
		var b = true;
		/*
		 * 입력 필드를 다 입력했을 경우
		 */
		if(b == true)
		{
			$("#softwareForm").submit();
			alert("업로드되었습니다.");
			
		}
		
		/*
		 * 입력 필드를 모두 입력하지 않은 경우
		 */
		else
		{
		 
		}
	}
</script>

<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />