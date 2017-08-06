<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String loginType = request.getParameter("login_type"); %>

<% if (loginType != null && loginType.equals("user")) { %>

    <jsp:include page="private/_header.jsp">
        <jsp:param name="_nav" value="" />
    </jsp:include>

    <jsp:include page="private/_profile_user.jsp" />

    <jsp:include page="private/_footer.jsp" />

<% } else if (loginType != null && loginType.equals("manager")) { %>

    <jsp:include page="private/_header.jsp">
        <jsp:param name="_nav" value="" />
    </jsp:include>

    <jsp:include page="private/_profile_manager.jsp" />

    <jsp:include page="private/_footer.jsp" />

<% } %>
