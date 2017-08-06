<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String loginType = request.getParameter("login_type"); %>

<% if (loginType != null && loginType.equals("user")) { %>

<jsp:include page="components/_header.jsp">
    <jsp:param name="_nav" value="download" />
</jsp:include>

<jsp:include page="container/_download_user.jsp" />

<jsp:include page="components/_footer.jsp" />

<% } else { %>

<jsp:include page="components/_header.jsp">
    <jsp:param name="_nav" value="download" />
</jsp:include>

<jsp:include page="container/_download_guest.jsp" />

<jsp:include page="components/_footer.jsp" />

<% } %>
