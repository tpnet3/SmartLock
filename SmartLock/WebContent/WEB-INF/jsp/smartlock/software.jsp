<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="smartlock.license.vo.LicenseManagerVO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="include/_header.jsp">
    <jsp:param name="_nav" value="software" />
</jsp:include>

<!-- Page Content -->
<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">소프트웨어
                <small>미리보기</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/">Home</a>
                </li>
                <li class="active">Softwares</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->

    <!-- Projects Row -->
    <c:forEach var="software" items="${softwareList}" >
        <div class="col-md-3 img-portfolio">
            <div align="center">
            	<span class="fa-stack fa-5x">
            		 <img class="fa fa-circle fa-stack-2x" src= "data:image/jpg;base64, ${software.img}"></img>
            	</span>
           	</div>
            <h3 class="text-center">${software.sw_name}</h3>
            <p class="text-center">${software.version}</p>
            <p class="text-center">${software.info}</p>
        </div>
    </c:forEach>
    <hr>
</div>
    <!-- Footer -->
    <jsp:include page="include/_footer_content.jsp" />

<!-- /.container -->

<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />

