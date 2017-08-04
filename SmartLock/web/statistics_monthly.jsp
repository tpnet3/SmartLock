<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="private/_header.jsp">
    <jsp:param name="_nav" value="statistics" />
    <jsp:param name="_css" value="/css/statistics.css" />
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
                <li><a href="statistics.jsp">License 사용 통계</a></li>
                <li class="active">월별 License 발급 현황</li>
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
        </div>
    </div>
    <br><br>
    <div class="col-sm-12">
        <div class="vGraph">
            <ul>
                <li><span class="gTerm">1월</span><span class="gBar" style="height:0%"><span>0%</span></span>
                </li>
                <li><span class="gTerm">2월</span><span class="gBar" style="height:20%"><span>20%</span></span>
                </li>
                <li><span class="gTerm">3월</span><span class="gBar" style="height:30%"><span>30%</span></span>
                </li>
                <li><span class="gTerm">4월</span><span class="gBar" style="height:40%"><span>40%</span></span>
                </li>
                <li><span class="gTerm">5월</span><span class="gBar" style="height:50%"><span>50%</span></span>
                </li>
                <li><span class="gTerm">6월</span><span class="gBar" style="height:60%"><span>60%</span></span>
                </li>
                <li><span class="gTerm">7월</span><span class="gBar" style="height:100%"><span>100%</span></span>
                </li>
                <li><span class="gTerm">8월</span><span class="gBar" style="height:80%"><span>80%</span></span>
                </li>
                <li><span class="gTerm">9월</span><span class="gBar" style="height:60%"><span>60%</span></span>
                </li>
                <li><span class="gTerm">10월</span><span class="gBar" style="height:40%"><span>40%</span></span>
                </li>
                <li><span class="gTerm">11월</span><span class="gBar" style="height:20%"><span>20%</span></span>
                </li>
                <li><span class="gTerm">12월</span><span class="gBar" style="height:10%"><span>10%</span></span>
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
    <jsp:include page="private/_footer_content.jsp" />

</div>
<!-- /.container -->
<!-- jQuery -->
<script src="../js/jquery.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="../js/bootstrap.min.js"></script>

<jsp:include page="private/_footer.jsp" />
