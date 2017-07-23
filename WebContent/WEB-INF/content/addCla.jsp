<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>
addClazz
</title>
	<style>
		h3 {
			align:center;
			font-color:red;
		}
	</style>
</head>
<body>
<jsp:include page="header.jsp"/>
	<form action="addClazz" method="post">
		<tr>
		<td>clssname:<input type="text" name="clazz.classname"> </td>
		</tr>
		<tr>
		<td>location<input type="text" name="clazz.location"> </td>
		</tr>
		<tr>
		<td><input type="submit" value="submint"></td>
		</tr>
	</form>
</body>
</html>