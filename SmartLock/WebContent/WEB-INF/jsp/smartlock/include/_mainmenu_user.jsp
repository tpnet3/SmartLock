<%@ page import="smartlock.member.vo.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String _nav = request.getParameter("_nav"); %>
<% UserVO userVO = (UserVO) session.getAttribute("user"); %>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Smart Lock</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-left">
                <!--
                <li <%= (_nav != null && _nav.equals("main")) ? "class=\"active\"" : "" %>>
                    <a href="/">Home</a>
                </li>
                -->
                <li <%= (_nav != null && _nav.equals("device")) ? "class=\"active\"" : "" %>>
                    <a href="/device">단말기</a>
                </li>
                <li <%= (_nav != null && _nav.equals("license")) ? "class=\"active\"" : "" %>>
                    <a href="/license/user?order=DEFAULT">라이선스</a>
                </li>
                <li <%= (_nav != null && _nav.equals("softwareUser")) ? "class=\"active\"" : "" %>>
                    <a href="/software/user">소프트웨어</a>
                </li>
                <li <%= (_nav != null && _nav.equals("download")) ? "class=\"active\"" : "" %>>
                    <a href="/download">다운로드</a>
                </li>
<<<<<<< HEAD
                <%-- <li <%= (_nav != null && _nav.equals("qna")) ? "class=\"active\"" : "" %>>
                    <a href="/qna">Q&A</a>
=======
                <li <%= (_nav != null && _nav.equals("qna")) ? "class=\"active\"" : "" %>>
                    <a href="/qna">도움말</a>
>>>>>>> branch 'master' of https://github.com/jiiiiireh/SmartLock.git
                </li>
                <!--
                <li <%= (_nav != null && _nav.equals("notice")) ? "class=\"active\"" : "" %>>
                    <a href="/notice">Notice</a> --%>
                </li>
                -->
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                        class="glyphicon glyphicon-user pull-leftt"></span></a>
                    <ul class="dropdown-menu">
                        <li><br>
                            <div class="col-md-5">
                                <img class="img-responsive" style="margin-left: 15px; margin-right: 20px" align="left" width="100px" src="/html/img/profile.png" alt=""></div>
                            <div class="col-md-7">
                                <h4><%= userVO.getUserName() %> 님</h4>
                                <h5><%= userVO.getEmail() %></h5>
                                <a class="btn btn-sm btn-default btn-block" href="/profile">마이페이지</a>
                                <br>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li><a href="/logout">로그아웃</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
