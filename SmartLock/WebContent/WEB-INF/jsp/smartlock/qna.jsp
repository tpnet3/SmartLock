<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="include/_header.jsp">
    <jsp:param name="_nav" value="qna" />
</jsp:include>

<!-- Page Content -->
<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">도움말
                <!--<small>Page Not Found</small>-->
            </h1>
            <!--
            <ol class="breadcrumb">
                <li><a href="404.jsp">Home</a>
                </li>
                <li class="active">404</li>
            </ol>
            -->
        </div>
    </div>
    <!-- /.row -->

    <div class="row">
        <div class="col-md-7">
            <div style="padding: 8px">
                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingOne">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    에이전트가 무엇인가요?
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                            <div class="panel-body">
                                소프트웨어가 정상적으로 실행될 수 있도록 라이선스를 인증 받는 프로그램입니다.
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingTwo">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                    단말기 등록은 어떻게 하나요?
                                </a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                            <div class="panel-body">
                                에이전트를 다운로드 받아 실행하면 단말기 등록을 진행할 수 있습니다.
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingThree">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                    라이선스는 어떻게 발급받나요?
                                </a>
                            </h4>
                        </div>
                        <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                            <div class="panel-body">
                                사용자가 라이선스를 요청하면 라이선스 관리자가 승인후에 발급받게됩니다.
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="heading4">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse4" aria-expanded="false" aria-controls="collapse4">
                                    라이선스를 발급받으면 어떻게 적용하나요?
                                </a>
                            </h4>
                        </div>
                        <div id="collapse4" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading4">
                            <div class="panel-body">
                                라이선스를 발급받고나면 자동적으로 에이전트가 소유여부를 식별하여 정상작동하게 됩니다.
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-5" style="text-align: center;">
            <div style="padding: 8px;">
                <div style="background-color: #FAFAFA; border: 1px solid #EEEEEE;">
                    <div style="padding: 96px 0;">
                        <div style="font-size: 36px;">
                            <a href="/html/pdf/manual.doc" style="color: #000; text-underline: none;" download>매뉴얼 다운로드</a>
                        </div>
                    </div>
                </div>
            </div>
            <div style="padding: 8px;">
                <div style="background-color: #FAFAFA; border: 1px solid #EEEEEE;">
                    <div style="padding: 96px 0;">
                        <div style="font-size: 32px;">1:1 문의</div>
                        <div style="font-size: 16px;">support@cadserv.co.kr</div>
                    </div>
                </div>
            </div>
        </div>
        <!--
        <div class="col-lg-12">
            <div class="jumbotron">
                <h1><span class="error-404">화면이 없어요 :)</span>
                </h1>
                <p>화면을 아직 안만들었어요.</p>
            </div>
        </div>
        -->
    </div>
</div>
<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />


<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />
