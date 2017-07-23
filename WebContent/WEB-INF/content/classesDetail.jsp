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
						border: 3px solid black;
						width: 1200px;
					}
					
					tr {
						height: 40px;
						background-color: #00bfff;
					}
					
					td {
						text-align: center;
					}
				</style>
			</head>

			<body>
			<jsp:include page="header.jsp"/>
				<%-- <%=request.getParameter("classes") %>
					<%= session.getAttribute("classes")%> --%>
					<% 
						session.getAttribute("user_id");
						session.getAttribute("username");
					%>
						<table>
							<tr>
								<th>课程名</th>
								<th>教室</th>
								<th>添加课程</th>
								<th>删除课程</th>
								<th>修改课程</th>
								<th>删除课表</th>
								<th>添加课表</th>
							</tr>
							<s:iterator value="classes" status="index">
								<%-- <s:if test="#index.odd == true"> 
		 <tr style="background-color:#cccccc" class="pt11" height="32">
	</s:if> 
	<s:else> 
		 <tr class="pt11" height="32">
	</s:else> --%>

									<tr>
										<td>
											<s:property value="classname" />
										</td>
										<td>
											<s:property value="location" />
										</td>
										<td><a href="addCla">添加课程</a></td>
										<td><a href="deleteAction?id='<s:property value=" id "/>'">删除课程</a></td>
										<td><a href='modifyClazz?id=<s:property value="id"/>&classname=<s:property value="classname"/>&location=<s:property value="location"/>'>修改课程</a>

										<td><a href="deleteMyAction?id='<s:property value=" id "/>'">删除课表</a></td>
										<td><a href="chooseMyAction?id='<s:property value=" id "/>'">添加课表</a></td>
									</tr>
							</s:iterator>
					</table>
			</body>

			</html>