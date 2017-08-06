<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="include/_header.jsp">
    <jsp:param name="_nav" value="statistics" />
    <jsp:param name="_css" value="/html/css/statistics.css" />
</jsp:include>

<!-- Header Carousel -->
<div class="container">
    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">통계
                <small>License 사용 통계</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">License 사용 통계</li>
                <li><a href="statistics_monthly.jsp">월별 License 발급 현황</a></li>
            </ol>
        </div>
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-sm-12" align="left">
            <div class="input-group">
                <select name="" id="location1" style="width: 180px; height: 35px;">
                    <option value="">전체보기</option>
                    <option value="">Microsoft Excel</option>
                    <option value="">Parallels Desktop</option>
                    <option value="">Adobe CC</option>
                    <option value="">Football Manager</option>
                </select>
            </div>
            <!-- 검색창을 추가할지말지?
            <div class="col-sm-6">
                <input type="text" class="col-md-4" placeholder="소프트웨어명을 입력하세요" id="searchField" style="width: 300px; height: 35px;">&nbsp;&nbsp;
                <button class="btn btn-primary" type="button" id="searchButton" data-loading-text="Searching.."> <i class="fa fa-search"></i> </button>--></div>
    </div>
    <br>
    <br>
    <div class="container">
        <div class="col-md-3">
            <div class="progress blue"> <span class="progress-left">
                        <span class="progress-bar"></span> </span> <span class="progress-right">
                        <span class="progress-bar"></span> </span>
                <div class="progress-value">10</div>
            </div>
            <h4 class="text-center">총 다운로드</h4>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="progress yellow"> <span class="progress-left"> <span class="progress-bar"></span> </span> <span class="progress-right"> <span class="progress-bar"></span> </span>
                <div class="progress-value">5</div>
            </div>
            <h4 class="text-center">라이센스 요청 <a href="/license.jsp"><i class="fa fa-pencil" style="color: black"></i></a></h4>
        </div>
        <div class="col-md-3">
            <div class="progress pink"> <span class="progress-left"> <span class="progress-bar"></span> </span> <span class="progress-right"> <span class="progress-bar"></span> </span>
                <div class="progress-value">3</div>
            </div>
            <h4 class="text-center">발급 된라이센스</h4>
        </div>
        <div class="col-md-3">
            <div class="progress green"> <span class="progress-left"> <span class="progress-bar"></span> </span> <span class="progress-right"> <span class="progress-bar"></span> </span>
                <div class="progress-value">7</div>
            </div>
            <h4 class="text-center">데모버전</h4>
        </div>
    </div>
    <!-- /.row -->
    <!-- Portfolio Section -->
    <br>
    <hr>

    <!-- Footer -->
    <jsp:include page="include/_footer_content.jsp" />

</div>
<!-- /.container -->

<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />
