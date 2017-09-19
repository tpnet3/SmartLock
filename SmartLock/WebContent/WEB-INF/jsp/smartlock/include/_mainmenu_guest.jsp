<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String _nav = request.getParameter("_nav"); %>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Smart Lock</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-left">
                <!--
                <li <%= (_nav != null && _nav.equals("main")) ? "class=\"active\"" : "" %>>
                    <a href="/">Home</a>
                </li>
                -->
                <li <%= (_nav != null && _nav.equals("about_us")) ? "class=\"active\"" : "" %>>
                    <a href="/about_us">서비스 소개</a>
                </li>
                <li <%= (_nav != null && _nav.equals("software")) ? "class=\"active\"" : "" %>>
                    <a href="/software">소프트웨어</a>
                </li>
                <li <%= (_nav != null && _nav.equals("download")) ? "class=\"active\"" : "" %>>
                    <a href="/download">다운로드</a>
                </li>
                <li <%= (_nav != null && _nav.equals("qna")) ? "class=\"active\"" : "" %>>
                    <a href="/qna">묻고답하기</a>
                </li>
                <li <%= (_nav != null && _nav.equals("faq")) ? "class=\"active\"" : "" %>>
                    <a href="/faq">자주묻는질문</a>
                </li>
                <li <%= (_nav != null && _nav.equals("help")) ? "class=\"active\"" : "" %>>
                    <a href="/help">도움말</a>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="/login">로그인</a></li>
                <li><a href="/signup">회원가입</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>