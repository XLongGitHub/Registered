
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>classesDetial</title>
<style>
table {
	widows: 810px;
	border: 3px solid black;
}

tr {
	height: 25px;
	background-color: #00bbff;
}
td {
	text-align: center;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
	<table>
		<tr><th>课程名</th><th>教室</th></tr>
	<s:iterator value="classes" status="index">	
		<tr>
			<td><s:property value="classname"/></td>
			<td><s:property value="location"/></td>
		</tr>
</s:iterator>
</table>
</body>
</html>