<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String _title = request.getParameter("_title"); %>
<% String[] _css = request.getParameterValues("_css"); %>

<% String authority = (String) request.getSession().getAttribute("authority"); %>

<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <% if (_title != null && ! _title.isEmpty()) { %>
        <title><%=_title%> | SmartLock</title>
    <% } else { %>
        <title>SmartLock</title>
    <% } %>

    <!-- Bootstrap Core CSS -->
    <link href="/html/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/html/css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/html/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <% if (_css != null) { %>
        <% for (int i = 0; i < _css.length; i++) { %>
            <link href="<%= _css[i] %>" rel="stylesheet">
        <% } %>
    <% } %>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<% if (authority != null && authority.equals("0")) { %>
    <jsp:include page="_mainmenu_user.jsp" />
<% } else if (authority != null && authority.equals("1")) { %>
    <jsp:include page="_mainmenu_manager.jsp" />
<% } else { %>
    <jsp:include page="_mainmenu_guest.jsp" />
<% } %>
