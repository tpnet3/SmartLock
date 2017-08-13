<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="include/_header.jsp">
    <jsp:param name="_nav" value="license" />
</jsp:include>

<!-- Header Carousel -->
<div class="container">
    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">라이센스 관리
                <small>발급 대기 현황</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">발급 대기 현황</li>
                <li><a href="../license_finish_manager.jsp">발급 완료 현황</a></li>
            </ol>
        </div>
    </div>
    <div class="row">
        <div class="row">
            <div class="col-sm-12">
                <div class="col-sm-2">
                    <div class="input-group">
                        <select name="" id="location1"
                                style="width: 180px; height: 35px;">
                            <option value="">소프트웨어명</option>
                            <option value="">전체보기</option>
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
                            <option value="">만료 날짜</option>
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
        <br>
        <!-- 검색필터-->
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h2 class="text-center"></h2>
            </div>
            <div id="no-more-tables">
                <table
                        class="col-sm-12 table-bordered table-striped table-condensed cf">
                    <thead class="cf" align="center">
                    <tr>
                        <td width="10px">
                            <h4>
                                <b>No.
                            </h4>
                        </td>
                        <td width="250px"><h4>
                            <b>소프트웨어명
                        </h4></td>
                        <td width="100px"><h4>
                            <b>이름
                        </h4></td>
                        <td width="100px"><h4>
                            <b>신청날짜
                        </h4></td>
                        <td width="150px"><h4>
                            <b>분류
                        </h4></td>
                        <td width="100px"><h4>
                            <b>상세보기
                        </h4></td>
                        <td width="100px"><h4>
                            <b>처리
                        </h4></td>
                    </tr>
                    </thead>
                    <tbody align="center">
                    <tr>
                        <td data-title="No.">1</td>
                        <td data-title="소프트웨어">Microsoft Excel</td>
                        <td data-title="이름">박지성</td>
                        <td data-title="신청날짜">2017-01-01</td>
                        <td data-title="분류"><span class="label label-success">일반
									신청</span></td>
                        <td data-title="상세보기"><a><span class="label"
                                                       style="background-color: darkgray; color: black">상세 보기</span></a></td>
                        <td data-title="상세보기"><a><span class="label"
                                                       style="background-color: indianred; color: white">발급하기</span></a></td>
                    </tr>
                    <tr>
                        <td data-title="No.">2</td>
                        <td data-title="소프트웨어">Microsoft Excel</td>
                        <td data-title="이름">이영표</td>
                        <td data-title="신청날짜">2017-02-02</td>
                        <td data-title="분류"><span class="label label-success">일반
									신청</span></td>
                        <td data-title="상세보기"><a><span class="label"
                                                       style="background-color: darkgray; color: black">상세 보기</span></a></td>
                        <td data-title="상세보기"><a><span class="label"
                                                       style="background-color: indianred; color: white">발급하기</span></a></td>
                    </tr>
                    <tr>
                        <td data-title="No.">3</td>
                        <td data-title="소프트웨어">Microsoft Excel</td>
                        <td data-title="이름">차두리</td>
                        <td data-title="신청날짜">2017-03-03</td>
                        <td data-title="분류"><span class="label label-warning">데모
									신청</span></td>
                        <td data-title="상세보기"><a><span class="label"
                                                       style="background-color: darkgray; color: black">상세 보기</span></a></td>
                        <td data-title="상세보기"><a><span class="label"
                                                       style="background-color: indianred; color: white">발급하기</span></a></td>
                    </tr>
                    <tr>
                        <td data-title="No.">4</td>
                        <td data-title="소프트웨어">Microsoft Excel</td>
                        <td data-title="이름">박주영</td>
                        <td data-title="신청날짜">2017-04-04</td>
                        <td data-title="분류"><span class="label label-warning">데모
									신청</span></td>
                        <td data-title="상세보기"><a><span class="label"
                                                       style="background-color: darkgray; color: black">상세 보기</span></a></td>
                        <td data-title="상세보기"><a><span class="label"
                                                       style="background-color: indianred; color: white">발급하기</span></a></td>
                    </tr>
                    <tr>
                        <td data-title="No.">5</td>
                        <td data-title="소프트웨어">Football Manager</td>
                        <td data-title="이름">김남일</td>
                        <td data-title="신청날짜">2017-05-05</td>
                        <td data-title="분류"><span class="label label-success">일반
									신청</span></td>
                        <td data-title="상세보기"><a><span class="label"
                                                       style="background-color: darkgray; color: black">상세 보기</span></a></td>
                        <td data-title="상세보기"><a><span class="label"
                                                       style="background-color: indianred; color: white">발급하기</span></a></td>
                    </tr>
                    <tr>
                        <td data-title="No.">6</td>
                        <td data-title="소프트웨어">Adobe CC</td>
                        <td data-title="이름">이근호</td>
                        <td data-title="신청날짜">2017-01-01</td>
                        <td data-title="분류"><span class="label label-success">일반
									신청</span></td>
                        <td data-title="상세보기"><a><span class="label"
                                                       style="background-color: darkgray; color: black">상세 보기</span></a></td>
                        <td data-title="상세보기"><a><span class="label"
                                                       style="background-color: indianred; color: white">발급하기</span></a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="row text-center">
            <div class="col-lg-12">
                <ul class="pagination">
                    <li><a href="#">&laquo;</a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</div>
<!-- /.row -->

<!-- /.row -->
<hr>

<!-- Footer -->
<jsp:include page="include/_footer_content.jsp" />

</div>
<!-- /.container -->

<jsp:include page="include/_jslib.jsp" />

<jsp:include page="include/_footer.jsp" />
