<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style>
		h3 {
			align:center;
			font-color:red;
		}
	</style>
</head>
<body>
<jsp:include page="header.jsp"/>
	
	<%=session.getAttribute("username") %>
	<%=session.getAttribute("user_id") %>
	
		
</body>
</html>