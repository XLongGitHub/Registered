<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>loginSuccess</title>
</head>
<body>
	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//int user_id = Integer.parseInt(request.getParameter("id"));
		/* out.write(username); */
		/* session.setParamater("username", username); */
		session.setAttribute("username", username);
		/* session.setAttribute("password", password); */
	%>
	<jsp:include page="header.jsp">
		<jsp:param name="username" value="username"/>
	</jsp:include>
	welcome <%=request.getParameter("username") %>
	<%-- <%=request.getParameter("user_id")+"fdihfodsajfoa" %> --%>
	<%=session.getAttribute("user_id")%>
	<%
		session.setAttribute("uername", username);
		//session.setAttribute("user_id", user_id);
	%>
</html>