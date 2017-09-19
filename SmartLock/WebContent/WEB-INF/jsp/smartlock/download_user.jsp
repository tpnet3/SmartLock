<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="include/_header.jsp">
    <jsp:param name="_nav" value="download" />
</jsp:include>

<!-- Page Content -->
<div class="container">
    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">다운로드</h2>
        </div>

        <br> <br>
        <!-- /.row -->
        <!-- Project One -->
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="panel text-center" style="border: 1px solid; box-shadow: 2px 2px">
                    <div class="panel-heading">
                        <h3>에이전트 다운로드</h3>
                    </div>
                    <div class="panel-body">
                        <span class="fa-stack fa-5x">
                          <i class="fa fa-circle fa-stack-2x"></i>
                           <i class="fa fa-download fa-stack-1x fa-inverse"></i>
                    </span>
                        <hr>
                        <h4>Agent v1.0.1</h4>
                        <p><br>프로그램을 정상적으로 실행시키기 위해 다운받으세요.</p>
                        <a class="btn btn-lg btn-default btn-block" href="/html/img/Microsoft_Excel.png" download>지금 다운로드</a>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <!-- /.row -->
    <hr>

    <!-- Footer -->
    <jsp:include page="include/_footer_content.jsp" />

</div>
<!-- /.container -->

<jsp:include page="include/_jslib.jsp" />

<jsp:include page="include/_footer.jsp" />
