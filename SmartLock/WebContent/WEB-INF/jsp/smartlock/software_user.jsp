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

<!-- Header Carousel -->
<div class="container">

	<!-- Page Heading/Breadcrumbs -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
				소프트웨어 <small>소프트웨어 라이선스 요청</small>
			</h1>
		</div>
	</div>
	<!-- /.row -->

	<!-- Projects Row -->
	<c:forEach var="software" items="${softwareList}" varStatus="count">
	
	<div class="col-md-3 img-portfolio">
		<div align="center"><span class="fa-stack fa-5x" data-toggle="tooltip" data-placement="bottom" title="${software.sw_name }">
            		 <img class="fa fa-circle fa-stack-2x" src= "data:image/jpg;base64, ${software.img}"></img>
                        </span></div>
		<h3 class="text-center">${software.sw_name}</h3>
<<<<<<< HEAD
		<h5 class="text-center">v${software.version}</h5>
		<p class="text-center">${software.info}</p>
		<p>
		</p>
=======
            <p class="text-center">v${software.version}</p>
            <p class="text-center">${software.info}</p>
>>>>>>> master
		<div align="center">
        <a class="btn btn-md btn-default btn-block" style="width:100px" onclick="request_license('${software.id}', '${software.sw_name }');"
        data-toggle="tooltip" data-placement="bottom" title="라이센스 신청하기">신청하기</a>
    	</div>
	</div>
	</c:forEach>
</div>
<hr>
</fmt:bundle>
<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />

<!-- /.container -->

<script>
	function request_license(sw_id, sw_name){
		var state;
		state = confirm(sw_name+"에 대한 라이선스 요청을 하시겠습니까?");
		if(state == true){
			$.ajax({
				url:"/software/user/request?id="+sw_id ,
				type:"GET",
				contentType: "application/json",
			 	data : {
			 		id : sw_id
			 	},
	      		success : function (data) {
	      		window.location = "/software/user/request?id="+sw_id;
	   		    },
		   		error : function(data, textStatus, errorThrown) {
	     	 	console.log(data);
    			}
			});
		} else {
			alert("요청을 취소합니다.");
		}
	}
</script>

<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />
