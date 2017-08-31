<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<jsp:include page="include/_header.jsp">
    <jsp:param name="_nav" value="statistics" />
    <jsp:param name="_css" value="/html/css/vGraph.css" />
    <jsp:param name="_css" value="/html/css/statistics.css" />
</jsp:include>

<!-- Header Carousel -->
<div class="container">
    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">통계
                <small>월별 발급 현황</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/statistics">License 사용 통계</a></li>
                <li class="active">월별 License 발급 현황</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-sm-12" align="left">
            <div class="input-group">
                <select name="" id="location1" style="width: 180px; height: 35px;">
                    <option value="전체보기" selected="selected">전체보기</option>
                    <c:forEach var="item" items="${swList}">
                    	<option value="${item.value}"><div hidden="hidden">${item.key}</div>${item.value}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <br><br>
    <div class="col-sm-12">
        <div class="vGraph" id="graph">
            <ul>
                <li><span class="gTerm">1월</span><span class="gBar" id="month1" style="height:${monthCnt[0]}"><span>${monthCnt[0]}</span></span>
                </li>
                <li><span class="gTerm">2월</span><span class="gBar" style="height:${monthCnt[1]}"><span>${monthCnt[1]}</span></span>
                </li>
                <li><span class="gTerm">3월</span><span class="gBar" style="height:${monthCnt[2]}"><span>${monthCnt[2]}</span></span>
                </li>
                <li><span class="gTerm">4월</span><span class="gBar" style="height:${monthCnt[3]}"><span>${monthCnt[3]}</span></span>
                </li>
                <li><span class="gTerm">5월</span><span class="gBar" style="height:${monthCnt[4]}"><span>${monthCnt[4]}</span></span>
                </li>
                <li><span class="gTerm">6월</span><span class="gBar" style="height:${monthCnt[5]}"><span>${monthCnt[5]}</span></span>
                </li>
                <li><span class="gTerm">7월</span><span class="gBar" style="height:${monthCnt[6]}"><span>${monthCnt[6]}</span></span>
                </li>
                <li><span class="gTerm">8월</span><span class="gBar" style="height:${monthCnt[7]}"><span>${monthCnt[7]}</span></span>
                </li>
                <li><span class="gTerm">9월</span><span class="gBar" style="height:${monthCnt[8]}"><span>${monthCnt[8]}</span></span>
                </li>
                <li><span class="gTerm">10월</span><span class="gBar" style="height:${monthCnt[9]}"><span>${monthCnt[9]}</span></span>
                </li>
                <li><span class="gTerm">11월</span><span class="gBar" style="height:${monthCnt[10]}"><span>${monthCnt[10]}</span></span>
                </li>
                <li><span class="gTerm">12월</span><span class="gBar" style="height:${monthCnt[11]}"><span>${monthCnt[11]}</span></span>
                </li>
            </ul>
        </div>
    </div>

    <!-- /.row -->

    <br>
    <div class="row">
        <hr>
    </div>

    <!-- Footer -->
    <jsp:include page="include/_footer_content.jsp" />

</div>
<!-- /.container -->

<!-- SW명별로 통계 -->
<script>
$.ajax({
	url:'/statistics/monthly/filter',
	type:'POST',
	contentType: 'application/json',
	data:{
		sw_id : sw_id	
	},
	success:function(data){
		alert(data);
/* 		$('#month1').style('height:${monthCnt[0]}');
		$('#month1').text('height:${monthCnt[0]}'); */
	},
	error:function(jqXHR, textStatus, errorThrown){
		alert('에러');
	}
});
</script> 
<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />
