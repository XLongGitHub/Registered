<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>registerDetail</title>
</head>
<body>
	<% 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	//	out.print(username+"<br>");
	//	out.print(password);
		
		if (username.equals("admin") && password.equals("admin")) {
			%>
			<jsp:forward page="registerSuccess.jsp">
				<jsp:param name="username" value="<%=username%>"/>				
				<jsp:param value="password" name="password"/>
			</jsp:forward>
			<%
		} else {
			%>
			<jsp:forward page="registerFailure.jsp"/>
			<%
		}
	%>
</body>
</html>